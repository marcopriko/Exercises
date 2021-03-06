package com.ctci.chapter4.es3;


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
}
