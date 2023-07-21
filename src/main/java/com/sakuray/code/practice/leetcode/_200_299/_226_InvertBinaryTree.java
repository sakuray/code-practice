package com.sakuray.code.practice.leetcode._200_299;

import static com.sakuray.code.practice.leetcode.Tools.*;

/**
 * Given the root of a binary tree, invert the tree, and return its root.
 * <p>
 * Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 * <p>
 * Input: root = [2,1,3]
 * Output: [2,3,1]
 * <p>
 * Input: root = []
 * Output: []
 */
public class _226_InvertBinaryTree {

    /**
     * 翻转二叉树
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
