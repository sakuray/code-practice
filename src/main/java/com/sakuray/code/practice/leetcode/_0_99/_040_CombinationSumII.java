package com.sakuray.code.practice.leetcode._0_99;

import com.sakuray.code.practice.leetcode.PrintTools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sum to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note: The solution set must not contain duplicate combinations.
 *
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5
 * Output:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 *
 * Constraints:
 *
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 */
public class _040_CombinationSumII {

    public static void main(String[] args) {
        PrintTools.print2List(combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
        PrintTools.print2List(combinationSum2(new int[]{2,5,2,1,2}, 5));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void combinationSum2(int[] candidates, int target, int start,
                                        List<Integer> cur, List<List<Integer>> result) {
        if (target < 0) return;
        if (target == 0) {
            result.add(new ArrayList<>(cur));
        } else {
            for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
                if(i > start && candidates[i] == candidates[i-1])
                    continue;
                cur.add(candidates[i]);
                combinationSum2(candidates, target - candidates[i], i + 1, cur, result);
                cur.remove((Object)candidates[i]);
            }
        }
    }
}
