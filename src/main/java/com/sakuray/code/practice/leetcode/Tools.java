package com.sakuray.code.practice.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Tools {

	public static class TreeNode {

		public int val;
        public TreeNode left;
        public TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}

		@Override
		public String toString() {
			return "[" + val + (left != null ? ",l="+left : "") + (right != null ? ",r=" + right:"")+"]";
		}
	}
	
	/**
	 * [1,2,3]		[1,null,2,2]
	 *    1				1
	 *   / \			 \
	 *  2   3		      2
	 *  				 /
	 *  				2
	 * 广度优先搜索BFS
	 * @param array
	 * @return
	 */
	public static TreeNode buildTreeByArray(Integer[] array) {
		if(array == null || array.length == 0) return null;
		TreeNode head = new TreeNode(array[0]);
		Queue<TreeNode> queue = new ArrayDeque<>();
		queue.add(head);
		int index = 1;
		while(!queue.isEmpty() && index < array.length) {
			TreeNode parent = queue.poll();
			if(array[index] != null) parent.left = new TreeNode(array[index]);
			index++;
			if(index < array.length && array[index] != null) parent.right = new TreeNode(array[index]);
			index++;
			if(parent.left != null) queue.add(parent.left);
			if(parent.right != null) queue.add(parent.right);
		}
		return head;
	}
	
	/**
	 * 构建链表节点
	 * @param obj
	 * @return
	 */
	public static ListNode buildList(int ...obj) {
		ListNode begin = new ListNode(-1);
		ListNode last = begin, cur;
		for(int i = 0; i < obj.length; i++) {
			cur = new ListNode(obj[i]);
			last.next = cur;
			last = cur;
		}
		return begin.next;
	}

    /**
     * 构建二维数组
     * @param col   列数
     * @param obj   值
     * @return      二维数组
     */
	public static int[][] build2Array(int col, int ...obj) {
	    int size = obj.length;
        if(size % col != 0) {
            throw new IllegalArgumentException("错误的列数或者是值数量");
        }
	    int row = size / col;
	    int[][] result = new int[row][col];
	    int length=0;
	    for(int i = 0; i < row; i++) {
	        for(int j = 0; j < col; j++) {
	            result[i][j] = obj[length];
	            length++;
            }
        }
        return result;
    }
 
	public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) {
			val = x;
			next = null;
		}
		@Override
		public String toString() {
			return val + (next == null ? "" : "->" + next);
		}
	}

	public static class Interval {
        public int start;
        public int end;
        public Interval() { start = 0; end = 0; }
        public Interval(int s, int e) { start = s; end = e; }
		@Override
		public String toString() {
			return "[" + start + "," + end + "]";
		}
	}
}
