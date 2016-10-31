package com.ctci.chapter4.es1;

import java.util.ArrayList;
import java.util.List;

public class Node {

	public int data;
	public List<Node> adj;
	public State state;
	
	public Node(int data){
		this.data = data;
		adj = new ArrayList<>();
		state = State.Unvisited;
	}
	
}
