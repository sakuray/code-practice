package com.sakuray.code.practice.offer;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵：
 *  1 2 3 4
 *  5 6 7 8
 *  9 10 11 12
 *  13 14 15 16
 *  则依次打印出数字
 *  1,2,3,4,
 *  8,12,16,15,
 *  14,13,9,5,
 *  6,7,11,10.
 */
public class _19_顺时针打印矩阵 {


    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        for(int i = 1; i <= 4; i++) {
            for(int j = 1; j<=4; j++) {
                matrix[i-1][j-1] = (i-1)*4+j;
            }
        }
        System.out.println(printMatrix(matrix));
    }

    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        int row = matrix.length; int col = matrix[0].length;
        int n = row * col;
        ArrayList<Integer> result = new ArrayList<>(n);
        int i = 0, j = 0, cyclic = 0;
        while(n > 0) {
            result.add(matrix[i][j]);
            if(i == cyclic && j < col-cyclic-1) {
                j++;
            }else if(i < row - cyclic - 1 && j == col-cyclic-1) {
                i++;
            }else if(i == row -cyclic - 1 && j > cyclic) {
                j--;
            } else if(j == cyclic && i > cyclic) {
                i--;
                if(i == j) {
                    cyclic++;
                    i = cyclic;
                    j = cyclic;
                }
            }
            n--;
        }

        return result;
    }

    public ArrayList<Integer> printMatrix_S(int [][] array) {
        ArrayList<Integer> result = new ArrayList<Integer> ();
        if(array.length==0) return result;
        int n = array.length,m = array[0].length;
        if(m==0) return result;
        int layers = (Math.min(n,m)-1)/2+1;//这个是层数
        for(int i=0;i<layers;i++){
            for(int k = i;k<m-i;k++) result.add(array[i][k]);//左至右
            for(int j=i+1;j<n-i;j++) result.add(array[j][m-i-1]);//右上至右下
            for(int k=m-i-2;(k>=i)&&(n-i-1!=i);k--) result.add(array[n-i-1][k]);//右至左
            for(int j=n-i-2;(j>i)&&(m-i-1!=i);j--) result.add(array[j][i]);//左下至左上
        }
        return result;
    }
}
