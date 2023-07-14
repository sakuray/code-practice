package com.sakuray.code.practice.leetcode._300_399;

import java.util.Arrays;

/**
 * Given an integer array nums, return the length of the longest strictly increasing subsequence
 * <p>
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * <p>
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * <p>
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 */
public class _300_LongestIncreasingSubsequence {

    /**
     * 最长增长子序列长度，子序列不一定连续
     * dp[i] = nums[i]结尾的最长子序列长度
     * dp[i] = 1，至少包含自己
     * 如何计算: dp[i] = dp[x] + 1，nums[x] < nums[i] 且 x < i
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    res = Math.max(dp[i], res);
                }
            }
        }
        return res;
    }

    public int lengthOfLIS_S(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            tails[i] = x;
            if (i == size) {
                ++size;
            }
        }
        return size;
    }
}
