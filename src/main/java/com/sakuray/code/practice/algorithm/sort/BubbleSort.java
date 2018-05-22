package com.sakuray.code.practice.algorithm.sort;

/**
 * 冒泡排序：重复比较相邻的两个数，如果位置不对，就交换，直到没有可以交换的为止
 * 性能：
 * 		最好时间分析：O(n)
 * 		最差时间分析：O(n2)
 * 		平均时间分析：O(n2)
 * 		稳定度：稳定
 * 		空间复杂度：O(1)
 */
public class BubbleSort {
	
	public static void sort(int[] obj) {
		for(int i = 0; i < obj.length - 1; i++) {
			for(int j = 0; j < obj.length - i - 1; j++) {
				if(obj[j] > obj[j+1]) {
					int temp = obj[j];
					obj[j] = obj[j+1];
					obj[j+1] = temp;
				}
			}
//			System.out.println(Arrays.toString(obj));
		}
	}

	/**
	 * 简单修改：冒泡排序升序时保证了从最后位开始倒数一直都是有序
	 * 内循环比较前面的数字，如果没有发生位置交互等同于前面也是有序的，所以数组整体有序，可以跳出循环
	 * 减少比较次数，增加了空间和计算开销。
	 * 
	 * 经过测试，这种方法的时间开销会更大，计算比比较次数要慢
	 */
	public static void sort2(int[] obj) {
		for(int i = 0; i < obj.length - 1; i++) {
			int j;
			int flag = 0;
			for(j = 0; j < obj.length - i - 1; j++) {
				if(obj[j] > obj[j+1]) {
					int temp = obj[j];
					obj[j] = obj[j+1];
					obj[j+1] = temp;
				} else {
					flag += 1;
				}
			}
			if(flag == j) {
				break;
			}
//			System.out.println(Arrays.toString(obj));
		}
	}
}
