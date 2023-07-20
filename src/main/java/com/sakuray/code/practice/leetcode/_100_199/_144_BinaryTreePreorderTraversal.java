package com.sakuray.code.practice.leetcode._100_199;

import static com.sakuray.code.practice.leetcode.Tools.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 *
 * Input: root = [1,null,2,3]
 * Output: [1,2,3]
 *
 * Input: root = []
 * Output: []
 *
 * Input: root = [1]
 * Output: [1]
 */
public class _144_BinaryTreePreorderTraversal {

    /**
     * 前序遍历，中，左，右
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        preorderTraversal(root, result);
        return result;
    }

    private void preorderTraversal(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }
}
