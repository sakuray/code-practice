package com.sakuray.code.practice.pattern.behave;

import java.util.ArrayList;
import java.util.List;

/**
 * 迭代器模式：
 *   迭代器模式的动机--能够游走于聚合内的每一个元素，同时还可以提供多种不同的遍历方式。
 *   所谓迭代器模式就是提供一种方法顺序访问一个聚合对象中的各个元素，而不是暴露其内部的表示。
 *   在实际的开发过程中，我们可能需要针对不同的需求，可能需要以不同的方式来遍历整个整合对象，但是我们不希望在聚合对象的抽象接口层中充斥着各种不同的便利操作。
 *   具备如下三个功能：
     1、能够便利一个聚合对象。
     2、我们不需要了解聚合对象的内部结构。
     3、能够提供多种不同的遍历方式。
 * 模式结构：
 * 	 Iterator: 抽象迭代器：所有迭代器都需要实现的接口，提供了游走聚合对象元素之间的方法。
     ConcreteIterator: 具体迭代器。利用这个具体的迭代器能够对具体的聚合对象进行遍历。每一个聚合对象都应该对应一个具体的迭代器。
     Aggregate: 抽象聚合类。
     ConcreteAggregate: 具体聚合类。实现creatorIterator()方法，返回该聚合对象的迭代器。
 * 适用场景：
 * 	 1、访问一个聚合对象的内容而无须暴露它的内部表示。
     2、需要为聚合对象提供多种遍历方式。
     3、为遍历不同的聚合结构提供一个统一的接口。
 * 个人理解：
 *   不同的类中的容器使用的不一样，需要统一调用访问的时候就会有问题，就需要一个中间者迭代器来完成这个动作，
 *   将其容器注册进自己相关的迭代器，里面实现遍历这个容器的方法，这个类要有一个能产生这个迭代器的方法。
 */
public class IteratorPattern {
	
	public class MenuItem {
		private String name;
		private String description;
		private int channel;
		public MenuItem(String name, String description, int channel) {
			this.name = name;
			this.description = description;
			this.channel = channel;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public int getChannel() {
			return channel;
		}
		public void setChannel(int channel) {
			this.channel = channel;
		}
	}
	
	// 迭代器接口
	public interface Iterator {
		boolean hasNext();
		Object next();
	}
	
	// 具体迭代器
	public class FilmMenuIterator implements Iterator {
		
		MenuItem[] menuItems;
		int position = 0;
		
		public FilmMenuIterator(MenuItem[] menuItems) {
			this.menuItems = menuItems;
		}

		@Override
		public boolean hasNext() {
			if(position > menuItems.length - 1 || menuItems[position] == null) {
				return false;
			}
			return true;
		}
		
		@Override
		public Object next() {
			MenuItem menuItem = menuItems[position];
			position ++;
			return menuItem;
		}
		
	}
	
	public class TVChannelMenuIterator implements Iterator {
		
		List<MenuItem> menuItems;
		int position = 0;
		
		public TVChannelMenuIterator(List<MenuItem> menuItems) {
			this.menuItems = menuItems;
		}

		@Override
		public boolean hasNext() {
			if(position > menuItems.size() - 1 || menuItems.get(position) == null) {
				return false;
			}
			return true;
		}

		@Override
		public Object next() {
			MenuItem menuItem = menuItems.get(position);
			position++;
			return menuItem;
		}
	}

	// 抽象聚合类
	public interface TelevisonMenu {
		public void addItem(int channel, String name, String description);
		public Iterator createIterator();
	}
	
	// 具体聚合类
	public class FilmMenu implements TelevisonMenu {

		static final int MAX_ITEMS = 5;
		MenuItem[] menuItems;
		int numberOfItems = 0;
		
		public FilmMenu(){
	        menuItems = new MenuItem[MAX_ITEMS];
	        
	        addItem(1, "绝世天劫", "这是布鲁斯威利斯主演的...");
	        addItem(2, "达芬奇密码", "这是我最喜欢的电影之一...");
	        addItem(3, "黑客帝国123", "不知道你能够看懂不???");
	        addItem(4, "我的女友是机器人", "一部我不反感的经典爱情电影...");
	        addItem(5, "肖申克的救赎", "自由，幸福，离你有多远");
	    }
		
		@Override
		public void addItem(int channel, String name, String description) {
			MenuItem tvmenuiItem = new MenuItem(name, description, channel);
	        //判断数组是否越界
	        if(numberOfItems > MAX_ITEMS){
	            System.out.println("不好意思，菜单满了....");
	        }
	        else{
	            menuItems[numberOfItems] = tvmenuiItem;
	            numberOfItems ++;
	        }
		}

		@Override
		public Iterator createIterator() {
			return new FilmMenuIterator(menuItems);
		}
	}
	
	public class TVChannelMenu implements TelevisonMenu {

		List<MenuItem> menuItems;
		
		public TVChannelMenu(){
	        menuItems = new ArrayList<MenuItem>();
	        addItem(1, "CCTV-1", "This is CCTV-1");
	        addItem(2, "CCTV-2", "This is CCTV-2");
	        addItem(3, "CCTV-3", "This is CCTV-3");
	        addItem(4, "CCTV-4", "This is CCTV-4");
	        addItem(5, "CCTV-5", "This is CCTV-5");
	    }
		
		@Override
		public void addItem(int channel, String name, String description) {
			MenuItem tvMenuItem = new MenuItem(name, description, channel);
	        menuItems.add(tvMenuItem);
		}

		@Override
		public Iterator createIterator() {
			return new TVChannelMenuIterator(menuItems);
		}
	}
	
	public class MainMenu {
		TelevisonMenu tvMenu;
	    FilmMenu filmMenu;
	    
	    public MainMenu(TelevisonMenu tvMenu,FilmMenu filmMenu){
	        this.tvMenu = tvMenu;
	        this.filmMenu  = filmMenu;
	    }
	    
	    public void printMenu(){
	        Iterator tvIterator = tvMenu.createIterator();
	        Iterator filmIterator = filmMenu.createIterator();
	        
	        System.out.println("电视节目有:");
	        printMenu(tvIterator);
	        System.out.println("----------------------------------------------------------------");
	        System.out.println("电影节目有:");
	        printMenu(filmIterator);
	    }

	    private void printMenu(Iterator iterator) {
	        while(iterator.hasNext()){
	            MenuItem menuItem = (MenuItem) iterator.next();
	            System.out.print("channe:"+menuItem.getChannel()+",  ");
	            System.out.print("name:"+menuItem.getName()+",  ");
	            System.out.println("description :"+menuItem.getDescription());
	        }
	    }
	}
	
	public static void main(String[] args) {
		TVChannelMenu tvMenu = new IteratorPattern().new TVChannelMenu();
        FilmMenu filmMenu = new IteratorPattern().new FilmMenu();
        
        MainMenu mainMenu = new IteratorPattern().new MainMenu(tvMenu, filmMenu);
        mainMenu.printMenu();
	}
}
