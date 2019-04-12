package com.leetcode.problempackage;

import java.util.Arrays;

public class RangeSumQuery2D {

	int [][] mat;
	
public RangeSumQuery2D(int[][] matrix) {
        
        this.mat = matrix.clone();
        for(int i =1; i< mat.length;i++){
            for(int j =0; j< mat[i].length;j++){
                mat[i][j] += mat[i-1][j];
            }   
        }
        
        print();
    }

public void update(int row, int col, int val) {
    
    int i = row;
    int act = 0;
    int diff = 0;
    if(row == 0) {
    	diff = val - mat[row][col];
    	i+=1;
        mat[row][col] =val;
    }else{
        act = mat[row][col] - mat[row-1][col];
        diff = val - act;
    }
    while(i<mat.length){
        mat[i][col]+=diff;
        i++;
    }
    print();
}

public int sumRegion(int row1, int col1, int row2, int col2) {
    
    int sum = 0;
    if(row1 == 0){
        
        for(int i = col1;i<=col2 ;i ++){
            sum+= mat[row2][i];
        }
    }else{
        row1-=1;
        
        for(int i = col1;i<=col2 ;i ++){
            sum+= (mat[row2][i] - mat[row1][i]);
        }
        
    }
    return sum;
}

public void print(){
    
    System.out.println("==============================");
    for(int i=0;i<mat.length;i++){
        System.out.println(Arrays.toString(mat[i]));
    }
    
    System.out.println("==============================");
}

	public static void main(String[] args) {
		
		
		int [][]matrix = {{1},{2}};
		RangeSumQuery2D rsq = new RangeSumQuery2D(matrix);
		
		rsq.sumRegion(0, 0, 0, 0);
		rsq.sumRegion(1, 0, 1, 0);
		rsq.sumRegion(0, 0, 1, 0);
		rsq.update(0, 0, 3);
		rsq.update(1, 0, 5);
		
	
	}
}
