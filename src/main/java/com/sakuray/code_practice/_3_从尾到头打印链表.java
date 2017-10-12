package com.sakuray.code_practice;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，从尾到头打印链表每个节点的值。
 */

public class _3_从尾到头打印链表 {
	
	public static void main(String[] args) {
		ListNode node5 = new ListNode(5);
		ListNode node4 = new ListNode(4, node5);
		ListNode node3 = new ListNode(3, node4);
		ListNode node2 = new ListNode(2, node3);
		ListNode node1 = new ListNode(1, node2);
		System.out.println(printListFromTailToHead(node1));
	}
	
	public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		long start = System.nanoTime();
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(listNode == null) return result;
		while(listNode.next != null) {
			result.add(listNode.val);
			listNode = listNode.next;
		}
		result.add(listNode.val);
		for(int i = 0; i < result.size() / 2; i++) {
			int temp = result.get(i);
			result.set(i, result.get(result.size()-i-1));
			result.set(result.size()-i-1, temp);
		}
		System.out.println(System.nanoTime()-start);
		return result;
	}
	
	// 最佳答案
	public ArrayList<Integer> printListFromTailToHead_S(ListNode listNode) {
        Stack<Integer> stack = new Stack<Integer>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
 
        ArrayList<Integer> list = new ArrayList<Integer>(stack.size());
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;       
    }
}

class ListNode {
	int val;
	ListNode next = null;
	
	ListNode(int val) {
		this.val = val;
	}
	
	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return "" + val;
	}
}