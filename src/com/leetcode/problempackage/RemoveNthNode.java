//Leetcode problem 19

package com.leetcode.problempackage;

public class RemoveNthNode {

	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	class Solution {
	    public ListNode removeNthFromEnd(ListNode head, int n) {
	        
	        if(head == null)
	            return head;
	        
	        ListNode originalHead = head;
	        ListNode toRemove = head;
	        ListNode prevNode = null;
	        
	        n = -n +1;
	        while(head.next!=null){
	            n++;
	            head = head.next;
	            if(n>0){
	                prevNode = toRemove;
	                toRemove = toRemove.next;
	                
	            }
	        }
	        if(n>0) prevNode.next = prevNode.next.next;
	        if(toRemove.equals(originalHead)) originalHead = originalHead.next;
	        return originalHead;
	    }
	}
}


/* Sample input 

[1,2,3,4,5]
2

Answer: [1,2,3,5] */
