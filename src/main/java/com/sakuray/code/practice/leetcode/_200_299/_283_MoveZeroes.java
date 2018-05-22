package com.sakuray.code.practice.leetcode._200_299;

import java.util.Arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
   For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
Note:
	You must do this in-place without making a copy of the array.
	Minimize the total number of operations.
 */
public class _283_MoveZeroes {

	public static void main(String[] args) {
		int[] test = new int[] {0, 1, 0, 3, 12};
		moveZeroes_S(test);
		System.out.println(Arrays.toString(test));
	}
	
	public static void moveZeroes(int[] nums) {
		int index = -1;
        for(int i = 0; i < nums.length; i++) {
        	if(nums[i] == 0 && index == -1) {
        		index = i;
        	} else if(nums[i] != 0 && index != -1) {
        		nums[index] = nums[i];
        		nums[i] = 0;
        		index = -1;
        		i = index;
        	}
        }
    }
	
	public static void moveZeroes_S(int[] nums) {
        if (nums == null || nums.length < 2)
            return;

        int p1 = 0; // 前面有多少个连续不为0的数字
        for (int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                int temp = nums[p1];
                nums[p1] = nums[i];
                nums[i] = temp;
                p1++;
            }
            System.out.println(Arrays.toString(nums));
        }
        
    }
}
