package com.sakuray.code.practice.leetcode._100_199;


/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 *
 * Input: [4,1,2,1,2]
 * Output: 4
 */
public class _136_SingleNumber {

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[] {2,2,1}));
        System.out.println(singleNumber(new int[] {4,1,2,1,2}));
    }


    public static int singleNumber(int[] nums) {
        if (nums.length == 1) return nums[0];
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
