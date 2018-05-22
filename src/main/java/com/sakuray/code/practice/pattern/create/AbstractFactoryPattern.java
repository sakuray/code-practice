package com.sakuray.code.practice.pattern.create;

/**
 * 抽象工厂模式：
 * 抽象工厂模式提供一个接口，用于创建相关或者依赖对象的家族，而不需要明确指定具体类。
         抽象工厂允许客户端使用抽象的接口来创建一组相关的产品，而不需要关系实际产出的具体产品是什么。这样一来，客户就可以从具体的产品中被解耦。
      模式结构：
     AbstractFactory：抽象工厂。抽象工厂定义了一个接口，所有的具体工厂都必须实现此接口，这个接口包含了一组方法用来生产产品。
     ConcreteFactory：具体工厂。具体工厂是用于生产不同产品族。要创建一个产品，客户只需要使用其中一个工厂完全不需要实例化任何产品对象。
     AbstractProduct：抽象产品。这是一个产品家族，每一个具体工厂都能够生产一整组产品。
     Product：具体产品。
      个人理解：
          抽象工厂定义工厂行为，抽象产品定义了产品的步骤，与抽象工厂对应。
          提供具体的产品需要在产品中注册抽象工厂，执行抽象工厂的一系列方法完成产品。
          预定产品会将其工厂注入，然后执行工厂的一系列方法，最后返回该产品。
 */
public class AbstractFactoryPattern {
	
	// 原料类
    public class Dough{}
    public class Sauce{}
    public class Cheese{}
    public class Veggies{}
    public class Pepperoni{}
    public class Clams{}
    // 具体原料类
    public class ThinCrustDough extends Dough{}
    public class MarinaraSauce extends Sauce{}
    public class ReggianoCheese extends Cheese{}
    public class Garlic extends Veggies{}
    public class Onion extends Veggies{}
    public class Mushroom extends Veggies{}
    public class RefPepper extends Veggies{}
    public class SlicedPepperoni extends Pepperoni{}
    public class FreshClams extends Clams{}
    
    
    // 抽象工厂接口
    public interface PizzaIngredientFactory {
        // 每个原料都有一个对应的方法创建该原料
        public Dough createDough();
        public Sauce createSause();
        public Cheese createCheese();
        public Veggies[] createVeggies();
        public Pepperoni createPepperoni();
        public Clams createClams();
    }
    
    // 具体工厂
    public class NYPizzaIngredientFactory implements PizzaIngredientFactory {

        @Override
        public Dough createDough() {
            return new ThinCrustDough();
        }
        @Override
        public Sauce createSause() {
            return new MarinaraSauce();
        }
        @Override
        public Cheese createCheese() {
            return new ReggianoCheese();
        }
        @Override
        public Veggies[] createVeggies() {
            Veggies[] veggies =  {new Garlic(),new Onion(),new Mushroom(),new RefPepper()};
            return veggies;
        }
        @Override
        public Pepperoni createPepperoni() {
            return new SlicedPepperoni();
        }
        @Override
        public Clams createClams() {
            return new FreshClams();
        }
    }
    
    // 抽象产品
    public abstract class Pizza {
        String name;
        Dough dough;
        Sauce sauce;
        Veggies veggies[];
        Cheese cheese;
        Pepperoni pepperoni;
        Clams clams;
        
        abstract void prepare();
        
        void bake() {
            System.out.println("Bake for 25 minutes at 350");
        }
        
        void cut() {
            System.out.println("Cutting the pizza into diagonal slices");
        }
        
        void box() {
            System.out.println("Place pizza in officical PizzaStore box");
        }
        
        public String getName() {
            return name;
        }
        
        public void setName(String name) {
            this.name = name;
        }
    }
    
    // 具体产品
    public class CheesePizza extends Pizza {

        PizzaIngredientFactory ingredientFactory;
        
        public CheesePizza(PizzaIngredientFactory ingredientFactory) {
            this.ingredientFactory = ingredientFactory;
        }
        
        @Override
        void prepare() {
            System.out.println("Preparing " + name);
            dough = ingredientFactory.createDough();
            sauce = ingredientFactory.createSause();
            cheese = ingredientFactory.createCheese();
        }
    }
    
    public class ClamPizza extends Pizza {

        PizzaIngredientFactory ingredientFactory;
        
        public ClamPizza(PizzaIngredientFactory ingredientFactory) {
            this.ingredientFactory = ingredientFactory;
        }
        
        @Override
        void prepare() {
            System.out.println("Prepare " + name);
            dough = ingredientFactory.createDough();
            sauce = ingredientFactory.createSause();
            cheese = ingredientFactory.createCheese();
            clams = ingredientFactory.createClams();
        }
        
    }
    
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
        
        abstract Pizza createPizza(String type);
    }
    
    public class NYPizzaStore extends PizzaStore {

        @SuppressWarnings("null")
        @Override
        Pizza createPizza(String type) {
            Pizza pizza = null;
            PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
            if("cheese".equals(type)) {
                pizza = new CheesePizza(ingredientFactory);
                pizza.setName("New York Style Cheese Pizza");
            } else if ("veggie".equals(type)) {
//                pizza = new VeggiePizza(ingredientFactory);
                pizza.setName("New York Style veggie Pizza");
            } else if ("clam".equals(type)) {
                pizza = new ClamPizza(ingredientFactory);
                pizza.setName("New York Style clam Pizza");
            } else if ("pepperoni".equals(type)) {
//                pizza = new PepperoniPizza(ingredientFactory);
                pizza.setName("New York Style pepperoni Pizza");
            }
            return pizza;
        }
    }
    
    public static void main(String[] args) {
        PizzaStore pizzaStore = new AbstractFactoryPattern().new NYPizzaStore();
        pizzaStore.orderPizza("cheese");
    }
}
