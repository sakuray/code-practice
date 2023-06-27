package com.sakuray.code.practice.leetcode._300_399;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 * Define a pair (u, v) which consists of one element from the first array and one element from the second array.
 * Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.
 * <p>
 * Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * Output: [[1,2],[1,4],[1,6]]
 * Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * <p>
 * Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * Output: [[1,1],[1,1]]
 * Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * <p>
 * Input: nums1 = [1,2], nums2 = [3], k = 3
 * Output: [[1,3],[2,3]]
 * Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
 */
public class _373_FindKPairsWithSmallestSums {


    /**
     * 不能使用双指针，匹配项是n * m，指针移动不能回退，导致缺少解
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(k, (o1, o2) -> {
            return nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]];
        });
        List<List<Integer>> result = new ArrayList<>();
        int n = nums1.length, m = nums2.length;
        // 初始队列中已经存在了数组2的0位，对应数组1的所有位置。后续只需要升级数组2的位置，保持数组1不变即可
        // 等于a0 + b0 a1+b0 ... an + b0已经将所有的解分段了。
        // 可能存在 a0 + b1, a0 + b2小于 a1 + b0。我们当前取出来的pair[i][j]能确定下一个数值一定在 a[i] + b[0]之后
        for (int i = 0; i < Math.min(n, k); i++) {
            queue.offer(new int[]{i, 0});
        }
        while (k-- > 0 && !queue.isEmpty()) {
            int[] poll = queue.poll();
            List<Integer> pair = new ArrayList<>();
            pair.add(nums1[poll[0]]);
            pair.add(nums2[poll[1]]);
            result.add(pair);
            if (poll[1] + 1 < m) {
                queue.offer(new int[]{poll[0], poll[1] + 1});
            }
        }
        return result;
    }
}
