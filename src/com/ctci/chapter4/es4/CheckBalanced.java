package com.ctci.chapter4.es4;

import java.util.HashMap;
import java.util.Random;


public class CheckBalanced {

	public static void main(String[] args) {
		//		int [] unsortedArray = {0,15,1,2,3,4,5,6,7,8,9,10,12,17,8};
		//		TreeNode root = TreeNode.createMinimalBT(unsortedArray);

		Random random = new Random();

		TreeNode root = null;
		root = TreeNode.TInsert(null, random.nextInt(100) + 1);

		for(int i = 2;i<6;i++){
			TreeNode.TInsert(root, random.nextInt(100) + 1);
		}

		BTreePrinter.prinTreeNode(root);

		System.out.println(checkBalanced(root));
	}

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
}
