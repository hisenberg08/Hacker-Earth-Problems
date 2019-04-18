package com.leetcode.problempackage;

import java.util.Arrays;

public class SudokuSolver {

	public static void main(String[] args) {
		
		SudokuSolver ss = new SudokuSolver();
		
		char [] [] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},
										{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},
										{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
		
		ss.solveSudoku(board);

	}
	
	public void solveSudoku(char[][] board) {
        
        helper(board);
        printBoard(board);
        
    }


	public void printBoard(char [][] board) {
		
		System.out.println("");
		System.out.println("====================================================");
		
		for(char [] ch : board) {
			
			System.out.println(Arrays.toString(ch));
			
		}
		System.out.println("====================================================");
		System.out.println("");
	}
    
    public boolean helper(char [][] board){
        
        for(int i=0; i < board.length ;i++){
            
            for(int j = 0; j< board[i].length ;j++){
                
                if(board[i][j] == '.'){
                    
                    for(int k = 1; k < 10 ; k++){
                        
                        char ch = (char)(k+'0');
                        
                        	if(allOk(i , j , ch, board)){
                            
	                            board[i][j] = ch;
	                            
	                            if(helper(board)){
	                            
	                                return true;
	                            
	                           }else{
	
	                                board[i][j] = '.';

                            }
                            
                        }
                        
                    }
                    
                    return false;
                    
                }
                
            }
            printBoard(board);
            
        }
        
        return true;
    }
    
    
    public boolean allOk(int row, int col, char ch, char [][] board){
        
        return rowOk(row, ch, board) &&
            colOk(col ,ch ,board) &&
            boxOk(row, col, ch, board);
        
    }
    
    
    
    private boolean boxOk(int row, int col, char ch, char [][] board){
        
        int rowSt = (row/3) * 3;
        int colSt = (col/3) * 3;
        
        
        for(int i=rowSt ; i< rowSt+3 ;i++){
            
            for(int j = colSt ; j < colSt + 3 ; j++){
                
                
                if(board[i][j] == ch){
                    
                    return false;
                    
                }
                
            }
            
        }
        
        return true;
        
    }
    
    
    private boolean colOk(int col, char ch, char [][] board){
        
        for(int i = 0;i< board.length;i++){
            
            if(board[i][col] == ch){
                
                return false;
                
            }
            
        }
        
        return true;
    }
    
    
    private boolean rowOk(int row, char ch, char [][] board){
        
        for(int i = 0;i< board[row].length;i++){
            
            if(board[row][i] == ch){
                
                return false;
                
            }
            
        }
        
        return true;
    }

}
