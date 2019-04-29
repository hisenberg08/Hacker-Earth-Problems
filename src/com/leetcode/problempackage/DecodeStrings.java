package com.leetcode.problempackage;

import java.util.Stack;

public class DecodeStrings {

	public static void main(String[] args) {
		
		DecodeStrings ds= new DecodeStrings();
		
		String s = "a2[c3[x]t3[y]]b";
		//String s = "2[abc]3[cd]ef";
		System.out.println(ds.decodeString(s));

	}

public String decodeString(String s) {
        
        Stack<String> strSt = new Stack<String>();
        Stack<Integer> intSt = new Stack<Integer>();
        
        String res = "";
        
        int cntr = 0;
        
        for(int i=0;i<s.length();i++){
            
            if(Character.isDigit(s.charAt(i))){
                
                int j =i;
                while(j<s.length() && Character.isDigit(s.charAt(j))) j++;
                cntr = Integer.parseInt(s.substring(i,j));
                i = j-1;
            }else if(Character.isLetter(s.charAt(i))){
                
                int j =i;
                while(j<s.length() && Character.isLetter(s.charAt(j))) j++;
                res += s.substring(i,j);
                i=j-1;
            }else if(s.charAt(i) == ']'){
                
                int cnt = intSt.pop();
                String prev = strSt.pop();
                
                while(cnt > 0){
                    prev+=res;
                    cnt--;
                }
              res = prev;  
              
            }else if(s.charAt(i) == '[') {
            	
            	intSt.push(cntr);
            	strSt.push(res);
            	cntr = 0;
            	res = "";
            }
        }
        return res;
    }
	
}
