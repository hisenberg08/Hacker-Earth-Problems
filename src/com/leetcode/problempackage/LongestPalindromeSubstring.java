package com.leetcode.problempackage;

public class LongestPalindromeSubstring {

	
public String longestPalindrome(String s) {
        
        char [] arr = s.toCharArray();
        
        int high = 0;
        int low = 0;
        int fhigh = 0;
        int flow = 0;
            
        for(int i=1; i< arr.length -1 ; i++){
            
            
            //check odd palidrome
            high = i+1;
            low = i-1;
            while(low > -1 && high < arr.length ){
                
                if(arr[high]!= arr[low]){
                    break;
                }
                high++;
                low--;
            }
            high-=1;
            low+=1;
            
            if(high-low > fhigh - flow){
                fhigh = high;
                flow = low;
            }
            
            
            //check even palindrome
            
            if(arr[i] == arr[i-1]){
                
                high = i;
                low = i-1;
                while(low > -1 && high < arr.length ){
                
                    if(arr[high]!= arr[low]){
                        break;
                    }
                    high++;
                    low--;
                }
                high-=1;
                low+=1;

                if(high-low > fhigh - flow){
                    fhigh = high;
                    flow = low;
                }
            }
            
        }
        return s.substring(flow,fhigh +1);
    }

	public static void main(String[] args) {
		
		LongestPalindromeSubstring lps = new LongestPalindromeSubstring();
		String s = "babad";
		System.out.println(lps.longestPalindrome(s));

	}

}
