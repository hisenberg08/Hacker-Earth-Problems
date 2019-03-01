package com.leetcode.problempackage;

public class SqrtOfNumber {

	public static void main(String[] args) {
		
		SqrtOfNumber sq = new SqrtOfNumber();
		System.out.println(sq.mySqrt(2147395599));
		
	}
	
public int mySqrt(int x) {
        
        int a = x/2;
        while(a*a>x){
             a =a/2;
        }
        while((a+1)*(a+1) <= x){
            a++;
        }
        return a;
    }

}
