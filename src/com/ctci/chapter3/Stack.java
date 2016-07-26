package com.ctci.chapter3;

import java.util.EmptyStackException;

public class Stack<T>{
	@SuppressWarnings("hiding")
	private class StackNode<T>{
		T data;
		StackNode<T> next;
		
		public StackNode(T data){
			this.data = data;
		}
	}

	private StackNode<T> top;

	public T pop(){
		if(top==null) throw new EmptyStackException();
		T data = top.data;
		top = top.next;
		return data;
	}
	
	public T peek(){
		if(top==null) throw new EmptyStackException();
		return top.data;
	}

	public void push(T item){
		StackNode<T> node = new StackNode<>(item);
		node.next = top;
		top = node;
	}

	public String toString(){
		StackNode<T> cur = top;
		StringBuilder buf = new StringBuilder();
		while(cur!=null){
			buf.append(cur.data.toString()+" ");
			cur = cur.next;
		}
		return buf.toString();
	}
}
