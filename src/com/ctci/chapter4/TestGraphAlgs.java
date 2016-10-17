package com.ctci.chapter4;

public class TestGraphAlgs {

	public static void main(String[] args) {
		Graph<Integer> graph = new Graph<>();
		
		GNode<Integer> node1 = new GNode<>(1);
		GNode<Integer> node2 = new GNode<>(2);
		GNode<Integer> node3 = new GNode<>(3);
		GNode<Integer> node4 = new GNode<>(4);
		GNode<Integer> node5 = new GNode<>(5);
		GNode<Integer> node6 = new GNode<>(6);
		GNode<Integer> node7 = new GNode<>(7);
		GNode<Integer> node8 = new GNode<>(8);
		GNode<Integer> node9 = new GNode<>(9);
		GNode<Integer> node10 = new GNode<>(10);
		GNode<Integer> node11 = new GNode<>(11);

		graph.addDirEdge(node1, node2);
		graph.addDirEdge(node2, node3);
		graph.addDirEdge(node2, node4);
		graph.addDirEdge(node4, node3);
		
		graph.addDirEdge(node5, node6);
		graph.addDirEdge(node5, node7);
		graph.addDirEdge(node7, node2);
		graph.addDirEdge(node7, node8);
		graph.addDirEdge(node9, node7);
		graph.addDirEdge(node6, node10);
		graph.addDirEdge(node6, node11);


		graph.DFS();
		//graph.DFSrec();
		System.out.println();
		graph.BFS();
	}

}
