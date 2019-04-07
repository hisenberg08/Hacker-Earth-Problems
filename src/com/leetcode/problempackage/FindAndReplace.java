package com.leetcode.problempackage;

import java.util.Map;
import java.util.TreeMap;

public class FindAndReplace {

	public static void main(String[] args) {
		
		
		FindAndReplace far = new FindAndReplace();
		
		String S = "jjievdtjfb";
		int [] indexes = {4,6,1};
		String [] sources = {"md","tjgb","jf"};
		String [] targets = {"foe","oov","e"};
		
		far.findReplaceString(S, indexes, sources, targets);

	}
	
public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
 
        
        Map<Integer,Integer> map = new TreeMap<Integer,Integer>();
        
        for(int i=0;i<indexes.length;i++) map.put(indexes[i],i);
    
        int curr = 0;
        int last = curr;
        StringBuilder sb = new StringBuilder();
        
        for(int i: map.keySet()){
            curr = i;
            String src = sources[map.get(curr)];
            int srcLen = src.length();
            
            if(curr!=last) sb.append(S.substring(last,curr));
            if(S.substring(curr,curr+srcLen).equals(src)){
                sb.append(targets[map.get(curr)]);
                last = curr;
            }else{
                sb.append(S.substring(curr,curr+srcLen));
            }
            last = curr+srcLen;
        }
        if(last<S.length()) sb.append(S.substring(last,S.length()));
        return sb.toString();
    }

}
