package com.sakuray.code.practice.pattern.struct;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元模式：
 *   所谓享元模式就是运行共享技术有效地支持大量细粒度对象的复用。系统使用少量对象,而且这些都比较相似，状态变化小，可以实现对象的多次复用。
          共享模式是支持大量细粒度对象的复用，所以享元模式要求能够共享的对象必须是细粒度对象。
          在了解享元模式之前我们先要了解两个概念：内部状态、外部状态。
          内部状态：在享元对象内部不随外界环境改变而改变的共享部分。
          外部状态：随着环境的改变而改变，不能够共享的状态就是外部状态。
          如何利用享元模式呢？这里我们只需要将他们少部分的不同的部分当做参数移动到类实例的外部去，然后再方法调用的时候将他们传递过来就可以了。
          这里也就说明了一点：内部状态存储于享元对象内部，而外部状态则应该由客户端来考虑。<br/>
 * 模式结构：
 *   Flyweight: 抽象享元类。所有具体享元类的超类或者接口，通过这个接口，Flyweight可以接受并作用于外部专题。<br/>
     ConcreteFlyweight: 具体享元类。指定内部状态，为内部状态增加存储空间。 <br/>
     UnsharedConcreteFlyweight: 非共享具体享元类。指出那些不需要共享的Flyweight子类。<br/> 
     FlyweightFactory: 享元工厂类。用来创建并管理Flyweight对象，它主要用来确保合理地共享Flyweight，当用户请求一个Flyweight时，FlyweightFactory就会提供一个已经创建的Flyweight对象或者新建一个（如果不存在）。<br/>
 * 适用场景：
 *   1、如果一个系统中存在大量的相同或者相似的对象，由于这类对象的大量使用，会造成系统内存的耗费，可以使用享元模式来减少系统中对象的数量。
     2、对象的大部分状态都可以外部化，可以将这些外部状态传入对象中。
 * 个人理解：
 *   
 */
public class FlyweightPattern {
	
	public static abstract class Shape {
	    public abstract void draw();
	}
	
	public static class Circle extends Shape{
	    private String color;
		public Circle(String color){
	        this.color = color;
	    }

	    public void draw() {
	        System.out.println("画了一个" + color +"的圆形");
	    }
	}
	/**
	 * 享元模式的核心在于享元工厂类，享元工厂类的作用在于提供一个用于存储享元对象的享元池，
	 * 用户需要对象时，首先从享元池中获取，如果享元池中不存在，则创建一个新的享元对象返回给用户，并在享元池中保存该新增对象。
	 */
	public static class FlyweightFactory{
	    static Map<String, Shape> shapes = new HashMap<String, Shape>();
	    
	    public static Shape getShape(String key){
	        Shape shape = shapes.get(key);
	        //如果shape==null,表示不存在,则新建,并且保持到共享池中
	        if(shape == null){
	            shape = new Circle(key);
	            shapes.put(key, shape);
	        }
	        return shape;
	    }
	    
	    public static int getSum(){
	        return shapes.size();
	    }
	}
	
	public static void main(String[] args) {
		Shape shape1 = FlyweightFactory.getShape("红色");
        shape1.draw();
        
        Shape shape2 = FlyweightFactory.getShape("灰色");
        shape2.draw();
        
        Shape shape3 = FlyweightFactory.getShape("绿色");
        shape3.draw();
        
        Shape shape4 = FlyweightFactory.getShape("红色");
        shape4.draw();
        
        Shape shape5 = FlyweightFactory.getShape("灰色");
        shape5.draw();
        
        Shape shape6 = FlyweightFactory.getShape("灰色");
        shape6.draw();
        
        System.out.println("一共绘制了"+ FlyweightFactory.getSum()+"中颜色的圆形");
	}
}
