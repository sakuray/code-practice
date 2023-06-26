package com.sakuray.code.practice.leetcode._300_399;

import java.util.Arrays;
import java.util.Random;

/**
 * Given an integer array nums, design an algorithm to randomly shuffle the array.
 * All permutations of the array should be equally likely as a result of the shuffling.
 * Implement the Solution class:
 * Solution(int[] nums) Initializes the object with the integer array nums.
 * int[] reset() Resets the array to its original configuration and returns it.
 * int[] shuffle() Returns a random shuffling of the array.
 * <p>
 * Input
 * ["Solution", "shuffle", "reset", "shuffle"]
 * [[[1, 2, 3]], [], [], []]
 * Output
 * [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
 * <p>
 * Explanation
 * Solution solution = new Solution([1, 2, 3]);
 * solution.shuffle();    // Shuffle the array [1,2,3] and return its result.
 * // Any permutation of [1,2,3] must be equally likely to be returned.
 * // Example: return [3, 1, 2]
 * solution.reset();      // Resets the array back to its original configuration [1,2,3]. Return [1, 2, 3]
 * solution.shuffle();    // Returns the random shuffling of array [1,2,3]. Example: return [1, 3, 2]
 */
public class _384_ShuffleAnArray {


    private int[] origin;
    private Random random = new Random();

    public void solve(int[] nums) {
        this.origin = nums;
    }

    public int[] reset() {
        return this.origin;
    }

    public int[] shuffle() {
        int length = this.origin.length;
        int[] ints = Arrays.copyOf(this.origin, length);
        for (int i = 0; i < length; i++) {
            int k = i + random.nextInt(length - i);
            int tmp = ints[i];
            ints[i] = ints[k];
            ints[k] = tmp;
        }
        return ints;
    }
}
