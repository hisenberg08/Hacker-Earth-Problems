package com.leetcode.problempackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParenthesis {

	static List<String> res = new ArrayList<String>();
	static int maxN = 0; 
	public static void main(String[] args) {
		
		int num = 3;
		maxN =  num;
		GenerateParenthesis gp = new GenerateParenthesis();
		gp.generateAllParenthesis(0, 0, "");
		for(String str: res)
			System.out.print(str+",  ");

	}

	
	public void generateAllParenthesis(int open,int close,String str){
		if(str.length() == maxN*2) {
			res.add(str);	
		} 
		else {
			if(open < maxN) generateAllParenthesis(open+1, close, str+"(");
				if(close< open)generateAllParenthesis(open, close+1, str+")");
			
		}
	}
	
	public boolean checkValidity(String str) {
		
		char [] strArr = str.toCharArray();
		Stack<Character> stCh = new Stack<>();
		try{
			for(char ch : strArr) {
				if(ch=='(') stCh.push(ch);
				else stCh.pop();
			}
		}catch(Exception e) {
		return false;	
		}
		if(stCh.size()==0)return true;
		else return false;
	}
}
