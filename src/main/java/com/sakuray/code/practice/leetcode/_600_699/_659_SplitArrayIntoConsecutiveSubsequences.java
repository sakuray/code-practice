package com.sakuray.code.practice.leetcode._600_699;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given an integer array nums that is sorted in non-decreasing order.
 * Determine if it is possible to split nums into one or more subsequences such that both of the following conditions are true:
 * Each subsequence is a consecutive increasing sequence (i.e. each integer is exactly one more than the previous integer).
 * All subsequences have a length of 3 or more.
 * Return true if you can split nums according to the above conditions, or false otherwise.
 * A subsequence of an array is a new array that is formed from the original array by deleting some (can be none) of the elements
 * without disturbing the relative positions of the remaining elements. (i.e., [1,3,5] is a subsequence of [1,2,3,4,5] while [1,3,2] is not).
 * <p>
 * Input: nums = [1,2,3,3,4,5]
 * Output: true
 * Explanation: nums can be split into the following subsequences:
 * [1,2,3,3,4,5] --> 1, 2, 3
 * [1,2,3,3,4,5] --> 3, 4, 5
 * <p>
 * Input: nums = [1,2,3,3,4,4,5,5]
 * Output: true
 * Explanation: nums can be split into the following subsequences:
 * [1,2,3,3,4,4,5,5] --> 1, 2, 3, 4, 5
 * [1,2,3,3,4,4,5,5] --> 3, 4, 5
 * <p>
 * Input: nums = [1,2,3,4,4,5]
 * Output: false
 * Explanation: It is impossible to split nums into consecutive increasing subsequences of length 3 or more.
 */
public class _659_SplitArrayIntoConsecutiveSubsequences {


    /**
     * 判断是否能拆分成多个连续的子串，每个子串长度>=3
     * 思考如果出现重叠是包含在之前子串中，还是新起一个子串：1,2,3,3,4,4,5,5 和 1,2,3,4,4,5
     * 答案是：如果下一个数字是连续的，就应该包含到当前子串中
     * 因为如果不包含，新起一个子串有2种可能：
     * 1.其可以拆分满足条件的若干子串：str1,str2,str3。str1肯定是可以和str连接在一起的，不会影响后续的拆分
     * 2.其不能拆分，比如：只剩下2个元素，但是其是可以和之前连续接在一起的，那么也应该尽可能和前面相连
     */
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> need = new HashMap<>();
        for (int n : nums) {
            freq.merge(n, 1, Integer::sum);
        }
        for (int n : nums) {
            if (freq.get(n) == 0) {
                continue;
            }
            if (need.getOrDefault(n, 0) > 0) {
                // 某个序列需要，补充在尾巴部分
                freq.put(n, freq.get(n) - 1);
                need.put(n, need.get(n) - 1);
                need.merge(n + 1, 1, Integer::sum);
            } else {
                // 无序列需要，新起一个序列，至少要包含三个
                int c1 = freq.getOrDefault(n, 0) - 1;
                int c2 = freq.getOrDefault(n + 1, 0) - 1;
                int c3 = freq.getOrDefault(n + 2, 0) - 1;
                if (c1 >= 0 && c2 >= 0 && c3 >= 0) {
                    freq.put(n, c1);
                    freq.put(n + 1, c2);
                    freq.put(n + 2, c3);
                    need.merge(n + 3, 1, Integer::sum);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
