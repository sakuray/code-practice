package com.sakuray.code.practice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
	Example 1:
		Input: [1, 2, 2, 3, 1]
		Output: 2
	Explanation: 
		The input array has a degree of 2 because both elements 1 and 2 appear twice.
		Of the subarrays that have the same degree:
		[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
		The shortest length is 2. So return 2.
	Example 2:
	Input: [1,2,2,3,1,4,2]
	Output: 6 
	Note:
		nums.length will be between 1 and 50,000.
		nums[i] will be an integer between 0 and 49,999.
 */
public class _697_DegreeOfAnArray {

	public static void main(String[] args) {
		System.out.println(findShortestSubArray(new int[] {1, 2, 2, 3, 1}));
		System.out.println(findShortestSubArray(new int[] {1,2,2,3,1,4,2}));
	}
	
	public static int findShortestSubArray(int[] nums) {
		Map<Integer,int[]> map = new HashMap<>(); //int[0] 次数 int[1] 起点 int[2] 终点
		List<Integer> max = new ArrayList<>();	// 最大频率
		int degree = 0;
		for(int i = 0; i < nums.length; i++) {
			int[] cur = map.get(nums[i]);
			if(cur == null) {
				cur = new int[3];
				cur[0] = 1;
				cur[1] = i;
				map.put(nums[i], cur);
				if(degree < 2) {
					max.add(nums[i]);
					degree = 1;
				}
			} else {
				cur[2] =  i;
				cur[0] = cur[0] + 1;
				if(cur[0] > degree) {
					max.clear();
					degree = cur[0];
					max.add(nums[i]);
				} else if(cur[0] == degree) {
					max.add(nums[i]);
				}
			}
		}
		if(degree == 1) {
			return 1;
		} else {
			int length = Integer.MAX_VALUE;
			for(int i : max) {
				int[] cur = map.get(i);
				length = Math.min(length, cur[2] - cur[1] + 1);
			}
			return length;
		}
    }
	
	public int findShortestSubArray_S(int[] nums) {
        if (nums.length == 0) return 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
        }
        int[] counts = new int[max+1];
        int[] starts = new int[max+1];
        int[] ends = new int[max+1];
        
        for (int i =0; i < nums.length; i++){
            if (counts[nums[i]] == 0){
                
                starts[nums[i]] = i;
                ends[nums[i]] = i;
            }
            else{
                ends[nums[i]] = i;
            }
            counts[nums[i]]++;
        }
        int max_count = 0;
        for (int i = 0; i < counts.length; i++){
            max_count = Math.max(max_count, counts[i]);
        }
        int min = nums.length;
        for (int i = 0; i < counts.length; i++){
            if (counts[i] == max_count){
                min = Math.min(min, ends[i] - starts[i] + 1);
            }
        }
        return min;
    }
}
