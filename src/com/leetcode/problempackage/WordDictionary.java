package com.leetcode.problempackage;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {

private TrieNode root;
    
    class TrieNode{
        
        Map<Character, TrieNode> map;
        boolean isWord;
        
        public TrieNode(){
            
            this.map = new HashMap<Character, TrieNode>();
            this.isWord = false;
        }
    }

    /** Initialize your data structure here. */
    public WordDictionary() {
        
        this.root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        
        TrieNode curr = root;
        int i = 0;
        while(i< word.length()){
            
           curr.map.putIfAbsent(word.charAt(i), new TrieNode());
           curr = curr.map.get(word.charAt(i));
           i++;
            
        }
        
        curr.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        
        return helper(root, word);
        
    }
    
    private boolean helper(TrieNode curr, String rem){
        
        if(rem.length() == 0) {
        	
        	if(curr.isWord) return true;
        	else return false;
        }
        
        if(rem.charAt(0)!= '.'){
            
            if(!curr.map.containsKey(rem.charAt(0))){
                
                return false;
            }else{
                
                return helper(curr.map.get(rem.charAt(0)), rem.substring(1));
                
            }
        }else{
            
            for(Character ch : curr.map.keySet()){
                
                if(helper(curr.map.get(ch), rem.substring(1))) return true;
                
            }
            return false;
            
        }
    }
	
	public static void main(String[] args) {
		
		WordDictionary wd =new WordDictionary();
		
		wd.addWord("a");
		wd.addWord("a");
		
		System.out.println(wd.search("."));
		System.out.println(wd.search("a"));
		System.out.println(wd.search("aa"));
		System.out.println(wd.search("a"));
		System.out.println(wd.search(".a"));
		System.out.println(wd.search("a."));

	}

}
