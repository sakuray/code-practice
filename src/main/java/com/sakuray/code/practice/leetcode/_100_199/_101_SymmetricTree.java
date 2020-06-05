package com.sakuray.code.practice.leetcode._100_199;


import com.sakuray.code.practice.leetcode.Tools;
import com.sakuray.code.practice.offer._18_二叉树的镜像;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *
 * But the following [1,2,2,null,3,null,3] is not:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 *
 * Follow up: Solve it both recursively and iteratively.
 */
import static com.sakuray.code.practice.leetcode.Tools.*;

public class _101_SymmetricTree {


    public static void main(String[] args) {
        System.out.println(isSymmetric(Tools.buildTreeByArray(new Integer[] {1,2,2,3,4,4,3})));
        System.out.println(isSymmetric(Tools.buildTreeByArray(new Integer[] {1,2,2,null,3,null,3})));
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSame(root.left, root.right);
    }

    public static boolean isSame(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;
        return isSame(left.left, right.right) && isSame(left.right, right.left);
    }
}
