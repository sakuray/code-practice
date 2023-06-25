package com.sakuray.code.practice.leetcode.common;

/**
 * 深度优先搜索，单条路径不断深入搜索，常见问题：
 * 二维数组搜索：岛屿问题
 * a.200题：岛屿数量
 */
public class DFS {


    private void dfs(int[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            // 搜索超过边界
            return;
        }
        if (visited[i][j]) {
            // 遍历过
            return;
        }
        // 当前节点的逻辑
        visited[i][j] = true;
        // 遍历上下左右
        dfs(grid, i + 1, j, visited);
        dfs(grid, i - 1, j, visited);
        dfs(grid, i, j + 1, visited);
        dfs(grid, i, j - 1, visited);
    }
}
