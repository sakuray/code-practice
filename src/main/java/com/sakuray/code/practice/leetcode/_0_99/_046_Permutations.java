package com.sakuray.code.practice.leetcode._0_99;

import com.sakuray.code.practice.leetcode.PrintTools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of distinct integers,
 * return all the possible permutations. You can return the answer in any order.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 *
 * Input: nums = [1]
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 */
public class _046_Permutations {

    public static void main(String[] args) {
        PrintTools.print2List(permute_S(new int[]{1,2,3}));
        PrintTools.print2List(permute_S(new int[]{0,1}));
        PrintTools.print2List(permute_S(new int[]{1}));
    }

    public static List<List<Integer>> permute_S(int[] nums) {
        List<List<Integer>> perms = new ArrayList<>();

        if ( nums.length == 1 ) {
            List<Integer> newList = new ArrayList<>();
            newList.add(nums[0]);
            perms.add(newList);
            return perms;
        }

        int first = nums[0];
        int[] remaining = Arrays.copyOfRange( nums,1, nums.length);
        List<List<Integer>> subPerms = permute(remaining);
        for ( List<Integer> l : subPerms ) {
            for ( int i=0; i <= l.size(); i++ ) {
                List<Integer> newList = new ArrayList<>(l.size() +1);
                newList.addAll(l);
                newList.add(i, first);
                perms.add(newList);
            }
        }
        return perms;
    }

    public static List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, new ArrayList<>(), result);
        return result;
    }

    private static void permute(int[] nums, List<Integer> cur, List<List<Integer>> result) {
        if (cur.size() == nums.length) {
            result.add(new ArrayList<>(cur));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!cur.contains(nums[i])) {
                    cur.add(nums[i]);
                    permute(nums, cur, result);
                    cur.remove((Object)nums[i]);
                }
            }
        }
    }
}
