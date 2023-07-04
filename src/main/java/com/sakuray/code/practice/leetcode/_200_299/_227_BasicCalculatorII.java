package com.sakuray.code.practice.leetcode._200_299;

import java.util.Stack;

/**
 * Given a string s which represents an expression, evaluate this expression and return its value.
 * The integer division should truncate toward zero.
 * You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 * <p>
 * Input: s = "3+2*2"
 * Output: 7
 * <p>
 * Input: s = " 3/2 "
 * Output: 1
 * <p>
 * Input: s = " 3+5 / 2 "
 * Output: 5
 */
public class _227_BasicCalculatorII {

    public static void main(String[] args) {
        System.out.println(7 == calculate("3+2*2"));
        System.out.println(1 == calculate("3/2"));
        System.out.println(5 == calculate("3+5 / 2"));
        System.out.println(7 == calculate("3+5 / 2 + 2"));
        System.out.println(24 == calculate("2*3*4"));
    }

    /**
     * 加，减，成，除，存在优先级
     * 通过堆栈，先放入数值。再遇到乘除先合并num，认为乘除产生了新num
     */
    public static int calculate(String s) {
        Stack<Integer> numStack = new Stack<>();
        char ch;
        int num = 0, negative = 1;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + ch - 48;
            } else if ('+' == ch || '-' == ch) {
                numStack.push(num * negative);
                negative = '+' == ch ? 1 : -1;
                num = 0;
            } else if ('*' == ch || '/' == ch) {
                int[] nextNum = findNextNum(s, i + 1);
                i = nextNum[1];
                if ('*' == ch) {
                    num = num * nextNum[0];
                } else {
                    num = num / nextNum[0];
                }
            }
        }
        int sum = num * negative;
        while (!numStack.isEmpty()) {
            sum += numStack.pop();
        }
        return sum;
    }

    private static int[] findNextNum(String s, int start) {
        char ch;
        int num = 0;
        for (int i = start; i < s.length(); i++) {
            ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + ch - 48;
            } else if (' ' == ch) {
                continue;
            } else {
                return new int[]{num, i - 1};
            }
        }
        return new int[]{num, s.length() - 1};
    }
}
