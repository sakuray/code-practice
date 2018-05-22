package com.sakuray.code.practice.pattern.behave;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 访问者模式：<br/>
 *   访问者模式的目的是封装一些施加于某种数据结构元素之上的操作，一旦这些操作需要修改的话，接受这个操作的数据结构可以保持不变。
 *   为不同类型的元素提供多种访问操作方式，且可以在不修改原有系统的情况下增加新的操作方式，这就是访问者模式的模式动机。
 *   访问者模式即表示一个作用于某对象结构中的各元素的操作，它使我们可以在不改变各元素的类的前提下定义作用于这些元素的新操作。<br/>
 * 模式结构：<br/>
 * 	 Visitor: 抽象访问者。为该对象结构中的ConcreteElement的每一个类声明的一个操作。 <br/>
     ConcreteVisitor: 具体访问者。实现Visitor申明的每一个操作，每一个操作实现算法的一部分。 <br/>
     Element: 抽象元素。定义一个Accept操作，它以一个访问者为参数。 <br/>
     ConcreteElement: 具体元素 。实现Accept操作。 <br/>
     ObjectStructure: 对象结构。能够枚举它的元素，可以提供一个高层的接口来允许访问者访问它的元素。<br/>
 * 适用场景：<br/>
 *   1、对象结构中对象对应的类很少改变，但经常需要在此对象结构上定义新的操作。<br/>
     2、需要对一个对象结构中的对象进行很多不同的并且不相关的操作，而需要避免让这些操作“污染”这些对象的类，也不希望在增加新操作时修改这些类。<br/>
 * 个人理解：<br/>
 *   访问者模式主要由访问者和被访问者构成，两者都可以有多个种类，通过一个结构类，将两者组合起来，
 *   接收一个访问者会调用访问者中访问被访问者的方法，前提是结构中已有被访问者。也可以是通过被访问者持有访问者来调访问者访问被访问者的方法。
 */
public class VisitorPattern {

	// Visitor
	public abstract class Visitor {
		protected String name;

		public void setName(String name) {
			this.name = name;
		}
		
		public abstract void visitor(Medicine medicine);
	}
	
	// ConcreteVisitor
	public class Charger extends Visitor {

		@Override
		public void visitor(Medicine medicine) {
			System.out.println("划价员：" + name + ",给药：" + medicine.getName() + ",划价：" + medicine.getPrice());
		}
		
	}
	
	public class WorkerOfPharmacy extends Visitor {

		@Override
		public void visitor(Medicine medicine) {
			System.out.println("药房工作者：" + name + ",拿药：" + medicine.getName());
		}
		
	}
	
	// Element
	public abstract class Medicine {
		protected String name;
		protected double price;
		
		public Medicine(String name, double price) {
			this.name = name;
			this.price = price;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}
		
		public abstract void accept(Visitor visitor);
	}
	
	// ConcreteElement
	public class MedicineA extends Medicine{

	    public MedicineA(String name, double price) {
	        super(name, price);
	    }

	    public void accept(Visitor visitor) {
	        visitor.visitor(this);
	    }
	}
	
	public class MedicineB extends Medicine{

	    public MedicineB(String name, double price) {
	        super(name, price);
	    }

	    public void accept(Visitor visitor) {
	        visitor.visitor(this);
	    }
	}
	
	//
	public class Presciption {
	    List<Medicine> list = new ArrayList<Medicine>();
	    
	    public void accept(Visitor visitor){
	        Iterator<Medicine> iterator = list.iterator();
	        
	        while (iterator.hasNext()) {
	            iterator.next().accept(visitor);
	        }
	    }
	    
	    public void addMedicine(Medicine medicine){
	        list.add(medicine);
	    }
	    
	    public void removeMedicien(Medicine medicine){
	        list.remove(medicine);
	    }
	}
	
	public static void main(String[] args) {
		VisitorPattern pattern = new VisitorPattern();
		
		Medicine a = pattern.new MedicineA("板蓝根", 11.0);
        Medicine b = pattern.new MedicineB("感康", 14.3);
        
        Presciption presciption = pattern.new Presciption();
        presciption.addMedicine(a);
        presciption.addMedicine(b);
        
        Visitor charger = pattern.new Charger();
        charger.setName("张三");
        
        Visitor workerOfPharmacy = pattern.new WorkerOfPharmacy();
        workerOfPharmacy.setName("李四");
        
        presciption.accept(charger);
        System.out.println("-------------------------------------");
        presciption.accept(workerOfPharmacy);
	}
}
