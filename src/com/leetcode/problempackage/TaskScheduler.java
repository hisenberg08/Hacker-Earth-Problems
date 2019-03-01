package com.leetcode.problempackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

//This solution is not perfect and it miss a few edge casees.
public class TaskScheduler {

	public static void main(String[] args) {
		
		
		TaskScheduler ts = new TaskScheduler();
		char [] t = {'A','A','A','A','A','A','B','C','D','G','E','F','G'};
		int n =2;
		System.out.println(ts.leastInterval(t, n));
	}
	
public int leastInterval(char[] t, int n) {
        
        Map<Character,Integer> map = new HashMap<>();
        Queue<Character> q = new LinkedList<>();
        for(int i=0;i<t.length;i++){
            if(map.containsKey(t[i])) map.put(t[i],map.get(t[i])+1);
            else map.put(t[i],1);  
        }
        
        map =map.entrySet()
                .stream()
                .sorted((Map.Entry.<Character, Integer>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        
        for (Character key : map.keySet()) {
        	q.add(key);
        }
        
        List<Character> lis = new ArrayList<>();
        int currLoc = 0;
        int cnt = 0;
        int start=0;
        while(!map.isEmpty()){
            currLoc = lis.size()-1;
            char ch = q.peek();
            
            if(currLoc-n<0) start = 0;
            else start = currLoc-n;
            
            boolean found = false;
            
            for(int i = start+1;i<=currLoc;i++){
                if(lis.get(i) == ch) {
                    found = true;
                    break;
                }
            }
            if(found) lis.add('\n');
            else {
             lis.add(ch);
             q.poll();
             if(map.get(ch) == 1) map.remove(ch);
             else {
              map.put(ch,map.get(ch) -1);       
              q.add(ch);
             }
            }
            cnt+=1;
        }
        for(char c: lis) System.out.print(c);
        
        return cnt;
    }

}
