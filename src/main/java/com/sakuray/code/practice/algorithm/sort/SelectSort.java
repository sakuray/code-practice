package com.sakuray.code.practice.algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序：选出数组中最大或最小的一个数放在数组首位
 * 性能：
 * 		最好时间分析：O(n2)
 * 		最差时间分析：O(n2)
 * 		平均时间分析：O(n2)
 * 		稳定度：不稳定([5,5,2]第一个5和2交换  导致5排到第2个5后面，所以不稳定)
 * 		空间复杂度：O(1)
 */
public class SelectSort {
	
	public static void sort(int[] obj) {
		for(int i = 0; i < obj.length - 1; i++) {
			int index = i;
			for(int j = i + 1; j < obj.length; j++) {
				if(obj[index] > obj[j]) {
					index = j;
				}
			}
			if(i != index) {
				int temp = obj[i];
				obj[i] = obj[index];
				obj[index] = temp;
			}
			System.out.println(Arrays.toString(obj));
		}
	}

}
