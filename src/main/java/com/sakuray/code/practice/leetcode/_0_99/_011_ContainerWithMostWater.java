package com.sakuray.code.practice.leetcode._0_99;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container,
 * such that the container contains the most water.
 * Note: You may not slant the container and n is at least 2.
 * 
 * 体积是Min(ax,ay)*(y-x) 找式子最大值
 */
public class _011_ContainerWithMostWater {

	public static void main(String[] args) {
		System.out.println(1 == maxArea(new int[] {1,1}));
	}
	
	public static int maxArea(int[] height) {
		if(height == null || height.length < 2) return 0;
		int l = 0, r = height.length - 1;
		int maxArea = -1;
		while(l < r) {
			int area = Math.min(height[l], height[r]) * (r - l);
			if(area > maxArea) maxArea = area;
			if(height[l] < height[r]) l++;
			else r--;
		}
        return maxArea;
    }
	
	public static int maxArea_S(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }
}
