package com.sakuray.code.practice.pattern.create;

import java.util.ArrayList;
import java.util.List;

/**
 * 工厂方法模式：
 *   在披萨实例中，如果我想根据地域的不同生产出不同口味的披萨，如纽约口味披萨，芝加哥口味披萨。
 *   如果利用简单工厂模式，我们需要两个不同的工厂，NYPizzaFactory、ChicagoPizzaFactory。
 *   在该地域中有很多的披萨店，他们并不想依照总店的制作流程来生成披萨，而是希望采用他们自己的制作流程。
 *   这个时候如果还使用简单工厂模式，因为简单工厂模式是将披萨的制作流程完全承包了。那么怎么办？
 *   解决方案：
 *     我们可以这样解决：将披萨的制作方法交给各个披萨店完成，
 *     但是他们只能提供制作完成的披萨，披萨的订单处理仍然要交给披萨工厂去做。
 *     也就是说，我们将createPizza()方法放回到PizzaStore中，其他的部分还是保持不变。
 * 模式结构：
 *   Product：抽象产品。所有的产品必须实现这个共同的接口，这样一来，使用这些产品的类既可以引用这个接口。而不是具体类。
     ConcreteProduct：具体产品。
     Creator：抽象工厂。它实现了所有操纵产品的方法，但不实现工厂方法。Creator所有的子类都必须要实现factoryMethod()方法。
     ConcreteCreator：具体工厂。制造产品的实际工厂。它负责创建一个或者多个具体产品，只有ConcreteCreator类知道如何创建这些产品。
    适用场景：
     1、一个类不知道它所需要的对象的类。在工厂方法模式中，我们不需要具体产品的类名，我们只需要知道创建它的具体工厂即可。
     2、一个类通过其子类来指定创建那个对象。在工厂方法模式中，对于抽象工厂类只需要提供一个创建产品的接口，而由其子类来确定具体要创建的对象，在程序运行时，子类对象将覆盖父类对象，从而使得系统更容易扩展。
     3、将创建对象的任务委托给多个工厂子类中的某一个，客户端在使用时可以无须关心是哪一个工厂子类创建产品子类，需要时再动态指定。
 * 个人理解：
 *   和抽象工厂很像，不同的是抽象工厂将具体的工厂放在具体的产品中，要知道产品，
 *   而工厂方法则是将产品放入具体工厂中，需要知道具体工厂
 */
public class FactoryMethodPattern {

	// 抽象产品
    public abstract class Pizza {
        protected String name;      //名称
        protected String dough;     //面团
        protected String sause;     //酱料
        protected List<String> toppings = new ArrayList<String>();
        
        public void prepare() {
            System.out.println("Preparing " + name);
            System.out.println("Tossing dough");
            System.out.println("Adding sause");
            System.out.println("Adding toppings ");
            for(int i = 0; i < toppings.size(); i++) {
                System.out.println("  " + toppings.get(i));
            }
        }
        
        public void bake() {
            System.out.println("Bake for 25 minutes at 350");
        }
        
        public void cut() {
            System.out.println("Cutting the pizza into diagonal slices");
        }
        
        public void box() {
            System.out.println("Place pizza in official PizzaStore box");
        }
        
        public String getName() {
            return name;
        }
    }
    
    //具体产品
    public class NYStyleCheesePizza extends Pizza {
        public NYStyleCheesePizza() {
            name = "Ny Style Sauce and Cheese Pizza";
            dough = "Thin Crust Dough";
            sause = "Marinara Sauce";
            
            toppings.add("Crated Reggiano Cheese");
        }
    }
    
    public class ChicagoStyleCheesePizza extends Pizza {
        public ChicagoStyleCheesePizza() {
            name = "Chicago Style Deep Dish Cheese Pizza";
            dough = "Extra Thick Crust Dough";
            sause = "Plum Tomato Sauce";
            
            toppings.add("Shredded Mozzarella Cheese");
        }
        
        public void cut() {
            System.out.println("Cutting the Pizza into square slices");
        }
    }
    
    // 抽象工厂
    public abstract class PizzaStore {
        public Pizza orderPizza(String type) {
            Pizza pizza;
            pizza = createPizza(type);
            
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
            
            return pizza;
        }
        //创建pizza的方法交给子类实现
        abstract Pizza createPizza(String type);
    } 
    
    // 具体工厂
    public class NYPizzaStore extends PizzaStore {

        @Override
        Pizza createPizza(String type) {
            Pizza pizza = null;
            if("cheese".equals(type)) {
                pizza = new NYStyleCheesePizza();
            } else if ("veggie".equals(type)) {
//                pizza = new NYStyleVeggiePizza();
            } else if ("clam".equals(type)) {
//                pizza = new NYStyleClamPizza();
            } else if ("pepperoni".equals(type)) {
//                pizza = new NYStylePepperoniPizza();
            }
            
            return pizza;
        }
        
    }
    
    public class ChicagoPizzaStore extends PizzaStore {

        @Override
        Pizza createPizza(String type) {
            Pizza pizza = null;
            
            if("cheese".equals(type)) {
                pizza = new ChicagoStyleCheesePizza();
            } else if ("veggie".equals(type)) {
//                pizza = new ChicagoStyleVeggiePizza();
            } else if ("clam".equals(type)) {
//                pizza = new ChicagoStyleClamPizza();
            } else if ("pepperoni".equals(type)) {
//                pizza = new ChicagoStylePepperoniPizza();
            }
            
            return pizza;
        }
        
    }
    
    public static void main(String[] args) {
    	FactoryMethodPattern factory = new FactoryMethodPattern();
        
        System.out.println("---------Joel 需要的芝加哥的深盘披萨---------");
        ChicagoPizzaStore chicagoPizzaStore = factory.new ChicagoPizzaStore();
        Pizza joelPizza = chicagoPizzaStore.orderPizza("cheese");
        System.out.println("Joel ordered a " + joelPizza.getName() + "\n");
        
        System.out.println("---------Ethan 需要的纽约风味的披萨---------");
        NYPizzaStore nyPizzaStore =  factory.new NYPizzaStore();
        Pizza ethanPizza = nyPizzaStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + ethanPizza.getName() + "\n");
        
    }
}
