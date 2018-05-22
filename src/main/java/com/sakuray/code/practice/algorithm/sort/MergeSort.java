package com.sakuray.code.practice.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序：分治，当排序的序列长度为1时，递归，长度为1的每个序列都已排好序了。
 * 性能：
 * 		最好时间分析：O(nlogn)
 * 		最差时间分析：O(nlogn)
 * 		平均时间分析：O(nlogn)
 * 		稳定度：稳定
 * 		空间复杂度：O(n)
 */
public class MergeSort {

	public static void sort(int[] obj) {
		mergeSort(obj,0,obj.length - 1);
	}
	
	// 分
	private static void mergeSort(int[] obj,int f, int l) {
		if(f < l) {
			int m = (f + l) / 2;
			mergeSort(obj, f, m);
			mergeSort(obj, m+1, l);
			merge(obj,f,m,l);
		}
	}
	
	// 合
	private static void merge(int[] obj,int f,int m, int l) {
		int n1 = m - f + 1;
		int n2 = l - m;
		
		int[] left = new int[n1+1];
		int[] right = new int[n2+1];
		
		for(int i = 0; i < n1; i++) {
			left[i] = obj[f+i];
		}
		
		for(int i = 0; i < n2; i++) {
			right[i] = obj[m+i+1];
		}
		
		left[n1] = Integer.MAX_VALUE;
		right[n2] = Integer.MAX_VALUE;
		
		int i = 0;
		int j = 0;
		for(int k = f; k <= l; k++) {
			if(left[i] <= right[j]) {
				obj[k] = left[i];
				i += 1;
			} else {
				obj[k] = right[j];
				j += 1;
			}
		}
		System.out.println(Arrays.toString(obj));
	}
}
