package com.sakuray.code.practice.leetcode._0_99;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 * <p>
 * Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 6
 * Explanation: The maximal rectangle is shown in the above picture.
 * <p>
 * Input: matrix = [["0"]]
 * Output: 0
 * <p>
 * Input: matrix = [["1"]]
 * Output: 1
 */
public class _085_MaximalRectangle {

    /**
     * 暴力求解法，当前点位向左边连续1的个数 dp[i][j]。然后不断往上 计算上面的连续个数， * 高度，找到最大面积
     * 如：
     * 00110
     * 01110
     * 11110
     * 在最后一行最后一个1时，左边有4个1 dp[2][3] = 4;
     * dp[1][3] = 3
     * 1* 4 < 2*3  = 3 * 2 = 6
     */
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        if (n == 0) {
            return 0;
        }
        int m = matrix[0].length;
        int dp[][] = new int[n][m];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    if (j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i][j - 1] + 1;
                    }
                } else {
                    dp[i][j] = 0;
                }
                int width = dp[i][j];
                for (int row = i; row >= 0; row--) {
                    int height = i - row + 1;
                    width = Math.min(width, dp[row][j]);
                    max = Math.max(max, height * width);
                }
            }
        }
        return max;
    }

    /**
     * 栈解法，见84题
     * 等于是每一层的height信息传递计算最大面积
     */
    public int maximalRectangle2(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[] height = new int[matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    height[j] += 1;
                } else {
                    height[j] = 0;
                }
            }
            max = Math.max(max, largestRectangleArea(height));
        }
        return max;
    }

    private int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                right[stack.peek()] = i;
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, (right[i] - left[i] - 1) * heights[i]);
        }
        return result;
    }
}
