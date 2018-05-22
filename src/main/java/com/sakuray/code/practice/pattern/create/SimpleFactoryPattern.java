package com.sakuray.code.practice.pattern.create;

import com.sakuray.code.practice.pattern.create.SimpleFactoryPattern.Pizza;

/**
 * 简单工厂模式：
 *   我们应该针对接口编程，而不是实现编程。直接new就是对实现编程
 * 模式分析：
 *   Factory：工厂角色。专门用于创建实例类的工厂，提供一个方法，
 *            该方法根据传递的参数不同返回不同类的具体实例。
     Product：抽象产品角色。为所有产品的父类。
     ConcreteProduct：具体的产品角色。
 * 模式场景：
 *   在一个披萨店中，要根据不同客户的口味，生产不同的披萨，如素食披萨、希腊披萨等披萨。
 * 应用场景：
 *   1、  工厂类负责创建的对象比较少。
     2、  客户端只知道传入工厂类的参数，对于如何创建对象不关心。
      个人理解：
          产品负责自己的生命周期，销售需要工厂来制作，工厂决定制作那种产品
 */
public class SimpleFactoryPattern {
    
    public abstract class Pizza {
        public abstract void prepare();
        public abstract void bake();
        public abstract void cut();
        public abstract void box();
    }
    
    public class CheesePizza extends Pizza {
        @Override
        public void prepare() {
            System.out.println("prepare CheesePizza ...");
        }
        @Override
        public void bake() {
            System.out.println("bake CheesePizza ...");
        }
        @Override
        public void cut() {
            System.out.println("cut CheesePizza ...");
        }
        @Override
        public void box() {
            System.out.println("box CheesePizza ...");
        }
    }
    
    public class ClamPizza extends Pizza {
        @Override
        public void prepare() {
            System.out.println("prepare ClamPizza ...");
        }
        @Override
        public void bake() {
            System.out.println("bake ClamPizza ...");
        }
        @Override
        public void cut() {
            System.out.println("cut ClamPizza ...");
        }
        @Override
        public void box() {
            System.out.println("box ClamPizza ...");
        }
    }
    
    public class PepperoniPizza extends Pizza {
        @Override
        public void prepare() {
            System.out.println("prepare PepperoniPizza ...");
        }
        @Override
        public void bake() {
            System.out.println("bake PepperoniPizza ...");
        }
        @Override
        public void cut() {
            System.out.println("cut PepperoniPizza ...");
        }
        @Override
        public void box() {
            System.out.println("box PepperoniPizza ...");
        }
    }
    
    public class VeggiePizza extends Pizza {
        @Override
        public void prepare() {
            System.out.println("prepare VeggiePizza ...");
        }
        @Override
        public void bake() {
            System.out.println("bake VeggiePizza ...");
        }
        @Override
        public void cut() {
            System.out.println("cut VeggiePizza ...");
        }
        @Override
        public void box() {
            System.out.println("box VeggiePizza ...");
        }
    }
    
    public Pizza createPizza(String type) throws Exception {
        Pizza pizza = null;
        if(type.equals("cheese")) {
            pizza = new CheesePizza();
        } else if (type.equals("clam")) {
            pizza = new ClamPizza();
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza();
        } else if(type.equals("veggie")) {
            pizza = new VeggiePizza();
        } else {
            throw new Exception();
        }
        return pizza;
    }
    
    public static void main(String[] args) {
        PizzaStore store = new PizzaStore(new SimpleFactoryPattern());
        try {
            store.orderPizza("cheese");
        } catch (Exception ex) {
            System.out.println("unknow type of pizza");
        }
    }
}

class PizzaStore {
	SimpleFactoryPattern factory;
    public PizzaStore(SimpleFactoryPattern factory) {
        this.factory = factory;
    }
    
    public Pizza orderPizza(String type) throws Exception {
        Pizza pizza;
        pizza = factory.createPizza(type);
        
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        
        return pizza;
    }
}

