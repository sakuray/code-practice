package com.sakuray.code.practice.pattern.behave;

/**
 * 中介者模式:
 * 	  所谓中介者模式就是用一个中介对象来封装一系列的对象交互，中介者使各对象不需要显式地相互引用，
 *   从而使其耦合松散，而且可以独立地改变它们之间的交互。
 *   中介者对象封装了对象之间的关联关系，导致中介者对象变得比较庞大，所承担的责任也比较多。它需要知道每个对象和他们之间的交互细节，如果它出问题，将会导致整个系统都会出问题。所以它比较容易应用也很容易误用。
 *   故当系统中出现了“多对多”交互复杂的关系群时，千万别急着使用中介者模式，你首先需要做的就是反思你的系统在设计上是不是合理。
 * 模式结构：
 *   Mediator: 抽象中介者。定义了同事对象到中介者对象之间的接口。
     ConcreteMediator: 具体中介者。实现抽象中介者的方法，它需要知道所有的具体同事类，同时需要从具体的同事类那里接收信息，并且向具体的同事类发送信息。
     Colleague: 抽象同事类。
     ConcreteColleague: 具体同事类。每个具体同事类都只需要知道自己的行为即可，但是他们都需要认识中介者。
      适用场景：
     1、 系统中对象之间存在比较复杂的引用关系，导致他们之间的依赖关系结构混乱而且难以复用该对象。
	 2、 想通过一个中间类来封装多个类中的行为，而又不想生成太多的子类。
 * 个人理解：
 * 	  两个需要联系的类不直接打交道，而是通过中介者交互，其与中介者互相包含。
 *   一个类联系另一个类时，触发中介者的相关方法，然后中介者来进行联系
 */
public class MediatorPattern {

	// 抽象中介者
	public abstract class Mediator {
		public abstract void constact(String message, Person person);
	}
	
	// 抽象同事
	public abstract class Person {
		protected String name;
		protected Mediator mediator;
		
		public Person(String name, Mediator mediator) {
			this.name = name;
			this.mediator = mediator;
		}
	}
	
	// 具体同事类
	public class HouseOwner extends Person {

		public HouseOwner(String name, Mediator mediator) {
			super(name, mediator);
		}
		
		// 与中介者联系
		public void constact(String message) {
			mediator.constact(message, this);
		}
		
		// 获取信息
		public void getMessage(String message) {
			System.out.println("房主：" + name + ",获得信息:" + message);
		}
	}
	
	public class Tenant extends Person {

		public Tenant(String name, Mediator mediator) {
			super(name, mediator);
		}
		
		// 与中介者联系
		public void constact(String message) {
			mediator.constact(message, this);
		}
		
		// 获取信息
		public void getMessage(String message) {
			System.out.println("租客：" + name + ",获得信息:" + message);
		}
	}
	
	// 具体中介者
	public class MediatorStructure extends Mediator {
		
		private HouseOwner houseOwner;
		private Tenant tenant;
		
		public HouseOwner getHouseOwner() {
			return houseOwner;
		}
		public void setHouseOwner(HouseOwner houseOwner) {
			this.houseOwner = houseOwner;
		}
		public Tenant getTenant() {
			return tenant;
		}
		public void setTenant(Tenant tenant) {
			this.tenant = tenant;
		}

		@Override
		public void constact(String message, Person person) {
			if(person == houseOwner) {
				tenant.getMessage(message);
			} else {
				houseOwner.getMessage(message);
			}
		}
	}
	
	public static void main(String[] args) {
		// 一个房主、一个租房者、一个中介机构
		MediatorStructure mediatorStructure = new MediatorPattern().new MediatorStructure();
		
		HouseOwner houseOwner = new MediatorPattern().new HouseOwner("张三", mediatorStructure);
		Tenant tenant = new MediatorPattern().new Tenant("李四", mediatorStructure);
		
		mediatorStructure.setHouseOwner(houseOwner);
		mediatorStructure.setTenant(tenant);
		
		tenant.constact("听说你那里有三室的房主出租.....");
        houseOwner.constact("是的!请问你需要租吗?");
	}
}
