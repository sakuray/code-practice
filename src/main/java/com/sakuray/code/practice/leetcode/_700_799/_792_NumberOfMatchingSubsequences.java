package com.sakuray.code.practice.leetcode._700_799;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.
 * A subsequence of a string is a new string generated from the original string with some characters (can be none)
 * deleted without changing the relative order of the remaining characters.
 * For example, "ace" is a subsequence of "abcde".
 * <p>
 * Input: s = "abcde", words = ["a","bb","acd","ace"]
 * Output: 3
 * Explanation: There are three strings in words that are a subsequence of s: "a", "acd", "ace".
 * <p>
 * Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
 * Output: 2
 */
public class _792_NumberOfMatchingSubsequences {

    /**
     * 判断words中有多少个是s的子串，先对s做字典
     */
    public int numMatchingSubseq(String s, String[] words) {
        Map<Character, List<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            indexMap.computeIfAbsent(s.charAt(i), k -> new ArrayList<>()).add(i);
        }

        Map<String, Integer> map = new HashMap<>();
        for (String str : words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        int res = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int i = 0, j = 0;
            for (; i < entry.getKey().length(); i++) {
                char c = entry.getKey().charAt(i);
                List<Integer> integers = indexMap.get(c);
                if (integers == null) {
                    break;
                }
                int pos = leftBound(integers, j);
                if (pos == -1) {
                    break;
                }
                // 向前移动指针 j
                j = integers.get(pos) + 1;
            }
            if (i == entry.getKey().length()) {
                res+=entry.getValue();
            }
        }
        return res;
    }

    private int leftBound(List<Integer> list, int target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target > list.get(mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left == list.size()) {
            return -1;
        }
        return left;
    }

    public int numMatchingSubseq_S(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        int ans = 0;
        char ch[] = s.toCharArray();
        for (String str : map.keySet()) {
            char temp[] = str.toCharArray();
            int i = 0;
            int j = 0;
            while (i < ch.length && j < temp.length) {
                if (ch[i] == temp[j]) {
                    i++;
                    j++;
                } else {
                    i++;
                }
            }
            if (j == temp.length) {
                ans += map.get(str);
            }
        }
        return ans;
    }
}
