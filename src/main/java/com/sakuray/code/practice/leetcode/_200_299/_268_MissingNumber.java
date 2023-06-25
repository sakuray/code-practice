package com.sakuray.code.practice.leetcode._200_299;

/**
 * Given an array nums containing n distinct numbers in the range [0, n],
 * return the only number in the range that is missing from the array.
 * <p>
 * Input: nums = [3,0,1]
 * Output: 2
 * Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
 * <p>
 * Input: nums = [0,1]
 * Output: 2
 * Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
 * <p>
 * Input: nums = [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
 */
public class _268_MissingNumber {

    /**
     * 利用成对的特性，a ^ a = 0, 0 ^ a = a，如果都成对就是变成0，缺少了的那个不成对就是最后结果
     */
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int res = n;
        for (int i = 0; i < n; i++) {
            res ^= i ^ nums[i];
        }
        return res;
    }
}
