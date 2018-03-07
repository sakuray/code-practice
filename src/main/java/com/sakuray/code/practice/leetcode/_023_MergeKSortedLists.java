package com.sakuray.code.practice.leetcode;


/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
public class _023_MergeKSortedLists {
	
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {val = x;}
		@Override
		public String toString() {
			return next == null ? String.valueOf(val) : val + "->" + next.toString();
		}
	}
	
	public static void main(String[] args) {
		ListNode one1 = new ListNode(2);
		ListNode one2 = new ListNode(7);
		one1.next = one2;
		ListNode two1 = new ListNode(1);
		ListNode two2 = new ListNode(3);
		ListNode two3 = new ListNode(5);
		two1.next = two2;
		two2.next = two3;
		ListNode three1 = new ListNode(4);
		ListNode three2 = new ListNode(9);
		three1.next = three2;
		ListNode[] test = new ListNode[3];
		test[0] = one1;
		test[1] = two1;
		test[2] = three1;
		System.out.println(mergeKLists(test));
	}

	public static ListNode mergeKLists(ListNode[] lists) {
		if(lists == null || lists.length == 0) return null;
        return merge(lists, 0, lists.length);
    }
	
	public static ListNode merge(ListNode[] lists, int begin, int end) {
		if(begin < end - 1) {
			int size = (end - begin) / 2;
			ListNode left = merge(lists, begin, begin + size);
			ListNode right = merge(lists, begin + size, end);
			if(left == null) return right;
			if(right == null) return left;
			ListNode start = new ListNode(0);
			ListNode p = start;
			while(left != null && right != null) {
				if(left.val > right.val) {
					p.next = right;
					right = right.next;
				} else {
					p.next = left;
					left = left.next;
				}
				p = p.next;
			}
			if(left != null) p.next = left;
			if(right != null) p.next = right;
			return start.next;
		} else {
			return lists[begin];
		}
	}
	
	public static ListNode mergeKLists_S(ListNode[] lists){
	    return partion(lists,0,lists.length-1);
	}

	public static ListNode partion(ListNode[] lists,int s,int e){
	    if(s==e)  return lists[s];
	    if(s<e){
	        int q=(s+e)/2;
	        ListNode l1=partion(lists,s,q);
	        ListNode l2=partion(lists,q+1,e);
	        return merge(l1,l2);
	    }else
	        return null;
	}

	//This function is from Merge Two Sorted Lists.
	public static ListNode merge(ListNode l1,ListNode l2){
	    if(l1==null) return l2;
	    if(l2==null) return l1;
	    if(l1.val<l2.val){
	        l1.next=merge(l1.next,l2);
	        return l1;
	    }else{
	        l2.next=merge(l1,l2.next);
	        return l2;
	    }
	}
}
