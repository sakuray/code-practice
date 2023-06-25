package com.sakuray.code.practice.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * 输出工具类
 */
public class PrintTools {

	/**
	 * 打印二维数组的值
	 * @param array
	 */
	public static void print2Array(char[][] array) {
		System.out.println("====================");
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j]+" ");
			}
			System.out.println();
		}
	}

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

	public static <T> void printList(List<T> list) {
		if (list == null) return;
		System.out.println(Arrays.toString(list.toArray()));
	}

	public static <T> void print2List(List<List<T>> lists) {
		if (lists == null) return;
		for(List list : lists) {
			printList(list);
		}
		System.out.println();
	}

	public static <T> void printList2(List<T> list) {
		if (list == null) return;
		System.out.print("[");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
			if (i != list.size() -1) System.out.print(", ");
		}
		System.out.println("]");
	}
}
