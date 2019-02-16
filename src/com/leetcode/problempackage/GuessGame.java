/*374. Guess Number Higher or Lower*/

package com.leetcode.problempackage;

public class GuessGame {

	static int pick = 1702766719;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(guessNumber(2126753390));
	}

	public static int guess(int number) {
		
		if(pick == number) return 0;
		else if(pick > number) return 1;
		else return -1 ;
	}
	
public static int guessNumber(int n) {
        
        int min = 0, max = n;
        int guessedNumber = ( min + (max-min)/2);
        int guessCheck = guess(guessedNumber);
        while(guessCheck != 0){
        	if (guessCheck  == -1){
                max = guessedNumber -1;
            }else{
                min = guessedNumber + 1;
            }
            guessedNumber = ( min + (max-min)/2);
            guessCheck = guess(guessedNumber);
        }
        return guessedNumber;
    }
	
}
