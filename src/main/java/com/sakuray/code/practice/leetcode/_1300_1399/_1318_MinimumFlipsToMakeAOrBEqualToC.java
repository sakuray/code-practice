package com.sakuray.code.practice.leetcode._1300_1399;

/**
 * Given 3 positives numbers a, b and c. Return the minimum flips required in some bits of a and b to make ( a OR b == c ). (bitwise OR operation).
 * Flip operation consists of change any single bit 1 to 0 or change the bit 0 to 1 in their binary representation.
 * <p>
 * Input: a = 2, b = 6, c = 5
 * Output: 3
 * Explanation: After flips a = 1 , b = 4 , c = 5 such that (a OR b == c)
 * <p>
 * Input: a = 4, b = 2, c = 7
 * Output: 1
 * <p>
 * Input: a = 1, b = 2, c = 3
 * Output: 0
 */
public class _1318_MinimumFlipsToMakeAOrBEqualToC {


    /**
     * a与b或需要调整多少位，有一个是1为1
     * 如果c为0，a，b需要调整a+b为才行，a +b = 1有一位为1，调整成0
     * 如果c为1，a,b为0调整一位即可
     * 一位位进行比对,测试用例范围不足32，仅30
     */
    public int minFlips(int a, int b, int c) {
        int result = 0;
        for (int i = 0; i < 31; i++) {
            int bit_a = (a >>> i) & 1;
            int bit_b = (b >>> i) & 1;
            int bit_c = (c >>> i) & 1;
            if (bit_c == 0) {
                result += bit_b + bit_a;
            } else {
                result += (bit_b | bit_a) ^ 1;
            }
        }
        return result;
    }
}
