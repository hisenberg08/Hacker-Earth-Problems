package com.hackerearth.mannaname;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MannaFirstName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n;
		String removedHalf;
		try {
			n = Integer.parseInt(bf.readLine());
			while(n!=0){
				int suvoCount=0,suvojitCount=0;
				String nameString = bf.readLine();
				while(nameString.length()>0){
					if(nameString.indexOf("SUVOJIT")>-1)
					{
						removedHalf = nameString.substring(0,nameString.indexOf("SUVOJIT"));
						nameString=nameString.substring(nameString.indexOf("SUVOJIT")+7);
						suvojitCount++;
						while(removedHalf.length()>0){
							if(removedHalf.indexOf("SUVO")>-1)
								{
								removedHalf=removedHalf.substring(removedHalf.indexOf("SUVO")+4);
								suvoCount++;
								}
							else
								break;
						}
					}else if(nameString.indexOf("SUVO")>-1){
						nameString=nameString.substring(nameString.indexOf("SUVO")+4);
						suvoCount++;
					}else
						break;
				}
				System.out.println("SUVO = "+suvoCount+ ", SUVOJIT = "+suvojitCount);
			n--;
			}

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
