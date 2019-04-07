package com.leetcode.problempackage;

import java.util.Stack;

public class BasicCalculator {

	public static void main(String[] args) {
		
		
		BasicCalculator bc = new BasicCalculator();
		String s = "1+1+(1+(1-3))+1";
		System.out.println(bc.calculate(s));

	}

public int calculate(String s) {
        
        int i=0;
        int res = 0;
        int sign = 1;
        Stack<Integer> st = new Stack<Integer>();
        Stack<Integer> si = new Stack<Integer>();
        while(i<s.length()){
            if(Character.isDigit(s.charAt(i))){
               int j = i;
                while(j<s.length() && Character.isDigit(s.charAt(j))) j++;
                res = res + sign * Integer.parseInt(s.substring(i,j));
                i=j;
            }else if(s.charAt(i) == '+'){
                sign = 1;
                i++;
            }else if(s.charAt(i) == '-'){
                sign = -1;
                i++;
            }else if(s.charAt(i) == '('){
                st.push(res);
                si.push(sign);
                res = 0;
                sign = 1;
                i++;
            }else if(s.charAt(i) == ')'){
                int top = st.pop();
                int sig = si.pop();
                res = top + sig*res;
                i++;
            }
        }
        return res;
    }
}
