package com.sakuray.code.practice.leetcode._0_99;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 * <p>
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 * <p>
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 */
public class _042_TrappingRainWater {

    /**
     * 接雨水，本质上就是计算当前节点左右的墙高，选择最低的那个墙 * 1 - 自身墙高，得到凹槽的面积
     *
     * @param height 墙高
     * @return 接到的雨水
     */
    public int trap(int[] height) {
        int length = height.length;
        if (length == 0) {
            return 0;
        }
        int[] leftMax = new int[length];
        leftMax[0] = height[0];
        for (int i = 1; i < length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        int[] rightMax = new int[length];
        rightMax[length - 1] = height[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        int size = 0;
        for (int i = 0; i < length; i++) {
            size = size + Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return size;
    }
}
