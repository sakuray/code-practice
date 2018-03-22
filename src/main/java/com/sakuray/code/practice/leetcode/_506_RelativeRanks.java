package com.sakuray.code.practice.leetcode;

import java.util.Arrays;

/**
 * Given scores of N athletes, find their relative ranks and the people with the top three highest scores, 
 * who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".
Example 1:
	Input: [5, 4, 3, 2, 1]
	Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
	Explanation: The first three athletes got the top three highest scores, 
				so they got "Gold Medal", "Silver Medal" and "Bronze Medal". 
	For the left two athletes, you just need to output their relative ranks according to their scores.
Note:
	N is a positive integer and won't exceed 10,000.
	All the scores of athletes are guaranteed to be unique. 
 */
public class _506_RelativeRanks {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(findRelativeRanks(new int[] {5, 4, 3, 2, 1})));
		System.out.println(Arrays.toString(findRelativeRanks(new int[] {10,3,8,9,4})));
		System.out.println(Arrays.toString(findRelativeRanks(new int[] {1})));
	}
	
	public static String[] findRelativeRanks(int[] nums) {
		if(nums == null || nums.length == 0) return null;
        int[] indexs = new int[nums.length];
        mergeSort(nums, indexs, 0, nums.length - 1);
        String[] result = new String[nums.length];
        for(int i = 0; i < indexs.length; i++) {
        	if(i == 0) result[indexs[i]] = "Gold Medal";
        	else if(i == 1) result[indexs[i]] = "Silver Medal";
        	else if(i == 2) result[indexs[i]] = "Bronze Medal";
        	else result[indexs[i]] = String.valueOf(i+1);
        }
        return result;
    }
	
	public static void mergeSort(int[] nums, int[] indexs, int start, int end) {
		if(start < end) {
			int mid = (end + start) / 2;
			mergeSort(nums, indexs, start, mid);
			mergeSort(nums, indexs, mid + 1, end);
			merge(nums, indexs, start, mid, end);
		} else {
			indexs[start] = start;
		}
	}
	
	public static void merge(int[] nums, int[] index, int start, int mid, int end) {
		int ls = mid - start + 1;
		int rs = end - mid;
		int[] left = new int[ls+1];
		int[] right = new int[rs+1];
		int[] li = new int[ls];
		int[] ri = new int[rs];
		for(int i = 0; i < ls; i++) {
			left[i] = nums[i+start];
			li[i] = index[i+start];
		}
		for(int i = 0; i < rs; i++) {
			right[i] = nums[i+mid+1];
			ri[i] = index[i+mid+1];
		}
		left[ls] = Integer.MIN_VALUE;
		right[rs] = Integer.MIN_VALUE;
		int i = 0, j = 0;
		for(int k = start; k <= end; k++) {
			if(left[i] < right[j]) {
				nums[k] = right[j];
				index[k] = ri[j];
				j++;
			} else {
				nums[k] = left[i];
				index[k] = li[i];
				i++;
			}
		}
	}
	
	public String[] findRelativeRanks_S(int[] nums) {
		String[] result = new String[nums.length];
		int max = 0;
		for (int i : nums) {
			if (i > max)
				max = i;
		}
		int[] hash = new int[max + 1];
		for (int i = 0; i < nums.length; i++) {
			hash[nums[i]] = i + 1;
		}
		int place = 1;
		for (int i = hash.length - 1; i >= 0; i--) {
			if (hash[i] != 0) {
				if (place == 1) {
					result[hash[i] - 1] = "Gold Medal";
				} else if (place == 2) {
					result[hash[i] - 1] = "Silver Medal";
				} else if (place == 3) {
					result[hash[i] - 1] = "Bronze Medal";
				} else {
					result[hash[i] - 1] = String.valueOf(place);
				}
				place++;
			}
		}
		return result;
	}
}
