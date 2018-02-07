package com.sakuray.code.practice.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * 
 * Example:
	Given nums = [2, 7, 11, 15], target = 9,
	Because nums[0] + nums[1] = 2 + 7 = 9,
	return [0, 1].
 */
public class _001_TwoSum {
	
	public static void main(String[] args) {
		int[] nums = new int[]{2, 7, 11, 15};
		System.out.println(Arrays.toString(twoSum(nums, 9)));
	}
	
	public static int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
        	int other = target - nums[i];
        	for(int j = i + 1; j < nums.length; j++) {
        		if(other == nums[j]) {
        			return new int[]{i, j};
        		}
        	}
        }
        return new int[] {-1, -1};
    }
	
	public static int[] twoSum_S(int[] nums, int target) {
	    Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	        map.put(nums[i], i);
	    }
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement) && map.get(complement) != i) {
	            return new int[] { i, map.get(complement) };
	        }
	    }
	    throw new IllegalArgumentException("No two sum solution");
	}
	
	public static int[] twoSum_S2(int[] nums, int target) {
	    Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement)) {
	            return new int[] { map.get(complement), i };
	        }
	        map.put(nums[i], i);
	    }
	    throw new IllegalArgumentException("No two sum solution");
	}

}
