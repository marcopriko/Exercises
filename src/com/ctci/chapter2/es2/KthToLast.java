package com.ctci.chapter2.es2;

import com.ctci.chapter2.es1.SLList;
import com.ctci.chapter2.es1.SLListNode;

public class KthToLast {

	public static void main(String[] args) {
		SLList list = new SLList();
		
		for(int i=0;i<10;i++){
			list.appendToTail(i);
		}
//		list.appendToTail(0);
//		list.appendToTail(1);
//		list.appendToTail(3);
//		list.appendToTail(1);
//		list.appendToTail(7);
//		list.appendToTail(8);
//		list.appendToTail(3);
//		list.appendToTail(2);
//		list.appendToTail(4);
//		list.appendToTail(5);
//		list.appendToTail(9);
//		list.appendToTail(8);
		
		System.out.println(list.printList());
		//System.out.println(KthToLast(list,8));
		//System.out.println(KthToLastRec1(list,8));
		System.out.println(KthToLastRec2(list,1));
	}
	
	public static int KthToLast(SLList list, int k){
		if(k<1) 
			throw new IllegalArgumentException("K too small");
		SLListNode curr = list.getHead();
		int size = 0;
		while(curr!=null){
			size++;
			curr=curr.getNext();
		}
		if(size < 1 || k > size) 
			throw new IllegalArgumentException("K too big");
		
		int index = size-k;
		int i=0;
		curr = list.getHead();
		while(i<index){
			i++;
			curr=curr.getNext();
		}
		return curr.getData();
	}
	
	public static int KthToLastRec1(SLList list, int k){
		if(k<1) 
			throw new IllegalArgumentException("K too small");
		return KthToLastRec1(list.getHead(), k, list.getSize());
	}
	
	private static int KthToLastRec1(SLListNode node, int k, int size){
		if(k==size)
			return node.getData();
		else
			return KthToLastRec1(node.getNext(), k, size-1);
	}
	
	
	public static int KthToLastRec2(SLList list, int k){
		if(k<1) 
			throw new IllegalArgumentException("K too small");
		return KthToLastRec2(list.getHead(), k);
	}
	private static int KthToLastRec2(SLListNode node, int k){
		int count;
		if(node==null)
			count = 0;
		else {
			count = 1 + KthToLastRec2(node.getNext(),k);
		}
		if(count==k)
			System.out.println("Kth to last element is: " + node.getData());
		return count;
	}
}
