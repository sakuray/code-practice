package com.sakuray.code.practice.leetcode;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class _016_3SumClosest {

	public static void main(String[] args) {
		System.out.println(2 == threeSumClosest(new int[] {-1, 2, 1, -4}, 1));
		System.out.println(27 == threeSumClosest(new int[] {-4,-7,-2,2,5,-2,1,9,3,9,4,9,-9,-3,7,4,1,0,8,5,-7,-7}, 29));
		System.out.println(82 == threeSumClosest(new int[] {1,2,4,8,16,32,64,128}, 82));
	}
	
	public static int threeSumClosest(int[] nums, int target) {
		int closest = nums[0] + nums[1] + nums[2];
		Arrays.sort(nums);
		for(int i = 0; i < nums.length - 2; i++) {
			int l = i + 1, r = nums.length - 1, sum = target - nums[i];
			while(l < r) {
				if(nums[l] + nums[r] == sum) {
					return target;
				} else {
					int distance = nums[l] + nums[r] - sum;
					boolean moreClose = Math.abs(distance) < Math.abs(closest - target) ? true : false;
					if(moreClose) closest = nums[l] + nums[r] + nums[i];
					if(distance > 0) {
						r--;
					} else {
						l++;
					}
				}
			}
		}
		return closest;
    }
	
	public static int threeSumClosest_S(int[] num, int target) {        
		int result = num[0] + num[1] + num[num.length - 1];
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            int start = i + 1, end = num.length - 1;
            while (start < end) {
                int sum = num[i] + num[start] + num[end];
                if (sum > target) {
                    end--;
                } else {
                    start++;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
	}
}
