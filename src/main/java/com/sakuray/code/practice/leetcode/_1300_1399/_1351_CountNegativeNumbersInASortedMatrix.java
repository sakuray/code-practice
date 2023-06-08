package com.sakuray.code.practice.leetcode._1300_1399;

import com.sakuray.code.practice.leetcode.Tools;

/**
 * Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise,
 * return the number of negative numbers in grid.
 *
 * Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * Output: 8
 * Explanation: There are 8 negatives number in the matrix.
 *
 * Input: grid = [[3,2],[1,0]]
 * Output: 0
 */
public class _1351_CountNegativeNumbersInASortedMatrix {

    public static void main(String[] args) {
        System.out.println(countNegatives(Tools.build2Array(4,4,3,2,-1, 3,2,1,-1, 1,1,-1,-2, -1,-1,-2,-3)));
        System.out.println(countNegatives(Tools.build2Array(2, 1,-1,-1,-1)));
    }

    public static int countNegatives(int[][] grid) {
        int ans = 0;
        for (int i = grid.length - 1; i >= 0; i--) {
            // 二分查找小于0的位置
            int left = 0, right = grid[0].length - 1;
            if (grid[i][right] < 0) {
                while (left < right) {
                    int mid = left + ((right - left) >>> 1);
                    if (grid[i][mid] < 0) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                int pos = right < 0 ? 0 : (grid[i][right] < 0 ? right : right + 1);
                ans += grid[0].length - pos;
            } else {
                // 当前行都不小于0,上面的行不会出现比0小的
                break;
            }
        }
        return ans;
    }
}
