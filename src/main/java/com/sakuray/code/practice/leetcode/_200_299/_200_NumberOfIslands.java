package com.sakuray.code.practice.leetcode._200_299;

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Input: grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * Output: 1
 * <p>
 * Input: grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * Output: 3
 */
public class _200_NumberOfIslands {

    /**
     * 计算岛屿的联通数量，dfs搜索，搜索过的修改土地内容
     */
    public int numIslands(char[][] grid) {
        int n = grid.length; int m = grid[0].length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    dfs(grid, i, j, n, m);
                }
            }
        }
        return result;
    }

    public void dfs(char[][] grid, int x, int y, int n, int m) {
        if (!isArea(x, y, n, m)) {
            return;
        }
        if (grid[x][y] == '0') {
            return;
        }
        if (grid[x][y] == '1') {
            grid[x][y] = '0';
        }
        dfs(grid, x + 1, y, n, m);
        dfs(grid, x - 1, y, n, m);
        dfs(grid, x, y + 1, n, m);
        dfs(grid, x, y - 1, n, m);
    }

    public boolean isArea(int x, int y, int n, int m) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }
}
