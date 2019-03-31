package com.leetcode.problempackage;

public class MedianOfTwoSortedArrays {

	int [] X;
    int [] Y;
	public static void main(String[] args) {
		
		
		MedianOfTwoSortedArrays  motsa = new MedianOfTwoSortedArrays();
		
		int [] nums1 = {1};
		int [] nums2 = {2};
		
		System.out.println(motsa.findMedianSortedArrays(nums1, nums2));

	}
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        if(nums1.length <= nums2.length) {
            X = nums1;
            Y = nums2;
        }else{
            Y = nums1;
            X = nums2;
        }
        
        int low = 0;
        int high = X.length;
        double res = 0.0;
        while(low <= high){

            int Px = (low + high)/2;
            int Py = ((X.length + Y.length + 1)/2) - Px;

            int Xmax = (Px - 1 < 0 || Px - 1 >  X.length -1)  ? Integer.MIN_VALUE : X[Px -1];
            int Ymax = (Py - 1 < 0  || Py - 1 > Y.length - 1 )  ? Integer.MIN_VALUE : Y[Py- 1];

            int Xmin = Px > X.length -1 ? Integer.MAX_VALUE : X[Px];
            int Ymin = Py > Y.length -1 ? Integer.MAX_VALUE : Y[Py];

            int leftMax = 0;
            int rightMin = 0;
            if(Xmax < Ymin && Ymax < Xmin){
                leftMax = Math.max(Xmax , Ymax);
                rightMin = Math.min(Xmin,Ymin);
                if((X.length + Y.length)%2 == 0) {
                    res = (double)(leftMax + rightMin)/2;
                }
                else {
                 res = leftMax;   
                }
                break;
            }else if(Xmax > Ymin){
                high = Px;
            }else{
                low = Px+1;
            }
        }
        return res;
    }
}
