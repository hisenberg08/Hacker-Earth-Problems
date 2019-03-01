package com.leetcode.problempackage;

public class PowerOfFour {

	public static void main(String[] args) {
			
		PowerOfFour pf = new PowerOfFour();
		int n = 64;
		System.out.println(pf.isPowerOfFour(n));
	}
	
	 public boolean isPowerOfFour(int n) {
         
	        if(n==1) return true;
	        if(n<4) return false;
	        return rec(n);
	        
	    }
	    
	     public boolean rec(int n){
	        if(n==4) return true;
	        else if(n%4!=0) return false;
	        else return rec(n/4);
	    }

}
