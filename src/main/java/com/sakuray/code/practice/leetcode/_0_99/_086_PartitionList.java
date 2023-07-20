package com.sakuray.code.practice.leetcode._0_99;

import static com.sakuray.code.practice.leetcode.Tools.*;

/**
 * Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * Input: head = [1,4,3,2,5,2], x = 3
 * Output: [1,2,2,4,3,5]
 * <p>
 * Input: head = [2,1], x = 2
 * Output: [1,2]
 */
public class _086_PartitionList {

    /**
     * 小于x的节点往前移动，保证相对顺序不变
     */
    public ListNode partition(ListNode head, int x) {
        ListNode begin = new ListNode(0);
        begin.next = head;
        ListNode insertNode = begin;
        ListNode preNode = begin;
        while (head != null) {
            if (head.val < x) {
                preNode.next = head.next;
                head.next = insertNode.next;
                insertNode.next = head;
                insertNode = head;
            }
            preNode = head;
            head = head.next;
        }
        return begin.next;
    }
}
