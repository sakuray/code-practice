package com.sakuray.code.practice.leetcode._0_99;

import com.sakuray.code.practice.leetcode.PrintTools;
import com.sakuray.code.practice.leetcode.Tools;

/**
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
Note:
   You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
   DO NOT allocate another 2D matrix and do the rotation.
   
   Example 1:

		Given input matrix = 
		[
		  [1,2,3],
		  [4,5,6],
		  [7,8,9]
		],
		
		rotate the input matrix in-place such that it becomes:
		[
		  [7,4,1],
		  [8,5,2],
		  [9,6,3]
		]
   Example 2:

		Given input matrix =
		[
		  [ 5, 1, 9,11],
		  [ 2, 4, 8,10],
		  [13, 3, 6, 7],
		  [15,14,12,16]
		], 
		
		rotate the input matrix in-place such that it becomes:
		[
		  [15,13, 2, 5],
		  [14, 3, 4, 1],
		  [12, 6, 8, 9],
		  [16, 7,10,11]
		]
 *
 */
public class _048_RotateImage {
	
	public static void main(String[] args) {
		int[][] test1 = Tools.build2Array(3, 1,2,3,4,5,6,7,8,9);
		rotate(test1);
		PrintTools.print2Array(test1);
		int[][] test2 = Tools.build2Array(4, 5,1,9,11,2,4,8,10,13,3,6,7,15,14,12,16);
		rotate(test2);
		PrintTools.print2Array(test2);
	}
	
	public static void rotate(int[][] matrix) {
        int n = matrix.length, t = n / 2;
        for(int i = 0; i < t; i++) {
        	for(int j = i; j < n - i - 1; j++) {
        		int tmp = matrix[i][j];
        		// 循环交换位置 (0,1)->(1,n-1)->(n-1,n-2)->(n-2,0)
        		// (i,j)->(j,n-i-1)->(n-i-1,n-j-1)->(n-j-1,i)
        		matrix[i][j] = matrix[n-j-1][i];
        		matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
        		matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
        		matrix[j][n-i-1] = tmp;
        	}
        }
    }
	
	public void rotate_S(int[][] matrix) {
        int len = matrix.length-1, level = 0,current = 0;
        if((len & 1) == 1){
            level = (len >> 1) + 1;
        }else {
            level = len >> 1;
        }
        while (current <= level){
            for (int i = current; i <= len-current-1; i++){ //
                int tmp1 = matrix[i][len-current];
                matrix[i][len-current] = matrix[current][i];
                int tmp2 = matrix[len-current][len-i];
                matrix[len-current][len-i] = tmp1;
                tmp1 = matrix[len-i][current];
                matrix[len-i][current] = tmp2;
                matrix[current][i] = tmp1;
            }
            current++;
        }
    }
}
