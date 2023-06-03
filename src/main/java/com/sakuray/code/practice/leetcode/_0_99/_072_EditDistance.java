package com.sakuray.code.practice.leetcode._0_99;

/**
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 * <p>
 * You have the following three operations permitted on a word:
 * <p>
 * Insert a character
 * Delete a character
 * Replace a character
 * <p>
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * <p>
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 */
public class _072_EditDistance {

    /**
     * 变更删除替换从a -> b,本质上只有3种操作：
     * 1.a比b少，直接补充a，那么:dp[i][j] = dp[i][j-1] + 1
     * 2.b比a少，直接补充b，那么：dp[i][j] = dp[i-1][j] + 1
     * 3.a和b一样。如果a[i] = b[j]那么dp[i][j] = dp[i - 1][j -1], 或者需要一步进行变化 + 1
     * 有3个路径变化成dp[i][j] 找到最短的路径即可
     */
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        if (n * m == 0) {
            return n + m;
        }
        int[][] dp = new int[n + 1][m + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= m; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int r1 = dp[i - 1][j] + 1;
                int r2 = dp[i][j - 1] + 1;
                int r3 = dp[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    r3 += 1;
                }
                dp[i][j] = Math.min(r1, Math.min(r2, r3));
            }
        }
        return dp[n][m];
    }
}
