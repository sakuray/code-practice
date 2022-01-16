package com.sakuray.code.practice.leetcode._0_99;

import com.sakuray.code.practice.leetcode.PrintTools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a collection of numbers, nums, that might contain duplicates,
 * return all possible unique permutations in any order.
 *
 * Example 1:
 *
 * Input: nums = [1,1,2]
 * Output:
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * Example 2:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 *
 * [2,2,1,1]
 * [[1,1,2,2],[1,2,1,2],[1,2,2,1],[2,1,1,2],[2,1,2,1],[2,2,1,1]]
 *
 * Constraints:
 *
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 */
public class _047_PermutationsII {

    public static void main(String[] args) {
        PrintTools.print2List(permuteUnique(new int[]{1, 1, 2}));
        PrintTools.print2List(permuteUnique(new int[]{1, 2, 3}));
        PrintTools.print2List(permuteUnique(new int[]{2, 2, 1, 1}));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i : nums) {
            Integer integer = hashMap.get(i);
            hashMap.put(i, integer == null ? 1 : integer + 1);
        }
        List<List<Integer>> result = new ArrayList<>();
        permuteUnique(nums, result, new ArrayList<>(), hashMap);
        return result;
    }

    private static void permuteUnique(int[] nums, List<List<Integer>> result,
                                      List<Integer> cur, Map<Integer, Integer> hashMap) {
        if (cur.size() == nums.length) {
            result.add(new ArrayList<>(cur));
        } else {
            Set<Integer> integers = hashMap.keySet();
            for (Integer i : integers) {
                int size = hashMap.get(i);
                if (size > 0) {
                    cur.add(i);
                    hashMap.put(i, size - 1);
                    permuteUnique(nums, result, cur, hashMap);
                    cur.remove((Object)i);
                    hashMap.put(i, size);
                }
            }
        }
    }
}
