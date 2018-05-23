package com.sakuray.code.practice.leetcode._700_799;

import com.sakuray.code.practice.leetcode.PrintTools;

/**
 * An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).
 * Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.
 * To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.
 * At the end, return the modified image.
 * Example 1:
 * Input: 
	image = [[1,1,1],[1,1,0],[1,0,1]]
	sr = 1, sc = 1, newColor = 2
   Output: [[2,2,2],[2,2,0],[2,0,1]]
   Explanation: 
	From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected 
	by a path of the same color as the starting pixel are colored with the new color.
	Note the bottom corner is not colored 2, because it is not 4-directionally connected
	to the starting pixel.
   Note:
	The length of image and image[0] will be in the range [1, 50].
	The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
	The value of each color in image[i][j] and newColor will be an integer in [0, 65535].
 *
 */
public class _733_FloodFill {
	
	public static void main(String[] args) {
		// [[0,0,0],[0,1,1]] 1,1,1
		int[][] test = new int[][] {new int[] {1,1,1}, new int[] {1,1,0}, new int[] {1,0,1}};
		test = floodFill(test, 1, 1, 2);
		PrintTools.print2Array(test);
		int[][] test2 = new int[][] {new int[] {0,0,0}, new int[] {0,1,1}};
		test2 = floodFill(test2, 1, 1, 1);
		PrintTools.print2Array(test2);
	}

	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		if(image[sr][sc] == newColor) return image;	// 如果不需要改变颜色，原样返回
        fill(image, image[sr][sc], sr, sc, newColor);
        return image;
    }
	
	public static void fill(int[][] image, int aim, int r, int c, int newColor) {
		if(r < image.length && r > -1 &&
				c < image[r].length && c > -1 && image[r][c] == aim) {
			image[r][c] = newColor;
			fill(image, aim, r+1, c, newColor);
			fill(image, aim, r-1, c, newColor);
			fill(image, aim, r, c+1, newColor);
			fill(image, aim, r, c-1, newColor);
		}
	}
	
	public int[][] floodFill_S(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor != newColor) dfs(image, sr, sc, oldColor, newColor);
        return image;
    }
    
    private void dfs(int[][] image, int sr, int sc, int oldColor, int newColor) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length) return;
        if (image[sr][sc] == oldColor) {
            image[sr][sc] = newColor;
            dfs(image, sr + 1, sc, oldColor, newColor);
            dfs(image, sr - 1, sc, oldColor, newColor);
            dfs(image, sr, sc + 1, oldColor, newColor);
            dfs(image, sr, sc - 1, oldColor, newColor);
        }
    }
}
