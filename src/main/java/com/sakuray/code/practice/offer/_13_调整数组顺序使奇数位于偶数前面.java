package com.sakuray.code.practice.offer;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class _13_调整数组顺序使奇数位于偶数前面 {
	
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7,8,9};
		reOrderArray(array);
		System.out.println(Arrays.toString(array));
	}
	
	public static void reOrderArray(int [] array) {
        int d = -1, temp;
        for(int i = 0; i < array.length; i++) {
        	if(array[i] % 2 == 0 && d == -1) {
        		d = i;
        	} else if(array[i] % 2 != 0 && d != -1) {
        		temp = array[i];
        		for(int j = i; j > d; j--) {
        			array[j] = array[j-1];
        		}
        		array[d] = temp; 
        		i = d + 1;
        		d = i;
        	}
        }
    }
	
	// 最佳答案
	public void reOrderArray_S(int [] array) {
        if(array == null || array.length == 0){
            return;
        }
        for(int i=1; i<array.length; i++){
            if(array[i]%2 == 1){
                int k=i-1;
                int temp=array[i];
                while(k>=0 && array[k]%2 ==0){
                    array[k+1]=array[k];
                    k--;
                }
                array[k+1]=temp;
            }
        }
    }
}
