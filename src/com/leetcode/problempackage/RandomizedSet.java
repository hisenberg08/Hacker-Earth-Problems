package com.leetcode.problempackage;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Random;

public class RandomizedSet {

    Map<Integer,Queue<Integer>> map;
    int [] arr;
    int max = -1;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<Integer,Queue<Integer>>();
        arr = new int[100];
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
    	 if(max == arr.length-5){
             int [] newArr = new int[max*3];
             for(int i=0;i<arr.length;i++)
                 newArr[i] = arr[i];
             arr = newArr;
         }
         
         arr[++max] = val;
         if(map.containsKey(val)){
             if(map.get(val).size() == 0){
                 map.get(val).add(max);
                 return true;
             }else{
                 map.get(val).add(max);
                 return false;    
             }
         }else{
             Queue<Integer> lis = new LinkedList<Integer>();
             lis.add(max);
             map.put(val, lis);
             return true;
         }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
    	if(map.containsKey(val) && map.get(val).size()>0){
            int lastElem = arr[max];
            if(max > 1){
                int index = map.get(val).poll();   
                arr[index] = lastElem;
                map.get(lastElem).add(index);
                max--;
            }else{
                map.get(val).poll();
            }
            return true; 
        }else return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        
    	Random random = new Random();
        int randomNum =  random.nextInt((max) + 1);
        return arr[randomNum];
    }
    
    public static void main(String [] args) {
    	
    	RandomizedSet rs = new RandomizedSet();
    	
    	System.out.println(rs.insert(-1));
    	System.out.println(rs.remove(-2));
    	System.out.println(rs.insert(-2));
    	System.out.println(rs.getRandom());
    	System.out.println(rs.remove(-1));
    	System.out.println(rs.insert(-2));
    	System.out.println(rs.getRandom());
    }
    
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */