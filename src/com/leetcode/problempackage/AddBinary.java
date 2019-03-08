package com.leetcode.problempackage;

import java.util.Stack;

public class AddBinary {

	public static void main(String[] args) {
		
		AddBinary ab = new AddBinary();
		String a = "10101001";
		String b = "1001010";
		System.out.println(ab.addBinary(a, b));

	}

	 public String addBinary(String a, String b) {
		int i=0;
        int carry = 0;
        Stack<Integer> st = new Stack<Integer>();
        int al = a.length()-1;
        int bl = b.length()-1;
        while(al>-1 && bl>-1){
            
            int aVal = Character.getNumericValue(a.charAt(al));
            int bVal = Character.getNumericValue(b.charAt(bl));
            
            int sum = aVal + bVal + carry;
            carry = sum/2;
            st.push(sum%2);
            al--;
            bl--;
        }
        
        while(al>-1){
            int aVal = Character.getNumericValue(a.charAt(al));
            
            int sum = aVal + carry;
            carry = sum/2;
            st.push(sum%2);
            al--;
        }
        
        while(bl>-1){
            
            int bVal = Character.getNumericValue(b.charAt(bl));
            
            int sum = bVal + carry;
            carry = sum/2;
            st.push(sum%2);
            bl--;
        }
        if(carry!=0) st.push(carry);
        
        StringBuffer sb = new StringBuffer();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        
        return sb.toString();
	}
}
