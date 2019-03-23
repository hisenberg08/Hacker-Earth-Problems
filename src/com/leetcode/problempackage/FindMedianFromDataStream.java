package com.leetcode.problempackage;

import java.util.PriorityQueue;

public class FindMedianFromDataStream {

	public static void main(String[] args) {
		
		MedianFinder mf = new MedianFinder();
		
		int [] arr = {1,2,3};
		mf.addNum(arr[0]);
		mf.addNum(arr[1]);
		System.out.println(mf.findMedian());
		mf.addNum(arr[2]);
		System.out.println(mf.findMedian());
	}

}

class MedianFinder {

    /** initialize your data structure here. */
    
    PriorityQueue<Integer> minH;
    PriorityQueue<Integer> maxH; 
    
    double median = Double.MAX_VALUE;
    
    public MedianFinder() {
        minH = new PriorityQueue<Integer>(); 
        maxH = new PriorityQueue<Integer>(); 
    }
    
    public void addNum(int num) {
        
        if(num > median){
            maxH.add(num);
        }else{
            minH.add(num*-1);
        }
        
        if(minH.size() - maxH.size() > 1 || minH.size() < maxH.size()){
            if(minH.size() - maxH.size() > 1){
                maxH.add(minH.poll() * -1);
            }else{
                minH.add(maxH.poll() * -1);
            }
        }
        
        if(minH.size() == maxH.size()){
            median = (double)(minH.peek()*-1 + maxH.peek())/2;
        }else{
            median = minH.peek()*-1;
        }
    }
    
    public double findMedian() {
        
        return median;
        
    }
}

