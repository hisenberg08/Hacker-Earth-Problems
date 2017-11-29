package com.leetcode.problempackage;

/*Solution to problem 35 leetcode: Search Insertion position*/
public class SearchInsertionPosition {

	public static void main(String[] args) {
		
		int [] arr = {};
		System.out.println(searchInsert(arr, 1));
	}

    public static int searchInsert(int[] nums, int target) {
        int i=0,j=nums.length-1;
        while(i<=j){
            int mid = (i+j)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]>target)
                 j=mid-1;
            else if(nums[mid]<target)
               i=mid+1;
            else
                return i-1;
        }
        return i;
    }
}
