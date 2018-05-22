package com.sakuray.code.practice.pattern.struct;

/**
 * 外观模式：
 *   所谓外观模式就是提供一个统一的接口，用来访问子系统中的一群接口。
          外观模式定义了一个高层接口，让子系统更容易使用。
 * 模式结构：
 *   Facade: 外观角色
     SubSystem:子系统角色
 * 适用场景：
 *   1、当要为一个复杂子系统提供一个简单接口时可以使用外观模式。
     2、客户程序与多个子系统之间存在很大的依赖性。引入外观类将子系统与客户以及其他子系统解耦，可以提高子系统的独立性和可移植性
 * 个人理解：
 *   就是一系列子类封装到一个外观中，外观调一个方法，触发子类一系列方法。
 */
public class AppearancePattern {
	
	public class Television {
		public void on() {
			System.out.println("打开了电视...");
		}
		
		public void off() {
			System.out.println("关闭了电视...");
		}
	}
	
	public class Light {
		public void on() {
			System.out.println("打开了电灯...");
		}
		
		public void off() {
			System.out.println("关闭了电灯...");
		}
	}
	
	public class AirCondition {
	    public void on(){
	        System.out.println("打开了空调....");
	    }
	    
	    public void off(){
	        System.out.println("关闭了空调....");
	    }
	}
	
	public class Screen {
	    public void up(){
	        System.out.println("升起银幕....");
	    }
	    
	    public void down(){
	        System.out.println("下降银幕....");        
	    }
	}
	
	public class WatchTvSwtichFacade {
	    Light light;
	    AirCondition ac;
	    Television tv;
	    Screen screen;
	    
	    public WatchTvSwtichFacade(Light light,AirCondition ac,Television tv,Screen screen){
	        this.light = light;
	        this.ac = ac;
	        this.tv = tv;
	        this.screen = screen;
	    }
	    
	    public void on(){
	        light.on();       //首先开灯
	        ac.on();          //然后是打开空调
	        screen.down();    //把银幕降下来
	        tv.on();          //最后是打开电视
	    }
	    
	    public void off(){
	        tv.off();         //首先关闭电视机
	        screen.up();      //银幕升上去
	        ac.off();         //空调关闭
	        light.off();      //最后关灯
	    }
	}
	
	public static void main(String[] args) {
		AppearancePattern pattern = new AppearancePattern();
		//实例化组件
        Light light = pattern.new Light();
        Television tv = pattern.new Television();
        AirCondition ac = pattern.new AirCondition();
        Screen screen = pattern.new Screen();
        
        WatchTvSwtichFacade watchTv = pattern.new WatchTvSwtichFacade(light, ac, tv, screen);
        
        watchTv.on();
        System.out.println("--------------可以看电视了.........");
        watchTv.off();
        System.out.println("--------------可以睡觉了...........");
	}
}
