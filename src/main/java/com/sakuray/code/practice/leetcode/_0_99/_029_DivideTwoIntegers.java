package com.sakuray.code.practice.leetcode._0_99;

/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
 * Return the quotient after dividing dividend by divisor.
 *
 * The integer division should truncate toward zero, which means losing its fractional part.
 * For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.
 *
 * Note:
 * Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range:
 * [−231,  231 − 1]. For this problem, assume that your function returns 231 − 1 when the division result overflows.
 *
 * Example 1:
 *
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Explanation: 10/3 = truncate(3.33333..) = 3.
 * Example 2:
 *
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Explanation: 7/-3 = truncate(-2.33333..) = -2.
 * Example 3:
 *
 * Input: dividend = 0, divisor = 1
 * Output: 0
 * Example 4:
 *
 * Input: dividend = 1, divisor = 1
 * Output: 1
 *
 *
 * Constraints:
 *
 * -231 <= dividend, divisor <= 231 - 1
 * divisor != 0
 */
public class _029_DivideTwoIntegers {

    public static void main(String[] args) {
        System.out.println(divide(10, 3));
        System.out.println(divide(7, -3));
        System.out.println(divide(0, 1));
        System.out.println(divide(1, 1));
        System.out.println(divide(2147483647, 1));
        System.out.println(divide(2147483647, -1));
        System.out.println(divide(-2147483647, -1));
        System.out.println(divide(-2147483647, 1));
        System.out.println(divide(-2147483648,-1));
        System.out.println(divide(-2147483648,1));
    }

    // 除数不断翻倍，直到小于
    public static int divide(int dividend, int divisor) {
        int flag = (dividend > 0) ^ (divisor > 0) ? -1 : 1;
        long ded = Math.abs((long)dividend);
        long div = Math.abs((long)divisor);
        long left = 0;
        while (ded >= div) {
            long tmpDivisor = div, m = 1;
            while ((tmpDivisor << 1) <= ded && (tmpDivisor << 1) > 0) { // 存在溢出可能
                tmpDivisor <<= 1;
                m <<= 1;
            }
            ded -= tmpDivisor;
            left += m;
        }
        long result = flag * left;
        if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        else if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        else return (int)result;
    }
}
