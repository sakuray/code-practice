package com.sakuray.code.practice.leetcode._900_999;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi] and secondList[j] = [startj, endj].
 * Each list of intervals is pairwise disjoint and in sorted order.
 * Return the intersection of these two interval lists.
 * A closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.
 * The intersection of two closed intervals is a set of real numbers that are either empty or represented as a closed interval.
 * For example, the intersection of [1, 3] and [2, 4] is [2, 3].
 * <p>
 * Input: firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
 * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 * <p>
 * Input: firstList = [[1,3],[5,9]], secondList = []
 * Output: []
 */
public class _986_IntervalListIntersections {

    /**
     * 找两组区间段的交集区间，每个区间段的区间有序，且不相交
     * 因为有序且不相交，找到两组的交集，可以使用双指针的方式
     */
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        getResult(firstList, secondList, 0, 0, result);
        return result.toArray(new int[0][]);
    }

    private void getResult(int[][] first, int[][] second, int f, int s, List<int[]> result) {
        if (f == first.length || s == second.length) {
            return;
        }
        int maxLeft = Math.max(first[f][0], second[s][0]);
        int minRight = Math.min(first[f][1], second[s][1]);
        // 左侧最大小于右侧最小，存在交集
        if (maxLeft <= minRight) {
            result.add(new int[]{maxLeft, minRight});
            if (minRight == first[f][1]) {
                getResult(first, second, f + 1, s, result);
            } else {
                getResult(first, second, f, s + 1, result);
            }
        } else {
            // 左侧最大大于右侧最小，意味着没有交集，移动左边的区间段
            if (maxLeft == first[f][0]) {
                getResult(first, second, f, s + 1, result);
            } else {
                getResult(first, second, f + 1, s, result);
            }
        }
    }
}
