//leetcode problem 23

package com.leetcode.problempackage;
public class MergekSortedList {

	public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
}
public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists.length == 0)
            return null;
        
        if(lists.length ==1)
            return lists[0];
        
        ListNode finalList = new ListNode(10);
        ListNode finalHead = finalList;
        int headToIncrement = 0;
        boolean finshed = false;
        while(!finshed){
        	ListNode minNode = new ListNode(99999);
        	boolean current = false;
        	boolean total = true;
        	for(int i=0;i<lists.length;i++){
            	if(lists[i]== null) {
            		current = true;
                }else if(lists[i].val<minNode.val) {
                    minNode.val = lists[i].val;
                    headToIncrement = i;
                    current = false;
                }
            	total = current && total;
            }
        	finshed = total;
            if(lists[headToIncrement]!=null) {
            	int nodeVal = lists[headToIncrement].val;
                ListNode newNode = new ListNode(nodeVal);
                finalList.next = newNode;
                finalList = finalList.next;
                lists[headToIncrement] = lists[headToIncrement].next;
            }
        }
        
       return finalHead.next;
    }	
}
