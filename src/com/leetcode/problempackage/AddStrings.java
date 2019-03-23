package com.leetcode.problempackage;

public class AddStrings {

	public static void main(String[] args) {
		
		AddStrings as = new AddStrings();
		String n1 = "1234453";
		String n2 = "23324";
		System.out.println(as.addStrings(n1, n2));

	}
	
public String addStrings(String n1, String n2) {
        
        int i= n1.length()-1;
        int j= n2.length()-1;
        
        int a = 0;
        int b = 0;
        int carry = 0;
        int sum = 0;
        
        StringBuffer sb = new StringBuffer();
        
        while(i>=0 && j>=0){
            a = n1.charAt(i) - '0';
            b = n2.charAt(j) - '0';
            sum = a + b + carry;
            sb.append(sum%10);
            carry = sum/10;
            i--;
            j--;
        }
        
        while(i>0){
            a = n1.charAt(i) - '0';
            sum = a + carry;
            sb.append(sum%10);
            carry = sum/10;
            i--;
        }
        
        
        while(j>0){
            b = n2.charAt(j) - '0';
            sum = b + carry;
            sb.append(sum%10);
            carry = sum/10;
            j--;
        }
        System.out.println(carry);
        
        if(carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

}
