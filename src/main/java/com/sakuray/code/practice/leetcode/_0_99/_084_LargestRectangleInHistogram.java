package com.sakuray.code.practice.leetcode._0_99;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
 * return the area of the largest rectangle in the histogram.
 * <p>
 * Input: heights = [2,1,5,6,2,3]
 * Output: 10
 * Explanation: The above is a histogram where width of each bar is 1.
 * The largest rectangle is shown in the red area, which has an area = 10 units.
 * <p>
 * Input: heights = [2,4]
 * Output: 4
 */
public class _084_LargestRectangleInHistogram {

    /**
     * 本质上就是当前高度向左右延展，不低于这个高度宽+1，这样就能使用长 * 宽计算当前高度能达到的最大面积
     * 本质上计算左右边界 * 当前柱子高度 = 当前最大面积
     * 如果左边高度小于当前高度就是左边界。不需要继续降低本节点高度扩展。因为小于的那个节点会计算相关高度
     * 最终形成了单调栈,只需要放入最接近当前柱状图，比当前高小的
     */
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> heightStack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!heightStack.isEmpty() && heights[heightStack.peek()] >= heights[i]) {
                heightStack.pop();
            }
            left[i] = heightStack.isEmpty() ? -1 : heightStack.peek();
            heightStack.push(i);
        }
        heightStack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!heightStack.isEmpty() && heights[heightStack.peek()] >= heights[i]) {
                heightStack.pop();
            }
            right[i] = heightStack.isEmpty() ? n : heightStack.peek();
            heightStack.push(i);
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, (right[i] - left[i] - 1) * heights[i]);
        }
        return result;
    }

    /**
     * 优化：我们需要左右边界得到宽度。左边界是最近的比当前柱高矮的，左边界与当前节点之间没有更矮的（最多等于）
     * 当压榨弹出的时候是不是已经能确定右边界了。
     * 栈中存入的弹出的都是不低于当前遍历节点高度的节点，且这些节点都在当前节点左侧。如果当前遍历点左侧有更低的节点，
     * 遍历更低的那个节点时就应该满足左侧节点 >= 更低节点，导致数据弹出。所以在节点弹出的时候，一定是当前节点时其右边界。
     */
    public int largestRectangleArea2(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);

        Stack<Integer> heightStack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!heightStack.isEmpty() && heights[heightStack.peek()] >= heights[i]) {
                right[heightStack.peek()] = i;
                heightStack.pop();
            }
            left[i] = heightStack.isEmpty() ? -1 : heightStack.peek();
            heightStack.push(i);
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, (right[i] - left[i] - 1) * heights[i]);
        }
        return result;
    }
}
