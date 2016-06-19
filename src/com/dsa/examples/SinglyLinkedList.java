package com.dsa.examples;

public class SinglyLinkedList<E> {

	private class Node<E> {
		private E element;
		private Node<E> next;

		public Node(E e, Node<E> n){
			element = e;
			next = n;
		}

		public E getElement(){
			return element;
		}
		public Node<E> getNext(){
			return next;
		}
		public void setNext(Node<E> n){
			next = n;
		}

		public String toString(){
			if(element==null) return null;
			return element.toString();
		}
	}

	private Node<E> header;
	private Node<E> trailer;
	private int size = 0;

	public SinglyLinkedList(){
		header = new Node<E>(null,null);
		trailer = new Node<E>(null,null);
		header.setNext(trailer);
	}

	public int size(){
		return size;
	}
	public boolean isEmpty(){
		return size==0;
	}
	public E first(){
		if(isEmpty()) return null;
		return header.getNext().getElement();
	}
	public E last(){
		if(isEmpty()) return null;
		Node<E> prev = null;
		Node<E> cur = header;
		while(cur.getNext()!=null){
			prev = cur;
			cur=cur.getNext();
		}
		return prev.getElement();
	}
	public void addFirst(E element){
		Node<E> newest = new Node<>(element,header.getNext());
		header.setNext(newest);
		size++;
	}

	public E removeFirst(){
		if(isEmpty()) return null;
		E element = header.getNext().getElement();
		header.setNext(header.getNext().getNext());
		size--;
		return element;
	}

	public String toString(){
		if(isEmpty()) return "List is empty";
		StringBuffer buf = new StringBuffer();	
		Node<E> cur = header;
		for (int i=0;i<size;i++){
			cur=cur.getNext();
			buf.append("[");
			if (i<size-1)
				buf.append(cur.toString()+"],");
			else
				buf.append(cur.toString()+"]");	
		}
		return buf.toString();		
	}
}
