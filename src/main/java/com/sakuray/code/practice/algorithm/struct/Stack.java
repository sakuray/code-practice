package com.sakuray.code.practice.algorithm.struct;

/**
 * 栈结构（后进先出），非线程安全
 */
public class Stack {
	
	private Object[] elements;
	
	private int elementCount;
	
	public Stack() {
		elementCount = 0;
		elements = new Object[10];
	}
	
	// 判断空栈
	public boolean empty() {
		return size() == 0;
	}
	
	// 入栈(未处理栈上溢)
	public void push(Object element) {
		int index = size();
		if(index >= elements.length) {
			throw new RuntimeException("栈上溢出");
		}
		elementCount++;
		elements[index] = element;
	}
	
	// 出栈(未处理下溢)
	public Object pop() {
		if(size()==0) {
			throw new RuntimeException("栈下溢出");
		} else {
			elementCount --;
			return elements[elementCount];
		}
	}
	
	public int size() {
		return elementCount;
	}
}
