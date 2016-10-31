package com.ctci.chapter4.es1;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	
	public List<Node> nodes;
	
	public Graph(){
		nodes = new ArrayList<>();
	}
	

	public void addDirEdge(Node node1, Node node2){
		node1.adj.add(node2);
		nodes.add(node1);
		nodes.add(node2);
	}

	public void addUndirEdge(Node node1, Node node2){
		node1.adj.add(node2);
		node2.adj.add(node1);
		nodes.add(node1);
		nodes.add(node2);
	}
	
}
