package com.leetcode.problempackage;

public class LisenceKeyFormatting {

	public static void main(String[] args) {
		
		LisenceKeyFormatting lkf = new LisenceKeyFormatting();
		String s = "--a-a-a-a--";
		int k = 2;
		System.out.println(lkf.licenseKeyFormatting(s, k));

	}
	
public String licenseKeyFormatting(String s, int k) {
        
        int i = s.length()-1;
        s = s.toUpperCase();
        StringBuffer sb = new StringBuffer();
        while(i>-1){
            int t = k;
            while(t>0 && i>-1){
                if(s.charAt(i)!='-'){
                    sb.append(s.charAt(i));
                    t--;
                }
                i--;
                if(t==0) sb.append('-');
            }
        }
        String res = sb.reverse().toString();
        
        if(res.charAt(0) == '-') return res.substring(1);
        return res;
    }

}
