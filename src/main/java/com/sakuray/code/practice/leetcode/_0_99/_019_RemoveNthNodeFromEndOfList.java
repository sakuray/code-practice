package com.sakuray.code.practice.leetcode._0_99;

import com.sakuray.code.practice.leetcode.Tools.ListNode;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
	For example,
		Given linked list: 1->2->3->4->5, and n = 2.
		After removing the second node from the end, the linked list becomes 1->2->3->5.
	Note:
	Given n will always be valid.
	Try to do this in one pass.
 *
 */
public class _019_RemoveNthNodeFromEndOfList {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
//		System.out.println(removeNthFromEnd(l1, 1));
//		System.out.println(removeNthFromEnd(l1, 2));
		System.out.println(removeNthFromEnd(l1, 5));
	}
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode p1 = head, begin = new ListNode(0), p2 = begin;
		begin.next = head;
		int i = 0;
		while(p1.next != null) {
			if(i == n - 1) {
				break;
			} else {
				p1 = p1.next;
				i++;
			}
		}
		while(p1.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		p2.next = p2.next.next;
        return begin.next;
    }
	
	public ListNode removeNthFromEnd_S1(ListNode head, int n) {
	    ListNode dummy = new ListNode(0);
	    dummy.next = head;
	    int length  = 0;
	    ListNode first = head;
	    while (first != null) {
	        length++;
	        first = first.next;
	    }
	    length -= n;
	    first = dummy;
	    while (length > 0) {
	        length--;
	        first = first.next;
	    }
	    first.next = first.next.next;
	    return dummy.next;
	}
	
	public ListNode removeNthFromEnd_S2(ListNode head, int n) {
	    ListNode dummy = new ListNode(0);
	    dummy.next = head;
	    ListNode first = dummy;
	    ListNode second = dummy;
	    // Advances first pointer so that the gap between first and second is n nodes apart
	    for (int i = 1; i <= n + 1; i++) {
	        first = first.next;
	    }
	    // Move first to the end, maintaining the gap
	    while (first != null) {
	        first = first.next;
	        second = second.next;
	    }
	    second.next = second.next.next;
	    return dummy.next;
	}
}


