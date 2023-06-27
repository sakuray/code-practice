package com.sakuray.code.practice.leetcode._600_699;

/**
 * You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately,
 * due to some error, one of the numbers in s got duplicated to another number in the set,
 * which results in repetition of one number and loss of another number.
 * You are given an integer array nums representing the data status of this set after the error.
 * Find the number that occurs twice and the number that is missing and return them in the form of an array.
 * <p>
 * Input: nums = [1,2,2,4]
 * Output: [2,3]
 * <p>
 * Input: nums = [1,1]
 * Output: [1,2]
 */
public class _645_SetMismatch {

    /**
     * 数组中有一个数字缺失，一个重复
     * 数组有值 和index，正常情况一下一个index0就存在一个num0的
     * 将nums[i]中的值作为索引，如果被索引两次，则数字重复
     * 如何判断所有两次？索引过后将其数值变成负数
     */
    public int[] findErrorNums(int[] nums) {
        int dup = -1;
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                dup = index + 1;
            } else {
                nums[index] *= -1;
            }
        }
        int missing = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missing = i + 1;
            }
        }
        return new int[]{dup, missing};
    }
}
