package com.leetcode.problempackage;

public class WiggleSort {

	public static void main(String[] args) {
			
		WiggleSort ws = new WiggleSort();
		int [] arr = {1,3,4,2};
		ws.wiggleSort(arr);

		for(int i: arr) System.out.print(i + " ");
		
	}
	
public void wiggleSort(int[] arr) {
	
	boolean flag = false;
	
	if(arr.length == 0 || arr.length == 1) return;
	int temp = -1;
	int i =1;
		while(i<arr.length) {
			if(!flag) {
				if(arr[i-1] > arr[i]) {
					temp = arr[i-1];
	    			arr[i-1] = arr[i];
	    			arr[i] = temp;
				}
			}else {
				if(arr[i-1]<arr[i]) {
					temp = arr[i-1];
	    			arr[i-1] = arr[i];
	    			arr[i] = temp;
				}
			}
			flag=!flag;
			i+=1;
		}
    }
}
