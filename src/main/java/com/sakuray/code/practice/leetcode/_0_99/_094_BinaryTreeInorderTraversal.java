package com.sakuray.code.practice.leetcode._0_99;

import com.sakuray.code.practice.leetcode.PrintTools;

import static com.sakuray.code.practice.leetcode.Tools.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 *
 * Input: root = []
 * Output: []
 *
 * Input: root = [1]
 * Output: [1]
 */
public class _094_BinaryTreeInorderTraversal {

    public static void main(String[] args) {
        PrintTools.printList2(inorderTraversal(null));
        PrintTools.printList2(inorderTraversal(new TreeNode(1)));
        TreeNode one = new TreeNode(1);
        one.right = new TreeNode(2);
        one.right.left = new TreeNode(3);
        PrintTools.printList2(inorderTraversal(one));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private static void inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }
}
