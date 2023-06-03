package com.sakuray.code.practice.leetcode._0_99;

/**
 * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 *
 * Input: s = "aa", p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 *
 * Input: s = "ab", p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 */
public class _010_RegularExpressionMatching {

    /**
     * f[i][j] 表示s的前i个字符与p中的前j 个字符是否能够匹配。
     * 在进行状态转移时，我们考虑p的第j个字符的匹配情况：
     * p的第j个字符是常量，必须匹配s[i]=p[j],f[i][j] = f[i-1][j-1] 不等就是false
     * p的第j个字符是*，标识对p的j-1字符任意匹配，
     *  匹配0次的时候f[i][j]=f[i][j-2] j-2意味着不需要匹配这个字符+*
     *  匹配1次的时候s[i]=p[j-1]: f[i][j]=f[i-1][j-2]
     *  匹配2次的时候s[i−1]=s[i]=p[j−1]：f[i][j]=f[i−2][j−2]
     *  比较复杂：本质上只有2种情况：
     *  匹配s 末尾的一个字符，将该字符扔掉，而该组合还可以继续进行匹配
     *  不匹配字符，将该组合扔掉，不再进行匹配
     *  s[i]=p[j-1] : f[i - 1][j] or f[i][j-2]
     *  f[i][j-2]
     * p的第j个字符是.，那么p[j] 一定成功匹配s 中的任意一个小写字母。
     *
     */
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }


    public boolean isMatch2(String s, String p) {
        int n = s.length(), y = p.length();
        boolean[][] dp = new boolean[n + 1][y + 1];
        dp[0][0] = true;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= y; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[n][y];
    }
}
