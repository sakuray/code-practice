package com.sakuray.code.practice.offer;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class _15_反转链表 {


    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        one.next = two;
        two.next = three;
        System.out.println(ReverseList(one));
    }

    public static ListNode ReverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode next;
        ListNode pre = head;
        while(head.next != null) {
            next = head.next;
            head.next = next.next;
            next.next = pre;
            pre = next;
        }
        return pre;
    }

    public ListNode ReverseList_S(ListNode head) {
        if(head==null)
            return null;
        ListNode newHead = null;
        ListNode pNode = head;
        ListNode pPrev = null;
        while(pNode!=null){
            ListNode pNext = pNode.next;
            if(pNext==null)
                newHead = pNode;
            pNode.next = pPrev;
            pPrev = pNode;
            pNode = pNext;
        }
        return newHead;
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val + ((next != null) ? "->" +next : "");
        }
    }
}
