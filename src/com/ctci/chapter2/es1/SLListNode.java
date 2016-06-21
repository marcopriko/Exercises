package com.ctci.chapter2.es1;

import java.util.HashSet;

public class SLListNode {

	private SLListNode next = null;
	private int data = 0;

	public SLListNode(int d){
		data = d;
	}

	public int getData(){
		return data;
	}

	public SLListNode getNext(){
		return next;
	}

	public void setData(int d){
		data = d;
	}

	public void setNext(SLListNode n){
		next = n;
	}


}
