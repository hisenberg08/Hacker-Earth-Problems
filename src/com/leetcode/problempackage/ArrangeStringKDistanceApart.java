package com.leetcode.problempackage;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ArrangeStringKDistanceApart {

public String rearrangeString(String s, int k) {
        
        char [] arr = s.toCharArray();
        
        Map<Character , Integer> map = new HashMap<>();
        
        for(char ch : arr){
            map.put(ch,map.getOrDefault(ch,0) + 1);
        }
        
        PriorityQueue<int []> pq = new PriorityQueue<>(new Comparator<int []>(){
           
            public int compare(int [] a, int [] b){
                
                if(a[1] > b[1]) return -1;
                
                else return 1;
            }
        });
        
        for(char ch : map.keySet()) {
        	pq.add(new int [] {ch, map.get(ch)});
        }
        
        Queue<int []> waitq = new LinkedList<>();
        
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            
            int [] poll = pq.poll();
            
            if(poll[1] == 0) break;
            
            sb.append((char) poll[0]);
            if(--poll[1] > -1){
                waitq.add(poll);
            }
            
            if(waitq.size() == k && !waitq.isEmpty()){
                
                pq.add(waitq.poll());
            }
            
        }
        
        String ans = sb.toString().length() == s.length() ? sb.toString() : "";
        return ans;
    }
	
	public static void main(String[] args) {
		
		ArrangeStringKDistanceApart as = new ArrangeStringKDistanceApart();
		String s = "aaabc";
		int k = 2;
		System.out.println(as.rearrangeString(s, k));

	}

}
