package com.sakuray.code.practice.pattern.behave;

import java.util.Stack;

/**
 * 解释器模式：
 *   在系统中如果某一特定类型的问题在频繁的发生，此时我们就有必要将这些问题的实例表述为一个语言中句子，因此可以构建一个解释器，然后利用该解释器来解释这些句子来解决这些问题
 *   所谓解释器模式就是定义语言的文法，并且建立一个解释器来解释该语言中的句子。
 *   在这里我们将语言理解成使用规定格式和语法的代码。
 *   正则表达式就是解释器模式的应用，解释器为正则表达式定义了一个文法，如何表示一个特定的正则表达式，以及如何解释这个正则表达式。
 *   解释器模式描述了如何构成一个简单的语言解释器，主要应用在使用面向对象语言开发的编译器中。它描述了如何为简单的语言定义一个文法，如何在该语言中表示一个句子，以及如何解释这些句子。
 * 模式结构：
 *   AbstractExpression: 抽象表达式。声明一个抽象的解释操作，该接口为抽象语法树中所有的节点共享。
     TerminalExpression: 终结符表达式。实现与文法中的终结符相关的解释操作。实现抽象表达式中所要求的方法。文法中每一个终结符都有一个具体的终结表达式与之相对应。
     NonterminalExpression: 非终结符表达式。为文法中的非终结符相关的解释操作。
     Context: 环境类。包含解释器之外的一些全局信息。
     Client: 客户类。  
 * 适用场景：
 *   1、可以将一个需要解释执行的语言中的句子表示为一个抽象语法树。
     2、一些重复出现的问题可以用一种简单的语言来进行表达。
     3、文法较为简单。
 * 个人体会：
 * 	 一个表达式，里面有解析式子的方法
 *  一个解析器，将事物解析成表达式，构建语法树，解析表达式
 */
// 用解释器模式实现一个基本的加、减、乘、除和求模运算。 如输入3*4/2%4
public class InterpreterPattern {
	
	// 抽象表达式
	public interface Node {
		public int interpret();
	}

	// 非终结表达式
	public class ValueNode implements Node {
		private int value;
		
		public ValueNode(int value) {
			this.value = value;
		}

		@Override
		public int interpret() {
			return this.value;
		}
	}
	
	// 终结表达式抽象类
	public abstract class SymbolNode implements Node {
		protected Node left;
		protected Node right;
		
		public SymbolNode(Node left, Node right) {
			this.left = left;
			this.right = right;
		}
	}
	
	// MulNode 乘法
	public class MulNode extends SymbolNode {

		public MulNode(Node left, Node right) {
			super(left, right);
		}

		@Override
		public int interpret() {
			return left.interpret() * right.interpret();
		}
	}
	
	// ModNode 取模
	public class ModNode extends SymbolNode {
		public ModNode(Node left, Node right) {
			super(left, right);
		}

		@Override
		public int interpret() {
			return left.interpret() % right.interpret();
		}
	}
	
	// DivNode 除法
	public class DivNode extends SymbolNode {

		public DivNode(Node left, Node right) {
			super(left, right);
		}

		@Override
		public int interpret() {
			return left.interpret() / right.interpret();
		}
	}
	
	// 构建语法分析树
	public class Calculator {
		private Node node;
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public void build(String statement) {
			Node left = null, right = null;
			Stack stack = new Stack();
			
			String[] statementArr = statement.split(" ");
			for(int i = 0; i < statementArr.length; i++) {
				if(statementArr[i].equalsIgnoreCase("*")) {
					left = (Node) stack.pop();
					int val = Integer.parseInt(statementArr[++i]);
					right = new ValueNode(val);
					stack.push(new MulNode(left, right));
				} else if(statementArr[i].equalsIgnoreCase("/")) {
					left = (Node) stack.pop();
					int val = Integer.parseInt(statementArr[++i]);
					right = new ValueNode(val);
					stack.push(new DivNode(left, right));
				} else if(statementArr[i].equalsIgnoreCase("%")) {
					left = (Node) stack.pop();
					int val = Integer.parseInt(statementArr[++i]);
					right = new ValueNode(val);
					stack.push(new ModNode(left, right));
				} else {
					stack.push(new ValueNode(Integer.parseInt(statementArr[i])));
				}
			}
			this.node = (Node) stack.pop();
		}
		
		public int compute() {
			return node.interpret();
		}
	}
	
	// 该程序并不完善
	public static void main(String[] args) {
		String statement = "3 * 2 * 4 / 6 % 5";
		Calculator calculator = new InterpreterPattern().new Calculator();
		calculator.build(statement);
		int result = calculator.compute();
		System.out.println(statement+ " = " + result);
	}
}
