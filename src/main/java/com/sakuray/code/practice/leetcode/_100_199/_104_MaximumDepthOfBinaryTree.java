package com.sakuray.code.practice.leetcode._100_199;


/**
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its depth = 3.
 */
import static com.sakuray.code.practice.leetcode.Tools.*;

public class _104_MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        System.out.println(maxDepth(buildTreeByArray(new Integer[]{3,9,20,null,null,15,7})));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
