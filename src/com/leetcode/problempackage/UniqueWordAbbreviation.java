package com.leetcode.problempackage;

import java.util.HashSet;
import java.util.Set;

public class UniqueWordAbbreviation {

Set<String> se = new HashSet<String>();

    public UniqueWordAbbreviation(String[] dictionary) {
        
        for(String str : dictionary){
            
            String abb = createAbb(str);
            se.add(abb);
        }
    }
    
    public boolean isUnique(String word) {
        
        String abb = createAbb(word);
        
        if(!se.contains(abb)){
            
            se.add(abb);
            return true;
        }
        
        return false;
    }
    
    private String createAbb(String str){
        
        if(str.length() == 0) return str;
        
        return str.charAt(0) + Integer.toString(str.length() - 2) + str.charAt(str.length() -1);
        
    }
	public static void main(String[] args) {
		
		String [] dict = {"hello"};
		UniqueWordAbbreviation uw = new UniqueWordAbbreviation(dict);
		
		String word = "hello";
		System.out.println(uw.isUnique(word));
		
	}

}
