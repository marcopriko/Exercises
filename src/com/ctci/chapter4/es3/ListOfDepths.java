package com.ctci.chapter4.es3;

import java.util.ArrayList;
import java.util.List;


public class ListOfDepths {

	public static void main(String[] args) {
		
		int [] unsortedArray = {0,1,2,3,4,5,6,7,8,9};
		TreeNode root = TreeNode.createMinimalBT(unsortedArray);
		BTreePrinter.prinTreeNode(root);
		
		List<List<TreeNode>> lists = listOfDepths(root);
		
		for(List<TreeNode> list: lists){
			for(TreeNode node: list){
				System.out.print(node.data + " ");
			}
			System.out.println();
		}
	}
	
	public static List<List<TreeNode>> listOfDepths(TreeNode root){
		List<List<TreeNode>> lists = new ArrayList<>();
		listOfDepths(root, lists, 0);
		return lists;
	}
	
	private static void listOfDepths(TreeNode node, List<List<TreeNode>> lists, int depth){
		if (node == null) return;
		if (lists.size() == depth){
			lists.add(depth, new ArrayList<TreeNode>());
		}
		lists.get(depth).add(node);
		listOfDepths(node.left, lists, depth + 1);
		listOfDepths(node.right, lists, depth + 1);
	}

	
	

}
