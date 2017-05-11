package com.hackerearth.timelyorder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TimelyOrders {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int numberOfQueries = Integer.parseInt(bf.readLine());
		String [][] dataArr = new String[numberOfQueries][3]; 
		int i=0;
		while(--numberOfQueries!=-1)
		{
			String [] input = bf.readLine().split(" ");
			if(Integer.parseInt(input[0])==1)
				{
				dataArr [i] = input;
				i++;
				}
			else if(Integer.parseInt(input[0])==2){
				
				long fromLastTimeToCheck = Long.parseLong(input[1]);
				long timeNow = Long.parseLong(input[2]); 
				long fromTimeToCheck = timeNow- fromLastTimeToCheck;
					
				int timelocation =binarysearch(dataArr,fromTimeToCheck,i);
				long sum = returnSum(dataArr,timelocation);
				
				System.out.println(sum);
			}
		}
	}
	
	  static private int binarysearch(String dataarray[][], long fromTimeToCheck,int i)
	  {
	    int first, last, middle;
	 
	    first  = 0;
	    last   = i;
	    middle = (first + last)/2;
	 
	    while( first <= last && dataarray[middle][2]!=null)
	    {
	      if ( Long.parseLong(dataarray[middle][2]) < fromTimeToCheck )
	        first = middle + 1;    
	      else if ( Long.parseLong(dataarray[middle][2]) == fromTimeToCheck ) 
	      {
	        return middle;
	      }
	      else
	         last = middle - 1;
	 
	      middle = (first + last)/2;
	   }
	   if ( first > last )
		   return last+1;
	return -1;
	  }
	  
	  static private long returnSum(String dataarray[][], int locationTOStartFrom){
		
		  long sum=0;
		  if(locationTOStartFrom==-1)
			  return 0;
		  else{
			  while(dataarray[locationTOStartFrom][1]!=null)
			  {
				  sum=sum+Long.parseLong(dataarray[locationTOStartFrom][1]);
				  locationTOStartFrom++;
			  }
		  }
			return sum;
	  } 
}
