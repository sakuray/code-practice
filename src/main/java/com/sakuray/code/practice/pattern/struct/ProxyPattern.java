package com.sakuray.code.practice.pattern.struct;

/**
 * 代理模式：
 *   代理模式就是给一个对象提供一个代理，并由代理对象控制对原对象的引用。
          在代理模式中，“第三者”代理主要是起到一个中介的作用，它连接客户端和目标对象。
 * 模式结构：
 *   Subject: 抽象角色。声明真实对象和代理对象的共同接口。
     Proxy: 代理角色。代理对象与真实对象实现相同的接口，所以它能够在任何时刻都能够代理真实对象。
                        代理角色内部包含有对真实对象的引用，所以她可以操作真实对象，同时也可以附加其他的操作，相当于对真实对象进行封装。
     RealSubject: 真实角色。它代表着真实对象，是我们最终要引用的对象
 * 适用场景：
 *   1、 远程代理：为一个对象在不同的地址空间提供局部代表。这样可以隐藏一个对象存在于不同地址空间的事实。
     2、 虚拟代理：通过使用过一个小的对象代理一个大对象。这样就可以减少系统的开销。
     3、 保护代理：用来控制对真实对象的访问权限。
 * 代理模式：
 *   原本两个对象之间的交互，由代理类完成，代理类和被代理类实现相同接口，代理类持有被代理类，调用代理类的方法，传到到被代理类。
 */
public class ProxyPattern {

	public class BeautifulGirl {
		String name;

		public BeautifulGirl(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
	
	public interface GiveGift {
		void giveFlowers();
		void giveChocolate();
		void giveBook();
	}
	
	public class You implements GiveGift {
		BeautifulGirl girl;
		
		public You(BeautifulGirl girl) {
			this.girl = girl;
		}

		@Override
		public void giveFlowers() {
			System.out.println(girl.getName() + ",送你一束花....");
		}

		@Override
		public void giveChocolate() {
			System.out.println(girl.getName() + ",送你一盒巧克力....");
		}

		@Override
		public void giveBook() {
			System.out.println(girl.getName() +",送你一本书....");
		}
	}
	
	public class HerChum implements GiveGift {
		
		You you;
		
		public HerChum(BeautifulGirl girl) {
			you = new You(girl);
		}

		@Override
		public void giveFlowers() {
			you.giveFlowers();
		}

		@Override
		public void giveChocolate() {
			you.giveChocolate();
		}

		@Override
		public void giveBook() {
			you.giveBook();
		}
		
	}
	
	public static void main(String[] args) {
		BeautifulGirl girl = new ProxyPattern().new BeautifulGirl("girls");
		HerChum chum = new ProxyPattern().new HerChum(girl);
		chum.giveBook();
		chum.giveChocolate();
		chum.giveFlowers();
	}
}
