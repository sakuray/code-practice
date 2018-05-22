package com.sakuray.code.practice.pattern.struct;

/**
 * 装饰模式：
 *   装饰者模式，动态地将责任附加到对象上。若要扩展功能，装饰者提供了比继承更加有弹性的替代方案。
 * 模式结构：
 *   Component: 抽象构件。是定义一个对象接口，可以给这些对象动态地添加职责。
     ConcreteComponent:具体构件。是定义了一个具体的对象，也可以给这个对象添加一些职责。
     Decorator: 抽象装饰类。是装饰抽象类，继承了Component,从外类来扩展Component类的功能，但对于Component来说，是无需知道Decorator存在的。
     ConcreteDecorator:具体装饰类，起到给Component添加职责的功能。
 * 适用场景：
 *   1、在不影响其他对象的情况下，以动态、透明的方式给单个对象添加职责。
     2、需要动态地给一个对象增加功能，这些功能也可以动态地被撤销。  当不能采用继承的方式对系统进行扩充或者采用继承不利于系统扩展和维护时。
 * 个人理解：
 *   装饰模式如其名字，有一个装饰类，继承了被装饰类，这就意味着可以对被装饰类的每一个方法字段采取其它手段实现，也意味着能够不断装饰。
 *   桥接模式只需要持有对象，与原对象不一样。装饰模式相当于对原对象包装了一层。
 */
public class DecorativePattern {

	// Component:
	public abstract class Beverage {
		protected String description = "Unknown Beverage";
		
		public String getDescription() {
			return description;
		}
		
		public abstract double cost();
	}
	
	// ConcreteComponent:
	public class HouseBlend extends Beverage {
		
		public HouseBlend() {
			description = "HouseBlend";
		}

		@Override
		public double cost() {
			return 0.89;
		}
		
	}
	
	public class DarkRoast extends Beverage {
		
		public DarkRoast() {
			description = "DarkRoast";
		}

		@Override
		public double cost() {
			return 1.05;
		}
		
	}
	
	public class Espresso extends Beverage {
		
		public Espresso() {
			description = "Espresso";
		}

		@Override
		public double cost() {
			return 2.16;
		}
		
	}
	
	public class Decat extends Beverage {
		
		public Decat() {
			description = "Decat";
		}

		@Override
		public double cost() {
			return 0.99;
		}
		
	}
	
	// Decorator
	public abstract class CondimentDecorator extends Beverage {
		
	}
	
	// ConcreteDecorator
	public class Milk extends CondimentDecorator {
		
		Beverage beverage;
		
		public Milk(Beverage beverage) {
			this.beverage = beverage;
		}
		
		@Override
		public String getDescription() {
			return beverage.getDescription() + ", Milk";
		}

		@Override
		public double cost() {
			return beverage.cost() + 0.3;
		}
		
	}
	
	public class Mocha extends CondimentDecorator {
	    Beverage beverage;
	    public Mocha(Beverage beverage){
	        this.beverage = beverage;
	    }
	    
	    @Override
	    public String getDescription() {
	        return beverage.getDescription() + " , Mocha";
	    }

	    @Override
	    public double cost() {
	        return beverage.cost() + 0.20;
	    }

	}
	
	public class Soy extends CondimentDecorator{
	    Beverage beverage;
	    public Soy(Beverage beverage) {
	        this.beverage = beverage;
	    }
	    @Override
	    public String getDescription() {
	        return beverage.getDescription() + " , Soy";
	    }

	    @Override
	    public double cost() {
	        return beverage.cost() + 0.10;
	    }
	}
	
	public class Whip extends CondimentDecorator {
	    Beverage beverage;
	    public Whip(Beverage beverage){
	        this.beverage = beverage;
	    }
	    @Override
	    public String getDescription() {
	        return beverage.getDescription() + " , Whip";
	    }

	    @Override
	    public double cost() {
	        return beverage.cost() + 0.20;
	    }

	}
	
	public static void main(String[] args) {
		DecorativePattern pattern = new DecorativePattern();
		Beverage beverage = pattern.new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());
        
        Beverage beverage2 = pattern.new DarkRoast();
        beverage2 = pattern.new Mocha(beverage2);
        beverage2 = pattern.new Mocha(beverage2);
        beverage2 = pattern.new Whip(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());    
	}
}
