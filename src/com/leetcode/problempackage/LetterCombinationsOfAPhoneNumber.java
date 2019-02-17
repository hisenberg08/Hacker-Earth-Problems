package com.leetcode.problempackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {

	public static void main(String[] args) {
		LetterCombinationsOfAPhoneNumber lc = new LetterCombinationsOfAPhoneNumber();
		String digits = "";
		System.out.println(lc.letterCombinations(digits));
	}
	
	List<String> res = new ArrayList<String>();
    Map<String,String> map = new HashMap<String,String>();
    public List<String> letterCombinations(String digits) {
    	map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");
    	
        if(digits.length()==0) return res;
        recurMeth("",digits);
        return res;
    }
    
    public void recurMeth(String curr, String rem_digit){
        
        if(rem_digit.length() == 0) res.add(curr);
        else{
            String digit = rem_digit.substring(0,1);
            if(digit.equals("1")) recurMeth(curr,rem_digit.substring(1));
            else {
            	String strForDigit = map.get(digit);
                for(int i=0;i<strForDigit.length();i++){
                    recurMeth(curr + strForDigit.substring(i,i+1), 
                    		rem_digit.substring(1));
                    }
            	}
            }
        }
}
