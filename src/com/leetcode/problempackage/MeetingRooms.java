package com.leetcode.problempackage;

import java.util.Arrays;

public class MeetingRooms {

	public static void main(String[] args) {
		
		MeetingRooms ms = new MeetingRooms();
		
		int [][] intervals = {{7,10},{2,4}};
		System.out.println(ms.canAttendMeetings(intervals));

	}
	
	 public boolean canAttendMeetings(int[][] intervals) {
	        
	        Arrays.sort(intervals, ((a ,b) -> a[0] - b[0]));
	                   
	        for(int i=1;i< intervals.length ; i++){
	            
	            if(intervals[i-1][1] > intervals[i][0]) return false;
	            
	        }
	        return true;
	    }

}
