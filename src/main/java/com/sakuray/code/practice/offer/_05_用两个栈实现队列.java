package com.sakuray.code.practice.offer;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class _05_用两个栈实现队列 {
	static Stack<Integer> stack1 = new Stack<Integer>();
    static Stack<Integer> stack2 = new Stack<Integer>();
    
    public static void main(String[] args) {
		push(1);
		push(2);
		System.out.println(pop());
		push(3);
		System.out.println(pop());
		System.out.println(pop());
	}
    
    public static void push(int node) {
    	while(!stack2.isEmpty()) {
    		stack1.push(stack2.pop());
    	}
    	stack1.push(node);
    }
    
    public static int pop() {
    	while(!stack1.isEmpty()) {
    		stack2.push(stack1.pop());
    	}
    	return stack2.pop();
    }
    
    // 最佳答案
    public void push_S(int node) {
        stack1.push(node);
    }
     
    public int pop_S() {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int first=stack2.pop();
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return first;
    }
}
