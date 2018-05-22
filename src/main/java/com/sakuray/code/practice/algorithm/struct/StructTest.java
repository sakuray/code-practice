package com.sakuray.code.practice.algorithm.struct;

import org.junit.Test;

public class StructTest {

	@Test
	public void testStack() {
		Stack stack = new Stack();
		for(int i = 0; i < 10; i++) {
			stack.push(i);
		}
		
		for(int i = 0; i < 10; i++) {
			System.out.print(stack.pop()+", ");
		}
		System.out.println();
	}
	
	@Test
	public void testLinkedList() {
		LinkedList<Integer> links = new LinkedList<Integer>();
		links.listInsert(1);
		links.listInsert(2);
		System.out.println(links.listSearch(2));
		System.out.println(links.listSearch(3));
		links.delete(links.listSearch(2));
		System.out.println(links.listSearch(2));
	}
	
	@Test
	public void testQueue() {
		Queue<Integer> queue = new Queue<Integer>();
		for(int i = 0; i < 5; i++) {
			queue.enQueue(i);
		}
		for(int i = 0; i < 4; i++) {
			System.out.print(queue.deQueue()+",");
		}
	}
}
