package com.hackerrank.problempackageone;

//This is solution to practice problem named Sum from hackerrank platform
public class Sum {
	
	public static void main(String [] args){
	
	int [] arr = {2,5,4,6,8};	
	int a =3;
	int [] ar =new int[a];
	int minmax =-2147483647;
	for(int i=0;i<arr.length-a+1;i++){
		int min =2147483647;
		for(int j=0;j<a;j++){
			ar[j] = arr[i+j];
			if(ar[j]<min) min = ar[j];
		}
	if(min>minmax) minmax=min;	
	}
	System.out.println(minmax);
	}
}
