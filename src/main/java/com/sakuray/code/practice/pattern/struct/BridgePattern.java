package com.sakuray.code.practice.pattern.struct;

/**
 * 桥接模式：
 *   桥接模式即将抽象部分与它的实现部分分离开来，使他们都可以独立变化。
          桥接模式将继承关系转化成关联关系，它降低了类与类之间的耦合度，减少了系统中类的数量，也减少了代码量。
 * 模式结构：
 *   Abstraction：抽象类。 
     RefinedAbstraction：扩充抽象类。 
     Implementor：实现类接口。 
     ConcreteImplementor：具体实现类 。 
 * 使用场景：
 *   1、如果一个系统需要在构件的抽象化角色和具体化角色之间增加更多的灵活性，避免在两个层次之间建立静态的继承联系，通过桥接模式可以使它们在抽象层建立一个关联关系。
     2、对于那些不希望使用继承或因为多层次继承导致系统类的个数急剧增加的系统，桥接模式尤为适用。
     3、一个类存在两个独立变化的维度，且这两个维度都需要进行扩展。
 * 个人理解：
 *   桥接模式是将两个变化的事务组合起来，而不是采用多个子类实现的方式完成。前提示有两个以上的维度会变化，比如这里的形状和颜色，如果只有一个就没必要使用桥接。
 */
public class BridgePattern {

	// 抽象类
	public abstract class Shape {
		Color color;
		
		public void setColor(Color color) {
			this.color = color;
		}
		
		public abstract void draw();
	}
	
	public class Circle extends Shape {

		@Override
		public void draw() {
			color.bepaint("圆形");
		}
		
	}
	
	public class Rectangle extends Shape {

		@Override
		public void draw() {
			color.bepaint("长方形");
		}
		
	}
	
	public class Square extends Shape {

		@Override
		public void draw() {
			color.bepaint("正方形");
		}
		
	}
	
	// 接口
	public interface Color {
		public void bepaint(String shape);
	}
	
	public class White implements Color {

		@Override
		public void bepaint(String shape) {
			System.out.println("白色的"+shape);
		}
		
	}
	
	public class Gray implements Color {

		@Override
		public void bepaint(String shape) {
			System.out.println("灰色的"+shape);
		}
		
	}
	
	public class Black implements Color {

		@Override
		public void bepaint(String shape) {
			System.out.println("黑色的"+shape);
		}
		
	}
	
	public static void main(String[] args) {
		BridgePattern pattern = new BridgePattern();
		Color white = pattern.new White();
		Shape square = pattern.new Square();
		
		square.setColor(white);
		square.draw();
		
		Shape rectange = pattern.new Rectangle();
		rectange.setColor(white);
		rectange.draw();
	}
}
