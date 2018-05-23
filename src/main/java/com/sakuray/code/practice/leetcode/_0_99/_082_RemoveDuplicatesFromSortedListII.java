package com.sakuray.code.practice.leetcode._0_99;

import com.sakuray.code.practice.leetcode.Tools;
import com.sakuray.code.practice.leetcode.Tools.ListNode;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * Example 1:
	Input: 1->2->3->3->4->4->5
	Output: 1->2->5
   Example 2:
	Input: 1->1->1->2->3
	Output: 2->3
 */
public class _082_RemoveDuplicatesFromSortedListII {
	
	public static void main(String[] args) {
		System.out.println(deleteDuplicates(Tools.buildList(1,2,3,3,4,4,5)));
		System.out.println(deleteDuplicates(Tools.buildList(1,1,1,2,3)));
		System.out.println(deleteDuplicates(Tools.buildList(1,1,1,1,1)));
	}
	
	public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode begin = new ListNode(-1);
        begin.next = head;
        ListNode safe = begin, pre = null;
        Integer cur = null;
        while(head != null) {
        	if(cur == null) {
        		cur = head.val;
        		pre = head;
        		head = head.next;
        	} else {
        		if(cur == head.val) {
        			safe.next = head.next;
        			pre = safe;
        			head = head.next;
        		} else {
        			cur = head.val;
        			safe = pre;
        			pre = head;
        			head = head.next;
        		}
        	}
        }
        return begin.next;
    }
	
	public ListNode deleteDuplicates_S(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while(head!=null && head.next!=null){
            int count = 0;
            while(head.next!=null && head.next.val == head.val){
                head = head.next;
                count++;
            }
            if(count == 0){
                pre = head;
                head = head.next;
            }else{
                pre.next = head.next;
                head = head.next;
            }
        }
        return dummy.next;
    }

}
