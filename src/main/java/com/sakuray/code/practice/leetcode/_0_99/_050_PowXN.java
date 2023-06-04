package com.sakuray.code.practice.leetcode._0_99;

/**
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 *
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 *
 * Input: x = 2.10000, n = 3
 * Output: 9.26100
 *
 * Input: x = 2.00000, n = -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 */
public class _050_PowXN {

    public static void main(String[] args) {
        System.out.println(-2147483648);
        System.out.println(Math.abs(-2147483648));
    }

    public double myPow(double x, int n) {
        double base = x, res = 1.0;
        // 需要转换成整型，否则Integer.MIN_VALUE还是本身
        long N = Math.abs((long)n);
        while (N > 0) {
            if (N % 2 == 1) {
                res *= base;
            }
            base *= base;
            N /= 2;
        }
        return n >= 0 ? res : 1.0 / res;
    }
}
