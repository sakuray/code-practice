package com.sakuray.code.practice.leetcode._1200_1299;

/**
 * Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.
 * Return the number of closed islands.
 * <p>
 * Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
 * Output: 2
 * Explanation:
 * Islands in gray are closed because they are completely surrounded by water (group of 1s).
 * <p>
 * Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
 * Output: 1
 * <p>
 * Input: grid = [[1,1,1,1,1,1,1],
 * [1,0,0,0,0,0,1],
 * [1,0,1,1,1,0,1],
 * [1,0,1,0,1,0,1],
 * [1,0,1,1,1,0,1],
 * [1,0,0,0,0,0,1],
 * [1,1,1,1,1,1,1]]
 * Output: 2
 */
public class _1254_NumberOfClosedIslands {

    /**
     * 上下左右被水包围的才算内陆。换个角度：总共有3类，水、陆地和边
     * 被水包围是不是意味着不靠边。那是不是只要排除了靠边的路径，剩下的陆地就是200题了
     */
    public int closedIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        for (int i = 0; i < n; i++) {
            dfs(grid, i, 0, n, m);
            dfs(grid, i, m - 1, n, m);
        }
        for (int i = 0; i < m; i++) {
            dfs(grid, 0, i, n, m);
            dfs(grid, n - 1, i, n, m);
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    result++;
                    dfs(grid, i, j, n, m);
                }
            }
        }
        return result;
    }

    private void dfs(int[][] grid, int i, int j, int n, int m) {
        if (i < 0 || j < 0 || i >= n || j >= m) {
            return;
        }
        if (grid[i][j] == 1) {
            return;
        }
        if (grid[i][j] == 0) {
            grid[i][j] = 1;
        }
        dfs(grid, i + 1, j, n, m);
        dfs(grid, i - 1, j, n, m);
        dfs(grid, i, j + 1, n, m);
        dfs(grid, i, j - 1, n, m);
    }
}
