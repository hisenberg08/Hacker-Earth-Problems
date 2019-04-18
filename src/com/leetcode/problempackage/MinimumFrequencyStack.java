package com.leetcode.problempackage;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class MinimumFrequencyStack {

	public static void main(String[] args) {
		
		MinimumFrequencyStack mfs= new MinimumFrequencyStack();
		mfs .push(5);
		mfs .push(7);
		mfs .push(5);
		mfs .push(7);
		mfs .push(4);
		mfs .push(5);
		System.out.println(mfs.pop());
		System.out.println(mfs.pop());
		System.out.println(mfs.pop());
		System.out.println(mfs.pop());
		
	}
	
	TreeMap<Integer, LinkedList<Integer>> map;
    Map<Integer,Integer> idx;
    
    public MinimumFrequencyStack() {
        
        this.map = new TreeMap<Integer, LinkedList<Integer>>(Collections.reverseOrder());
        this.idx = new HashMap<Integer,Integer>();
    }
    
    public void push(int x) {
        
        
        int cnt = idx.getOrDefault(x,0);
        
        map.putIfAbsent(cnt+1,new LinkedList<Integer>());
        map.get(cnt+1).addFirst(x);
        idx.put(x,cnt+1);
    }
    
    public int pop() {
        
        int x = map.firstEntry().getKey();
    	int toReturn  = map.get(x).getFirst();
        if(map.get(x).size() == 1){
            map.remove(x);
        }else {
        	map.get(x).removeFirst();
        }
        
        idx.put(toReturn, x-1);
        
        return toReturn;
    }

}
