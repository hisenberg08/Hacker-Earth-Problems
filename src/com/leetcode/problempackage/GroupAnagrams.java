package com.leetcode.problempackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public static void main(String[] args) {
		
		String [] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		
		GroupAnagrams ga = new GroupAnagrams();
		List<List<String>> groupedAnagrams = ga.groupAnagrams(strs);
		for(List<String> lis: groupedAnagrams) {
			for(String st: lis) {
				System.out.print(st + ",");
			}
			System.out.println("");
		}
	}

public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> res = new ArrayList<>();
        if(strs.length == 0) return res;
        
        Map<String,Integer> rec = new HashMap<String, Integer>();
        int i = 0;
        for(String str: strs){
            char [] ch = str.toCharArray();
            Arrays.sort(ch);
            String check = String.valueOf(ch);
            if(rec.containsKey(check)){
                int listNum = rec.get(check);
                res.get(listNum).add(str);
            }else{
                List<String> newLis = new ArrayList<>();
                newLis.add(str);
                res.add(newLis);
                rec.put(check,i);
                i++;
            }
        }
        return res;
    }
}
