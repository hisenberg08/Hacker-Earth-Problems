package com.leetcode.problempackage;

public class PlusOne {

	public static void main(String[] args) {
		
		PlusOne po = new PlusOne();
		int [] i = {9,9,9}; 
		i = po.plusOne(i);
		for(int j: i)System.out.print(j + " ");

	}
	
public int[] plusOne(int[] d) {
        
        int carry = 1;
        int val  = 0;
        for(int i=d.length-1 ; i>=0 ; i--){
            val = d[i] + carry;
            carry = val/10;
            d[i] = val%10;
        }
        
        if(carry > 0){
            int [] temp = new int[d.length+1];
            temp[0] = carry;
            for(int i=1;i<temp.length ; i ++){
                temp[i] = d[i-1];
            }
            return temp;
        }
    return d;
    }

}
