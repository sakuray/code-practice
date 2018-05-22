package com.sakuray.code.practice.pattern.behave;

/**
 * 模板方法模式：
 *   所谓模板方法模式就是在一个方法中定义一个算法的骨架，而将一些步骤延迟到子类中。模板方法使得子类可以在不改变算法结构的情况下，重新定义算法中的某些步骤。
 * 模式接口：
 *   AbstractClass: 抽象类
     ConcreteClass:  具体子类
      适用场景：
     1、 一次性实现一个算法的不变的部分，并将可变的行为留给子类来实现。
     2、 各子类中公共的行为应被提取出来并集中到一个公共父类中以避免代码重复。
     3、控制子类的扩展。
      个人理解：
          模板方法有一个抽象类，定义了整个流程，且为final不能修改，一些共用的流程已经实现，有区别的由子类实现，但是大方向定向了。
 */
public class TemplateMethodPattern {

	// 抽象类
	public abstract class CaffeineBeverage {
		// 模板方法，控制流程，为final 不希望子类覆盖这个方法，防止更改流程的执行顺序
		final void prepareRecipe() {
			boilWater();
			brew();
			pourInCup();
			addCondiments();
		}
		
		abstract void brew();
		
		abstract void addCondiments();
		
		void boilWater() {
			System.out.println("Boiling water...");
		}
		
		void pourInCup() {
			System.out.println("Pouring into Cup...");
		}
	}
	
	public class Coffee extends CaffeineBeverage {

		@Override
		void brew() {
			System.out.println("Dripping Coffee through filter...");
		}

		@Override
		void addCondiments() {
			System.out.println("Adding Sugar and Milk...");
		}
		
	}
	
	public class Tea extends CaffeineBeverage {

		@Override
		void brew() {
			System.out.println("Steeping the tea...");
		}

		@Override
		void addCondiments() {
			System.out.println("Adding Lemon...");
		}
		
	}
	
	public static void main(String[] args) {
		Tea tea = new TemplateMethodPattern().new Tea();
		tea.prepareRecipe();
	}
}
