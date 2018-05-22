package com.sakuray.code.practice.leetcode._100_199;

import com.sakuray.code.practice.leetcode.Tools.ListNode;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * Note: Do not modify the linked list.
 * Follow up:
 * 		Can you solve it without using extra space?
 */
public class _142_LinkedListCycleII {
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		l1.next = l2; l2.next = l3;
		l3.next = l4; l4.next = l5;
		l5.next = l6; l6.next = l3;
		System.out.println(detectCycle(l1).val);
	}

	/**
	 * 假设有环，环前有n个节点，环有m个节点。
	 * n
	 * ------  k
	 *   |m |
	 *   ----
	 * 一个移动2节点的指针，一个移动1节点的指针，最终在环的k处相遇
	 * 假设1节点指针移动x步，
	 * 即  x = n + c1m + k	2x = n + c2m + k
	 * 易得出  n + k = (c2-c1)m
	 * 所以n + k 是环m的倍数，此时1节点指针在n + k处
	 * 此时1节点到环节点还有成(c2-c1)m - k，可以看成是距离n
	 * 所以再有一个节点从起点出发走n距离到环点，此时1节点也走了n距离即在环点处相遇
	 */
	public static ListNode detectCycle(ListNode head) {
		ListNode p1 = head, p2 = head;
		while(p1 != null && p2 != null) {
			p1 = p1.next;
			p2 = p2.next;
			if(p2 == null) break;
			p2 = p2.next;
			if(p2 == p1) {
				p2 = head;
				while(p1 != p2) {
					p1 = p1.next;
					p2 = p2.next;
				}
				return p1;
			}
		}
        return null;
    }
}
