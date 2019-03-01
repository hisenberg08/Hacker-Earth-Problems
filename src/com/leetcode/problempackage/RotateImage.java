package com.leetcode.problempackage;

public class RotateImage {

	public static void main(String[] args) {

		RotateImage rm = new RotateImage();
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		rm.rotate(matrix );
				
			
	}
	
	public void rotate(int[][] matrix) {
        int temp = 0,i=0,j=0;
        int s = matrix.length;
        for(i=0;i<s;i++){
            for(j=i;j<s;j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        i = 0;
        j = s-1;
        int k = 0;
        while(i<j){
            for(k=0;k<s;k++){
                temp = matrix[k][i];
                matrix[k][i] = matrix[k][j];
                matrix[k][j] = temp;
            }
             i++;
            j--;
        }
    }
	
	

}
