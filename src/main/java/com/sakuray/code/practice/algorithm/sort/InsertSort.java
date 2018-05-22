package com.sakuray.code.practice.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序:保证前面的序列有序 
 * 性能：
 * 		最好时间分析：O(n)
 * 		最差时间分析：O(n2)
 * 		平均时间分析：O(n2)
 * 		稳定度：稳定
 * 		空间复杂度：O(1)
 */
public class InsertSort {

	public static void sortAsc(int[] obj) {
		for(int i = 1; i<obj.length; i++) {
			int key = obj[i];
			int j;
			for(j = i - 1; j >= 0; j--) {
				int temp = obj[j];
				if(key < temp) {
					obj[j+1] = temp;
				} else {
					break;
				}
			}
			obj[j+1] = key;
			System.out.println(Arrays.toString(obj));
		}
	}
	
	public static void sortDesc(int[] obj) {
		for(int i = 1; i < obj.length; i++) {
			int key = obj[i];
			int j;
			for(j = i - 1; j >= 0; j--) {
				int temp = obj[j];
				if(key > temp) {
					obj[j+1] = temp;
				} else {
					break;
				}
			}
			obj[j+1] = key;
			System.out.println(Arrays.toString(obj));
		}
	}
}
