package com.sakuray.code.practice.algorithm.struct;

/**
 * 双向链表
 */
public class LinkedList<T> {
	
	private Node<T> first;	// 头节点
	private Node<T> last;	// 尾节点
	
	// 搜索
	public Node<T> listSearch(T k) {
		Node<T> x = first;
		while(x != last && x.item != k) {
			x = x.next;
		}
		return x;
	}
	
	// 插入（插入链表前端，插入的节点下一个节点就是当前头节点，当前节点变成头节点）
	private void listInsert(Node<T> x) {
		x.next = first;
		if(first != null) {
			first.prev = x;
		}
		first = x;
		x.prev = null;
	}
	
	public void listInsert(T t) {
		Node<T> x = new Node<T>(null, t, null);
		listInsert(x);
	}
	
	// 删除
	public void delete(Node<T> x) {
		if(x.prev != null) {
			x.prev.next = x.next;
		} else {
			first = x.next;
		}
		if(x.next != null) {
			x.next.prev = x.prev;
		}
	}

	// 链表的一个节点
	private static class Node<T> {
		private Node<T> prev;	// 上一节点
		private T item;	// 当前节点内容
		private Node<T> next;	// 下一节点
		
		Node(Node<T> prev, T item, Node<T> next) {
			this.prev = prev;
			this.item = item;
			this.next = next;
		}
		
	}
}
