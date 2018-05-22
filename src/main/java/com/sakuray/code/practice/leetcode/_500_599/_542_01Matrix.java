package com.sakuray.code.practice.leetcode._500_599;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
	The distance between two adjacent cells is 1.
	Example 1: 
		Input:
			0 0 0
			0 1 0
			0 0 0
		Output:
			0 0 0
			0 1 0
			0 0 0
	Example 2: 
		Input:
			0 0 0
			0 1 0
			1 1 1
		Output:
			0 0 0
			0 1 0
			1 2 1
	Note:
		The number of elements of the given matrix will not exceed 10,000.
		There are at least one 0 in the given matrix.
		The cells are adjacent in only four directions: up, down, left and right.
 */
public class _542_01Matrix {
	
	public static void main(String[] args) {
		int[][] test1 = new int[][] {
			{0, 0, 0},
			{0, 1, 0},
			{1, 1, 1}
		};
		int[][] result = updateMatrix(test1);
		print2Array(result);
		int[][] test2 = new int[][] {
			{0, 0, 0},
			{0, 1, 0},
			{0, 0, 0}
		};
		result = updateMatrix(test2);
		print2Array(result);
		int[][] test3 = new int[][] {
			{0, 1, 0},
			{1, 1, 1},
			{1, 1, 1},
			{0, 1, 0}
		};
		result = updateMatrix(test3);
		print2Array(result);
	}
	
	public static void print2Array(int[][] result) {
		System.out.println("--------------------");
		for(int i = 0; i < result.length; i++) {
			System.out.println(Arrays.toString(result[i]));
		}
		System.out.println("--------------------");
	}

	public static int[][] updateMatrix(int[][] matrix) {
        int rows = matrix.length;
        if(rows == 0) return matrix;
        int columns = matrix[0].length;
        int[][] result = new int[rows][columns];
        List<int[]> needChange = new ArrayList<>(); 
        for(int i = 0; i < rows; i++) {
        	for(int j = 0; j < columns; j++) {
        		if(matrix[i][j] != 0) {
        			int[] index = new int[2];
        			index[0] = i;
        			index[1] = j;
        			needChange.add(index);
        			result[i][j] = Integer.MAX_VALUE;
        		}
        	}
        }
        int aim = 1;
        while(!needChange.isEmpty()) {
        	Iterator<int[]> it = needChange.iterator();
        	while(it.hasNext()) {
        		int[] index = it.next();
        		// right,left,down,up has value equal aim - 1,this point is aim
        		int left = (index[1] == 0) ? -1 : result[index[0]][index[1]-1];
        		if(left == aim - 1) {result[index[0]][index[1]] = aim; it.remove(); continue;}
        		int right = (index[1] == columns - 1) ? -1 : result[index[0]][index[1]+1];
        		if(right == aim - 1) {result[index[0]][index[1]] = aim; it.remove(); continue;}
        		int up = (index[0] == 0) ? -1 : result[index[0]-1][index[1]];
        		if(up == aim - 1) {result[index[0]][index[1]] = aim; it.remove(); continue;}
        		int down = (index[0] == rows - 1) ? -1 : result[index[0]+1][index[1]];
        		if(down == aim - 1) {result[index[0]][index[1]] = aim; it.remove(); continue;}
        	}
        	aim++;
        }
        return result;
    }
	
	public static int[][] updateMatrix_S(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++){
            for (int j= 0; j< matrix[0].length; j++){
                if(matrix[i][j] != 0) {
                    calculateDistance(matrix, i, j);
                }
            }
        }
        return matrix;
    }

    public static void calculateDistance(int[][] matrix, int i, int j){
        int xlength = matrix[0].length;
        int ylength = matrix.length;
        for(int x = 1; x < xlength+ylength-2; x++){
            for(int y = 0; y <= x; y++){
                if(i+y <= ylength-1 && j+x-y <= xlength-1){
                    if (matrix[i+y][j+x-y] == 0){
                        matrix[i][j]= x;
                        return;
                    }
                }
                if (i-y >= 0 && j-x+y >= 0 ) {
                    if (matrix[i-y][j-x+y] == 0){
                        matrix[i][j]= x;
                        return;
                    }
                }
                if (i+y <= ylength-1 && j-x+y >= 0 ) {
                    if (matrix[i+y][j-x+y] == 0){
                        matrix[i][j]= x;
                        return;
                    }
                }
                if (i-y >= 0 && j+x-y <= xlength-1 ) {
                    if (matrix[i-y][j+x-y] == 0){
                        matrix[i][j]= x;
                        return;
                    }
                }
            }
        }
    }
}
