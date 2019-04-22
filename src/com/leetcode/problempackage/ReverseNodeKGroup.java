package com.leetcode.problempackage;


public class ReverseNodeKGroup {

	public static void main(String[] args) {
		
		int [] arr = {1,2,3,4,5};
		
		ListNode head = new ListNode(-1);
		ListNode curr = head;
		for(int val : arr) {
			curr.next= new ListNode(val);
			curr =curr.next;
		}
		
		ReverseNodeKGroup rn =  new ReverseNodeKGroup();
		ListNode res =rn.reverseKGroup(head.next, 3);
		while(res!=null) {
			System.out.println(res.val);
			res = res.next;
		}

	}
	
public ListNode reverseKGroup(ListNode head, int k) {
        
	ListNode first = head;
    ListNode last = first;
    ListNode dummy = new ListNode(-1);
    ListNode firstDummy = dummy;
    
    dummy.next = head;
    while(last!=null){
       
        int i = k-1;
        while(i > 0 && last != null){
            
            last = last.next;
            i--;
        }
        
        if(last == null) return firstDummy.next;
        
        i = k;
        ListNode prev = last.next;
        dummy.next = last;
        dummy  = first;
        while(i > 0){
            
            ListNode temp = first.next;
            first.next = prev;
            prev = first;
            first = temp;
            
            i--;
            
        }
        last= first;
       
    }
    
    return firstDummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    }



//while(last!=null){
//    
//    int t = k;
//    while(last!=null && t > 0){
//        
//        last = last.next;
//        t--;
//    }
//    
//    if(last == null) return head;
//    
//    ListNode prev = last;
//    while(first!=last && first!=null){
//        ListNode temp = first.next;
//        first.next = prev;
//        prev = first;
//        first = temp;
//    }
//    
//}
