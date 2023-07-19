package com.sakuray.code.practice.leetcode._400_499;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of intervals intervals where intervals[i] = [starti, endi],
 * return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 * <p>
 * Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
 * Output: 1
 * Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
 * <p>
 * Input: intervals = [[1,2],[1,2],[1,2]]
 * Output: 2
 * Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
 * <p>
 * Input: intervals = [[1,2],[2,3]]
 * Output: 0
 * Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 */
public class _435_NonOverlappingIntervals {

    /**
     * 确定最少移除多少个保持区间不重叠，贪心算法
     * 按照结束时间排序，如果下一个区间开始时间大于上一个区间的结束时间，则不重叠
     * [x1, y1] [x2, y2] [x3, y3] ... [xn, yn] y1 <= y2 <= y3
     * 贪心算法担心的是局部最优解不是全局最优解，此题担心什么？
     * [x3, y3] 覆盖了多个区间 [x1,y1][x2,y2]，导致原本只需要移除[x3,y3]即可，现在移除了2个区间，确保剩下的不重叠
     * 那么按照结束时间排序是否可以解决这个问题？想想如果x3,y3和x1,y1 x2,y2重叠，意味着什么？
     * x3 <= x1 and x2 且 y3 >= y1,y2
     * 局部最优解，肯定会先遍历到1，2组，这个时候x3肯定不满足x3 >= y1, y2
     * 如果y1 = y2，那么两个必定要移除一个，也只需要判断x1,x2是否和上一个截止时间重叠，重叠移除2个
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int n = intervals.length, count = 1, pre = 0;
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= intervals[pre][1]) {
                pre = i;
                count++;
            }
        }
        return n - count;
    }

    public int eraseOverlapIntervals_S(int[][] intervals) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, n = intervals.length;
        for (int i = 0; i < n; i++) {
            max = Integer.max(max, intervals[i][1]);
            min = Integer.min(min, intervals[i][1]);
        }
        int diff = max - min + 2;
        int[] rightEnd = new int[diff];
        for (int in[] : intervals) {
            int l = in[0] - min + 1;
            int r = in[1] - min + 1;
            if (l > rightEnd[r]) {
                rightEnd[r] = l;
            }
        }
        int s = 1, ans = intervals.length - 1;
        for (int i = 2; i < diff; i++) {
            if (s <= rightEnd[i]) {
                ans--;
                s = i;
            }
        }
        return ans;
    }
}
