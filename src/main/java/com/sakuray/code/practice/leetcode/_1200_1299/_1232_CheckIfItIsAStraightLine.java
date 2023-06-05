package com.sakuray.code.practice.leetcode._1200_1299;

/**
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point.
 * Check if these points make a straight line in the XY plane.
 * <p>
 * Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * Output: true
 * <p>
 * Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * Output: false
 */
public class _1232_CheckIfItIsAStraightLine {

    /**
     * 两点构成一条直线，判断斜率。
     * X1 - X2 / Y1 - Y2 等于 X1 - X3 / Y1 - Y3
     * 令第一个点是原点0,0，后续所有点都需要平移成新的坐标(x,y)
     * Ax + By = 0 (过原点执行)
     * 第二个点位，可以求出A= y B = -x
     */
    public boolean checkStraightLine(int[][] coordinates) {
        int x = coordinates[0][0], y = coordinates[0][1];
        for (int i = 1; i < coordinates.length; i++) {
            coordinates[i][0] -= x;
            coordinates[i][1] -= y;
        }
        int A = coordinates[1][1], B = -coordinates[1][0];
        for (int i = 2; i < coordinates.length; i++) {
            if (A * coordinates[i][0] + B * coordinates[i][1] != 0) {
                return false;
            }
        }
        return true;
    }
}
