package com.sakuray.code.practice.offer;

import java.util.*;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class _22_从上往下打印二叉树 {


    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if(root != null) {
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode tmp = queue.poll();
                if(tmp.left != null) queue.add(tmp.left);
                if(tmp.right != null) queue.add(tmp.right);
                result.add(tmp.val);
            }
        }
        return result;
    }

    public ArrayList<Integer> PrintFromTopToBottom_S(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(root == null) return list;
        Deque<TreeNode> deque = new LinkedList<TreeNode>();

        deque.add(root);
        while(!deque.isEmpty()){
            TreeNode t = deque.pop();
            list.add(t.val);
            if(t.left != null) deque.add(t.left);
            if(t.right != null) deque.add(t.right);
        }
        return list;
    }
}
