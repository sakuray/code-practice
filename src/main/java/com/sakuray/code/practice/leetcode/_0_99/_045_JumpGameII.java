package com.sakuray.code.practice.leetcode._0_99;

/**
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
 *
 * Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
 *
 * 0 <= j <= nums[i] and
 * i + j < n
 * Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
 *
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 */
public class _045_JumpGameII {

    /**
     * 贪心算法：局部最优解，问题的关键在于此处运用贪心算法为什么会是全局最优解
     * 例子：2,3,1,1,4
     * 从2开始跳：可以跳到3或者1，怎么选择？3比1大，局部最优节点应该选择3.但是局部最优不是全局最优。我们可以知道3能跳到4，1只能跳到1。
     * 关键点在于：我们只需要不断推进最远位置即可。
     * 2的最远位置是跳到1，这意味着2，3，1都只需要一步。遍历2，3，1的时候大家在同一起跑线上。都是step+1
     * 而遍历3的时候，我们知道其最大调到4，遍历到1的时候，其跳到1，这个时候到达1就是到达了2能跳到的最远位置，step+1。
     * 而3推进的最远位置更远，在到达4之前，我们知道至少有一种办法跳2次可以到达这个位置。遍历中间这段距离的时候大家又在同一起跑线了。
     * 抽象理解：
     *  从i开始跳，其值是nums[i]，这意味着从i + 1,...i+nums[i]都只需要跳一次能到达，步数是1
     *  我们不知道接下来跳到哪个，但是可以知道i+1,...是等价的。推进i+1..的最远范围即可。就是步数为2的时候最远能到哪
     *  同样循环下去，到达第二个最远点，我们至少知道只需要2步到达这个位置(最少步数)，而第二个最远点k能到达的范围k+1,k+nums[k]是第三步的范围
     *  到第三步的时候不知道跳转路径，但是知道只要3步能到这个点，而且一定是最远的点
     */
    public int jump(int[] nums) {
        int maxP = 0, end = 0, step = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxP = Math.max(i + nums[i], maxP);
            if (i == end) {
                end = maxP;
                step++;
            }
        }
        return step;
    }
}
