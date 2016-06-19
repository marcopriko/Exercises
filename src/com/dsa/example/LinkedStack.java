package com.dsa.example;

public class LinkedStack<E> implements Stack<E>{
	
	private SinglyLinkedList<E> list = new SinglyLinkedList<>();
	
	public LinkedStack(){
		
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public void push(E e) {
		list.addFirst(e);
	}

	@Override
	public E top() {
		// TODO Auto-generated method stub
		return list.first();
	}

	@Override
	public E pop() {
		return list.removeFirst();
	}

}
