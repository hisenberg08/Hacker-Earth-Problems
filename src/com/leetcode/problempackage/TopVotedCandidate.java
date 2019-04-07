package com.leetcode.problempackage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TopVotedCandidate {

	int [] winnerAtTime;
	int [] times;
	
	 public TopVotedCandidate(int[] persons, int[] times) {
		 
		 winnerAtTime = new int[times.length];
		 this.times = times;
		 Map<Integer,Integer> map = new HashMap<Integer,Integer>();	 
		 
		 int prevWinner = persons[0];
		 
		 for(int i=0;i<persons.length;i++) {
			 map.put(persons[i],map.getOrDefault(persons[i], 0)+1);
			 
				 if(map.get(persons[i]) >= map.get(prevWinner)){
					 prevWinner = persons[i];
			 }
			 winnerAtTime[i] = prevWinner;
		 }
	 }
	 
	 
	public static void main(String [] args) {
		
		int [] persons = {0,1,2,2,1};
    	int [] times = {20,28,29,54,56};
		TopVotedCandidate tvc = new TopVotedCandidate(persons, times);
		int [] test = {56};
		for(int i:test) System.out.print(tvc.q(i) + "  ");
		
		
	}
	
public int binarySearch(int t){

	if(t<times[0]) return 0;
	if(t>times[times.length-1]) return times.length-1;
	
	
	int l = 0;
    int h = times.length;
    int m = 0;
    while(l<h){
        m = (l+h)/2;
        if(times[m] == t) break;
        else if(times[m] > t){
            h = m;
        }else{
            l = m+1;
        }
    }
    m = times[m]>t ? m-1 :m;
   return m;
    }

public int binnarySearchI(int t) {
	
	int loc = Arrays.binarySearch(times, t);
	return loc;
}

public int q(int t) {
	
	return winnerAtTime[binarySearch(t)];  
}
	
}
