package com.leetcode.problempackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	
	Map<String,List<String>> map;
	
	public static void main(String[] args) {
		
		
		WordLadder wl = new WordLadder();
		
		List<String> wordList = Arrays.asList("hot","dog");
		
		System.out.println(wl.ladderLength("hot","dog" , wordList));

	}
	
	
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
			
		Set<String> visited = new HashSet<String>();
		
		Queue<String> q = new LinkedList<String>();
		q.add(beginWord);
		visited.add(beginWord);
		
		
		int elemInThisLayer = 1;
		int elemInNextLayer = 0;
		int depth = 0;
		boolean found = false;
		while(!q.isEmpty()) {
					
			String curr = q.poll();
			if(curr.equals(endWord)) {
				found = true;
				break;
			} 
			
			elemInThisLayer--;
			for(String str: wordList) {
				if(!visited.contains(str) && dist(curr,str)) {
					q.add(str);
					visited.add(str);
					elemInNextLayer++;
				}
			}
			
			if(elemInThisLayer == 0) {
				elemInThisLayer  = elemInNextLayer;
				elemInNextLayer=0;
				depth+=1;
			}
		}
		
		if(found) return depth+1;
		return 0;
		
    }
	
	public void createMap(List<String> wordList) {
		
		this.map = new HashMap<>();
		
		for(int i=0;i<wordList.size();i++) {
			for(int j=0;j<wordList.size();j++) {
					
				String in = wordList.get(i);
				String va = wordList.get(j);
				if(dist(in, va) && !in.equals(va)) {
					if(map.containsKey(in)){
							map.get(in).add(va);	
						}else{
							map.put(in, new ArrayList<String>());
							map.get(in).add(va);
					}
				}
			}	
		}
	}
	
	
	public boolean dist(String s1, String s2) {
		
		char [] c1 = s1.toCharArray();
		char [] c2  = s2.toCharArray();
		
		int cnt = 0;
		for(int i=0;i<c1.length;i++) {
			
				if(c1[i]!= c2[i]) cnt++;
				if(cnt == 2) return false;
		}
		return true;
	}

}
