package com.sakuray.code.practice.leetcode._0_99;

import java.util.HashSet;
import java.util.Set;

/**
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 * <p>
 * Input: n = 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
 * <p>
 * Input: n = 1
 * Output: 1
 */
public class _052_NQueensII {

    /**
     * 同51，但是不需要保存答案，满足条件+1即可
     */
    public int totalNQueens(int n) {
        return backtrack(n, 0, new HashSet<>(), new HashSet<>(), new HashSet<>());
    }


    private int backtrack(int n, int row, Set<Integer> columns, Set<Integer> left, Set<Integer> right) {
        if (n == row) {
            return 1;
        } else {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (columns.contains(i)) {
                    continue;
                }
                int leftIndex = row - i;
                if (left.contains(leftIndex)) {
                    continue;
                }
                int rightIndex = row + i;
                if (right.contains(rightIndex)) {
                    continue;
                }
                columns.add(i);
                left.add(leftIndex);
                right.add(rightIndex);
                count += backtrack(n, row + 1, columns, left, right);
                columns.remove(i);
                left.remove(leftIndex);
                right.remove(rightIndex);
            }
            return count;
        }
    }
}
