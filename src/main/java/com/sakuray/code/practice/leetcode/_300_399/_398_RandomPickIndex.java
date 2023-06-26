package com.sakuray.code.practice.leetcode._300_399;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Given an integer array nums with possible duplicates, randomly output the index of a given target number.
 * You can assume that the given target number must exist in the array.
 * Implement the Solution class:
 * Solution(int[] nums) Initializes the object with the array nums.
 * int pick(int target) Picks a random index i from nums where nums[i] == target. If there are multiple valid i's,
 * then each index should have an equal probability of returning.
 * <p>
 * Input
 * ["Solution", "pick", "pick", "pick"]
 * [[[1, 2, 3, 3, 3]], [3], [1], [3]]
 * Output
 * [null, 4, 0, 2]
 * <p>
 * Explanation
 * Solution solution = new Solution([1, 2, 3, 3, 3]);
 * solution.pick(3); // It should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
 * solution.pick(1); // It should return 0. Since in the array only nums[0] is equal to 1.
 * solution.pick(3); // It should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
 */
public class _398_RandomPickIndex {

    private Map<Integer, List<Integer>> map = new HashMap<>();
    private Random random = new Random();

    public void solve(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int target = nums[i];
            map.computeIfAbsent(target, k -> new ArrayList<>()).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> integers = map.get(target);
        int i = random.nextInt(integers.size());
        return integers.get(i);
    }
}
