package com.ctci.chapter4.es1;

import java.util.LinkedList;
import java.util.Stack;


public class RouteBtwNodes {

	public static void main(String[] args) {
		Graph graph = new Graph();
		
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		Node node9 = new Node(9);
		Node node10 = new Node(10);
		Node node11 = new Node(11);
		Node node12 = new Node(12);

		graph.addDirEdge(node1, node2);
		graph.addDirEdge(node2, node3);
		graph.addDirEdge(node2, node4);
		graph.addDirEdge(node4, node3);
		graph.addDirEdge(node3, node5);
		
		graph.addDirEdge(node5, node6);
		graph.addDirEdge(node5, node7);
		//graph.addDirEdge(node7, node2);
		graph.addDirEdge(node7, node8);
		graph.addDirEdge(node9, node7);
		graph.addDirEdge(node6, node10);
		graph.addDirEdge(node6, node11);
		
		System.out.println(searchDFS(graph,node1,node5));

	}
	
	public static boolean search(Graph g, Node start, Node end){
		
		if (start == end)
			return true;
		
		for (Node node: g.nodes){
			node.state = State.Unvisited;
		}
		
		LinkedList<Node> queue = new LinkedList<>();
		
		start.state = State.Visiting;
		queue.add(start);
		
		while(!queue.isEmpty()){
			Node cur = queue.remove();
			if (cur == end) 
				return true;
			for(Node neighbor: cur.adj){
				if(neighbor.state == State.Unvisited){
					neighbor.state = State.Visiting;
					queue.add(neighbor);
				}
			}
			cur.state = State.Visited;			
		}

		return false;
	}
	
	public static boolean searchDFS(Graph g, Node start, Node end){
		
		if(start == end) return true;
		for(Node node: g.nodes){
			node.state = State.Unvisited;
		}
		
		Stack<Node> stack = new Stack<>();
		stack.push(start);
		
		while(!stack.isEmpty()){
			Node cur = stack.pop();
			cur.state = State.Visited;
			if(cur == end) return true;
			
			for(Node neighbor: cur.adj){
				if(neighbor.state == State.Unvisited){
					stack.push(neighbor);
				}
			}
		}
		return false;
	}

}
