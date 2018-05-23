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
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
	}
}
