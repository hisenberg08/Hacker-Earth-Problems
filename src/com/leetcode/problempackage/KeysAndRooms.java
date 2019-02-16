
//Leetcode problem number 841

package com.leetcode.problempackage;

import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class KeysAndRooms {
	
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
	     
        Stack<Integer> availableKeys = new Stack<Integer>();
        HashSet<Integer> notVisited = new HashSet<Integer>();
        
        for(int t=0;t<rooms.size();t++)
            notVisited.add(t);
        
        availableKeys.push(0);
        while(!availableKeys.empty()){
            int currRoom = availableKeys.pop();
            notVisited.remove(currRoom);
            for (int i: rooms.get(currRoom)){
                if(notVisited.contains(i)){
                    availableKeys.push(i);
                }
            }
        }
        
        if(notVisited.size()>0) return false;
        else return true;
    }
	
}
