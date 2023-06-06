package com.sakuray.code.practice.leetcode._0_99;

import static com.sakuray.code.practice.leetcode.Tools.*;

/**
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 * <p>
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 * <p>
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 * <p>
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 */
public class _025_ReverseNodesInKGroup {

    public static void main(String[] args) {
        System.out.println(reverseKGroup(buildList(1, 2, 3, 4, 5), 2));
        System.out.println(reverseKGroup(buildList(1, 2, 3, 4, 5), 5));
    }

    /**
     * 单链表翻转group是链表长度，现在指定group大小
     * 注意最后不足的长度需要保持原顺序
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode first = root;
        int cnt = k;
        while (head.next != null) {
            if (!leftK(first.next, k)) {
                break;
            }
            cnt--;
            if (cnt == 0) {
                cnt = k;
                first = head;
                head = head.next;
            } else {
                ListNode next = head.next;
                head.next = next.next;
                next.next = first.next;
                first.next = next;
            }
        }
        return root.next;
    }

    private static boolean leftK(ListNode n, int k) {
        while (n != null) {
            n = n.next;
            k--;
            if (k <= 0) {
                return true;
            }
        }
        return false;
    }

    public ListNode reverseKGroup_S(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;

        while (head != null) {
            ListNode tail = pre;
            // 查看剩余部分长度是否大于等于 k
            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            ListNode nex = tail.next;
            ListNode[] reverse = myReverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            // 把子链表重新接回原链表
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }

        return hair.next;
    }

    public ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }
}
