package com.leetcode.problempackage;
 
//Leetcode problem number 2

class AddTwoNumbers {
   
	  //Definition for singly-linked list.
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	 }
	  
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int sum =0;
        ListNode finalList = new ListNode(0);
        ListNode finalHead = finalList;
        int carry = 0;
        while(l1 != null || l2!=null || carry!=0){
            int l1Val = 0,l2Val = 0;
            if(l1 != null && l2!= null){
                l1Val = l1.val;
                l2Val = l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }else if(l1 != null){
                 l1Val = l1.val;
                 l1 = l1.next;
            }else if(l2 != null){
                l2Val = l2.val;
                l2 = l2.next;
            }
            sum = l1Val + l2Val + carry;
            carry = sum/10;
            sum = sum%10;
            ListNode currNode = new ListNode(sum);
            finalList.next = currNode;
            finalList = finalList.next;
        }
        return finalHead.next;
    }
}