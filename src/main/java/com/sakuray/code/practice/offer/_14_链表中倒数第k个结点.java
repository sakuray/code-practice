package com.sakuray.code.practice.offer;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class _14_链表中倒数第k个结点 {
	
	public static void main(String[] args) {
		ListNode five = new ListNode(5);
		ListNode four = new ListNode(4, five);
		ListNode three = new ListNode(3, four);
		ListNode two = new ListNode(2, three);
		ListNode one = new ListNode(1, two);
		System.out.println(FindKthToTail(one, 6).val);
	}
	
	public static ListNode FindKthToTail(ListNode head,int k) {
		if(head == null || k < 1) return null;
		ListNode temp = head;
		int length = 1;
		while(temp.next != null) {
			temp = temp.next;
			length += 1;
		}
		if(k > length) return null;
		int aim = length - k;
		temp = head;
		while(aim != 0 && temp != null) {
			aim--;
			temp = temp.next;
		}
		return temp;
    }
	
	// 最佳答案
	public ListNode FindKthToTail_S(ListNode head,int k) {
        if(head == null || k <=0){ //参数判断
           return  null;
       }
        ListNode pAhead = head;
        ListNode pBehind = head;
        for (int i = 0; i< k-1;i++){
            if(pAhead.next != null){
                pAhead = pAhead.next;
            }else {
                return  null;    //参数判断
            }
        }
        while (pAhead.next != null){
            pAhead = pAhead.next;
            pBehind = pBehind.next;
        }
        return pBehind;
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
	}
}

