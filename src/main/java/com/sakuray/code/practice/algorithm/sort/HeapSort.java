package com.sakuray.code.practice.algorithm.sort;

import java.util.Arrays;

/**
 * 堆排序：利用堆积树（堆）数据结构设计的一种排序算法，是选择排序的一种，是完全二叉树。
 * 		  堆分为大根堆和小根堆:这里使用的是大根堆，特点是:每个节点的值都不大于其父节点的值，即A[PARENT[i]] >= A[i]
 * 		  小根堆适用于构造优先队列。
 * 性能：
 * 		最好时间分析：O(nlogn)
 * 		最差时间分析：O(nlogn)
 * 		平均时间分析：O(nlogn)
 * 		稳定度：不稳定
 * 		空间复杂度：
 * 堆的性质：
 * 		16			数组存储的结构：
 * 	  14   10			16  14  10  8  7  9  3  2  4  1
 *   8  7  9  3		脚标   0   1   2  3  4  5  6  7  8  9
 *  2 4 1			特点：i节点的父节点是(i-1)/2     
 *  					  i节点的左右节点下标分别是2*i+1  2*i+2
 */
public class HeapSort {

	public static void sort(int[] obj) {
		// 将数组构建成最大堆
		buildMaxHeap(obj);
		System.out.println("最大堆："+Arrays.toString(obj));
		// 取出a[0] 最大值，放入末尾，再将剩余的数组构建成最大堆，继续出去最大值
		int length = obj.length;
		for(int i = obj.length - 1; i >= 1; i--) {
			int max = obj[0];
			obj[0] = obj[i];
			obj[i] = max;
			length = length - 1;
			maxHeapify(obj, 0, length);
			System.out.println(Arrays.toString(obj));
		}
	}
	
	// 维护最大堆性质
	private static void maxHeapify(int[] obj, int index,int lenght) {
		int l = 2 * index + 1;	// 左节点
		int r = 2 * index + 2;	// 右节点
		
		/**
		 * 从obj[index]作为父节点 从其和其子节点中选出最大的节点，
		 * 如果index是最大的，则以index节点为父节点的子树就是最大堆
		 * 否则index是某个孩子节点，交换obj[index]和obj[largest]的值
		 * 从而使index和其孩子都满足最大堆的性质
		 */
		int largest;
		if((l <= lenght - 1) && (obj[l] > obj[index])) { // 若左节点大于父节点，则最大的就是左节点
			largest = l;
		} else {
			largest = index;
		}
		
		if((r <= lenght - 1) && (obj[r] > obj[largest])) {
			largest = r;
		}
		
		if(largest != index) {
			int temp = obj[index];
			obj[index] = obj[largest];
			obj[largest] = temp;
			maxHeapify(obj, largest, lenght);
		}
	}
	
	// 创建最大堆
	private static void buildMaxHeap(int[] obj) {
		for(int i = obj.length / 2 - 1; i >= 0; i--) {
			maxHeapify(obj, i, obj.length);
		}
	}
}
