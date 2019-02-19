package com.leetcode.problempackage;

import java.util.Stack;

public class SimplifyPath {

	public static void main(String[] args) {
		SimplifyPath sp = new SimplifyPath();
		System.out.println(sp.simplifyPath("/home/"));

	}
	
public String simplifyPath(String path) {
	 String [] p = path.split("/");
     Stack<String> s = new Stack<String>();
     
     for(String st: p){
         
         if(st.indexOf(".")>=0) {
             if(st.length()==2){
                 if(st.charAt(0) == '.' && st.charAt(1) == '.') {
                  if(!s.empty()) s.pop();
              }
             } else if(st.length()!=1) s.push(st);
         }else if(!st.equals("")) {
         	s.push(st);
         }
         
     }
     
     StringBuilder sb = new StringBuilder();
     while(!s.empty()){
         sb.insert(0,s.pop());
         sb.insert(0,"/");
         
     }
     
     if(sb.length() == 0) return sb.append("/").toString();
     else return sb.toString();
	}
}
