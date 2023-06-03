package com.sakuray.code.practice.leetcode._0_99;

/**
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:
 * <p>
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 * <p>
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * <p>
 * Input: s = "aa", p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 * <p>
 * Input: s = "cb", p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 */
public class _044_WildcardMatching {

    /**
     * 还是正则匹配，比010简单一些
     * ？匹配任何一个字符，010中的.
     * * 比010中简单，前者需要和上一个字符进行匹配，后者不需要，仅需要一个字符即可
     * dp[i][j]当 s[i] = p[j]时，等于dp[i - 1][j - 1]，或者p[j]是？
     * s[j]是* 的情况，dp[i][j] = dp[i][j-1] (匹配0个)或者dp[i-1][j]匹配N个
     * 当s的前n个字符都是*时，dp[0][j] = true
     */
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[n][m];
    }
}
