package com.sakuray.code.practice.leetcode.common;

/**
 * 深度优先搜索，单条路径不断深入搜索，常见问题：
 * 二维数组搜索：岛屿问题
 * a.200题：岛屿数量
 * b.1254题：内陆岛屿数量：关键点将靠边的岛屿淹没，再按照题200计算就能得到内陆岛屿数量了
 * c.695题：最大岛屿面积：遇到路径+1即可
 * d.1905题：子岛屿数量：关键将岛2是陆地，岛1是海洋的板块填海，类似1254题
 * e.694题：不同岛屿数量：关键是将岛屿序列化，相同形状岛屿序列化出来的结果一致
 * f.1020题：飞地数量：同1254，靠近网格边缘的不是飞地，其他的是
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
