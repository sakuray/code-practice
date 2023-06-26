package com.sakuray.code.practice.leetcode._200_299;

import java.util.Arrays;

/**
 * Given an integer n, return the number of prime numbers that are strictly less than n.
 * Input: n = 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * <p>
 * Input: n = 0
 * Output: 0
 * <p>
 * Input: n = 1
 * Output: 0
 */
public class _204_CountPrimes {

    /**
     * 素数筛选法，k的倍数都不会是素数
     */
    public int countPrimes(int n) {
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);
        for (int i = 2; i * i < n; i++) {
            if (primes[i]) {
                // 从i的2倍开始遍历还是会重复，比如5*2,在之前2*5已经计算过了，从i* i开始遍历
                // i * i之内的一定会被遍历重置，主要关注i * i之外的，比如2 * 5 = 10，3 * 5 = 15，4 * 5 = 20, 5的时候不需要关注25以内的
                for (int j = i * i; j < n; j += i) {
                    primes[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i]) {
                count++;
            }
        }
        return count;
    }
}
