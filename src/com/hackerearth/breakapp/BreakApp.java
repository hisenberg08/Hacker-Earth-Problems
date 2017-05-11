package com.hackerearth.breakapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BreakApp {

	public static void main(String[] args) {

		Map<Integer, Integer> dateWeightage = new HashMap<Integer,Integer>();
		int count = 0;
		List<Integer> myList = new ArrayList<Integer>();
		
		try {
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(bf.readLine());
			while(n>0){
				String[] sentence = bf.readLine().split(" ");
				for(String word : sentence ){
					try{
						int date = Integer.valueOf(word.trim());
						if(dateWeightage.containsKey(date)){
							int weight = dateWeightage.get(date);
							if(sentence[0].trim().equals("G:")){
								dateWeightage.put(date, weight+2);
							}
							else
								dateWeightage.put(date, weight+1);
						}
						else{
							if(sentence[0].trim().equals("G:"))
								dateWeightage.put(date,2);
							else
								dateWeightage.put(date,1);
						}
						}catch(Exception e){
						continue;	
						}
				}
				n--;
			}
			if(!dateWeightage.isEmpty()){
				int maxWeight = Collections.max(dateWeightage.values());
				for (Map.Entry<Integer, Integer> entry : dateWeightage.entrySet()) {
					 if (entry.getValue().equals(maxWeight)){
						 myList.add(entry.getKey());
						 count++;
					 }
				}	
			}
			if(count<=1 && (myList.contains(19) || myList.contains(20)))
				System.out.println("Date");
			else
				System.out.println("No Date");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
