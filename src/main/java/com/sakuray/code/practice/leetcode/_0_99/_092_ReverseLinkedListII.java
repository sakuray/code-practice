package com.sakuray.code.practice.leetcode._0_99;

import com.sakuray.code.practice.leetcode.Tools.ListNode;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
	For example:
		Given 1->2->3->4->5->NULL, m = 2 and n = 4,
		return 1->4->3->2->5->NULL.
	Note:
		Given m, n satisfy the following condition:
		1 ≤ m ≤ n ≤ length of list.
 *
 */
public class _092_ReverseLinkedListII {

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
		System.out.println(reverseBetween(l1, 5, 5));
	}
	
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode start = new ListNode(0);
		start.next = head;
		ListNode b = start, s = null, e = null, p, q;
		int count = 0;
		while(start != null) {
			if(count == m - 1) {
				s = start;
			    e = start.next;
			} else if(count > m && count <= n) {
				p = s.next;
				q = e.next;
				s.next = e.next;
				e.next = q.next;
				q.next = p;
			}
			start = start.next;
			count++;
		}
        return b.next;
    }
	
	public ListNode reverseBetween_S(ListNode head, int m, int n) {  
        if(head == null)  
            return null;  
        ListNode dummy = new ListNode(0);  
        dummy.next = head;  
        ListNode preNode = dummy;  
        int i=1;  
        while(preNode.next!=null && i<m)  
        {  
            preNode = preNode.next;  
            i++;  
        }  
        if(i<m)  
            return head;  
        ListNode mNode = preNode.next;  
        ListNode cur = mNode.next;  
        while(cur!=null && i<n)  
        {  
            ListNode next = cur.next;  
            cur.next = preNode.next;  
            preNode.next = cur;  
            mNode.next = next;  
            cur = next;  
            i++;  
        }  
        return dummy.next;  
    }
}
