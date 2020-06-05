package com.sakuray.code.practice.leetcode._0_99;


/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class _053_MaximumSubarray {


    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }


    /**
     * 遇到第i个元素
     * 1.num[i]是正数，如果前面的合计为负，舍弃，从num[i]开始累加，如果前面是正数，加上
     * 2.如果num[i]是负数，前面加上该值还比当前值大，加上，否则舍弃
     * 简单的说就是：
     *  之前的累加值+当前值 >= 当前值，否则舍弃，从当前值开始查询最大子串
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int max = Integer.MIN_VALUE, now = 0;
        for (int cur : nums) {
            now = Math.max(cur + now, cur);
            max = Math.max(max, now);
        }
        return max;
    }
}
