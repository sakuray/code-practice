package com.sakuray.code.practice.algorithm.struct;

/**
 * 队列：先进先出
 */
public class Queue<T> {
	
	private Object[] elements;
	private int take = 0;
	private int put = 0;
	private int size = 0;
	
	public Queue() {
		elements = new Object[10];
	}

	// 入队
	public void enQueue(T x) {
		if(put == take && elements[take] != null) {
			throw new RuntimeException("队列已满");
		}
		elements[put] = x;
		if(++put == elements.length) {
			put = 0;
		}
		size++;
	}
	
	// 出队
	public T deQueue() {
		if(elements[take] == null) {
			throw new RuntimeException("队列中没有元素了");
		}
		@SuppressWarnings("unchecked")
		T result = (T) elements[take];
		elements[take] = null;
		if(++take == elements.length) {
			take = 0;
		}
		size--;
		return result;
	}
	
	public int size() {
		return size;
	}
}
