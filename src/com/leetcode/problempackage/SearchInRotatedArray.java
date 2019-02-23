package com.leetcode.problempackage;

public class SearchInRotatedArray {

	public static void main(String[] args) {
		
		SearchInRotatedArray sr = new SearchInRotatedArray();
		int [] nums = {0,1,2,3,4,5,6,7,8,9};
		int target = 9;
		int res = 0;
		int piv = sr.findPivot(nums);
		if(piv == -1 ) res = sr.binarySearch(nums, target, nums.length-1, 0);
		else {
			if(nums[0] <= target && target<= nums[piv]) res = sr.binarySearch(nums, target, piv, 0);
			else res = sr.binarySearch(nums, target, nums.length-1, piv +1);
		}
		System.out.println(res);
	}
	
	public int findPivot(int [] A) {
		
		int l = 0,  h = A.length -1;
		int m = 0;
		while(l<h) {
			m = (h+l)/2;
			if(A[m]>A[m+1]) return m;
			else if(A[m] > A[l]) l = m;
			else h =m;
		}
		return -1;
	}
	
	public int binarySearch(int [] A ,int t, int h, int l) {
		
		int m  =0;
		while(l<=h) {
			m = (h+l)/2;
			if(A[m] ==  t) return m;
			else if(A[m] >  t) h =m-1;
			else l = m+1;
		}
		return -1;
	}
}
