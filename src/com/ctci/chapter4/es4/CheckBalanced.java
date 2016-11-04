package com.ctci.chapter4.es4;

import java.util.HashMap;
import java.util.Random;


public class CheckBalanced {

	public static void main(String[] args) {

		Random random = new Random();

		TreeNode root = null;
		root = TreeNode.TInsert(null, random.nextInt(100) + 1);

		for(int i = 2;i<6;i++){
			TreeNode.TInsert(root, random.nextInt(100) + 1);
		}

		BTreePrinter.prinTreeNode(root);

		System.out.println(checkBalancedCTCI(root));
	}

	/*
	 * my impl
	 */
	public static boolean checkBalanced(TreeNode node){		
		HashMap<TreeNode, Integer> heights = new HashMap<>();
		height(node, heights); 		
		for(TreeNode n: heights.keySet()){
			if(heights.get(n) > 1){
				if(Math.abs(heights.get(n.left) - heights.get(n.right)) > 1)
					return false;
			}
		}
		return true;
	}

	private static int height(TreeNode node, HashMap<TreeNode, Integer> heights){
		if(node == null){
			heights.put(node, 0);
			return 0;
		} else {
			int height = 1 + Math.max(height(node.left, heights), height(node.right ,heights));
			heights.put(node, height);
			return height;
		}
	}
	
	/*
	 * bad impl
	 */
	
	private static int getHeight(TreeNode root){
		if(root==null) return -1;
		return 1 + Math.max(getHeight(root.left),getHeight(root.right));
	}
	
	public static boolean checkBalancedBad(TreeNode root){
		if(root==null) return true;
		
		int heightDiff = getHeight(root.left) - getHeight(root.right);
		if(Math.abs(heightDiff) > 1){
			return false;
		} else {
			return checkBalancedBad(root.left) && checkBalanced(root.right);
		}
	}
	
	/*
	 * book impl
	 */
	
	private static int checkHeight(TreeNode root){
		if(root==null) return -1;
		
		int leftheight = checkHeight(root.left);
		if(leftheight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
		
		int rightheight = checkHeight(root.right);
		if(rightheight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
		
		int heightDiff = leftheight - rightheight;
		if(Math.abs(heightDiff) > 1){
			return Integer.MIN_VALUE;
		} else {
			return Math.max(leftheight, rightheight) + 1;
		}
	}
	
	public static boolean checkBalancedCTCI(TreeNode root){
		return checkHeight(root) != Integer.MIN_VALUE;
	}
	
	
}
