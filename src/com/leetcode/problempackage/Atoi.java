package com.leetcode.problempackage;

public class Atoi {

	public static void main(String[] args) {
		
		String str = "+";
		Atoi at = new Atoi();
		System.out.println(at.myAtoi(str));
	}
	
public int myAtoi(String str) {
        
        if(str == null || str.equals("")) return 0;
		char [] ch = str.toCharArray();
		int iMax = ch.length;
		int i = 0;
        while(i < iMax  && (int)ch[i] == 32) i++;
        
        char sign = '\0';
        if( i >= iMax || ((int)ch[i] != 43 && (int)ch[i] != 45 && ((int)ch[i] < 48  || (int)ch[i] > 57))) return 0;
        else{
            if((int)ch[i] == 43) {
             sign = '+';
                i++;
            }
            else if((int)ch[i] == 45){
              sign = '-';
              i++;
            } 
        }
        
        StringBuilder s = new StringBuilder();
        while(i < iMax && (int)ch[i] >47  && (int)ch[i] < 58 ){
            s.append(ch[i]);
            i++;
        }
        int finalNum = 0;
        try {
        	if(s.toString() == null || s.toString().equals(""))return 0;
        	else if(sign == '\0') finalNum = Integer.parseInt(s.toString());
        		else finalNum= Integer.parseInt(sign + s.toString());
        	return finalNum;
        }catch(Exception e) {
        	if((int)sign == 45) return Integer.MIN_VALUE;
        	else return Integer.MAX_VALUE;
        }
        
        
    }

}
