package com.leetcode.problempackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecodeString {

	public static void main(String[] args) {
		
		
		EncodeDecodeString ed = new EncodeDecodeString();
		
		List<String> strs = Arrays.asList(new String []{"He/llo","World"});
		
		
		
		String st = ed.encode(strs);
		
		List<String> lis = ed.decode(st);
		
		System.out.println(Arrays.toString(lis.toArray()));

	}

	// Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        
        for(String str : strs){
            sb.append(str.length()).append("*").append(str);
        }
        return sb.toString();
        
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        
        int i = 0;
        List<String> res = new ArrayList<String>();
        while(i<s.length()){
                
            int star = s.indexOf("*",i);
            int size = Integer.parseInt(s.substring(i,star));
            res.add(s.substring(star+1,star+size+1));
            i = star + size + 1;
        }
        return res;
    }
	
}
