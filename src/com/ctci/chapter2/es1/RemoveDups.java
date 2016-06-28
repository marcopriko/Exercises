package com.ctci.chapter2.es1;

import com.ctci.chapter2.LLN;

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
		LLN list = new LLN(0,null,null);
		LLN cur = list;

		list.appendToTail(1);
		list.appendToTail(2);
		list.appendToTail(3);
		list.appendToTail(4);
		list.appendToTail(6);
		list.appendToTail(6);
		list.appendToTail(7);
		list.appendToTail(8);
		list.appendToTail(3);
		list.appendToTail(10);
		list.appendToTail(11);
		list.appendToTail(12);
		
		//list.deleteDups2();
		//removeDups(list);
		
		StringBuilder buff = new StringBuilder();
		while(cur!=null){
			buff.append(" " + cur.data + " ");
			cur=cur.next;
		}
		System.out.println(buff.toString());
		System.out.println(list.hashCode());
	}
	
	public static void removeDups(LLN head){
		LLN curr = head;
		LLN runner;
		while(curr!=null){
			runner=curr;
			while(runner.next!=null){
				if(runner.next.data == curr.data)
					runner.next = runner.next.next;
				else
					runner = runner.next;
			}
			curr=curr.next;
		}
		
	}


}
