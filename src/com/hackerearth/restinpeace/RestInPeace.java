package com.hackerearth.restinpeace;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class RestInPeace {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		while(--n!=-1){
			String tocheckstr = bf.readLine();
			int toCheck = Integer.parseInt(tocheckstr);
			if(toCheck%21==0 || tocheckstr.contains("21"))
				System.out.println("The streak is broken!");
			else
				System.out.println("The streak lives still in our heart!");
		}
	}

}
