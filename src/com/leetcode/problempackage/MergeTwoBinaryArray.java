package com.leetcode.problempackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class MergeTwoBinaryArray {
	
	
	  public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	 
	class Solution {
	    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
	        
	        if(t1 == null && t2==null)
	            return null;
	        
	        int value = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
	        TreeNode tree = new TreeNode(value);
	        
	        tree.left = mergeTrees(t1 == null ? null : t1.left , t2 == null ? null : t2.left);
	        tree.right = mergeTrees(t1 == null ? null : t1.right , t2 == null ? null : t2.right);
	        
	            return tree;
	    }
	}

	public static class MainClass {
	    public static TreeNode stringToTreeNode(String input) {
	       MergeTwoBinaryArray mt = new MergeTwoBinaryArray();
	    	input = input.trim();
	        input = input.substring(1, input.length() - 1);
	        if (input.length() == 0) {
	            return null;
	        }
	    
	        String[] parts = input.split(",");
	        String item = parts[0];
	        TreeNode root = mt.new TreeNode(Integer.parseInt(item));
	        Queue<TreeNode> nodeQueue = new LinkedList<>();
	        nodeQueue.add(root);
	    
	        int index = 1;
	        while(!nodeQueue.isEmpty()) {
	            TreeNode node = nodeQueue.remove();
	    
	            if (index == parts.length) {
	                break;
	            }
	    
	            item = parts[index++];
	            item = item.trim();
	            if (!item.equals("null")) {
	                int leftNumber = Integer.parseInt(item);
	                node.left = mt.new TreeNode(leftNumber);
	                nodeQueue.add(node.left);
	            }
	    
	            if (index == parts.length) {
	                break;
	            }
	    
	            item = parts[index++];
	            item = item.trim();
	            if (!item.equals("null")) {
	                int rightNumber = Integer.parseInt(item);
	                node.right = mt.new TreeNode(rightNumber);
	                nodeQueue.add(node.right);
	            }
	        }
	        return root;
	    }
	    
	    public static String treeNodeToString(TreeNode root) {
	        if (root == null) {
	            return "[]";
	        }
	    
	        String output = "";
	        Queue<TreeNode> nodeQueue = new LinkedList<>();
	        nodeQueue.add(root);
	        while(!nodeQueue.isEmpty()) {
	            TreeNode node = nodeQueue.remove();
	    
	            if (node == null) {
	              output += "null, ";
	              continue;
	            }
	    
	            output += String.valueOf(node.val) + ", ";
	            nodeQueue.add(node.left);
	            nodeQueue.add(node.right);
	        }
	        return "[" + output.substring(0, output.length() - 2) + "]";
	    }
	    
	    public static void main(String[] args) throws IOException {
	        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	        String line;
	        MergeTwoBinaryArray mt = new MergeTwoBinaryArray();
	        while ((line = in.readLine()) != null) {
	            TreeNode t1 = stringToTreeNode(line);
	            line = in.readLine();
	            TreeNode t2 = stringToTreeNode(line);
	            
	            TreeNode ret = mt.new Solution().mergeTrees(t1, t2);
	            
	            String out = treeNodeToString(ret);
	            
	            System.out.print(out);
	        }
	    }
	}
	
}
