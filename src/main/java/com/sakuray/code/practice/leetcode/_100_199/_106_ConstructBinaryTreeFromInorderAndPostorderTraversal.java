package com.sakuray.code.practice.leetcode._100_199;

import java.util.HashMap;
import java.util.Map;

import static com.sakuray.code.practice.leetcode.Tools.*;

/**
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree
 * and postorder is the postorder traversal of the same tree, construct and return the binary tree.
 * <p>
 * Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * *    3
 * * 9    20
 * *    15  7
 * Output: [3,9,20,null,null,15,7]
 * <p>
 * Input: inorder = [-1], postorder = [-1]
 * Output: [-1]
 */
public class _106_ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public static void main(String[] args) {
        System.out.println(buildTree(new int[] {9,3,15,20,7}, new int[] {9,15,7,20,3}));
        System.out.println(buildTree(new int[] {-1}, new int[] {-1}));
    }

    /**
     * 知道中序遍历和后序遍历，构建树
     * 左中右
     * 左右中
     */
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> numIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            numIndexMap.put(inorder[i], i);
        }
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, numIndexMap);
    }


    private static TreeNode buildTree(int[] inorder, int inS, int inE, int[] postorder, int pS, int pE,
                                      Map<Integer, Integer> indexMap) {
        if (inS > inE) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[pE]);
        int rootIndex = indexMap.get(root.val);
        int leftSize = rootIndex - inS;
        root.left = buildTree(inorder, inS, rootIndex - 1, postorder, pS, pS + leftSize - 1, indexMap);
        root.right = buildTree(inorder, rootIndex + 1, inE, postorder, pS + leftSize, pE - 1, indexMap);
        return root;
    }
}
