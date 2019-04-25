package com.leetcode.problempackage;

public class FirstUniqueCharacter {

	public static void main(String[] args) {
		
		FirstUniqueCharacter fuc = new FirstUniqueCharacter();
		String s = "thisisthetest";
		System.out.println(fuc.firstUniqChar(s));

	}
	
	public int firstUniqChar(String s) {
		int [] arr = new int [26];
        for(int i =0; i< s.length();i++){
            
            int loc = (int)s.charAt(i) - 97;
            System.out.println(loc);
            
            arr[loc] =+1;
            
        }
        
        for(int i = 0; i< s.length();i++){
            
            int loc = (int)s.charAt(i) - 97;
             if(arr[loc] == 1) return i;
            
        }
        
        return -1;
    }

}
