package com.example.trees;


public class Tree {

	public static TNode TInsert(TNode root, int elem){
		if(root == null)
			return new TNode(elem);
		TNode x = root;
		TNode y = null;
		
		while(x!=null){
			y = x;
			if(elem <= x.data)
				x = x.left;
			else
				x = x.right;
		}
		
		TNode z = new TNode(elem);
		z.parent = y;
		
		if(elem <= y.data)
			y.left = z;
		else
			y.right = z;
		
		return z;
		
	}
}
