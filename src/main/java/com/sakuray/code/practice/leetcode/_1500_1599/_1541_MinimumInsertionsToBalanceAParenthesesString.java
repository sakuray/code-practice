package com.sakuray.code.practice.leetcode._1500_1599;

/**
 * Given a parentheses string s containing only the characters '(' and ')'. A parentheses string is balanced if:
 * Any left parenthesis '(' must have a corresponding two consecutive right parenthesis '))'.
 * Left parenthesis '(' must go before the corresponding two consecutive right parenthesis '))'.
 * In other words, we treat '(' as an opening parenthesis and '))' as a closing parenthesis.
 * For example, "())", "())(())))" and "(())())))" are balanced, ")()", "()))" and "(()))" are not balanced.
 * You can insert the characters '(' and ')' at any position of the string to balance it if needed.
 * Return the minimum number of insertions needed to make s balanced.
 * <p>
 * Input: s = "(()))"
 * Output: 1
 * Explanation: The second '(' has two matching '))', but the first '(' has only ')' matching.
 * We need to add one more ')' at the end of the string to be "(())))" which is balanced.
 * <p>
 * Input: s = "())"
 * Output: 0
 * Explanation: The string is already balanced.
 * <p>
 * Input: s = "))())("
 * Output: 3
 * Explanation: Add '(' to match the first '))', Add '))' to match the last '('.
 */
public class _1541_MinimumInsertionsToBalanceAParenthesesString {

    /**
     * 一个左括号必须匹配两个右括号，判断需要插入多少个才能平衡。
     * 同921题：出现一个左括号，需要2个右括号，那么有以下几种情况
     * 1.右括号变多，需要增加左括号，然后右括号所需+1(左括号=2右括号-1已存在)
     * 2.左括号时遇到所需右括号为奇数个，抵消一个右括号
     */
    public int minInsertions(String s) {
        int result = 0, needRight = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                needRight += 2;
                if (needRight % 2 == 1) {
                    result++;
                    needRight--;
                }
            } else {
                needRight--;
                if (needRight == -1) {
                    result++;
                    needRight = 1;
                }
            }
        }
        return result + needRight;
    }
}
