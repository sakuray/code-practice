package com.sakuray.code.practice.leetcode;

import com.sakuray.code.practice.leetcode.Tools.ListNode;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Example
	Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	Output: 7 -> 0 -> 8
	Explanation: 342 + 465 = 807.
 */
public class _002_AddTwoNumbers {
	
	public static void main(String[] args) {
		ListNode node = new ListNode(2);
		ListNode node2 = new ListNode(4);
		ListNode node3 = new ListNode(3);
		node.next = node2;
		node2.next = node3;
		
		ListNode b = new ListNode(5);
		ListNode b2 = new ListNode(6);
		ListNode b3 = new ListNode(6);
		ListNode b4 = new ListNode(9);
		ListNode b5 = new ListNode(9);
		b.next = b2;
		b2.next = b3;
		b3.next = b4;
		b4.next = b5;
		
		ListNode result = addTwoNumbers(node, b);
		System.out.println(result);
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		boolean carry = false;
		ListNode first = null;
		ListNode last = null;
		ListNode now = null;
		int cur = 0;
		while(l1 != null || l2 != null) {
			if(l1 != null && l2 != null) {
				cur = l1.val + l2.val;
			} else if(l1 == null) {
				cur = l2.val;
			} else if(l2 == null) {
				cur = l1.val;
			}
        	if(carry) {
        		cur++;
        		carry = false;
        	}
        	if(cur > 9) {
        		carry = true; 
        		cur = cur % 10;
        	}
        	now = new ListNode(cur);
			if(first == null) {
				first = last = now;
        	} else {
        		last.next = now;
        		last = now;
        	}
			l1 = l1 == null ? null : l1.next;
			l2 = l2 == null ? null : l2.next;
        }
		if(carry) {
			last.next = new ListNode(1);
		}
		return first;
    }
	
	public static ListNode addTwoNumbers_S(ListNode l1, ListNode l2) {
	    ListNode dummyHead = new ListNode(0);
	    ListNode p = l1, q = l2, curr = dummyHead;
	    int carry = 0;
	    while (p != null || q != null) {
	        int x = (p != null) ? p.val : 0;
	        int y = (q != null) ? q.val : 0;
	        int sum = carry + x + y;
	        carry = sum / 10;
	        curr.next = new ListNode(sum % 10);
	        curr = curr.next;
	        if (p != null) p = p.next;
	        if (q != null) q = q.next;
	    }
	    if (carry > 0) {
	        curr.next = new ListNode(carry);
	    }
	    return dummyHead.next;
	}

}