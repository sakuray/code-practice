package com.sakuray.code.practice.pattern.behave;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式（发布-订阅模式）：
 *  观察者模式定义了对象之间的一对多依赖关系。这样一来，当一个对象改变状态时，它的所有依赖者都会收到通知并且自动更新。
 *  发生改变的对象称之为观察目标，而被通知的对象称之为观察者。
 *  一个观察目标可以有多个观察者，而且这些观察者之间没有相互联系，所以可以根据需要增加和删除观察者，使得系统更易于扩展。
 * 基本结构：
 *   Subject：目标。他把所有对观察者对戏的引用保存在一个聚集里，每一个主题都可以有多个观察者。
     Observer：观察者。为所有的具体观察者定义一个接口，在得到主题的通知时能够及时的更新自己。
     ConcreteSubject：具体主题。将有关状态存入具体观察者对象。在具体主题发生改变时，给所有的观察者发出通知。
     ConcreteObserver:具体观察者。实现抽象观察者角色所要求的更新接口，以便使本身的状态与主题状态相协调。
     适用场景：
     1、一个抽象模型有两个方面，其中一个方面依赖于另一个方面。将这些方面封装在独立的对象中使它们可以各自独立地改变和复用。
     2、一个对象的改变将导致其他一个或多个对象也发生改变，而不知道具体有多少对象将发生改变，可以降低对象之间的耦合度。
     3、一个对象必须通知其他对象，而并不知道这些对象是谁。需要在系统中创建一个触发链，A对象的行为将影响B对象，B对象的行为将影响C对象……，可以使用观察者模式创建一种链式触发机制。
 * 个人理解：
 * 	 一个主题，实现者就是被观察对象，被观察对象要有注册观察者，移除，通知三个功能
 *   观察者观察主题，将其注册入被观察对象。
 *   被观察对象发生改变时，通过通知函数，通知所有观察者，就是调用观察者的受到观察者接口约束的方法
 */
public class ObserverPattern {
	// 主题接口 Subject
    public interface Subject {
        // 注册观察者
        public void registerObserver(Observer observer);
        
        // 删除观察者
        public void removeObserver(Observer observer);
        
        // 当主题发生变化时，这个方法要被调用，以通知所有的观察者
        public void notifyObserver();
    }
    
    // 观察者接口 Observer
    public interface Observer {
        public void update(float temp, float humidity, float pressure);
    }
    
    // 布告板显示接口
    public interface DisplayElement {
        public void display();
    }
    
    // 具体主题
    public class WeatherData implements Subject {
        
        private List<Observer> observers;
        private float temperature;
        private float pressure;
        private float humidity;
        
        public WeatherData() {
            observers = new ArrayList<Observer>();
        }

        @Override
        public void registerObserver(Observer observer) {
            observers.add(observer);
        }

        @Override
        public void removeObserver(Observer observer) {
            int i = observers.indexOf(observer);
            if(i >= 0) {
                observers.remove(i);
            }
        }

        @Override
        public void notifyObserver() {
            for(int i = 0; i < observers.size(); i++) {
                Observer observer = observers.get(i);
                observer.update(temperature, humidity, pressure);
            }
        }
        
        // 气象站得到更新的观测数据时，通知观察者
        public void measurementChanged() {
            notifyObserver();
        }
        
        public void setMeasurements(float temperature, float humidity, float pressure) {
            this.temperature = temperature;
            this.humidity = humidity;
            this.pressure = pressure;
            measurementChanged();
        }
    }
    
    // 布告板 CurrentConditionDisplay
    public class CurrentConditionsDisplay implements Observer, DisplayElement {

        private float temperature;
        private float humidity;
        private Subject weatherData;
        
        public CurrentConditionsDisplay(Subject weatherData) {
            this.weatherData = weatherData;
            this.weatherData.registerObserver(this);
        }
        
        @Override
        public void display() {
            System.out.println("Current conditions:" + temperature + "F degrees and " + humidity + "% humidity");
        }

        @Override
        public void update(float temp, float humidity, float pressure) {
            this.temperature = temp;
            this.humidity = humidity;
            display();
        }
        
    }
    
    public static void main(String[] args) {
         WeatherData weatherData = new ObserverPattern().new WeatherData();
         @SuppressWarnings("unused")
         CurrentConditionsDisplay conditionsDisplay = new ObserverPattern().new CurrentConditionsDisplay(weatherData);
         
         weatherData.setMeasurements(80, 65, 30.4f);
         weatherData.setMeasurements(82, 70, 29.2f);
         weatherData.setMeasurements(78, 78, 40.4f);
    }
}
