package com.leetcode.problempackage;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	
	public static void main(String [] args) {
		
		LRUCache lru = new LRUCache(2);
		System.out.println(lru.get(2));
		lru.put(2, 6);
		System.out.println(lru.get(1));
		lru.put(1, 5);
		lru.put(1, 2);
		System.out.println(lru.get(1));
		System.out.println(lru.get(2));
		
	}
	
	Map<Integer, Node> cache;
	int capacity;
	
		public LRUCache(int capacity) {
	        
			this.cache = new HashMap<>();
			this.capacity = capacity;
			
	    }
	    
	    public int get(int key) {
	        
	    	if(cache.containsKey(key)) {
	    		
	    		Node node = cache.get(key);
	    		moveToTail(node);
	    		return node.val;
	    	}
	    	
	    	return -1;
	    }
	    
	    public void put(int key, int value) {
	        
	    	Node node = new Node(key,value);
	    	
	    	if(cache.containsKey(key)){
	    		Node slateNode= cache.get(key); 
	    		
	    		deleteFromList(slateNode);
	    		insertToTail(node);
	    		cache.put(key, node);
	    		return;
	    	}
	    	
	    	if(cache.size() == capacity) {
	    		
	    		cache.remove(head.key);
	    		deleteFromList(head);
	    		
	    	}

	    	insertToTail(node);
    		cache.put(key, node);
	    }
	    
	    Node head = null;
		Node tail = null;
		
		public void insertToTail(Node node) {
			
			if(head == null && tail == head) {
				
				head = node;
				tail = head;
			}else {
				
				tail.right = node;
				node.left = tail;
				tail = tail.right;
				
			}
		}
		
		public void deleteFromList(Node node) {
			
			if(node.left == null && node.right == null) {				//only element in the list
				
				head = null;
				tail = head;
			}else if(node.left != null && node.right != null) {		//deleting the middle element	
				
				node.left.right = node.right;
				node.right.left= node.left;
				
			}else if(node.left == null) {											//deleting the first element
				
				head = head.right;
				head.left = null;
			}else if(node.right == null){											//deleting the last element
				
				tail = tail.left;
				tail.right = null;
			}
		}
		
		public void moveToTail(Node node) {
			
			deleteFromList(node);
			insertToTail(node);
			
		}
}

class Node {
	
	public int val;
	public int key;
	public Node left;
	public Node right;
	
	public Node(int key, int val){
		
		this.val = val;
		this.key = key;
		this.left = null;
		this.right = null;
	}
	
}	

