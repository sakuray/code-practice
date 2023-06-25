package com.sakuray.code.practice.leetcode._600_699;

import java.util.HashSet;
import java.util.Set;

/**
 * 收费题目，未验证
 */
public class _694_NumberOfDistinctIslands {

    /**
     * 不同形状的岛屿，关键在于生成岛屿的唯一标识。按照遍历顺序赋值，给出途径。注意还需要撤销步骤
     * 下，右，撤销右，撤销下
     * 下，撤销下，右，撤销右
     * 上面两个图形形状是不一样的
     */
    public int numDistinctIslands(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Set<String> result = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, n, m, sb, 100);
                    result.add(sb.toString());
                }
            }
        }
        return result.size();
    }

    private void dfs(int[][] grid, int i, int j, int n, int m, StringBuilder sb, int dir) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        sb.append(dir).append(",");
        dfs(grid, i + 1, j, n, m, sb, 1);
        dfs(grid, i - 1, j, n, m, sb, 2);
        dfs(grid, i, j + 1, n, m, sb, 3);
        dfs(grid, i, j - 1, n, m, sb, 4);
        sb.append(-dir).append(",");
    }
}
