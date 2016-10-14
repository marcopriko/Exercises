package com.example.trees;

import java.util.Random;

public class TestBTreeOps {

	public static void main(String[] args) {
		Random random = new Random();
		
		TNode root = null;
		root = Tree.TInsert(null, random.nextInt(100) + 1);

		for(int i = 2;i<20;i++){
			Tree.TInsert(root, random.nextInt(100) + 1);
		}
		
		BTreePrinter.printNode(root);

	}

}
