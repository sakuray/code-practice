package com.sakuray.code.practice.leetcode._400_499;

/**
 * You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.
 * <p>
 * Grid cells are connected horizontally/vertically (not diagonally).
 * The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
 * <p>
 * The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1.
 * The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 * <p>
 * Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
 * Output: 16
 * Explanation: The perimeter is the 16 yellow stripes in the image above.
 * <p>
 * Input: grid = [[1]]
 * Output: 4
 * <p>
 * Input: grid = [[1,0]]
 * Output: 4
 */
public class _463_IslandPerimeter {

    /**
     * 计算岛屿周长，一个方格有4条边，遇到陆地不是周长，遇到海或者数组边界周长+1，
     * 同问题200，但只有一个岛屿，只需要遍历一次
     */
    public int islandPerimeter(int[][] grid) {
        int n = grid.length; int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j, n, m);
                }
            }
        }
        return 0;
    }

    private int dfs(int[][] grid, int x, int y, int n, int m) {
        if (x >= 0 && y >= 0 && x < n && y < m) {
            if (grid[x][y] == 0) {
                return 1;
            }
            if (grid[x][y] == 2) {
                return 0;
            }
            grid[x][y] = 2;
            return dfs(grid, x + 1, y, n, m)
                    + dfs(grid, x - 1, y, n, m)
                    + dfs(grid, x, y + 1, n, m)
                    + dfs(grid, x, y - 1, n, m);
        }
        return 1;
    }
}
