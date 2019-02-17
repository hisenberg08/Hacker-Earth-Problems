package com.leetcode.problempackage;

public class MultiplyStrings {

	public static void main(String[] args) {
			
		String s1 = "0";
		String s2 = "0";
		
		MultiplyStrings ms = new MultiplyStrings();
		
		System.out.println(ms.multiply(s1, s2));
	}
	
public String multiply(String num1, String num2) {
        
		char[] c1,c2;
        if(num1.length() > num2.length()){
            c1 = num1.toCharArray();
            c2 = num2.toCharArray();
        }else{
            c1 = num2.toCharArray();
            c2 = num1.toCharArray();
        }
        
        int [] res = new int[c1.length + c2.length + 1];
        int i=res.length-1;
      
        int carry =0;
            for(int p=c2.length-1;p>-1;p--) {
                 int j =i;
            	carry =0;
                 for(int q=c1.length-1;q>-1;q--) {
            		 int number = (c1[q] - '0') * (c2[p] - '0');
                     int afterCarry = number + carry + res[j];
                     carry = afterCarry/10;
                     res[j] = afterCarry%10;
                     j--;
                }
            	 if(carry!=0) res[j] = carry;
                 i--;
            }
          StringBuffer sb = new StringBuffer();
          
          i =0;
          while(i<res.length && res[i] == 0) i++;
          
          while(i<res.length) {
        	  sb.append(res[i]); 
        	  i++;
          }
          if(sb.length()==0) return "0";
		return sb.toString();
        
    }

}
