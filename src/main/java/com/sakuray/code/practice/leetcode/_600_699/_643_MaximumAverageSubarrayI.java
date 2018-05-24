package com.sakuray.code.practice.leetcode._600_699;

/**
 * Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. 
 * And you need to output the maximum average value.
 * 
 * Example 1:
	Input: [1,12,-5,-6,50,3], k = 4
	Output: 12.75
	Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
   Note:
	1 <= k <= n <= 30,000.
	Elements of the given array will be in the range [-10,000, 10,000].
 */
public class _643_MaximumAverageSubarrayI {

	public static void main(String[] args) {
		System.out.println(findMaxAverage(new int[] {1,12,-5,-6,50,3}, 4));	// 12.75
	}
	
	
	public static double findMaxAverage(int[] nums, int k) {
        int sum = 0;
		for(int i = 0; i < k; i++) {
        	sum+=nums[i];
        }
		int cur = sum;
		for(int i = k; i < nums.length; i++) {
			cur = cur + nums[i] - nums[i-k];
			if(cur > sum) sum = cur;
		}
		return (double)sum / (double)k;
    }
	
	
	public double findMaxAverage_S(int[] nums, int k) {
        int tmp = 0, res = 0;
        for(int i = 0; i < k; i++) {
            res += nums[i];
        }
        tmp = res;

        for(int i = k; i < nums.length; i++) {
            tmp = tmp+nums[i]-nums[i-k];
        
            if(tmp > res) res = tmp;
        }
        return ((double)res)/k;
    }
}
