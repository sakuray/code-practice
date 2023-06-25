package com.sakuray.code.practice.leetcode._200_299;

/**
 * Given an integer n, return true if it is a power of two. Otherwise, return false.
 * An integer n is a power of two, if there exists an integer x such that n == 2x.
 * <p>
 * Input: n = 1
 * Output: true
 * Explanation: 20 = 1
 * <p>
 * Input: n = 16
 * Output: true
 * Explanation: 24 = 16
 * <p>
 * Input: n = 3
 * Output: false
 */
public class _231_PowerOfTwo {

    /**
     * 判断某个数字是否是2的幂次，这个数字一定仅包含一位1
     */
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }
}
