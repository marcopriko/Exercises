package com.ctci.chapter2.es1;

import java.util.HashSet;

public class SLList{
	
	SLListNode head = null;
	int size=0;

	public SLList(){
	}
	
	public void appendToTail(int d){
		SLListNode newNode = new SLListNode(d);
		if(head==null){
			head = newNode;
		} else {
			SLListNode n = head;
			while(n.getNext()!=null){
				n=n.getNext();
			}
			n.setNext(newNode);	
		}
		size++;
		
	}
	
	public boolean isEmpty(){
		return (size==0);
	}	
	
	public SLListNode getHead(){
		return head;
	}	
	public int getSize(){
		return size;
	}
	

	public String printList(){
		SLListNode n = head;
		StringBuilder buff = new StringBuilder();
		while(n!=null){
			
			buff.append(n.getData()+" ");
			n=n.getNext();
		}
		return buff.toString();
	}
	
	public void removeDups(){
		if(this.isEmpty()) return;
		HashSet<Integer> hashSet = new HashSet<>();
		SLListNode curr = this.getHead();
		SLListNode prev = null;
		while(curr.getNext()!=null){
			if(!hashSet.contains(curr.getData())){
				hashSet.add(curr.getData());
				prev = curr;
			} else {
				prev.setNext(curr.getNext());	
			}
			curr=curr.getNext();
		}
		if(!hashSet.contains(curr.getData())){
			hashSet.add(curr.getData());
			prev = curr;
		} else {
			prev.setNext(curr.getNext());	
		}
	}
	
	public void deleteDups(){
		HashSet<Integer> set = new HashSet<>();
		SLListNode prev = null;
		SLListNode n = this.getHead();
		while(n!=null){
			if(set.contains(n.getData())){
				prev.setNext(n.getNext());
			} else {
				set.add(n.getData());
				prev=n;
			}
			n=n.getNext();
		}
	}
	
	public void deleteDups2(){ // My Solution

		SLListNode head = this.getHead();
		SLListNode current = head.getNext();
		SLListNode runner;
		SLListNode prev;
		
		while(current!=null){
			runner=head;
			prev=head;
			while(runner!=current){
			  if(runner.getData() == current.getData()){
			  	prev.setNext(runner.getNext());
			  	break;
			  }
			  prev=runner;
			  runner=runner.getNext();
			}
			current=current.getNext();
		}
	}
	
	public void deleteDups3(){ // Solution
		SLListNode current = this.getHead();;
		SLListNode runner;
		
		while(current!=null){
			runner=current;
			while(runner.getNext()!=null){
			  if(runner.getNext().getData() == current.getData()){
			  	runner.setNext(runner.getNext().getNext());
			  } else {	  
				  runner=runner.getNext();
			  }
			}
			current=current.getNext();
		}
	}
	
}