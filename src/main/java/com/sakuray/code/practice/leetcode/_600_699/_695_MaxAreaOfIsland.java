package com.sakuray.code.practice.leetcode._600_699;

/**
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
 * You may assume all four edges of the grid are surrounded by water.
 * The area of an island is the number of cells with a value 1 in the island.
 * Return the maximum area of an island in grid. If there is no island, return 0.
 * <p>
 * Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Output: 6
 * Explanation: The answer is not 11, because the island must be connected 4-directionally.
 * <p>
 * Input: grid = [[0,0,0,0,0,0,0,0]]
 * Output: 0
 */
public class _695_MaxAreaOfIsland {

    /**
     * 求面积最大的岛屿面积，同问题200
     */
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length; int m = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j, n, m));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int x, int y, int n, int m) {
        if (x >= 0 && y >= 0 && x < n && y < m) {
            if (grid[x][y] == 0) {
                return 0;
            }
            grid[x][y] = 0;
            return 1 + dfs(grid, x + 1, y, n, m)
                    + dfs(grid, x - 1, y, n, m)
                    + dfs(grid, x, y + 1, n, m)
                    + dfs(grid, x, y - 1, n, m);
        }
        return 0;
    }
}
