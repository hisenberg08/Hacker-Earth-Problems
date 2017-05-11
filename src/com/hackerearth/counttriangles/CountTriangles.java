package com.hackerearth.counttriangles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CountTriangles {

	private static Map<Long, Integer> triangleCount = new HashMap<Long,Integer>();
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			int numberOfTriangles = Integer.parseInt(bf.readLine());
			while(numberOfTriangles>0){
				String sides = bf.readLine();
				String [] side = sides.split(" ");
				long triangleCode = getTriangleCode(Long.parseLong(side[0]),Long.parseLong(side[1]),Long.parseLong(side[2]));
				saveTriangleCode(triangleCode);
				numberOfTriangles--;
			}
			System.out.println(uniqueTriangleCount());
	}

	private static long getTriangleCode(long x,long y,long z){
		
		return((x*y*z)*(x+y+z));
	}
	
	private static void saveTriangleCode(long triangleCode){
		
		if(triangleCount.containsKey(triangleCode)){
			triangleCount.put(triangleCode, triangleCount.get(triangleCode)+1);
		}
		
		else
			triangleCount.put(triangleCode, 1);
	}
	
	private static int uniqueTriangleCount(){
		
		int uniqueCount =0;
		for (Map.Entry<Long, Integer> entry : triangleCount.entrySet()) {
			if(entry.getValue()==1)
				uniqueCount++;
		}
		
		return uniqueCount;
	}
}
