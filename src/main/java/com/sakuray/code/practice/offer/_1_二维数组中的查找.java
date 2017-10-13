package com.sakuray.code.practice.offer;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class _1_二维数组中的查找 {

	public static void main(String[] args) {
		int[][] array = new int[][] {
			{1,2,8,9},
			{2,4,9,12},
			{4,7,10,13},
			{6,8,11,15}
		};
		System.out.println(Find(7,array));
	}
	
	public static boolean Find(int target, int [][] array) {
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j < array[i].length; j++) {
				if(target == array[i][j]) {
					return true;
				} else if(target < array[i][j]){
					break;
				}
			}
		}
		return false;
    }
	
	// 最佳答案
	public boolean Find_S(int[][] array, int target) {
		int len = array.length - 1;
		int i = 0;
		while ((len >= 0) && (i < array[0].length)) {
			if (array[len][i] > target) {
				len--;
			} else if (array[len][i] < target) {
				i++;
			} else {
				return true;
			}
		}
		return false;
	}
}
