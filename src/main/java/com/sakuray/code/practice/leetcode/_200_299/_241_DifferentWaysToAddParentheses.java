package com.sakuray.code.practice.leetcode._200_299;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string expression of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators.
 * You may return the answer in any order.
 * The test cases are generated such that the output values fit in a 32-bit integer and the number of different results does not exceed 104.
 * <p>
 * Input: expression = "2-1-1"
 * Output: [0,2]
 * Explanation:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * <p>
 * Input: expression = "2*3-4*5"
 * Output: [-34,-14,-10,-10,10]
 * Explanation:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 */
public class _241_DifferentWaysToAddParentheses {

    /**
     * 分治思想，本质上就是运算符的执行顺序问题
     */
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            int ch = expression.charAt(i);
            if (ch == '-' || ch == '+' || ch == '*') {
                List<Integer> leftResult = diffWaysToCompute(expression.substring(0, i));
                List<Integer> rightResult = diffWaysToCompute(expression.substring(i + 1));
                for (int left : leftResult) {
                    for (int right : rightResult) {
                        if (ch == '+') {
                            result.add(left + right);
                        } else if (ch == '-') {
                            result.add(left - right);
                        } else {
                            result.add(left * right);
                        }
                    }
                }
            }
        }
        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }
        return result;
    }
}
