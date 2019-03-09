package com.leetcode.problempackage;

public class FirstUniqueCharacterInString {

	public static void main(String[] args) {
		
		FirstUniqueCharacterInString fucis = new FirstUniqueCharacterInString();
		String s = "leetcode";
		System.out.println(fucis.firstUniqChar(s));
	}
	
	public int firstUniqChar(String s) {
	        
		Integer [] fb = new Integer[26];
        int val = 0;
        for(int i=0;i<s.length();i++){
            val = s.charAt(i)-97;
            if(fb[val] == null) fb[val] =0;
            else if(fb[val] == 0) fb[val] = 1;
        }
        
         for(int i=0;i<s.length();i++){
        	 val = s.charAt(i)-97;
        	 if(fb[val] == 0) return i;
         }
        return -1;
	    }
	
}
