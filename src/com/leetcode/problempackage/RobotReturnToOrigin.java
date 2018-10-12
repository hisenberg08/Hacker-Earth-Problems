package com.leetcode.problempackage;

public class RobotReturnToOrigin {

	public static void main(String[] args) {
		System.out.println(judgeCircle("UD"));
	}
	
	 public static boolean judgeCircle(String moves) {
	        int x=0,y=0;
	        char [] movesArr = moves.toCharArray();
	        for(char ch: movesArr){
	            switch(ch){
	                case 'L':
	                    x-=1;
	                    break;
	                case 'R':
	                    x+=1;
	                    break;
	                case 'U':
	                    y+=1;
	                    break;
	                case 'D':
	                    y-=1;
	                    break;
	            }
	        }
	        if(x==0 && y==0)
	                return true;
	            else
	                return false;
	    }
}
