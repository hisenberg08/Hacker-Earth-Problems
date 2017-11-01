package com.leetcode.problempackage;
import java.util.HashMap;
import java.util.Map;

/*Below is the code for finding the substring of max length with no duplicates in a given string.
 * 	If same n substrings are of equal length then these codes return the first max substrings. 
 * 
 *  The first method longestSubstring uses brute force and takes a time between O(n) and O(n^2).
 *  In this whenever a duplicate is encountered pointer moves to the location of collision in substring
 *  and start checking from collision element to onward again. This leads to multiple calculations for
 *  the same set of data.
 *  
 *  The second method betterCodeForlongestSubstring uses an efficient algorithm.
 *  This method ensures a worst case runtime of O(n).
 *  Whenever a duplicate is encountered we store the string in variable prev and compare it with current
 *  longest substring.
 *  Here we keep track of the longest required substring and compare it with the current longest.
 *  */

public class LongestSubstring {

	public static void main(String[] args) {
	
	  System.out.println(longestSubstring("abcadefgbbxyz"));
	  System.out.println(betterCodeForlongestSubstring("abcadefgbbxyz"));
	}

	
	 public static String longestSubstring(String s) {
	     
	        char [] c = s.toCharArray();
	        Map<Character,Integer> map = new HashMap<Character,Integer>();
	        String prev = "", now = "";
	        int i=0;
	        while(i<c.length){
	            if(!map.containsKey(c[i])){
	                map.put(c[i],i);
	                now = now+c[i];
	            }
	            else{
	            	if(now.length() >= prev.length()){
	                    prev = now;
	                    now = "";
	                    i = map.get(c[i]);
	                    map.clear();
	                }else{
	                	now = "";
	                	i = map.get(c[i]);
	                	map.clear();
	                }
	            }
	            i++;
	        }
	        if(now.length()>prev.length())
	            return now;
	        else
	            return prev;
	    }
	 
 public static String betterCodeForlongestSubstring(String s){
	 String prev = "", now = "";
	 for(int i =0;i<s.length();i++){
		 
		 if(now.indexOf(s.charAt(i)) ==-1)
			 now = now+s.charAt(i);
		 else{
			 //This is one peculiar case when duolicates are adjcent elements.
			 if(s.charAt(i) != s.charAt(i-1)){
				 if(now.length()>=prev.length()){
					 prev = now;
				 }
				 //create a substring from the next char at collision to next element in the String s.
                 now = now.substring(now.indexOf(s.charAt(i))+1,now.length())+s.charAt(i);
			 }else{
				 if(now.length()>=prev.length()){
					 prev = now;
				 }
                  now ="";
                  now = now+s.charAt(i);
             }
		 }
	 }
	 
	 if(now.length() > prev.length())
		 return now;
	 else
		 return prev;
 	}
}
