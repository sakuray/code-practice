package com.sakuray.code.practice.leetcode._0_99;

import com.sakuray.code.practice.leetcode.Tools.ListNode;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
For example,
	Given 1->1->2, return 1->2.
	Given 1->1->2->3->3, return 1->2->3.
 */
public class _083_RemoveDuplicatesFromSortedList {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(2);
		l1.next = l2; l2.next = l3;
		ListNode t1 = new ListNode(1);
		ListNode t2 = new ListNode(1);
		ListNode t3 = new ListNode(2);
		ListNode t4 = new ListNode(3);
		ListNode t5 = new ListNode(3);
		t1.next = t2; t2.next = t3;
		t3.next = t4; t4.next = t5;
		System.out.println(deleteDuplicates(l1));
		System.out.println(deleteDuplicates(t1));
	}
	
	public static ListNode deleteDuplicates(ListNode head) {
		if(head == null) return head;
		ListNode p = head;
		while(p != null) {
			if(p.next != null && p.val == p.next.val) {
				p.next = p.next.next;
			} else {
				p = p.next;
			}
		}
		return head;
    }
	
	public ListNode deleteDuplicates_S(ListNode head) {
        if(head==null || head.next==null)return head;
        head.next=deleteDuplicates(head.next);
        
        if(head.val == head.next.val)return head.next;
        else return head;
    }
}
