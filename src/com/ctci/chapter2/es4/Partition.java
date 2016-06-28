package com.ctci.chapter2.es4;

import com.ctci.chapter2.LLN;

public class Partition {

	public static void main(String[] args) {
		LLN list = new LLN(0,null,null);
		list.appendToTail(7);
		list.appendToTail(2);
		list.appendToTail(8);
		list.appendToTail(3);
		list.appendToTail(9);
		list.appendToTail(6);
		list.appendToTail(5);
		list.appendToTail(8);
		list.appendToTail(1);
		list.appendToTail(2);
		list.appendToTail(5);
		list.appendToTail(3);
		
		list.print();
		
		//LLN newList = partition(list, 5);
		
		//newList.print();
		
		LLN newList2 = partition(list, 5);
		
		newList2.print();
	}
	
	public static LLN partition(LLN head, int x){
		if(head==null) return null;
		if(head.next==null) return head;
		
		int size = 1;
		LLN cur = head;
		while(cur.next!=null){
			cur = cur.next;
			size++;
		}
		System.out.println("Size  =  "+size);
		LLN tail = cur;
		
		cur = head;
		LLN prev = null;
		int index = 0;
		while(cur!=null && index<size){
			if(cur.data >= x){
				LLN tmp = cur.next;
				tail.next = cur;
				cur.next = null;
				tail = cur;
				cur = tmp;
				if(prev==null)
					head = cur;
				else
					prev.next = cur;
			} else {
				prev = cur;
				cur = cur.next;
			}
			index++;
		}
		return head;
	}

	public static LLN partition2(LLN head, int x){
		if(head==null) return null;
		if(head.next==null) return head;
		
		LLN before = null;
		LLN after = null;
		LLN tailBefore = null;
		
		for(LLN cur = head; cur!=null; cur = cur.next){
			if(cur.data < x){
				before = new LLN (cur.data,before);		
				if(tailBefore==null)
					tailBefore=before;
			} else {
				after = new LLN (cur.data,after);	
			}
		}
		tailBefore.next = after;
		head = before;

		return head;
	}
	
	public static LLN partition3(LLN node, int x){
		if(node==null) return null;
		if(node.next==null) return node;
		
		LLN head = node;
		LLN tail = node;
		while(node!=null){
			LLN next = node.next;
			if(node.data < x){
				node.next = head;
				head = node;
			} else {
				tail.next = node;
				tail = node;
			}
			node = next;
		}
		tail.next = null;
		
		return head;
	}



}
