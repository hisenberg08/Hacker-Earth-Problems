package com.leetcode.problempackage;

/*
One interesting point here is number of final recursions remain the same irrespective of the correctness of the string, i.e. if the string is 
correct both naive solution and the better one recurse for the same number of times, but as soon as we make a slight change in the 
input string number of recursive steps increases drastically. But with the help of memoization we can contain the number of recursive by
keeping track of the string which leads to incorrect answers.

for correct string (returning true)

len of string: 224
memo hit 0
total recursions: 225
final recursions: 225


for incorrect string (returning false)

len of string: 224
memo hit 1962
total recursions: 2186
final recursions: 224
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

	
	Set<String> set = new HashSet<>();
	Set<String> danger = new HashSet<>();
    boolean res = false;
    Set<String> memo = new HashSet<>();
    
    // variables to better understand the recursion counts
    int memocnt = 0;
    int cnt = 0;
    
	public static void main(String[] args) {
			
		WordBreak wb = new WordBreak();
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		List<String> wordDict = Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
		System.out.println(wb.wordBreak(s, wordDict));
		
	}
	
	    public boolean wordBreak(String s, List<String> wordDict) {
	     
	        for(String st: wordDict) set.add(st);
	        
	        System.out.println("len of string: " + s.length());
	        boolean res =helper(s); 
	         
	        System.out.println("memo hit " +(memocnt));
	        
	        System.out.println("total recursions: " +(cnt));
	        
	        System.out.println("final recursions: " +(cnt - memocnt));
	        return res;
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
	    
	    
	    
	    public boolean helper(String rem) {
	    	cnt++;
	        if(rem.length() == 0) {
	            return true;
	        }
	        
	        if(memo.contains(rem)) {
	        	memocnt++;
	        	return false;
	        }
	        
	        for(int i=1;i<=rem.length();i++){
		            
		            String curr = rem.substring(0,i);
		            if(set.contains(curr)){
		                if(helper(rem.substring(i))) {
	                        return true;
		                }
		                
		            }
		        }
	        	
	        memo.add(rem);
	        return false;
	    	
	    }
}
