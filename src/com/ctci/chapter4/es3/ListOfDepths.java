package com.ctci.chapter4.es3;

import java.util.ArrayList;
import java.util.List;

import com.ctci.chapter4.es2.BTreePrinter;
import com.ctci.chapter4.es2.TreeNode;

public class ListOfDepths {

	public static void main(String[] args) {
		
		int [] array = {0,1,2,3,4,5,6};
		TreeNode root = createMinimalBST(array);
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
		//lists.add(0, new ArrayList<TreeNode>());
		listOfDepths(root, lists, 0);
		return lists;
	}
	
	private static void listOfDepths(TreeNode node, List<List<TreeNode>> lists, int depth){
		if (node == null) return;
		if (lists.size() -1 < depth){
			lists.add(depth, new ArrayList<TreeNode>());
		}
		lists.get(depth).add(node);
		listOfDepths(node.left, lists, depth + 1);
		listOfDepths(node.right, lists, depth + 1);
	}

	
	
	public static TreeNode createMinimalBST(int[] sortedArray){
		return createMinimalBST(sortedArray, 0, sortedArray.length - 1);
	}

	private static TreeNode createMinimalBST(int[] sortedArray, int start, int end){
		if(end < start) return null;
		int mid = (start + end)/2;
		TreeNode node = new TreeNode(sortedArray[mid]);
		node.left = createMinimalBST(sortedArray, start, mid - 1);
		node.right = createMinimalBST(sortedArray, mid + 1, end);
		return node;
	}
}
