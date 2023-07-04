package com.sakuray.code.practice.leetcode._900_999;

/**
 * A parentheses string is valid if and only if:
 * It is the empty string,
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 * You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.
 * For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
 * Return the minimum number of moves required to make s valid.
 * <p>
 * Input: s = "())"
 * Output: 1
 * <p>
 * Input: s = "((("
 * Output: 3
 */
public class _921_MinimumAddToMakeParenthesesValid {

    /**
     * 简单来说就是补充括号，判断少了多少个左括号，或者是又括号
     */
    public int minAddToMakeValid(String s) {
        int result = 0, needRight = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                needRight++;
            } else if (s.charAt(i) == ')'){
                needRight--;
                if (needRight == -1) {
                    needRight = 0;
                    result++;
                }
            }
        }
        return result + needRight;
    }
}
