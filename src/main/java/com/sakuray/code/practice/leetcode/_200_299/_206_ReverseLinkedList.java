package com.sakuray.code.practice.leetcode._200_299;

import static com.sakuray.code.practice.leetcode.Tools.*;

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * <p>
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * <p>
 * Input: head = [1,2]
 * Output: [2,1]
 * <p>
 * Input: head = []
 * Output: []
 */
public class _206_ReverseLinkedList {

    public static void main(String[] args) {
        System.out.println(reverseList( buildList(1,2,3,4,5)));
    }

    /**
     * 翻转链表，这里最重要的点就在于先断那根线，先连哪根线。head.next都是要放入最头部的
     * 1,2,3,4,5
     * first永远是1，head永远是头节点，第一次翻转成2,1,3,4,5
     * tmp = first.next = 2
     * first.next = first.next.next: 1->3->4->5
     * tmp.next = head 2->1->3->4->5
     * head = tmp
     * 简单来说就是头插法，确定当前的头节点，移除。将剩余节点连在一起
     * 再将当前头节点的next，设置成之前的头节点，最后将其设置成头节点
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode first = head, tmp;
        while (first.next != null) {
            tmp = first.next;
            first.next = first.next.next;
            tmp.next = head;
            head = tmp;
        }
        return head;
    }
}
