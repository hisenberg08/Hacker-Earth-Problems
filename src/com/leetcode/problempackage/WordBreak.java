package com.leetcode.problempackage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

	
	Set<String> set = new HashSet<>();
	Set<String> danger = new HashSet<>();
    boolean res = false;
    
	public static void main(String[] args) {
			
		WordBreak wb = new WordBreak();
		String s = "cars";
		List<String> wordDict = Arrays.asList("car","ca","rs");
		System.out.println(wb.wordBreak(s, wordDict));
		
	}
	
	    public boolean wordBreak(String s, List<String> wordDict) {
	     
	        for(String st: wordDict) set.add(st);
	        return checkWord(s);
	    }
	    
	    
	    public boolean checkWord(String rem){
	        if(set.contains(rem)) return true;
	        if(rem.length() == 0) return true;
	        
	        for(int i=1;i<rem.length();i++){
	            String f = rem.substring(0,i);
	            if(set.contains(f)) {
	                int j = i;
	            	while(set.contains(rem.substring(0,j+1)))j++;
	                f = rem.substring(0,j);
	                boolean flag  = false;
	                if(!danger.contains(f)) {
	                	res = res || checkWord(rem.substring(j));
	                	if(!res){
	                		danger.add(f);
	                		flag = true;
	                	}
	                }
	                if(flag)
	                	res = res || checkWord(rem.substring(i));
	            }
	        }
	        return res;
	    }

}
