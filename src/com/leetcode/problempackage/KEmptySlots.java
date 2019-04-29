package com.leetcode.problempackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KEmptySlots {

	public static void main(String[] args) {
		
		KEmptySlots kes = new KEmptySlots();
		
		int [] flowers = {1,3};
		int k = 1;
		kes.kEmptySlots(flowers, k);

	}
	
public int kEmptySlots(int[] flowers, int k) {
        
        
        List<Integer> lis = new ArrayList<Integer>();
        for(int j = 0; j < flowers.length ;j++){
            
            lis.add(flowers[j]);
            
            Collections.sort(lis);
            
            
            int index = Collections.binarySearch(lis, flowers[j]);
            
            
            if(index - 1 > -1 && index + 1 < lis.size()){
                
                if(lis.get(index) - lis.get(index - 1) - 1 == k 
                   || lis.get(index + 1) - lis.get(index) - 1 == k){
                    
                    return j;
                }
                
            }
            
        }
        
        return -1;
    }

}
