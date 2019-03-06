package com.leetcode.problempackage;

import java.util.Arrays;

public class CoinChange {

	public static void main(String[] args) {
		
		CoinChange cc= new CoinChange();
		int [] coins = {5,6};
		int amount = 22;
		System.out.println(cc.coinChange(coins, amount));
	}
		
	public int coinChange(int [] coins, int amount) {

		int [] temp = new int [amount +1];
		
		Arrays.sort(coins);
		for(int i=0;i<temp.length;i++) {
			if(i%coins[0] == 0) temp[i] = i/coins[0];
			else temp[i] = -1;
		}
		
		for(int i=1;i<coins.length;i++) {
			for(int j=0;j<temp.length;j++) {
				
				if(temp[j]!=-1 && j - coins[i]>-1 && temp[j-coins[i]]!=-1) {
					temp[j] =Math.min(temp[j], temp[j-coins[i]]+1);
				}else if(temp[j]==-1 && j - coins[i]>-1 && temp[j-coins[i]]!=-1){
					temp[j] =temp[j-coins[i]]+1;
				}
			}
		}
		return temp[temp.length-1];
	}
}
