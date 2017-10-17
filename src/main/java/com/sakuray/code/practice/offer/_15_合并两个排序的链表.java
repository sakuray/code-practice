package com.sakuray.code.practice.offer;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class _15_合并两个排序的链表 {

	public static void main(String[] args) {
		ListNode nine = new ListNode(9);
		ListNode seven = new ListNode(7, nine);
		ListNode five = new ListNode(5, seven);
		ListNode three = new ListNode(3, five);
		ListNode one = new ListNode(1, three);
		
		ListNode ten = new ListNode(10);
		ListNode eight = new ListNode(8, ten);
		ListNode six = new ListNode(6, eight);
		ListNode four = new ListNode(4, six);
		ListNode two = new ListNode(2, four);
		System.out.println(Merge(one, two));
	}
	
	public static ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode result = new ListNode(0);
        ListNode temp = result;
        while(list1 != null && list2 != null) {
        	if(list1.val <= list2.val) {
        		temp.next = list1;
        		list1 = list1.next;
        		temp = temp.next;
        	} else {
        		temp.next = list2;
        		list2 = list2.next;
        		temp = temp.next;
        	}
        }
        if(list1 == null) temp.next = list2;
        if(list2 == null) temp.next = list1;
        return result.next;
    }
	
	// 最佳答案
	public ListNode Merge_S(ListNode list1, ListNode list2) {
		if (list1 == null) {
			return list2;
		} else if (list2 == null) {
			return list1;
		}

		// 合并表的头结点
		ListNode head = null;
		ListNode p = null;
		if (list1.val < list2.val) {
			head = list1;
			list1 = list1.next;
		} else {
			head = list2;
			list2 = list2.next;
		}

		p = head;
		// 循环合并，直至其中一表至末尾
		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				p.next = list1;
				list1 = list1.next;
				p = p.next;
			} else {
				p.next = list2;
				list2 = list2.next;
				p = p.next;
			}
		}

		if (list1 == null) {
			p.next = list2;
		}
		if (list2 == null) {
			p.next = list1;
		}
		return head;
	}
	
	static class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	    
	    ListNode(int val, ListNode next) {
	    	this.val = val;
	    	this.next = next;
	    }
	    
	    @Override
	    public String toString() {
	    	return this.val + " "+ next;
	    }
	}
}
