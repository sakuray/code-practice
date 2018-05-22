package com.sakuray.code.practice.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序：是对冒泡排序的一种改进。基本思路是：
 * 		通过一趟排序将要排序的数据分割成两份，一部分所有的数据比另一部分都要小，
 * 		再按此方法对这两部分进行快速排序
 * 性能：
 * 		最好时间分析：O(nlogn)
 * 		最差时间分析：O(n2)
 * 		平均时间分析：O(nlogn)
 * 		稳定度：不稳定
 * 		空间复杂度：O(logn)
 */
public class QuickSort {

	public static void sort(int[] obj) {
		quicksort(obj, 0, obj.length - 1);
	}
	
	// 拆分数组
	private static int partition(int[] obj, int f, int l) {
		int flag = obj[f];	// 用第一个作为分割值，保持这位不动
		int index = f;
		/**
		 * 从第二个开始遍历，比flag大，index停在那个位置，index记录的是比flag大的最左边的一个位置
		 * 当找到一个比flag小的值时，交换位置，index向前+1  这样保证了index左边的值都比index小，
		 * 遍历结束时，将flag与index交换位置，就可以保证flag左边的都比其小，右边的都比其大
		 */
		for(int i = f + 1; i <= l; i++) {
			if(obj[i] <= flag) {
				index ++;
				int temp = obj[i];
				obj[i] = obj[index];
				obj[index] = temp;
			}
		}
		int temp = obj[index];
		obj[index] = flag;
		obj[f] = temp;
		System.out.println(Arrays.toString(obj));
		return index;
	}
	
	// 递归拆分排序
	private static void quicksort(int[] obj, int f, int l) {
		if(f < l) {
			int m = partition(obj, f, l);
			quicksort(obj, f, m - 1);
			quicksort(obj, m + 1, l);
		}
	}
}
