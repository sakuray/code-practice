package com.sakuray.code.practice.leetcode._100_199;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.
 * <p>
 * Input: n = 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 * <p>
 * Input: n = 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 * <p>
 * Input: n = 0
 * Output: 0
 */
public class _172_FactorialTrailingZeroes {

    /**
     * 阶乘后面的0，怎样会出现0，那一定是10 = 2 * 5，阶乘中2一定比5多，偶数都可以分解成2 * n，
     * 那么问题就在于计算阶乘会出现多少个5，5，15，但是25会出现2次5，125会出现3次
     */
    public int trailingZeroes(int n) {
        int count = 0;
        long divisor = 5;
        while (divisor <= n) {
            count += n / divisor;
            divisor *= 5;
        }
        return count;
    }
}
