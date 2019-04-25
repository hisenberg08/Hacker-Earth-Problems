package com.leetcode.problempackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {
	
	List<String> res = new ArrayList<String>();
	 Set<String> se = new HashSet<String>();
	 Set<String> memo = new HashSet<String>();
	 public List<String> wordBreak(String s, List<String> wordDict) {
		 
		 createSet(wordDict);
		 helper(s, new StringBuilder());
		 return res;
	        
	    }
	
	 
	 public boolean helper(String rem, StringBuilder sb) {
		 
		 if(rem.length() == 0) {
			 System.out.println(sb.toString());
			 if(sb.length() > 0) sb.setLength(sb.length() -1);
			 res.add(sb.toString());
			 return true;
		 }
		 
		 if(memo.contains(rem)) return true;
		 
		 for(int i = 1; i<=rem.length();i++) {
			 
			 String curr = rem.substring(0, i);
			 if(se.contains(curr)) {
				 
				 StringBuilder sbNew = new StringBuilder(sb.toString());
				 sbNew.append(curr);
				 sbNew.append(" ");
				 if(helper(rem.substring(i), sbNew)) {
					 memo.add(rem);
					 continue;
				 }else {
					 return false;
				 }
			 }
		 }
		 return true;
	 }
	 
	 public void createSet(List<String> wordDict) {
		 
		 for(String str : wordDict) {
			 se.add(str);
		 }
	 }
	 
	 public static void main(String [] args) {
		 
		 WordBreakII  wb = new WordBreakII();
		 String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		 List<String> wordDict = Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
		 wb.wordBreak(s, wordDict);
		 
		 for(String str: wb.res) {
			 System.out.println(str);
		 }
	 }
}
