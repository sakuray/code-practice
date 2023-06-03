package com.sakuray.code.practice.leetcode._0_99;

/**
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 * <p>
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 * <p>
 * Input: nums = [1]
 * Output: 1
 * Explanation: The subarray [1] has the largest sum 1.
 * <p>
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 */
public class _053_MaximumSubarray {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    /**
     * 连续子数组的最大值，本质上就是求Max(f(i))  f(i)是指数组最后一个值是i，连续的子数组的最大值
     * 很容易知道这种情况下是i向前推导如果f(i-1)是正数就包含进来，如果f(i-1)是负数不包含。
     * 我们只需要2个值：pre记录当前最大,max记录全局最大值
     */
    public static int maxSubArray(int[] nums) {
        int max = nums[0], pre = 0;
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            max = Math.max(pre, max);
        }
        return max;
    }
}
