package com.leetcode.problempackage;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserialIzeBinaryTree {

	public static void main(String[] args) {
		
		TreeNode tn = new TreeNode(1);
		TreeNode head = tn;
		tn.left = new TreeNode(2);
		tn.right = new TreeNode(3);
		
		tn = tn.right;
		tn.left = new TreeNode(4);
		tn.right = new TreeNode(5);
		
		
		
		SerializeAndDeserialIzeBinaryTree st = new SerializeAndDeserialIzeBinaryTree();
		//String str = st.serialize(null);
		
		TreeNode root = st.deserialize("5,2,3,null,null,2,4,3,1,null,null,null,null,null,null");
		System.out.println(st.serialize(root));
		
		
		
	}
	
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> qu = new LinkedList<TreeNode>();
        
        qu.add(root);
        TreeNode curr;
        while(!qu.isEmpty()){
            
            curr = qu.poll();
            if(curr!=null) sb.append(curr.val);
            else sb.append("null");
            sb.append(',');
            if(curr!=null) qu.add(curr.left);
            if(curr!=null) qu.add(curr.right);
        }
        
        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        
        TreeNode root = null;
        
        String [] st = data.split(",");
        
        if(st[0].equals(null)) return root;
        
        TreeNode []  re = new TreeNode [st.length];
        
        for(int i=0;i<re.length;i++) {
        	if (!st[i].equals("null")) re[i] = new TreeNode(Integer.parseInt(st[i]));
        	else re[i] = null;
        }

        int nullcnt = 0;
        for(int i=0;i<re.length;i++) {
        	
        	int depth = (i == 0 || i == 1) ? i  : (int) ((Math.log(i))/Math.log(2))+1;
        	
        	int valToLookLeft = 2*depth +1;
        	int valToLookRight = 2*depth +2;
        	
        	boolean isNull = false;
        	if(valToLookLeft < re.length) {
        		if(re[i]!=null) re[i].left = re[valToLookLeft];
        		else {
        			nullcnt ++;
        			isNull = true;
        		}
        	}
        	
        	if(valToLookRight < re.length && !isNull) {
        		if(re[i]!=null) re[i].right = re[i].right = re[valToLookRight];
        		else nullcnt ++;
        	}
        }
        return re[0];
    }
	

}



 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
 