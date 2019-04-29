package com.leetcode.problempackage;

public class InorderSuccessorBST {

	public static void main(String[] args) {
		
		
		InorderSuccessorBST ios = new InorderSuccessorBST();
		TreeNode root = ios.new TreeNode(7);
		root.left =ios. new TreeNode(4);
		root.left.left =ios. new TreeNode(3);
		root.left.right =ios. new TreeNode(5);
		root.left.right.right =ios. new TreeNode(6);
		root.right = ios.new TreeNode(10);
		root.right.left = ios.new TreeNode(9);
		root.right.right = ios.new TreeNode(12);
		
		System.out.println(ios.successor(root,ios.new TreeNode(4)).val);

	}

	public TreeNode successor(TreeNode root, TreeNode p) {
		  if (root == null)
		    return null;

		  if (root.val <= p.val) {
		    return successor(root.right, p);
		  } else {
		    TreeNode left = successor(root.left, p);
		    return (left != null) ? left : root;
		  }
		}

	class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
}
