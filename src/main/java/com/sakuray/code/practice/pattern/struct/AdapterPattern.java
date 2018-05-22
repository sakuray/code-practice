package com.sakuray.code.practice.pattern.struct;

/**
 * 适配器模式：
 *   何谓适配器模式？适配器模式就是将一个类的接口，转换成客户期望的另一个接口。适配器让原本接口不兼容的类可以合作无间。
 *   在适配器模式中，我们可以定义一个包装类，包装不兼容接口的对象，这个包装类就是适配器，它所包装的对象就是适配者。
 *   适配器提供给客户需要的接口，适配器的实现就是将客户的请求转换成对适配者的相应的接口的引用。也就是说，当客户调用适配器的方法时，
 *   适配器方法内部将调用适配者的方法，客户并不是直接访问适配者的，而是通过调用适配器方法访问适配者。因为适配器可以使互不兼容的类能够“合作愉快”。<br/>
 * 模式结构：
 *   Target：目标抽象类
     Adapter：适配器类
     Adaptee：适配者类
     Client：客户类<br/>
      适用场景：
     1.系统需要使用现有的类，而这些类的接口不符合系统的需要。
     2.想要建立一个可以重复使用的类，用于与一些彼此之间没有太大关联的一些类<br/>
      个人理解：
          适配器就是将一个接口通过适配器转换成另一个接口的相关内容。适配器需要实现目标接口，持有原接口的对象。
          在目标接口方法中将原接口对象处理成所需要的内容。
 */
public class AdapterPattern {

	// Target
	public interface Robot {
		void cry();
		void move();
	}
	
	public class BioRobot implements Robot {

		@Override
		public void cry() {
			System.out.println("仿生机器人叫...");
		}

		@Override
		public void move() {
			System.out.println("仿生机器人慢慢移动...");
		}
	}
	
	public class Dog {
		public void wang() {
			System.out.println("小狗叫：汪汪...");
		}
		
		public void run() {
			System.out.println("小狗快快跑...");
		}
	}
	
	// Adapter
	public class DogAdapter implements Robot {
		Dog dog;
		public DogAdapter(Dog dog) {
			this.dog = dog;
		}
		
		@Override
		public void cry() {
			System.out.println("机器人模拟狗叫...");
			dog.wang();
		}

		@Override
		public void move() {
			System.out.println("机器人模拟狗跑...");
			dog.run();
		}
	}
	
	public static void main(String[] args) {
//		BioRobot robot = new AdapterPattern().new BioRobot();
		Dog dog = new AdapterPattern().new Dog();
		
		Robot dogRobot = new AdapterPattern().new DogAdapter(dog);
		
		System.out.println("BioRob cry...");
		dogRobot.cry();
		dogRobot.move();
	}
}
