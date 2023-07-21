package com.sakuray.code.practice.leetcode._100_199;

import static com.sakuray.code.practice.leetcode.Tools.*;

/**
 * Given the root of a binary tree, flatten the tree into a "linked list":
 * The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
 * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 * <p>
 * Input: root = [1,2,5,3,4,null,6]
 * Output: [1,null,2,null,3,null,4,null,5,null,6]
 * <p>
 * Input: root = []
 * Output: []
 * <p>
 * Input: root = [0]
 * Output: [0]
 */
public class _114_FlattenBinaryTreeToLinkedList {

    public static void main(String[] args) {
        flatten(buildTreeByArray(new Integer[]{1,2,5,3,4,null,6}));
    }

    /**
     * 二叉树按照先序遍历顺序，变成链表，left为null,right是下一个节点
     * 注意左右子树拼接，需要知道左右子树的头尾节点
     */
    public static void flatten(TreeNode root) {
        reverse(root);
    }


    private static TreeNode reverse(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode leftEnd = reverse(root.left);
        TreeNode rightEnd = reverse(root.right);
        TreeNode tmp = null;
        if (leftEnd != null) {
            tmp = root.left;
        }
        if (rightEnd != null) {
            if (tmp == null) {
                tmp = root.right;
            } else {
                leftEnd.right = root.right;
            }
        }
        root.left = null;
        root.right = tmp;
        return rightEnd == null ? leftEnd : rightEnd;
    }
}
