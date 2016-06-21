package com.ctci.chapter2.es1;

/**
 * Mistakes:
 * Did not use prev node in the runner technique from 0 to current node.
 * Preferred way to the runner technique from current to end of list (no need to keep prev node). 
 * 
 * @author Marco
 *
 */

public class RemoveDups {

	public static void main(String[] args) {
		SLList list = new SLList();
		
//		for(int i=0;i<10;i++){
//			list.appendToTail(i/2);
//		}
		list.appendToTail(0);
		list.appendToTail(1);
		list.appendToTail(3);
		list.appendToTail(1);
		list.appendToTail(7);
		list.appendToTail(8);
		list.appendToTail(3);
		list.appendToTail(2);
		list.appendToTail(4);
		list.appendToTail(5);
		list.appendToTail(9);
		list.appendToTail(8);
		
		list.deleteDups2();
		System.out.println(list.printList());
	}


}
