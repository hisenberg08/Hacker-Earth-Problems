package com.leetcode.problempackage;

		/*This code checks for the validity of the String of parenthesis.
		 * Here I have used stack to solve the problem. My reason to use stack here is: the type of bracket that is opened in the end is the one that will be closed
		 * first.Hence LIFO arrangement of data could be best implemented using stack.*/

import java.util.HashMap;
import java.util.Map;

public class ValidParen {

	static char [] stack = null;
	static int size = 0, top = -1;
	static Map<Character,Character> charMap = new HashMap<Character,Character>();
	
	public static void main(String[] args) {
		
		System.out.println(checkString("[([])[{[]()}]{()}]"));
		
	}
	
	private static boolean checkString(String s){
		
		charMap.put(')','(');
		charMap.put('}','{');
		charMap.put(']','[');
		
		char [] arr = s.toCharArray();
		size = arr.length;
		stack = new char[size];
		for(int i=0;i<arr.length;i++){
			if(arr[i]=='(' || arr[i]=='[' || arr[i]=='{'){
				push(arr[i]);
			}else{
				char val = pop();
				if(val != charMap.get(arr[i])){
					return false;
				}
			}
		}
		if(top!=-1)
			return false;
		else
			return true;
	}
	
	private static void push(char c){
		
		if(top>=-1 && top<size){
			top++;
			stack[top] =  c;
		}
	}
	
	private static char pop(){
	
		char ret = stack[top];
		top--;
		return ret;
	}
}
