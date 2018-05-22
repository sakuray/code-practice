package com.sakuray.code.practice.pattern.create;

/**
 * 原型模式：
 *   在面向对象系统中，我们可能希望克隆出若干个一模一样的对象。
 *   但是有些对象创建过程比较复杂，如果new该对象会带来很多的麻烦，原型模式可以满足这种需求。
 *   在原型模式中，我们可以利用一个原型对象来指明我们要创建的对象的类型，然后通过复制这个对象的方法来获得与该对象一模一样的对象实例。
 *   这就是原型模式的设计目的。
 *   所谓原型模式就是用原型实例指定创建对象的种类，并且通过复制这些原型创建新的对象。
 *   浅拷贝：使用一个已知实例对新创建实例的成员变量逐个赋值，这个方式被称为浅拷贝。
 *   深拷贝：当一个类的拷贝构造方法，不仅要复制对象的所有非引用成员变量值，还要为引用类型的成员变量创建新的实例，并且初始化为形式参数实例值。
 * 模式结构：
     Prototype：抽象原型类。声明克隆自身的接口。 
     ConcretePrototype：具体原型类。实现克隆的具体操作。 
     Client：客户类。让一个原型克隆自身，从而获得一个新的对象。
 * 使用场景：
 *   1、如果创建新对象成本较大，我们可以利用已有的对象进行复制来获得。
     2、如果系统要保存对象的状态，而对象的状态变化很小，或者对象本身占内存不大的时候，也可以使用原型模式配合备忘录模式来应用。相反，如果对象的状态变化很大，或者对象占用的内存很大，那么采用状态模式会比原型模式更好。 
     3、需要避免使用分层次的工厂类来创建分层次的对象，并且类的实例对象只有一个或很少的几个组合状态，通过复制原型对象得到新实例可能比使用构造函数创建一个新实例更加方便。
 */
public class PrototypePattern {
	
	public class Resume implements Cloneable {
		private String name;
		private String birthday;
		private String sex;
		private String school;
		private String timeArea;
		private String company;
		
		// 初始化简历赋值姓名
		public Resume(String name) {
			this.name = name;
		}
		
		public void setPersonInfo(String birthday,String sex, String school) {
			this.birthday = birthday;
			this.sex = sex;
			this.school = school;
		}
		
		public void setWorkExperience(String timeArea,String company) {
			this.timeArea = timeArea;
			this.company = company;
		}

		@Override
		protected Object clone() {
			Resume resume = null;
			try {
				resume = (Resume) super.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			return resume;
		}
		
		public void display() {
			System.out.println("姓名："+ name);
			System.out.println("生日：" + birthday + ",性别："+sex+",毕业学校："+school);
			System.out.println("工作年限：" + timeArea + ",公司：" + company);
		}
		
	}
	
	public static void main(String[] args) {
		Resume a = new PrototypePattern().new Resume("小李子");
		a.setPersonInfo("2.15", "男", "XX大学");
		a.setWorkExperience("2016.03.01", "XX科技公司");
		
		// 克隆对象
		Resume b = (Resume) a.clone();
		
		System.out.println("----------------A--------------");
		a.display();
		System.out.println("----------------B--------------");
		b.display();
		
		System.out.print("A==B?");
		System.out.println(a == b);
		
		System.out.print("A.getClass()==B.getClass()?");
		System.out.println(a.getClass() == b.getClass());
		
		System.out.print("A.equals(B)?");
		System.out.println(a.equals(b)); // 这个需要重写equals方法
	}
}
