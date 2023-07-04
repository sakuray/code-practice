package com.sakuray.code.practice.leetcode._100_199;

/**
 * Given an integer array nums where every element appears three times except for one, which appears exactly once.
 * Find the single element and return it.
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 * <p>
 * Input: nums = [2,2,3,2]
 * Output: 3
 * <p>
 * Input: nums = [0,1,0,1,0,1,99]
 * Output: 99
 */
public class _137_SingleNumberII {

    /**
     * 数组中仅一个数值出现一次，其他的出现3次
     * 最简单的就是一个map计数，问题是有没有其他的办法，如同136一样
     * 位运算的两种方式：所有的数值都是二进制字符串  001001100...
     * 1.如果一个数字出现3次，那么意味着其每一位都出现了3次，计算每一位的数值，除以3，除不尽就是这位出现了一次
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int n : nums) {
                sum += n >> i & 1;
            }
            sum %= 3;
            result |= sum << i;
        }
        return result;
    }

    /**
     * 第二种思路：使用位运算跟踪每个位置的计数，这样我们知道1个位置出现1次，2次，3次的情况
     * 1.一个位置首次出现，其会被存储到ones中，位置从0变成1
     * 2.一个位置二次出现，其会从ones中删除，存储在twos中
     * 3.一个位置三次出现，其会从ones重置，从0变成1，且从1，2中移除
     * ^：相同为0，不同为1
     * ~：0变成1，1变成0
     * &：都为1才是1
     */
    public int singleNumber_S(int[] nums) {
        int ones = 0;
        int twos = 0;
        for (int num : nums) {
            ones ^= (num & ~twos);
            twos ^= (num & ~ones);
        }
        return ones;
    }
}
