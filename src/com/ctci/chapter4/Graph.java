package com.ctci.chapter4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class Graph<T> {

	List<GNode<T>> nodes;

	public Graph(){
		nodes = new ArrayList<>();
	}

	public void addDirEdge(GNode<T> node1, GNode<T> node2){
		node1.adj.add(node2);
		nodes.add(node1);
		nodes.add(node2);
	}

	public void addUndirEdge(GNode<T> node1, GNode<T> node2){
		node1.adj.add(node2);
		node2.adj.add(node1);
		nodes.add(node1);
		nodes.add(node2);
	}

	public void DFS(){
		HashSet<GNode<T>> visitedNodes = new HashSet<>();
		for(GNode<T> node: nodes){
			if(!visitedNodes.contains(node)){
				DFS(node, visitedNodes);
				System.out.println();
			}
		}
	}

	private void DFS(GNode<T> startNode, HashSet<GNode<T>> visitedNodes ){
		Stack<GNode<T>> stack = new Stack<>();
		stack.push(startNode);
		while(!stack.isEmpty()){
			GNode<T> cur = stack.pop();
			if(!visitedNodes.contains(cur)){
				cur.visit();
				visitedNodes.add(cur);
			}
			for (GNode<T> node: cur.adj){
				stack.push(node);
			}
		}
	}

	private void DFSrec(GNode<T> curNode, HashSet<GNode<T>> visitedNodes ){
		if(!visitedNodes.contains(curNode)){
			curNode.visit();
			visitedNodes.add(curNode);	
			for (GNode<T> node: curNode.adj){
				DFSrec(node,visitedNodes);
			}
		}
	}



	public void BFS(){
		HashSet<GNode<T>> visitedNodes = new HashSet<>();

	}
}


/*
void dfs(node start) {
 stack<node> s;
 s.push(start);
 while (s.empty() == false) {
  top = s.top();
  s.pop();

  if (top is not marked as visited) {
   check for termination condition (have we reached the node we want to?)

   mark top as visited;
   add all of top's neighbors to the stack.
  }
 }
}

void bfs(node start) {
 queue<node> s;
 s.push(start);
 mark start as visited
 while (s.empty() == false) {
  top = s.front();
  s.pop();

  check for termination condition (have we reached the node we want to?)

  add all of top's unvisited neighbors to the queue
  mark all of top's unvisited neighbors as visited
 }
}
 */


