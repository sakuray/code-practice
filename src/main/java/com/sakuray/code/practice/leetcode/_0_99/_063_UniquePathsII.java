package com.sakuray.code.practice.leetcode._0_99;

/**
 * You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]).
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
 * The robot can only move either down or right at any point in time.
 *
 * An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.
 * Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 * The testcases are generated so that the answer will be less than or equal to 2 * 109.
 * Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: 2
 * Explanation: There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 *
 * Input: obstacleGrid = [[0,1],[0,0]]
 * Output: 1
 */
public class _063_UniquePathsII {

    /**
     * 和62区别在于遇到1，置为0
     * 滚动数组，进行降维，[i][j]的可能性只与左边和上边的数值有关。
     * 所以只需要列大小的数组进行滚动即可：
     * 1 1 1 1 1 1 1
     * 1
     * 1
     * 如上图：
     * 第一排遍历时，第一个数值只取决于前面的，状态是{1,1,1,1,1,1,1}
     * 第二批便利是，第一个数值只取决于前面的和其左边的，前面的就是当前位置1，左边的就是其坐标位置，具体操作变成了：
     * {1,1,1,1,1,1,1}
     * {1,2,1,1,1,1,1}
     * {1,2,3,1,1,1,1}
     * ....
     * {1,2,3,4,5,6,7}
     * 再下一排就是
     * {1,3,3,4,5,6,7}
     * ...
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] f = new int[m];

        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }

        return f[m - 1];
    }

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int x = obstacleGrid.length;
        int y = obstacleGrid[0].length;
        int[] dp = new int[y];
        dp[0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    dp[j] = dp[j - 1] + dp[j];
                }
            }
        }
        return dp[y - 1];
    }
}
