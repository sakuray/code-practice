package com.sakuray.code.practice.leetcode._0_99;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an integer array nums that may contain duplicates, return all possible subsets(the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * <p>
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 * <p>
 * Input: nums = [0]
 * Output: [[],[0]]
 */
public class _090_SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtracking(0, nums, new LinkedList<>(), result);
        return result;
    }

    private void backtracking(int start, int[] nums, LinkedList<Integer> cur, List<List<Integer>> result) {
        result.add(new ArrayList<>(cur));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            cur.addLast(nums[i]);
            backtracking(i + 1, nums, cur, result);
            cur.removeLast();
        }
    }
}
