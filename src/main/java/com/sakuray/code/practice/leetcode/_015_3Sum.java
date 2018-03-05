package com.sakuray.code.practice.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * Note: The solution set must not contain duplicate triplets.
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
	[
  		[-1, 0, 1],
  		[-1, -1, 2]
	]
 *
 */
public class _015_3Sum {
	
	public static void main(String[] args) {
//		System.out.println(threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
//		System.out.println(threeSum(new int[] {0, 0, 0}));		// 000
//		System.out.println(threeSum(new int[] {3,0,-2,-1,1,2}));
//		System.out.println(threeSum(new int[] {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6}));
		System.out.println(threeSum(new int[] {-4,-2,-1}));
	}
	
	/**
	 * 3数和为0有以下几种情况：
	 * 1.一负两正
	 * 2.二负一正
	 * 3.一负0一正
	 * 4.全0
	 * @param nums
	 * @return
	 */
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new java.util.ArrayList<>();
		if(nums != null && nums.length > 2) {
			java.util.Arrays.sort(nums);
			int zeroBegin = -1;
			int positive = -1;
			for(int i = 0; i < nums.length; i++) {
				if(nums[i] == 0 && zeroBegin == -1) {
					zeroBegin = i;
				}
				if(nums[i] > 0) {
					positive = i;
					break;
				}
			}
			int mNIndex = (zeroBegin != -1) ? zeroBegin - 1 : (positive != -1 ? positive - 1 : nums.length);
			List<Integer> one = null;
			System.out.println(mNIndex + " >>>" + zeroBegin + "<<<<" + positive);
			if(positive != -1) {
				for(int i = 0; i <= mNIndex; i++) {
					int next = i;
					for(int j = i+1; j <= nums.length - 1; j++) {
						if(j <= mNIndex) {	// 2负1正
							if(nums[i] == nums[j]) {
								next = j;
							}
							if(j > i + 1 && nums[j] == nums[j-1]) { // 计算过，不再计算
								continue;
							} else {
								int other = 0 - nums[i] - nums[j];
								int index = java.util.Arrays.binarySearch(nums, positive, nums.length, other);
								if(index > 0) {
									one = new java.util.ArrayList<>(3);
									one.add(nums[i]);
									one.add(nums[j]);
									one.add(other);
									result.add(one);
								}
							}
						} else if(j >= positive) {	// 1负2正
							if(j > positive && nums[j] == nums[j - 1]) { // 计算过，不再计算
								continue;
							}
							int other = 0 - nums[i] - nums[j];
							if(other <= 0 || other < nums[j]) {	// 没有满足项
								break;
							} else {
								int index = java.util.Arrays.binarySearch(nums, j+1, nums.length, other);
								if(index > 0) {
									one = new java.util.ArrayList<>(3);
									one.add(nums[i]);
									one.add(nums[j]);
									one.add(other);
									result.add(one);
								}
							}
						} else { // 1负0和1正
							int other = 0 - nums[i] - nums[j];
							int index = java.util.Arrays.binarySearch(nums, positive, nums.length, other);
							if(index > 0) {
								one = new java.util.ArrayList<>(3);
								one.add(nums[i]);
								one.add(nums[j]);
								one.add(other);
								result.add(one);
							}
							j = positive - 1;	// 只有1组解
						}
					}
					i = next;
				}
			}
			// 判断全0的情况
			if(zeroBegin != -1) {
				int size = positive != -1 ? positive - zeroBegin : nums.length - zeroBegin;
				if(size > 2) {
					one = new java.util.ArrayList<>(3);
					one.add(0);
					one.add(0);
					one.add(0);
					result.add(one);
				}
			}
		}
		return result;
	}
	
	public List<List<Integer>> threeSum_S(int[] num) {
	    Arrays.sort(num);
	    List<List<Integer>> res = new LinkedList<>(); 
	    for (int i = 0; i < num.length-2; i++) {
	        if (i == 0 || (i > 0 && num[i] != num[i-1])) {
	            int lo = i+1, hi = num.length-1, sum = 0 - num[i];
	            while (lo < hi) {
	                if (num[lo] + num[hi] == sum) {
	                    res.add(Arrays.asList(num[i], num[lo], num[hi]));
	                    while (lo < hi && num[lo] == num[lo+1]) lo++;
	                    while (lo < hi && num[hi] == num[hi-1]) hi--;
	                    lo++; hi--;
	                } else if (num[lo] + num[hi] < sum) lo++;
	                else hi--;
	           }
	        }
	    }
	    return res;
	}
}
