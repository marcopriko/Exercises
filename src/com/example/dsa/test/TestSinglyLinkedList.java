package com.example.dsa.test;

import com.example.dsa.SinglyLinkedList;

public class TestSinglyLinkedList {

	public static void main(String[] args) {
		
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.addFirst(1);
		list.addFirst(2);
		list.addFirst(3);
		list.addFirst(4);
		list.addFirst(5);
		list.addFirst(6);
		list.addFirst(7);
		list.addFirst(8);
		list.addFirst(9);
		System.out.println(list);
		System.out.println(list.last());
	}


}
