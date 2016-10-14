package com.ctci.chapter4;

import java.util.ArrayList;
import java.util.List;

public class GNode<T> {
	public T data;
	public List<GNode<T>> adj;
		
	public GNode(T data){
		this.data = data;
		adj = new ArrayList<>();
	}
	
	public void visit(){
		System.out.print("Node " + data +" -> ");
	}
		
}
