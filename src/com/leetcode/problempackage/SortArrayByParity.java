package com.leetcode.problempackage;

import java.util.Arrays;

public class SortArrayByParity {

	public static void main(String[] args) {

		int [] arr = {1,6,2,3,6,9};
		System.out.println(Arrays.toString(sortArrayByParity(arr)));
	}

	public static int[] sortArrayByParity(int[] A) {
	       
        int size = A.length;
        int [] returnArr = new int[size];
        int i=0,j=size-1;
        for(int num:A){
            if(num%2==0){
                returnArr[i]=num;
                    i++;
            }else{
                returnArr[j]=num;
                j--;
            }
        }
        return returnArr;
    }
}
