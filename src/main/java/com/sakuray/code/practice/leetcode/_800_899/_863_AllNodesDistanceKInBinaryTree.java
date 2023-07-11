package com.sakuray.code.practice.leetcode._800_899;

import static com.sakuray.code.practice.leetcode.Tools.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Given the root of a binary tree, the value of a target node target, and an integer k,
 * return an array of the values of all nodes that have a distance k from the target node.
 * You can return the answer in any order.
 * <p>
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
 * Output: [7,4,1]
 * Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
 * <p>
 * Input: root = [1], target = 1, k = 3
 * Output: []
 */
public class _863_AllNodesDistanceKInBinaryTree {

    public static void main(String[] args) {
        System.out.println(distanceK(buildTreeByArray(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4}), new TreeNode(5), 2));
        System.out.println(distanceK(buildTreeByArray(new Integer[]{0, 1, null, null, 2, null, 3, null, 4}), new TreeNode(3), 0));
    }

    /**
     * 广度优先搜索，target节点k步能到达的节点，看成是个图
     */
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (k == 0) {
            List<Integer> result = new ArrayList<>();
            result.add(target.val);
            return result;
        }
        Map<Integer, TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.val == target.val) {
                target = poll;
                break;
            }
            if (poll.left != null) {
                parentMap.put(poll.left.val, poll);
                queue.add(poll.left);
            }
            if (poll.right != null) {
                parentMap.put(poll.right.val, poll);
                queue.add(poll.right);
            }
        }
        List<Integer> result = new ArrayList<>();
        queue.clear();
        queue.add(target);
        Set<Integer> exist = new HashSet<>();
        while (!queue.isEmpty() && k > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                exist.add(poll.val);
                addResult(result, queue, k, poll.left, exist);
                addResult(result, queue, k, poll.right, exist);
                addResult(result, queue, k, parentMap.get(poll.val), exist);
            }
            k--;
        }
        return result;
    }

    private static void addResult(List<Integer> result, Queue<TreeNode> queue, int k, TreeNode node, Set<Integer> exits) {
        if (node != null && !exits.contains(node.val)) {
            exits.add(node.val);
            if (k == 1) {
                result.add(node.val);
            } else {
                queue.add(node);
            }
        }
    }
}
