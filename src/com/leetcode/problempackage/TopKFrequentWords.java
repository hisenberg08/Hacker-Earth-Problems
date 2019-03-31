package com.leetcode.problempackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {

	public static void main(String[] args) {
		
		
		TopKFrequentWords tk = new TopKFrequentWords();
		String []  lis = {"i", "love", "leetcode", "i", "love", "coding"};
		List<String> res = tk.topKFrequent(lis, 2);;
		
		
		for(String str : res) System.out.print(str + " ,");
		

	}
	
public List<String> topKFrequent(String[] words, int k) {
        
        Map<String, Integer> map = new HashMap<String,Integer>();
        for(String word: words ){
            map.put(word, map.getOrDefault(word,0)+1);
        }
        
        PriorityQueue<String> pq = new PriorityQueue<String>( 
        (w1, w2) -> map.get(w1) == map.get(w2) ? w1.compareTo(w2) 
            : map.get(w1) - map.get(w2));
        
        for(String s: map.keySet()) {
        		pq.add(s);
        		if(pq.size()>k) pq.poll();
        }
        
    
        List<String> res = new ArrayList<String>();
        while(k>0) {
         res.add(pq.poll());
            k--;
        }
        
        return res;
    }

}
