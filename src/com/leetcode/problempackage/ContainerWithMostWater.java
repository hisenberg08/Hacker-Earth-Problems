package com.leetcode.problempackage;

public class ContainerWithMostWater {
	
	public static void main(String [] args){
		
		int [] n = {1,8,6,2,5,4,8,3,7};
		System.out.println(findContainerWithMostWater(n));
	}
	
	public static int findContainerWithMostWater(int [] height) {
		
		int maxArea = 0;
		int i=0,j=height.length-1;
		while(i<j){
			int ht = Math.min(height[i], height[j]);
			int area = ht*(j-i);
			if(area>maxArea) maxArea= area;
			if(height[i]<height[j]) i++;
			else j--;
		}
		return maxArea;
	}

}
