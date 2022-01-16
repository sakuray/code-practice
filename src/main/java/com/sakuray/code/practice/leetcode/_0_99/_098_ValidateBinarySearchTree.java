package com.sakuray.code.practice.leetcode._0_99;

import static com.sakuray.code.practice.leetcode.Tools.*;

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * Input: root = [2,1,3]
 * Output: true
 *
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * -231 <= Node.val <= 231 - 1
 */
public class _098_ValidateBinarySearchTree {

    public static void main(String[] args) {
        System.out.println(true == isValidBST(buildTreeByArray(new Integer[] {2, 1, 3})));
        System.out.println(false == isValidBST(buildTreeByArray(new Integer[] {5,1,4,null,null,3,6})));
        System.out.println(true == isValidBST(buildTreeByArray(new Integer[] {Integer.MAX_VALUE})));
        System.out.println(false == isValidBST(buildTreeByArray(new Integer[] {2, 2, 2})));
        System.out.println(false == isValidBST(buildTreeByArray(new Integer[] {5,4,6,null,null,3,7})));
    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValid(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }
}
