package com.sakuray.code.practice.pattern.create;

/**
 * 建造者模式
        建造者模式将一个复杂对象的构建与表示分离，使得同样的构建过程可以创建不同的表示。
        建造者模式构建复杂对象就像造汽车一样，是一个一个组件一个一个步骤创建出来的，
        它允许用户通过制定的对象类型和内容来创建他们，但是用户并不需要知道这个复杂对象是如何构建的，
        它只需要明白通过这样做我可以得到一个完整的复杂对象实例。
 * 模式结构：
    Builder：抽象建造者。它声明为创建一个Product对象的各个部件指定的抽象接口。 
    ConcreteBuilder：具体建造者。实现抽象接口，构建和装配各个部件。 
    Director：指挥者。构建一个使用Builder接口的对象。它主要是用于创建一个复杂的对象，它主要有两个作用，
                            一是：隔离了客户与对象的生产过程，二是：负责控制产品对象的生产过程。 
    Product：产品角色。一个具体的产品对象。
 * 适用场景
    1、需要生成的产品对象有复杂的内部结构，这些产品对象通常包含多个成员属性。 
    2、隔离复杂对象的创建和使用，并使得相同的创建过程可以创建不同的产品。
 * 个人理解：
	产品本身是通过建造者一步步创建的，指挥者持有创建者，调用创建者的方法来创建产品
 */
public class BuilderPattern {

	// Product
    public class Meal {
        
        private String food;
        private String drink;
        
        public String getFood() {
            return food;
        }
        public void setFood(String food) {
            this.food = food;
        }
        public String getDrink() {
            return drink;
        }
        public void setDrink(String drink) {
            this.drink = drink;
        }
        
    }
    
    // Builder
    public abstract class MealBuilder {
        Meal meal = new Meal();
        
        public abstract void buildFood();
        
        public abstract void buildDrink();
        
        public Meal getMeal() {
            return meal;
        }
    }
    
    // ConcreteBuilder A
    public class MealA extends MealBuilder {

        @Override
        public void buildFood() {
            meal.setDrink("一杯可乐");
        }

        @Override
        public void buildDrink() {
            meal.setFood("一盒薯条");
        }
        
    }
    
    // ConcreteBuilder B
    public class MealB extends MealBuilder {

        @Override
        public void buildFood() {
            meal.setDrink("一杯柠檬汁");
        }

        @Override
        public void buildDrink() {
            meal.setFood("三个鸡翅");
        }
        
    }
    
    // Director 
    public class KFCWaiter {
        private MealBuilder mealBuilder;
        
        public void setMealBuilder(MealBuilder mealBuilder) {
            this.mealBuilder = mealBuilder;
        }
        
        public Meal construct() {
            // 准备食物
            mealBuilder.buildFood();
            mealBuilder.buildDrink();
            
            return mealBuilder.getMeal();
        }
    }
    
    public static void main(String[] args) {
        KFCWaiter waiter = new BuilderPattern().new KFCWaiter();
        MealA a = new BuilderPattern().new MealA();
        waiter.setMealBuilder(a);
        Meal mealA = waiter.construct();
        System.out.print("套餐A的组成部分:");
        System.out.println(mealA.getFood() + "---" + mealA.getDrink());
    }
}
