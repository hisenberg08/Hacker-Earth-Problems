package com.leetcode.problempackage;

public class IsPalindrome {

	public static void main(String[] args) {
		
		
		IsPalindrome ip = new IsPalindrome();
		String s = "...;;;";
		System.out.println(ip.isPalindrome(s));

	}
	
public boolean isPalindrome(String s) {
        
        char [] ch = s.toLowerCase().toCharArray();
        int i = 0;
        int j  = ch.length-1;
        boolean flag = false;
        while(i<j){
            if((Character.isLetter(ch[i]) || Character.isDigit(ch[i]))
                && (Character.isLetter(ch[j]) || Character.isDigit(ch[j]))){
                if(ch[i] != ch[j]){
                    flag = true;
                    break;
                }else{
                    i++;
                    j--;
                }
            }else {
            	 if((!Character.isLetter(ch[i]) || !Character.isDigit(ch[i]))
                         && (Character.isLetter(ch[j]) || Character.isDigit(ch[j]))){
                           i++;
                       }
            	 else if((!Character.isLetter(ch[j]) || !Character.isDigit(ch[j]))
                     && (Character.isLetter(ch[i]) || Character.isDigit(ch[i]))){
                       j--;
                   }else {
                   	i++;
                	j--;
                }
            }
        }
        if(flag) return false;
        else return true;
    }

}
