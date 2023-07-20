package com.sakuray.code.practice.leetcode._200_299;

import static com.sakuray.code.practice.leetcode.Tools.*;

/**
 * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
 * <p>
 * Input: head = [1,2,2,1]
 * Output: true
 * <p>
 * Input: head = [1,2]
 * Output: false
 */
public class _234_PalindromeLinkedList {

    /**
     * 难点在于无法从链表尾部双向逼近
     * 翻转一半节点，然后再快慢指针对比：876、206
     */
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = slow, temp;
        slow = slow.next;
        prev.next = null;
        while (slow != null) {
            temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        fast = head;
        slow = prev;
        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
}
