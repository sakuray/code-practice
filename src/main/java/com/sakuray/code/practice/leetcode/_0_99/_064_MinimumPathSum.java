package com.sakuray.code.practice.leetcode._0_99;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right,
 * which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 *
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 *
 * Input: grid = [[1,2,3],[4,5,6]]
 * Output: 12
 */
public class _064_MinimumPathSum {

    /**
     * grid[i][j] = min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j]
     */
    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) continue;
                else if (i == 0) grid[i][j] = grid[i][j - 1] + grid[i][j];
                else if (j == 0) grid[i][j] = grid[i - 1][j] + grid[i][j];
                else grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    /**
     * 只能右移和下移，本质上是求
     * grid[i][j] = min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j]
     */
    public int minPathSum2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i != 0 || j != 0) {
                    if (i == 0) {
                        grid[i][j] = grid[i][j - 1] + grid[i][j];
                    } else if (j == 0) {
                        grid[i][j] = grid[i - 1][j] + grid[i][j];
                    } else {
                        grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j]) + grid[i][j];
                    }
                }
            }
        }
        return grid[m - 1][n - 1];
    }
}
