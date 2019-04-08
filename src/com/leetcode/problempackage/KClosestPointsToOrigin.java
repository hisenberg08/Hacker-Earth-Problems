package com.leetcode.problempackage;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

	public static void main(String[] args) {
		
		
		KClosestPointsToOrigin kc = new KClosestPointsToOrigin();
		int [][] points = {{-95,76},{17,7},{-55,-58},{53,20},{-69,-8},{-57,87},{-2,-42},{-10,-87},{-36,-57},{97,-39},{97,49}};
		int K = 5;
		
		int [][] arr = kc.kClosest(points, K);
		
		for(int [] a : arr) System.out.println(Arrays.toString(a));

	}
	
public int[][] kClosest(int[][] points, int K) {

		PriorityQueue<coordinate> pq = new PriorityQueue<coordinate>(new CoordinateDist());
        for(int i=0;i<points.length;i++){
            
        	coordinate co = new coordinate(points[i][0], points[i][1]);
        	System.out.println(co.dist + " " + co.x + " " + co.y);
        	pq.add(co);        	
            if(pq.size() > K){
                pq.poll();
            }
        }
        
        int res [][] = new int[K][2];
        for(int i=0;i<K;i++) {
        	coordinate co = pq.poll();
        	res[i][0] = co.x;
        	res[i][1] = co.y;
        }
        return res;
    }
}

 class CoordinateDist implements Comparator<coordinate> {

	@Override
	public int compare(coordinate o1, coordinate o2) {
		
		if(o1.dist > o2.dist) return -1;
		else if(o1.dist < o2.dist) return 1;
		else return 0;
	}
 }

 
 class coordinate {
	 
	 int x;
	 int y;
	 double dist;
	 
	 public coordinate(int x , int y) {
			this.x = x;
			this.y=y;
			this.dist = calculateDist(x, y);
		}
	 
	 public double calculateDist(int x, int y){
	        return Math.sqrt(x*x + y*y);
	    }
	 
 }