package com.sakuray.code.practice.pattern.create;

/**
 * 单例模式：
 *   有时候某些对象我们只需要一个，如：线程池、缓存、对话框等等，对于这类对象我们只能有一个实例，如果我们制造出多个实例，就会导致很多问题产生。
 *   所谓单例模式就是确保某一个类只有一个实例，并且提供一个全局访问点。
 *   一、它只有一个实例。
           二、它必须要自行实例化。
           三、它必须自行想整个系统提供访问点。
 * 模式结构：
 *   Singleton：单例。
 * 使用场景：
 *   一、系统只需要一个实例对象，如系统要求提供一个唯一的序列号生成器，或者需要考虑资源消耗太大而只允许创建一个对象。
          二、客户调用类的单个实例只允许使用一个公共访问点，除了该公共访问点，不能通过其他途径访问该实例。
 */
public class SingletonPattern {

	private static SingletonPattern single;	// 方式2，直接初始化静态变量，饿汉式
	
	private SingletonPattern() {}
	
	public static SingletonPattern getInstance() {
		// 这样在多线程条件下依旧可能产生两个实例，两个都通过来single为null的判定就会发生
		if(single == null) {
			single = new SingletonPattern();
		}
		return single;
	}
	
	// 方式1：加上同步锁
	public static synchronized SingletonPattern getInstanceSafe() {
		if(single == null) {
			single = new SingletonPattern();
		}
		return single;
	}
	
	// 方法3：双重检查加锁
	public static SingletonPattern getInstanceSafe2() {
		if(single == null) {
			synchronized(SingletonPattern.class) {
				if(single == null) {
					single = new SingletonPattern();
				}
			}
		}
		return single;
	}
	
	// 方法4：静态内部类实现
	private static class InnerInstance {
		private static final SingletonPattern instance = new SingletonPattern();
	}
	public static final SingletonPattern getInstanceInner() {
		return InnerInstance.instance;
	}
	
	// 方法5：枚举  还能防止反序列化重新创建新的对象
	public enum SingletonEnum {
		INSTANCE;
		public void xxx() {
			
		}
	}
	
	/**
	 * 单例模式还有两个问题需要注意：
	 * 1.如果单例由不同的类装载器装入，那便有可能存在多个单例类的实例。假如不是远端存取，
	 * 	  如一些servlet容器对每个servlet使用完全不同的类装载器，这样如果两个servlet访问一个单例类，就会有各自的实例
	 * 2.如果单例类实现了serializable，那么这个类的实例就可能被序列化和反序列化，如果复原就会存在多个单例
	 */
	// 第一个问题的解决办法是：没看明白
	/*@SuppressWarnings({ "unused", "rawtypes" })
	private static Class getClass(String classname) throws ClassNotFoundException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		
		if(classLoader == null) {
			classLoader = SingletonPattern.class.getClassLoader();
		}
		return (classLoader.loadClass(classname));
	}*/
	
}
