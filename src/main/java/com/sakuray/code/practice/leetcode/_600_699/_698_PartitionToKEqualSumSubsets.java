package com.sakuray.code.practice.leetcode._600_699;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums and an integer k, return true if it is possible to divide this array into k non-empty subsets whose sums are all equal.
 * Input: nums = [4,3,2,3,5,2,1], k = 4
 * Output: true
 * Explanation: It is possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
 * <p>
 * Input: nums = [1,2,3,4], k = 3
 * Output: false
 */
public class _698_PartitionToKEqualSumSubsets {

    /**
     * 分成多个相等集合，回溯穷举，可以一个个桶凑齐
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums.length < k) {
            return false;
        }
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        int used = 0;
        return backtracking(k, nums, used, 0, 0, target, new HashMap<>());
    }

    private boolean backtracking(int k, int[] nums, int used, int start, int cur, int target, Map<Integer, Boolean> mem) {
        if (k == 0) {
            return true;
        }
        if (mem.containsKey(used)) {
            return mem.get(used);
        }
        if (cur == target) {
            boolean backtracking = backtracking(k - 1, nums, used, 0, 0, target, mem);
            mem.put(used, backtracking);
            return backtracking;
        }
        for (int i = start; i < nums.length; i++) {
            if (((used >> i) & 1) == 1) {
                continue;
            }
            if (nums[i] + cur > target) {
                continue;
            }
            used |= (1 << i);
            cur = cur + nums[i];
            if (backtracking(k, nums, used, start + 1, cur, target, mem)) {
                return true;
            }
            used ^= (1 << i);
            cur = cur - nums[i];
        }
        return false;
    }
}
