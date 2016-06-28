package com.ctci.chapter2.es3;

import com.ctci.chapter2.LLN;

public class DeleteMiddleNode {

	public static void main(String[] args) {
		LLN list = new LLN(0,null,null);
		LLN cur;
		list.appendToTail(1);
		list.appendToTail(2);
		list.appendToTail(3);
		list.appendToTail(4);
		list.appendToTail(5);
		list.appendToTail(6);
		cur = list.appendToTail(7);
		list.appendToTail(8);
		list.appendToTail(9);
		list.appendToTail(10);
		list.appendToTail(11);
		list.appendToTail(12);
		
		list.print();
		
		removeNode(cur);
		
		list.print();
	}
	
	public static boolean removeNode(LLN node){
		if(node==null || node.next==null) return false;
		node.data=node.next.data;
		node.next=node.next.next;
		return true;
	}

}
