package com.sakuray.code.practice.leetcode;


/**
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 * Example:
	Input: 1->2->4, 1->3->4
	Output: 1->1->2->3->4->4
 */
public class _021_MergeTwoSortedLists {

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
		ListNode l2= new ListNode(2);
		ListNode l3= new ListNode(4);
		l1.next = l2;
		l2.next = l3;
		ListNode r1 = new ListNode(1);
		ListNode r2= new ListNode(3);
		ListNode r3= new ListNode(4);
		r1.next = r2;
		r2.next = r3;
		System.out.println(l1);
		System.out.println(r1);
		System.out.println(mergeTwoLists(l1, r1));
	}
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		ListNode begin = new ListNode(0);
		ListNode p = begin;
		while(l1 != null && l2!= null) {
			if(l1.val > l2.val) {
				p.next = l2;
				l2 = l2.next;
			} else {
				p.next = l1;
				l1 = l1.next;
			}
			p = p.next;
		}
		if(l1 != null) {
			p.next = l1;
		} else {
			p.next = l2;
		}
		return begin.next;
    }
	
	public ListNode mergeTwoLists_S(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        
        ListNode mergeHead;
        if(l1.val < l2.val){
            mergeHead = l1;
            mergeHead.next = mergeTwoLists(l1.next, l2);
        }
        else{
            mergeHead = l2;
            mergeHead.next = mergeTwoLists(l1, l2.next);
        }
        return mergeHead;
    }
}
