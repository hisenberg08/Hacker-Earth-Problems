package com.leetcode.problempackage;

		/*This code converts Roman number to corresponding decimal value.*/

import java.util.Map;
import java.util.HashMap;
public class RomanToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convertToInt("CCCXCIX"));
		
	}

	public static int convertToInt(String str){
		
		int number =0;
		Map<Character, Integer> romanNumMap = new HashMap<Character,Integer>();
		
		romanNumMap.put('M',1000);
		romanNumMap.put('D',500);
		romanNumMap.put('C',100);
		romanNumMap.put('L',50);
		romanNumMap.put('X',10);
		romanNumMap.put('V',5);
		romanNumMap.put('I',1);
		
		for(int i=0;i<str.length();i++){

			int val1 = 0, val2=0,add=0;  
			val1 = romanNumMap.get(str.charAt(i));
			add = val1;
			if(i+1<str.length()){
				val2 = romanNumMap.get(str.charAt(i+1));
				if(val2>val1){
					add = val2-val1;
					i++;
				}
			}
				number = number + add;
		}
		return number;
	}
}
