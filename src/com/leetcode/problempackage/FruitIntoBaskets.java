package com.leetcode.problempackage;

public class FruitIntoBaskets {

	public static void main(String[] args) {
		
		FruitIntoBaskets fib = new FruitIntoBaskets();
		int [] tree = {1,0,1,4,1,4,1,2,3};
		System.out.println(fib.totalFruit(tree));

	}
	
public int totalFruit(int[] tree) {
        
        int type_1 = -1;
        int type_2 = -1;
        int max = -1;
        int low = 0;
        int high = 0;
        
        while(high < tree.length){
            if(tree[high] == type_1 || tree[high] == type_2 || type_1 == -1 || type_2 ==-1){
                if(type_1 == -1) type_1 = tree[high];
                else if(type_2 == -1 && tree[high]!=type_1) type_2 = tree[high];
                high++;
            }else{
                
                type_1 = tree[high-1];
                type_2 = tree[high];
                
                low = high-1;
                while(low>0){
                    if(tree[low-1]!=type_1) break;
                     low--;
                }
            }
            max = Math.max(max,high-low);
        }
        return max;
    }

}
