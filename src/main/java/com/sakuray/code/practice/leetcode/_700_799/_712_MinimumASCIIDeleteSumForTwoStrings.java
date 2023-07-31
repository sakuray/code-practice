package com.sakuray.code.practice.leetcode._700_799;

/**
 * Given two strings s1 and s2, return the lowest ASCII sum of deleted characters to make two strings equal.
 * <p>
 * Input: s1 = "sea", s2 = "eat"
 * Output: 231
 * Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
 * Deleting "t" from "eat" adds 116 to the sum.
 * At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.
 * <p>
 * Input: s1 = "delete", s2 = "leet"
 * Output: 403
 * Explanation: Deleting "dee" from "delete" to turn the string into "let",
 * adds 100[d] + 101[e] + 101[e] to the sum.
 * Deleting "e" from "leet" adds 101[e] to the sum.
 * At the end, both strings are equal to "let", and the answer is 100+101+101+101 = 403.
 * If instead we turned both strings into "lee" or "eet", we would get answers of 433 or 417, which are higher.
 */
public class _712_MinimumASCIIDeleteSumForTwoStrings {

    /**
     * 类似72题编辑距离，删除若干char，问删除的sum(char)最小值，使得s1==s2
     * dp[i][j]就是使得s1==s2的minimumDeleteSum
     * 如果s1.charAt(i) == s2.charAt(j) 则 dp[i][j] = dp[i-1][j-1]不需要操作
     * 如果不等于，那么简单来说就是删除i或者删除j使得其相等，如果删除i
     * 那么 dp[i][j] = dp[i-1][j] + s1.charAt(i)，否则dp[i][j]=dp[i][j-1] + s2.charAt(j)，取最小的
     * 状态公式确定之后，问题就是其实迭代内容是什么。可以看见假设是一个田，我们要得到右下角的值，需要知道另外3个空格的内容。
     * 需要初始化dp[i][0]和dp[0][j]。 dp[i][0]是不是意味着s2为空？其值就是s1.charAt(i)，其他的同理
     */
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
        }

        for (int j = 1; j <= m; j++) {
            dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + s1.charAt(i - 1), dp[i][j - 1] + s2.charAt(j - 1));
                }
            }
        }
        return dp[n][m];
    }
}
