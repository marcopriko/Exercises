package com.ctci.chapter3;

import java.util.NoSuchElementException;

public class Queue<T> {
	private static class QueueNode<T>{
		T data;
		QueueNode<T> next;
		
		public QueueNode(T data){
			this.data = data;
		}
	}
	
	private QueueNode<T> first;
	private QueueNode<T> last;
	
	public void add(T item){
		QueueNode<T> newNode = new QueueNode<>(item);
		if(last!=null)
			last.next = newNode;
		last = newNode;
		if(first==null)
			first = last;
	}
	
	public T remove(){
		if(first==null) throw new NoSuchElementException();
		T item = first.data;
		first = first.next;
		if(first==null)
			last = null;
		return item;
	}
	
	public T peek(){
		if(first==null) throw new NoSuchElementException();
		return first.data;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public String toString(){
		QueueNode<T> cur = first;
		StringBuilder buf = new StringBuilder();
		while(cur!=null){
			buf.append(cur.data.toString()+" ");
			cur = cur.next;
		}
		return buf.toString();
	}

}
