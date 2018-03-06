package com.sakuray.code.practice.leetcode;


/**
 * Given a linked list, swap every two adjacent nodes and return its head.
	For example,
	Given 1->2->3->4, you should return the list as 2->1->4->3.
	Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 *
 */
public class _024_SwapNodesInPairs {
	
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
		@Override
		public String toString() {
			return val + (next != null ? "->" + next : "");
		}
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		System.out.println(l1);
//		System.out.println(swapPairs(l1));
//		System.out.println(swapPairs(l2));
//		System.out.println(swapPairs(l3));
		System.out.println(swapPairs(l4));
	}
	
	public static ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode p = new ListNode(0), q = p;
		p.next = head;
		while(head != null && head.next != null) {
			q.next = head.next;
			head.next = head.next.next;
			q.next.next = head;
			q = head;
			head = head.next;
		}
		return p.next;
    }
	
	public ListNode swapPairs_S(ListNode head) {
        if ((head == null)||(head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }
}
