package com.ctci.chapter4.es4;


public class TreeNode {

	public int data;
	public TreeNode left,right,parent;
	
	public TreeNode(int data){
		this.data = data;
	}
	
	
	public static TreeNode createMinimalBT(int[] unsortedArray){
		return createMinimalBT(unsortedArray, 0, unsortedArray.length - 1);
	}

	private static TreeNode createMinimalBT(int[] unsortedArray, int start, int end){
		if(end < start) return null;
		int mid = (start + end)/2;
		TreeNode node = new TreeNode(unsortedArray[mid]);
		node.left = createMinimalBT(unsortedArray, start, mid - 1);
		node.right = createMinimalBT(unsortedArray, mid + 1, end);
		return node;
	}
	
	
	public static TreeNode TInsert(TreeNode root, int elem){
		if(root == null)
			return new TreeNode(elem);
		TreeNode x = root;
		TreeNode y = null;
		
		while(x!=null){
			y = x;
			if(elem <= x.data)
				x = x.left;
			else
				x = x.right;
		}
		
		TreeNode z = new TreeNode(elem);
		z.parent = y;
		
		if(elem <= y.data)
			y.left = z;
		else
			y.right = z;
		
		return z;
		
	}
}
