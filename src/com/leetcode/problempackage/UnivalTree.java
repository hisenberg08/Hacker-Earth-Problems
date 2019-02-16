package com.leetcode.problempackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class UnivalTree {
	
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	
	class Solution {
	    int value = -99999;
	    boolean result = true;
	    public boolean isUnivalTree(TreeNode root) {
	    	if(result == false)
	    		return false;        
	        if(root.left!= null) 
	    		result = isUnivalTree(root.left);
	        if(value  == -99999)
	            value = root.val;
	        else
	            if(root.val != value)
	                return false;
	        if(root.right!= null) 
	        	result = isUnivalTree(root.right);
	        return result;
	    }
	}


	
    public static TreeNode stringToTreeNode(String input) {
    	UnivalTree ut = new UnivalTree();
    	input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }
    
        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = ut.new TreeNode(Integer.parseInt(item));
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
                node.left = ut.new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }
    
            if (index == parts.length) {
                break;
            }
    
            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = ut.new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }
    
    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);
            UnivalTree ut = new UnivalTree();
            boolean ret = ut.new Solution().isUnivalTree(root);
            
            String out = booleanToString(ret);
            
            System.out.print(out);
        }
    }
}
