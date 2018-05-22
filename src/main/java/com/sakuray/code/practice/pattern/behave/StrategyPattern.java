package com.sakuray.code.practice.pattern.behave;

import java.util.Arrays;

/**
 * 策略模式：
 *   首先我们需要知道策略模式与状态模式是如此的相似，就犹如一对双胞胎一样。
 *   只不过状态模式是通过改变对象内部的状态来帮助对象控制自己的行为，而策略模式则是围绕可以互换的算法来创建成功业务的。
 *   所谓策略模式就是定义了算法族，分别封装起来，让他们之前可以互相转换，此模式然该算法的变化独立于使用算法的客户。
 * 模式结构：
 * 	 Context:环境类。
 *   Strategy:抽象策略
 *   ConcreteStrategy:具体策略
 * 使用场景：
 *   1、如果在一个系统里面有许多类，它们之间的区别仅在于它们的行为，那么使用策略模式可以动态地让一个对象在许多行为中选择一种行为。 
     2、一个系统需要动态地在几种算法中选择一种。 
     3、如果一个对象有很多的行为，如果不用恰当的模式，这些行为就只好使用多重的条件选择语句来实现。
      个人理解：
          策略模式和状态模式很像，但是状态模式通过改变自身的状态，来改变类的行为，行为可能又会修改状态。
          状态模式将动作实现和职责分离，动作委托到当前状态对象来执行。
          策略模式对方法本身进行封装，委派给不同的对象进行管理。要使用哪个策略就设置委派的对象来使用相应的方法。
 */
public class StrategyPattern {

	// 抽象策略
	public interface Sort {
		public abstract int[] sort(int arr[]);
	}
	
	// 具体策略
	public class BubbleSort implements Sort {

		@Override
		public int[] sort(int[] arr) {
			int len = arr.length;
			for (int i = 0; i < len; i++) {
				for (int j = i + 1; j < len; j++) {
					int temp;
					if (arr[i] > arr[j]) {
						temp = arr[j];
						arr[j] = arr[i];
						arr[i] = temp;
					}
				}
			}
			System.out.println("冒泡排序");
			return arr;
		}
	}
	
	public class InsertionSort implements Sort {
		@Override
		public int[] sort(int[] arr) {
			int len = arr.length;
	        for (int i = 1; i < len; i++) {
	            int j;
	            int temp = arr[i];
	            for (j = i; j > 0; j--) {
	                if (arr[j - 1] > temp) {
	                    arr[j] = arr[j - 1];

	                } else
	                    break;
	            }
	            arr[j] = temp;
	        }
	        System.out.println("插入排序");
	        return arr;
		}
	}
	
	public class SelectionSort implements Sort {

		@Override
		public int[] sort(int[] arr) {
			int len = arr.length;
	        int temp;
	        for (int i = 0; i < len; i++) {
	            temp = arr[i];
	            int j;
	            int samllestLocation = i;
	            for (j = i + 1; j < len; j++) {
	                if (arr[j] < temp) {
	                    temp = arr[j];
	                    samllestLocation = j;
	                }
	            }
	            arr[samllestLocation] = arr[i];
	            arr[i] = temp;
	        }
	        System.out.println("选择排序");
	        return arr;
		}
	}
	
	// 环境
	public class ArrayHandler {
		private Sort sortObj;
		
		public int[] sort(int arr[]) {
			sortObj.sort(arr);
			return arr;
		}

		public void setSortObj(Sort sortObj) {
			this.sortObj = sortObj;
		}
		
	}
	
	public static void main(String[] args) {
		int arr[] = {1, 4, 6, 2, 5, 3, 7, 10, 9};
		ArrayHandler ah = new StrategyPattern().new ArrayHandler();
		
		Sort sort = new StrategyPattern().new SelectionSort();
		ah.setSortObj(sort);
		System.out.println(Arrays.toString(ah.sort(arr)));
	}
}
