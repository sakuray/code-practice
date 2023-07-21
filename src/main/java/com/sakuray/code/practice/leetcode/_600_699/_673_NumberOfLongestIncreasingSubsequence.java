package com.sakuray.code.practice.leetcode._600_699;

import java.util.Arrays;

/**
 * Given an integer array nums, return the number of longest increasing subsequences.
 * Notice that the sequence has to be strictly increasing.
 * <p>
 * Input: nums = [1,3,5,4,7]
 * Output: 2
 * Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].
 * <p>
 * Input: nums = [2,2,2,2,2]
 * Output: 5
 * Explanation: The length of the longest increasing subsequence is 1, and there are 5 increasing subsequences of length 1, so output 5.
 */
public class _673_NumberOfLongestIncreasingSubsequence {

    public static void main(String[] args) {
        System.out.println(findNumberOfLIS(new int[]{1, 2, 4, 3, 5, 4, 7, 2}));
    }

    /**
     * 类似300题，1218题，这里求的不是最长的长度，而是最长的有多少个
     * 动态规划，定义dp[i]=到i点的时候最长增长的长度，count[i]表示出现了多长次
     */
    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        int[] count = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);

        int maxLength = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        // 前面的路径选择可能性最多的作为新增路径的基础数据
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        // 如果可能性相同，意味着有多组可以达成最长长度的，累加
                        count[i] += count[j];
                    }
                }
            }
            maxLength = Math.max(dp[i], maxLength);
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxLength) {
                result += count[i];
            }
        }
        return result;
    }
}
