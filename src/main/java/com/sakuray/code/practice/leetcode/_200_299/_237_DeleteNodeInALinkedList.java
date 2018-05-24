package com.sakuray.code.practice.leetcode._200_299;

import com.sakuray.code.practice.leetcode.Tools;
import com.sakuray.code.practice.leetcode.Tools.ListNode;

/**
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, 
 * the linked list should become 1 -> 2 -> 4 after calling your function.
 */
public class _237_DeleteNodeInALinkedList {

	public static void main(String[] args) {
		ListNode list = Tools.buildList(1,2,3,4);
		deleteNode(list.next.next);
		System.out.println(list);
	}
	
	public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
