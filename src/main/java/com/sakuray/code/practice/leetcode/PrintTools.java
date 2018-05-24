package com.sakuray.code.practice.leetcode;

/**
 * 输出工具类
 */
public class PrintTools {

	/**
	 * 打印二维数组的值
	 * @param array
	 */
	public static void print2Array(int[][] array) {
		System.out.println("====================");
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	/**
	 * 打印一维数组的值
	 * @param array
	 */
	public static void printArray(int[] array) {
		if(array == null) return;
		printArray(array, 0, array.length);
	}
	
	/**
	 * 打印指定范围的数组的值
	 */
	public static void printArray(int[] array, int start, int end) {
		if(array == null) return;
		System.out.print("[");
		for(int i = start; i < end; i++) {
			System.out.print(array[i]);
			if(i != end - 1) System.out.print(", ");
		}
		System.out.println("]");
	}
}
