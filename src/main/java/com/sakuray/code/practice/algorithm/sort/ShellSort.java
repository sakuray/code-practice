package com.sakuray.code.practice.algorithm.sort;

import java.util.Arrays;

/**
 * 希尔排序：是一种插入排序，又称缩小增量排序
 * 性能：
 * 		最好时间分析：
 * 		最差时间分析：
 * 		平均时间分析：O(n1.25)
 * 		稳定度：不稳定
 * 		空间复杂度：O(1)
 * 例子：
 * 		9	1	5	8	3	7	4	6	2
 *      |———————————————|———————————————|
 *      	|———————————————|
 *      		|———————————————|
 *      			|———————————————|
 *      
 *      |———————|———————|———————|———————|	2
 *      	|———————|———————|———————|
 *      
 *      |———|———|———|———|———|———|———|———|	1
 */
public class ShellSort {

	public static void sort(int[] obj) {
		for(int step = obj.length / 2; step > 0; step /= 2) {
			for(int i = step; i < obj.length; i++) {
				for(int j = i - step; j >= 0; j -= step) {
					if(obj[j] > obj[j+step]) {
						int temp = obj[j];
						obj[j] = obj[j+step];
						obj[j+step] = temp;
					}
				}
			}
			System.out.println(Arrays.toString(obj));
		}
	}
}
