package com.sakuray.code.practice.leetcode._500_599;

import static com.sakuray.code.practice.leetcode.Tools.*;

/**
 * Given the root of a binary tree, return the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 * The length of a path between two nodes is represented by the number of edges between them.
 * <p>
 * Input: root = [1,2,3,4,5]
 * Output: 3
 * Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
 * <p>
 * Input: root = [1,2]
 * Output: 1
 */
public class _543_DiameterOfBinaryTree {

    /**
     * 找二叉树两节点的最长路径，路径即从A到B要走的步数
     * 找到树的左右侧最大高度，再计算所有子树的最大值
     */
    public int diameterOfBinaryTree(TreeNode root) {
        int[] result = new int[1];
        height(root, result);
        return result[0];
    }

    private int height(TreeNode root, int[] diameter) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left, diameter);
        int right = height(root.right, diameter);
        diameter[0] = Math.max(diameter[0], (left + right));
        return Math.max(left, right) + 1;
    }
}
