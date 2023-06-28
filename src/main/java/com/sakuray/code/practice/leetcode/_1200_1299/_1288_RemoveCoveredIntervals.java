package com.sakuray.code.practice.leetcode._1200_1299;

import java.util.Arrays;

/**
 * Given an array intervals where intervals[i] = [li, ri] represent the interval [li, ri),
 * remove all intervals that are covered by another interval in the list.
 * The interval [a, b) is covered by the interval [c, d) if and only if c <= a and b <= d.
 * Return the number of remaining intervals.
 * <p>
 * Input: intervals = [[1,4],[3,6],[2,8]]
 * Output: 2
 * Explanation: Interval [3,6] is covered by [2,8], therefore it is removed.
 * <p>
 * Input: intervals = [[1,4],[2,3]]
 * Output: 1
 */
public class _1288_RemoveCoveredIntervals {

    /**
     * 移除区间完全被覆盖的，统计剩余多少区间
     * 排序后判断更容易，问题关键怎么排序，[1,2][1,3][2,4]..
     * 按照左侧升序，右侧降序排列[1,3][1,2][2,4]这样1相同的可以直接省略
     */
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, ((o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]));
        int res = 0, right = -1;
        for (int[] range : intervals) {
            // 确定左边上一个一定比现在的更靠左，如果上一个右边比当前更大 则上一个肯定包含当前的区间范围
            // last: left ~ right
            // cur :   left + n ~ range[1]
            if (right < range[1]) {
                right = range[1];
                res++;
            }
        }
        return res;
    }
}
