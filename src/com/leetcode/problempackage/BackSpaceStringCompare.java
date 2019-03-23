package com.leetcode.problempackage;

public class BackSpaceStringCompare {

	public static void main(String[] args) {
		
		BackSpaceStringCompare bsc = new BackSpaceStringCompare();
		String s = "y#fo##f";
		String t = "y#f#o##f";
		System.out.println(bsc.backspaceCompare(s, t));
	}
	
public boolean backspaceCompare(String s, String t) {
        
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        
        for(int i=0;i<s.length();i++){
        	if(s.charAt(i) == '#') {
            	if(sb1.length() > 0) sb1.setLength(sb1.length() - 1);
            }
            else sb1.append(s.charAt(i));
        }
        
        
        for(int j=0;j<t.length();j++){
            if(t.charAt(j) == '#') {
            	if(sb2.length() > 0) sb2.setLength(sb2.length() - 1);
            }
            else sb2.append(t.charAt(j));
        }
        
        return sb1.toString().equals(sb2.toString());
        
    }

}
