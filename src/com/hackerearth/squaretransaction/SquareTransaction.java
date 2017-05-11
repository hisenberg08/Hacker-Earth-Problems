package com.hackerearth.squaretransaction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SquareTransaction {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		String [] input = br.readLine().split(" ");
		int numberOfQueries = Integer.parseInt(br.readLine());
		while(--numberOfQueries!=-1){
			int target = Integer.parseInt(br.readLine());	
				int i=0,sum=0;
				do{
					sum = sum+Integer.parseInt(input[i]);
					i++;
				}while(sum<target && i!=input.length);
				
				if(i==input.length && sum<target)
					System.out.println("-1");
				else
					System.out.println(i);
			}
		}
	}
