package com.sakuray.code.practice.leetcode._0_99;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * <p>
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * <p>
 * Input: nums = [0]
 * Output: [[],[0]]
 */
public class _078_Subsets {

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2,3}));
        System.out.println(subsets(new int[]{0}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(nums, 0, result, new LinkedList<>());
        return result;
    }

    private static void backtracking(int[] nums, int start, List<List<Integer>> result, LinkedList<Integer> cur) {
        result.add(new ArrayList<>(cur));
        for (int i = start; i < nums.length; i++) {
            cur.addLast(nums[i]);
            backtracking(nums, i + 1, result, cur);
            cur.removeLast();
        }
    }
}
