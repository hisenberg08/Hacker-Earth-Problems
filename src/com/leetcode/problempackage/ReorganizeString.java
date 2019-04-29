package com.leetcode.problempackage;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {

	public static void main(String[] args) {
		
		
		ReorganizeString rs = new ReorganizeString();
		String S = "vvvlo";
		System.out.println(rs.reorganizeString(S));

	}
	
public String reorganizeString(String S) {
        
        char [] arr = S.toCharArray();
        
        Map<Character, Integer> map = new HashMap<Character,Integer>();
        
        for(char ch: arr){
            
            map.put(ch, map.getOrDefault(ch,0)+1);
            
            if(map.get(ch) > (S.length() +1) / 2)
                return "";
        }
        
        PriorityQueue<int []> pq = new PriorityQueue<>( (a,b) -> b[1] - a[1] );
        
        for(Character ch : map.keySet()){
            
            pq.add(new int [] {ch, map.get(ch)});
        }
        
        
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            
            int [] first = pq.poll();
            
            if(sb.length() == 0 || first[0] != sb.charAt(sb.length() -1)){
                
                sb.append((char)first[0]);
                
                if(--first[1] > 0){
                    pq.add(first);
                }
            }else{
                int [] second =pq.poll();
                sb.append((char) second[0]);
                
                if(--second[1] > 0){
                    pq.add(second);
                }
                pq.add(first);
            }
        }
        return sb.toString();
    }

}
