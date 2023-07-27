package com.sakuray.code.practice.leetcode._100_199;

import java.util.HashMap;
import java.util.Map;

import static com.sakuray.code.practice.leetcode.Tools.*;

/**
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree
 * and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 * <p>
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * <p>
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 */
public class _105_ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static void main(String[] args) {
        System.out.println(buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
        System.out.println(buildTree(new int[]{-1}, new int[]{-1}));
        System.out.println(buildTree(new int[]{1, 2}, new int[]{2, 1}));
        System.out.println(buildTree(new int[]{1, 2}, new int[]{1, 2}));
        System.out.println(buildTree(new int[]{3, 2, 1, 4}, new int[]{1, 2, 3, 4}));
    }

    /**
     * 根据前序遍历：中左右，中序遍历：左中右
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> numIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            numIndexMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, numIndexMap);
    }

    private static TreeNode buildTree(int[] preorder, int preS, int preE, int[] inorder, int inS, int inE,
                                      Map<Integer, Integer> numIndexMap) {
        if (preS > preE) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preS]);
        int mid = numIndexMap.get(root.val);
        int leftSize = mid - inS;
        root.left = buildTree(preorder, preS + 1, preS + leftSize, inorder, inS, mid - 1, numIndexMap);
        root.right = buildTree(preorder, preS + leftSize + 1, preE, inorder, mid + 1, inE, numIndexMap);
        return root;
    }
}
