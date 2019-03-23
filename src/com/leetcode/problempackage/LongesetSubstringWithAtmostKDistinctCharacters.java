package com.leetcode.problempackage;

import java.util.HashMap;
import java.util.Map;

public class LongesetSubstringWithAtmostKDistinctCharacters {

	public static void main(String[] args) {
		
		
		LongesetSubstringWithAtmostKDistinctCharacters ls = new LongesetSubstringWithAtmostKDistinctCharacters();
		
		String s = "hdjashd";
		int k =4;
		System.out.println(ls.lengthOfLongestSubstringKDistinct(s, k));

	}
	
public int lengthOfLongestSubstringKDistinct(String s, int k) {
        
        char [] ch = s.toCharArray();
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        
        int left = 0 , right = 0, maxLen = Integer.MIN_VALUE, len = 0;
        while(right<ch.length){
            char r = ch[right];
            
            if(map.containsKey(r)){
                map.replace(r,map.get(r)+1);
            }else{
                if(map.size() >= k){
                    while(map.size() >= k){
                        int cnt = map.get(ch[left]);
                        if(cnt > 1){
                            map.replace(ch[left],cnt-1);
                        }else{
                            map.remove(ch[left]);
                        }
                        left++;
                    }
                }
                map.put(r,1);
            }
            right++;
            
            len = right - left;
            if(len > maxLen) maxLen  = len;
        }
        
        return maxLen;
    }

}
