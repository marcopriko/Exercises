package com.ctci.chapter3;

public class TestQueue {

	public static void main(String[] args) {
		Queue<Integer> queue = new Queue<>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		System.out.println(queue);
		System.out.println("Peek: "+queue.peek());
		System.out.println(queue);
		System.out.println("Remove: "+queue.remove());
		System.out.println(queue);
	}

}
