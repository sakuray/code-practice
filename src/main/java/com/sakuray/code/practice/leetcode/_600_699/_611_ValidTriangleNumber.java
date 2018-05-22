package com.sakuray.code.practice.leetcode._600_699;

import java.util.Arrays;

/**
 * Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the array 
 * that can make triangles if we take them as side lengths of a triangle.
	Example 1:
		Input: [2,2,3,4]
		Output: 3
		Explanation:
		Valid combinations are: 
			2,3,4 (using the first 2)
			2,3,4 (using the second 2)
			2,2,3
		Note:
			The length of the given array won't exceed 1000.
			The integers in the given array are in the range of [0, 1000].
 */
public class _611_ValidTriangleNumber {

	public static void main(String[] args) {
		System.out.println(triangleNumber(new int[] {2,2,3,4}));
	}
	
	// 两边之和大于第三边
	public static int triangleNumber(int[] nums) {
		Arrays.sort(nums);
		int result = 0;
		for(int i = 0; i < nums.length - 2; i++) {
			for(int j = i + 1; j < nums.length - 1; j++) {
				for(int k = j + 1; k < nums.length; k++) {
					if(nums[i] + nums[j] > nums[k]) {
						result++;
					} else {
						break;
					}
				}
			}
		}
        return result;
    }
	
	public int triangleNumber_S(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    res += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        
        return res;
    }
}
