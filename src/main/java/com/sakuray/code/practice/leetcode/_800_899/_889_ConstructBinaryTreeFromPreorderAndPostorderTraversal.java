package com.sakuray.code.practice.leetcode._800_899;

import java.util.HashMap;
import java.util.Map;

import static com.sakuray.code.practice.leetcode.Tools.*;

/**
 * Given two integer arrays, preorder and postorder where preorder is the preorder traversal of a binary tree
 * of distinct values and postorder is the postorder traversal of the same tree, reconstruct and return the binary tree.
 * If there exist multiple answers, you can return any of them.
 * <p>
 * Input: preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
 * Output: [1,2,3,4,5,6,7]
 * <p>
 * Input: preorder = [1], postorder = [1]
 * Output: [1]
 */
public class _889_ConstructBinaryTreeFromPreorderAndPostorderTraversal {

    public static void main(String[] args) {
        System.out.println(constructFromPrePost(new int[]{1,2,4,5,3,6,7}, new int[]{4,5,2,6,7,3,1}));
    }

    /**
     * 根据前序遍历，后序遍历，构建二叉树
     * 中左右， 左右中
     */
    public static TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        Map<Integer, Integer> numIndexMap = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            numIndexMap.put(postorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1, numIndexMap);
    }

    private static TreeNode buildTree(int[] preorder, int preS, int preE, int[] postorder, int postS, int postE,
                                      Map<Integer, Integer> indexMap) {
        if (preS > preE) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preS]);
        if (preS == preE) {
            return root;
        }
        int leftRootValue = preorder[preS + 1];
        Integer postIndex = indexMap.get(leftRootValue);
        int leftSize = postIndex - postS + 1;
        root.left = buildTree(preorder, preS + 1, preS + leftSize, postorder, postS, postIndex, indexMap);
        root.right = buildTree(preorder, preS + leftSize + 1, preE, postorder, postIndex + 1, postE - 1,indexMap);
        return root;
    }
}
