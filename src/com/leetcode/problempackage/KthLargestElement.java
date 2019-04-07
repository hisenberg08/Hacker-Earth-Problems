package com.leetcode.problempackage;

import java.util.Arrays;
import java.util.Random;


//This code has some problem and needs to be fixed
public class KthLargestElement {

	
	int [] nums;
    int k;
    
    
    public int findKthLargest(int[] nums, int k) {
        
        this.nums = nums;
        this.k = k;
        
        return quickSelect(0, nums.length-1);
        
    }
    
    
    public int partion(int low, int high, int pivotIndex){
        
        //swap pivotIndex with right
        swap(pivotIndex,high);
        pivotIndex = high;
        //write for loop to place the pivot value
        int i = low, j = high -1;
        
        while(i<=j){
            if(nums[i] > nums[pivotIndex] && nums[j] <= nums[pivotIndex]) {
            	swap(i,j);
            	i++;
            	j--;
            }
            else if(nums[i] <= nums[pivotIndex]) i++;
            else if(nums[j] > nums[pivotIndex]) j--;
            else{
                i++;
                j--;
            }
        }
        
        //swap high and pivot
        swap(i,pivotIndex);
        
        //return pivot index
        return i;
    }
    
    
    public int quickSelect(int low, int high){
        
        if(low == high) return nums[low];
        
        //Random rand = new Random();
        int pivot = low ;//+ rand.nextInt(high - low);
        
        pivot = partion(low, high, pivot);
        
        
        System.out.println(Arrays.toString(nums) + "   pivot:    "+pivot );
        
        if(pivot == nums.length - k) return nums[pivot];
        
        else if(pivot > k ) return quickSelect(low,pivot-1);
            
        else return quickSelect(pivot+1, high);
        
    }
    
    public void swap(int ia , int ib){
        
        int temp = nums[ia];
        nums[ia] = nums[ib];
        nums[ib] = temp;
        
    }
	
	public static void main(String[] args) {
		
		KthLargestElement elem = new KthLargestElement();
		
		int [] nums = {3,2,1,5,6,4};
		int k = 7;
		System.out.println(elem.findKthLargest(nums, k));

	}

}
