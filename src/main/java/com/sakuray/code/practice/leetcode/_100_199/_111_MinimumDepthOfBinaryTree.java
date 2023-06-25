package com.sakuray.code.practice.leetcode._100_199;

import java.util.ArrayDeque;
import java.util.Queue;

import static com.sakuray.code.practice.leetcode.Tools.*;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * Note: A leaf is a node with no children.
 * <p>
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 2
 * <p>
 * Input: root = [2,null,3,null,4,null,5,null,6]
 * Output: 5
 */
public class _111_MinimumDepthOfBinaryTree {

    /**
     * 判断层级，广度优先搜索
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = 1;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return result;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result++;
        }
        return result;
    }
}
