package com.leetcode.problempackage;

public class DecodeWays {

	static int count =0;
	public static void main(String[] args) {
			
		DecodeWays dw = new DecodeWays();
		String digit  = "202";
		dw.rec(digit);
		System.out.println(count);

	}

//recursive solution: very bad and super slow
	public void rec(String d){
			
	        if(d.length() == 0) count+=1;
	        else if(d.charAt(0) == '0') d = d.substring(1);
	        else{
	            if(d.length()==1) {
	            	rec("");	
	            }
	            else{
	                int val =    Character.getNumericValue(d.charAt(0))*10 + Character.getNumericValue(d.charAt(1));
	            	if( val <=26 && val >0)
	                	   rec(d.substring(2));
	                rec(d.substring(1));	
	            }
	        }
	    }
}
