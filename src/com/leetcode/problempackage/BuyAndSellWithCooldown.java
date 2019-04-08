package com.leetcode.problempackage;

//At each day we have an option, we can either buy a stock or sell the one we have at hand. The dynamic programming approach aims to find the
//maximum profit by simpultaneously calculating profits from buying and selling the stock a given day.


//buy[i] = Math.max(sell[i-2] - price, buy[i-1]);

//Let's say on this day we decie to buy a stock. Then maximum profit we can have this day is if we find the max of the all the actions we can take this 
//day, i.e. we can either buy a stock or not.

//Now if we decide to buy the stock, then yesterday has to be a cooldown day. The max profit that I can earn was made on last sell. That was on i-2
//day. Since I am buying today I am putting out money from profits hence sell[i-2] - price or if I decide not to buy today then my max profit is coming 
//from my last buyout i.e. buy[i-1]. 


//sell[i] = Math.max(buy[i-1] + price, sell[i-1])
//Similar to above explanation, if we decide to sell the stock on a given day then profit made from selling that would be profit till last buyout and the 
//profit that I am going to make today from the current sellout. i.e. buy[i-1] + price. And if I decide not to sell the stock today then max profit would be
//the one that I have gotten from the last sellout i.e. sell[i-1].


public class BuyAndSellWithCooldown {
	
	public static void main(String[] args) {
		
		BuyAndSellWithCooldown bs = new BuyAndSellWithCooldown();
		int [] prices = {1,2,3,0,2};
		System.out.println(bs.maxProfit(prices));

	}
	
	public int maxProfit(int[] prices) {
        int buyLast = Integer.MIN_VALUE;
        int sell2P = 0, sellPrev =0;
        
        int buyCurr = 0, sellCurr =0;
        for(int i:prices){
            
            buyCurr = Math.max((sell2P - i),buyLast);
            sellCurr = Math.max((buyLast + i),sellPrev);
            
            buyLast = buyCurr;
            
            sell2P = sellPrev;
            sellPrev = sellCurr;
        }
        
        return sellCurr;
    }

}
