package com.leetcode.problempackage;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class OddEvenJump {

	public static void main(String[] args) {
		
		OddEvenJump oej = new OddEvenJump();
		int [] A = {10,13,12,14,15};
		System.out.println(oej.oddEvenJumps(A));
		
		

	}
	
public int oddEvenJumps(int[] A) {
        
        int n = A.length;
        
        TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
        boolean [] odd = new boolean[n];
        boolean [] even = new boolean[n];
        
        odd[n-1] = true;
        even[n-1] = true;
        map.put(A[n-1],n-1);
        
        for(int i= n-2; i>=0 ;i--){
            
            
            // returns the max of all the keys less than current key, i.e.
            //A[i] >= A[j] condition for odd check
            Integer fk = map.floorKey(A[i]);
            
            //returns the min of all the keys greater than the current key, i.e. 
            //A[i] <=A[j] which is the condition for even check
            Integer ck = map.ceilingKey(A[i]);
            
            
            if(ck!=null){
                
                int loc = map.get(ck);
                
                //check if we can make an even jump from the next location.
                odd[i] = even[loc];
                
            }
            
            
            if(fk!=null){
            
                int loc = map.get(fk);
                
                //check if we can make an odd jump from the next location.
                even[i] = odd[loc];
                
            }
            
            map.put(A[i],i);
        }
        
        System.out.println(Arrays.toString(odd));
        System.out.println(Arrays.toString(even));
        
        return 0;
    }
}
