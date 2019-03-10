package com.leetcode.problempackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnagramMappings {

	public static void main(String[] args) {
		
		AnagramMappings am= new AnagramMappings();
		
		int [] A = {26,75,94,89,74,4,7,54,54,88};
		int [] B = {89,4,54,74,88,75,26,94,54,7};
		
		A = am.anagramMappings(A, B);
		
		for(int i: A) System.out.print(i + " ");
	}

public int[] anagramMappings(int[] A, int[] B) {
        
        Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
        
        for(int i=0;i<B.length;i++) {
        	if(map.containsKey(B[i])) {
        		map.get(B[i]).add(i);
        	}
        	else {
        		List<Integer> lis = new ArrayList<>();
        		lis.add(i);
        		map.put(B[i], lis);
        	}
        }
        
        
        for(int i=0;i<A.length;i++) {
        	A[i] = map.get(A[i]).get(0);
        }
        return A;
    }
	
}
