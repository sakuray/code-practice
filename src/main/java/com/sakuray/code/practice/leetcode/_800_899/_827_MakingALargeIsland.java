package com.sakuray.code.practice.leetcode._800_899;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.
 * Return the size of the largest island in grid after applying this operation.
 * An island is a 4-directionally connected group of 1s.
 * <p>
 * Input: grid = [[1,0],[0,1]]
 * Output: 3
 * Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
 * <p>
 * Input: grid = [[1,1],[1,0]]
 * Output: 4
 * Explanation: Change the 0 to 1 and make the island bigger, only one island with area = 4.
 * <p>
 * Input: grid = [[1,1],[1,1]]
 * Output: 4
 * Explanation: Can't change any 0 to 1, only one island with area = 4.
 */
public class _827_MakingALargeIsland {

    /**
     * 同问题200，我们需要标记每块岛屿的下标
     * 然后遍历格子，判断填海造路的最大面积
     */
    public int largestIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int islandIndex = 2;
        Map<Integer, Integer> islandArea = new HashMap<>();
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, islandIndex, i, j, n, m);
                    islandArea.put(islandIndex, area);
                    islandIndex++;
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    int tmpArea = 1 + nextArea(islandArea, grid, i, j, n, m);
                    maxArea = Math.max(maxArea, tmpArea);
                }
            }
        }
        return maxArea;
    }

    private int nextArea(Map<Integer, Integer> islandArea, int[][] grid, int x, int y, int n, int m) {
        Set<Integer> islandSet = new HashSet<>();
        if (isArea(x - 1, y, n, m)) {
            islandSet.add(grid[x-1][y]);
        }
        if (isArea(x + 1, y, n, m)) {
            islandSet.add(grid[x+1][y]);
        }
        if (isArea(x, y - 1, n, m)) {
            islandSet.add(grid[x][y - 1]);
        }
        if (isArea(x, y + 1, n, m)) {
            islandSet.add(grid[x][y + 1]);
        }
        int area = 0;
        for (Integer index : islandSet) {
            area += islandArea.getOrDefault(index, 0);
        }
        return area;
    }


    private boolean isArea(int x, int y, int n, int m) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }


    private int dfs(int[][] grid, int islandIndex, int x, int y, int n, int m) {
        if (isArea(x, y, n, m)) {
            if (grid[x][y] == 0) {
                return 0;
            }
            if (grid[x][y] != 1) {
                return 0;
            }
            grid[x][y] = islandIndex;
            return 1 + dfs(grid, islandIndex, x + 1, y, n, m)
                    + dfs(grid, islandIndex, x - 1, y, n, m)
                    + dfs(grid, islandIndex, x, y + 1, n, m)
                    + dfs(grid, islandIndex, x, y - 1, n, m);
        }
        return 0;
    }
}
