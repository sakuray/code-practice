package com.sakuray.code.practice.leetcode._100_199;


/**
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. 
 * Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.
   The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.
   Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; 
   other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
   In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
   Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
   For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
		-2 (K)	-3	3
		-5	-10	1
		10	30	-5 (P)
   Notes:
        The knight's health has no upper bound.
        Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
 *
 */
public class _174_DungeonGame {

	public static void main(String[] args) {
		int[][] test = new int[][] {
			{-2, -3, 3},
			{-5, -10, 1},
			{10, 30, 5}
		};
		int[][] test2 = new int[][] {
			{0, -3}
		};
		int[][] test3= new int[][] {
			{0}
		};
		int[][] test4 = new int[][] {
			{2, 1},
			{1, -1}
		};
		System.out.println(calculateMinimumHP(test));
		System.out.println(calculateMinimumHP(test2));
		System.out.println(calculateMinimumHP(test3));
		System.out.println(calculateMinimumHP(test4));
	}
	
	public static int calculateMinimumHP(int[][] dungeon) {
		int rows = dungeon.length;
		int columns = dungeon[rows - 1].length;
		int[][] result = new int[rows+1][columns+1];
		for(int i = rows - 1; i >= 0; i--) {
			for(int j = columns - 1; j >= 0; j--) {
				int nextMin;
				if(i == rows - 1) {
					nextMin = result[i][j+1];
				} else if(j == columns - 1) {
					nextMin = result[i+1][j];
				} else {
					nextMin = Math.min(result[i+1][j], result[i][j+1]);
				}
				int cur = dungeon[i][j];
				if(cur > 0 && cur >= nextMin) {
					result[i][j] = 0;
				} else {
					result[i][j] = nextMin - cur;
				}
//				if(cur > 0) {
//					if(cur >= nextMin) {
//						result[i][j] = 0;
//					} else {
//						result[i][j] = nextMin - cur;
//					}
//				} else {
//					result[i][j] = -cur + nextMin;
//				}
			}
		}
//        return dungeon[rows-1][columns-1] > 0 ? result[0][0] : result[0][0] + 1;
		return result[0][0] + 1;
    }
	
	public int calculateMinimumHP_S(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return -1;
        }
        int height = dungeon.length;
        int width = dungeon[0].length;
        int[][] dp = new int[height][width];
        dp[height - 1][width - 1] = 1 - dungeon[height - 1][width - 1] < 1 ? 1 : 1 - dungeon[height - 1][width - 1];
        for (int i = width - 2; i >= 0; i --) {
            dp[height - 1][i] = dp[height - 1][i + 1] - dungeon[height - 1][i] < 1 ? 1 : dp[height - 1][i + 1] - dungeon[height - 1][i];
        }
        for (int i = height - 2; i >= 0; i --) {
            dp[i][width - 1] = dp[i + 1][width - 1] - dungeon[i][width - 1] < 1 ? 1 : dp[i + 1][width - 1] - dungeon[i][width - 1];
        }
        return dfs(dungeon, 0, 0, dp);
    }
    
    private int dfs(int[][] dungeon, int i, int j, int[][] dp) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int down = dfs(dungeon, i + 1, j, dp);
        int right = dfs(dungeon, i, j + 1, dp);
        dp[i][j] = Math.min(down, right) - dungeon[i][j];
        if (dp[i][j] < 1) {
            dp[i][j] = 1;
        }
        return dp[i][j];
    }
}
