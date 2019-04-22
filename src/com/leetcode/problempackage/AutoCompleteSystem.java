package com.leetcode.problempackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class AutocompleteSystem {

	
	public static void main(String [] args) {
		
		
		String [] sentences = {"i love you","island","iroman","i love leetcode"};
		int [] times = {5,3,2,2};
		AutocompleteSystem acs = new AutocompleteSystem(sentences, times);
		
		acs.input('i');
		acs.input(' ');
		acs.input('a');
		acs.input('#');
		
		System.out.println("hello");
		
	}
	
	
    TrieNode root;
    String prefix = "";
    
    public AutocompleteSystem(String[] sentences, int[] times) {
        
        this.root = new TrieNode();
        
        for(int i=0;i<times.length;i++){
            
            add(sentences[i],times[i]);
            
        }
    }
    
    public List<String> input(char c) {
        
        if(c == '#'){
            
            add(prefix,1);
            prefix = "";
            return new ArrayList<String>();
        }
        
        prefix = prefix + c;
        
        TrieNode curr = root;
        
        int i=0;
        while(i < prefix.length()){
            
            TrieNode next = curr.children.get(prefix.charAt(i));
            
            if(next == null){
                
                return new ArrayList<String>();
                
            }
            curr = next;
            i++;
        }
        
        PriorityQueue<Pair> pq = 
            new PriorityQueue<>( (a,b) -> a.cnt == b.cnt ? a.s.compareTo(b.s) : b.cnt - a.cnt);
        
        
        for(String str : curr.counts.keySet()){
            
            
            pq.add(new Pair(str, curr.counts.get(str)));
            
        }
        
        int t = 0;
        List<String> res = new ArrayList<String>();
        while(t < 3 && !pq.isEmpty()){
            
            res.add(pq.poll().s);
            t++;
        }
        
        return res;
    }
    
    
    public void add(String s , int cnt){
        
        TrieNode curr = root;
        char [] arr = s.toCharArray();
        
        
        for(char ch : arr){
            
            curr.children.putIfAbsent(ch,new TrieNode());
            curr = curr.children.get(ch);
            curr.counts.put(s , curr.counts.getOrDefault(s,0) + cnt);
            
        }
        
    }
    
}


class TrieNode{
    
    public Map<Character, TrieNode> children;
    public Map<String, Integer> counts;
    
    public TrieNode(){
        
        this.children = new HashMap<Character, TrieNode>();
        this.counts = new HashMap<String, Integer>();
    }
}

class Pair{
    
    String s;
    int cnt;
    
    public Pair(String s, int c){
        
        this.s = s;
        this.cnt = c;
    }
}