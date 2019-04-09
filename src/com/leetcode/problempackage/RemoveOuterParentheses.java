package com.leetcode.problempackage;

public class RemoveOuterParentheses {

	public static void main(String[] args) {
		
		
		RemoveOuterParentheses rop = new RemoveOuterParentheses();
		String S = "()";
		System.out.println(rop.removeOuterParentheses(S));

	}
	
public String removeOuterParentheses(String S) {
        
        int cntr = 0;
        
        char [] ch = S.toCharArray();
        int start = 0;
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<ch.length;i++){
            
            if(ch[i] == '(') cntr++;
            else cntr--;
            
            if(cntr == 0 && start+1<i){
                sb.append(S.substring(start+1,i));
                start = i+1;
            }
        }
        
        return sb.toString();
    }

}
