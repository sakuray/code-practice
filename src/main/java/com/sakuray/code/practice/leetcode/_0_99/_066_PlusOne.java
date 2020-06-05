package com.sakuray.code.practice.leetcode._0_99;


import com.sakuray.code.practice.leetcode.PrintTools;

/**
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 *
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 */
public class _066_PlusOne {

    public static void main(String[] args) {
        PrintTools.printArray(plusOne(new int []{1,2,3}));
        PrintTools.printArray(plusOne(new int []{9,9,9}));
        PrintTools.printArray(plusOne(new int []{9,6,9}));
    }

    /**
     * 最后一位+1  判断是否有进位，有进位继续循环前一位加1，没进位返回
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        int[]result = new int[digits.length + 1];
        result[0] = 1;
        System.arraycopy(digits, 0, result, 1, digits.length);
        return result;
    }
}
