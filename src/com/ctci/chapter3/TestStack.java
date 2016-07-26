package com.ctci.chapter3;

public class TestStack {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack);
		System.out.println("Peek: "+stack.peek());
		System.out.println(stack);
		System.out.println("Pop: "+stack.pop());
		System.out.println(stack);
	}

}
