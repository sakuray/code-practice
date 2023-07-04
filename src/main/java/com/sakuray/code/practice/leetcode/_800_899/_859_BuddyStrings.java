package com.sakuray.code.practice.leetcode._800_899;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given two strings s and goal, return true if you can swap two letters in s so the result is equal to goal, otherwise, return false.
 * Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at s[i] and s[j].
 * For example, swapping at indices 0 and 2 in "abcd" results in "cbad".
 * <p>
 * Input: s = "ab", goal = "ba"
 * Output: true
 * Explanation: You can swap s[0] = 'a' and s[1] = 'b' to get "ba", which is equal to goal.
 * <p>
 * Input: s = "ab", goal = "ab"
 * Output: false
 * Explanation: The only letters you can swap are s[0] = 'a' and s[1] = 'b', which results in "ba" != goal.
 * <p>
 * Input: s = "aa", goal = "aa"
 * Output: true
 * Explanation: You can swap s[0] = 'a' and s[1] = 'a' to get "aa", which is equal to goal.
 */
public class _859_BuddyStrings {

    public static void main(String[] args) {
        System.out.println(buddyStrings("ab", "ba"));
        System.out.println(buddyStrings("ab", "ab"));
        System.out.println(buddyStrings("aa", "aa"));
        System.out.println(buddyStrings("abcaa", "abcbb"));
    }

    /**
     * 简单来说必须交互一次从s得到goal。如果两个字符串相等，有重复字符返回true，否则返回false
     * 如果两个字符串不等，仅存在2个位置不相同。
     */
    public static boolean buddyStrings(String s, String goal) {
        if (s == null || goal == null) {
            return false;
        }
        int len = s.length();
        if (len == 0 || len != goal.length()) {
            return false;
        }
        boolean result = false, safe = true; int diffTime = 0;
        Map<Character, Character> diff = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            char c1 =  s.charAt(i);
            char c2 = goal.charAt(i);
            set.add(c1);
            if (c1 != c2) {
                safe = false;
                if (diffTime >= 2) {
                    return false;
                } else {
                    if (diffTime == 1) {
                        result = diff.getOrDefault(c2, c2) == c1;
                    }
                    diff.put(c1, c2);
                }
                diffTime++;
            }
        }
        if (safe) {
            result = set.size() < len;
        }
        return result;
    }
}
