package com.hackerearth.bstproblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Here i have used concept of nested class.

public class MonkWatchingFight {

	public class BSTNode {

		int data, subNodeCount;
		BSTNode left, right;
		
		public BSTNode(){
			data = 0;
			left = null;
			right = null;
			subNodeCount=0;
		}
		
		public BSTNode(int n){
			
			data = n;
			left = null;
			right = null;
			subNodeCount=0;
		}
		
		/**
		 * @return the data
		 */
		public int getData() {
			return data;
		}

		/**
		 * @param data the data to set
		 */
		public void setData(int data) {
			this.data = data;
		}

		/**
		 * @return the left
		 */
		public BSTNode getLeft() {
			return left;
		}

		/**
		 * @param left the left to set
		 */
		public void setLeft(BSTNode left) {
			this.left = left;
		}

		/**
		 * @return the right
		 */
		public BSTNode getRight() {
			return right;
		}

		/**
		 * @param right the right to set
		 */
		public void setRight(BSTNode right) {
			this.right = right;
		}

		/**
		 * @return the subNodeCount
		 */
		public int getSubNodeCount() {
			return subNodeCount;
		}

		/**
		 * @param subNodeCount the subNodeCount to set
		 */
		public void setSubNodeCount(int subNodeCount) {
			this.subNodeCount = subNodeCount;
		}
	}
	
	public class BSTOperationsRecursive {

		private BSTNode root;
			
			public BSTOperationsRecursive(){
				root = null;
			}
			
			public boolean isEmpty(){
				return root==null;
			}
			
			public void insert(int key){
				root = insertKey(root,key);
			}
			
			private BSTNode insertKey(BSTNode rec , int key){
				
				if(rec==null){
					rec = new BSTNode(key);
					return rec;
				}
				else if(rec.data < key) {
					rec.subNodeCount++;
					rec.right = insertKey(rec.right, key);
				}
				else if(rec.data > key){
					rec.subNodeCount++;
					rec.left = insertKey(rec.left, key); 
				}
				return rec;
			}
			
			public void display(String traversalType){
				if(traversalType.equals("inorder")) inOrderTraversal(root);
				else if(traversalType.equals("preorder")) preOrderTraversal(root);
				else postOrderTraversal(root);
			}
			
			private void inOrderTraversal(BSTNode root){
				if(root!=null){
					inOrderTraversal(root.left);
					System.out.print(" " + root.data);
					inOrderTraversal(root.right);
				}
			}
			
			private void preOrderTraversal(BSTNode root){
				if(root!=null){
					System.out.print(" " + root.data);
					preOrderTraversal(root.left);
					preOrderTraversal(root.right);
				}
			}
			
			private void postOrderTraversal(BSTNode root){
				if(root!=null){
					postOrderTraversal(root.left);
					postOrderTraversal(root.right);
					System.out.print(" " + root.data);
				}
			}
			
			public void search(int key){
				
				BSTNode searchNode = bstSearch(root, key);
				if(searchNode!=null) if(searchNode.data==key) System.out.println("key present");
				else System.out.println("key not present");
					
			}
			
			private BSTNode bstSearch(BSTNode root, int key){
					if(root==null) return null;
					else if(root.data==key) return root;
					else if(root.data>key) return bstSearch(root.left, key);
					else if(root.data<key) return bstSearch(root.right, key);
					return null;
			}
			
			public void delete(int key){
				root=deleteKey(root, key);
			}
			
			private BSTNode deleteKey(BSTNode root , int key){
				
				//This is the base condition i.e. is tree is empty.
				if(root == null) return null;
				
				root.subNodeCount--;
				//if key is greater than node recur right.
				if(root.data<key) root.right=deleteKey(root.right, key);
				
				////if key is less than node recur left.
				else if(root.data>key) root.left=deleteKey(root.left, key);
				
				else{
					
					//handles 2 condition i.e. if node to be deleated is leaf node or node with single child. 
					if(root.left==null) return root.right;
					else if(root.right==null) return root.left;
					
					//condition to handle node with both left and right child.
					else{
						
						/*provides the next element that would replace the deleted node. Its value is replaced with next biggest element.
						basically the least element of right subtree.*/
						root.data = getSuccessor(root.right);
						
						//this actually deletes the element which replaces the element to be deleted.
						root.right = deleteKey(root.right, root.data);
					}
				}
				return root;
			}
			
			private int getSuccessor(BSTNode root){
				
				int successor = root.data;
				while(root.left!=null){
					root = root.left;
					successor = root.data;
				}
				return successor;
			}
			
			//This method calculates the height of tree (i.e. longest path from root to leaf)
			
			public int getTreeHeight(){
				int treeheight=calculateHeight(root);
				return treeheight;
			}
			
			/*return statement recursively calculates the max of height left and right subtree
			 * -------Just for better understanding-----
			 * All the recursive steps are stored in the stack. For first return statement returnMax(node a,node b) next checking the node a for its left
			 * and right would be next step in recursion.  
			 * */
			private int calculateHeight(BSTNode root){
				if(root==null) return 0;
				return 1+returnMax(calculateHeight(root.left),calculateHeight(root.right));
			}
			
			private int returnMax(int x, int y){
				if(x>y) return x;
				else return y;
			}
		}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		MonkWatchingFight mef = new MonkWatchingFight();
		BSTOperationsRecursive bor = mef.new BSTOperationsRecursive();
		bf.readLine();
		String [] numArr = bf.readLine().split(" ");
		int i=0;
		while(i<numArr.length){
			bor.insert(Integer.parseInt(numArr[i]));
			i++;
		}
		System.out.println(bor.getTreeHeight());
	}

}
