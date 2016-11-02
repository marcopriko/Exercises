package com.ctci.chapter4.es2;


public class TestMinimalTree {

	public static void main(String[] args) {

		int [] array = {0,1,2,3,4,5,6};
		TreeNode root = createMinimalBST(array);
		BTreePrinter.prinTreeNode(root);

	}


	public static TreeNode createMinimalBST(int[] sortedArray){
		return createMinimalBST(sortedArray, 0, sortedArray.length - 1);
	}

	public static TreeNode createMinimalBST(int[] sortedArray, int start, int end){
		if(end < start) return null;
		int mid = (start + end)/2;
		TreeNode node = new TreeNode(sortedArray[mid]);
		node.left = createMinimalBST(sortedArray, start, mid - 1);
		node.right = createMinimalBST(sortedArray, mid + 1, end);
		return node;
	}
}
