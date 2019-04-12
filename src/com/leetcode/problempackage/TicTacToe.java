package com.leetcode.problempackage;

public class TicTacToe {
	
	int [][] board;
    int [] rowArr;
    int [] colArr;
    int digL = 0;
    int digR = 0;
    int boardL;
    
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        
        this.board = new int [n][n];
        this.rowArr = new int [n];
        this.colArr = new int [n];
        this.boardL = n;
        
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        
        board[row][col] = player;
        rowArr[row]+=1;
        colArr[col]+=1;
        if(row == col) digL+=1;
        if(row+col == boardL -1) digR+=1;
        
        if(rowArr[row] == boardL){
            int checkH = checkH(row);
            if(checkH!= 0) return checkH;
        }
         
        if(colArr[col] == boardL){
            int checkV = checkV(col);
            if(checkV!=0) return checkV; 
        }
        
        if(digL == boardL){
            int checkD = 0;
            if(row == col) {
                checkD = checkDL();
                if(checkD!=0) return checkD;
            }
        }
        
        
        if(digR == boardL){
            int checkD = 0;
            checkD = checkDR();
            if(checkD!=0) return checkD;
        }
        
        return 0;
    }
    
    
    public int checkH(int row){
        
        int firstVal = board[row][0];
        if(firstVal == 0) return 0;
        
        for(int j=1;j<boardL;j++){
            
            if(board[row][j]!=firstVal) return 0;
        }
        
        return firstVal;
        
    }
    
    
    public int checkV(int col){
        
        int firstVal = board[0][col];
        if(firstVal == 0) return 0;
        
        for(int j=1;j<boardL;j++){
            
            if(board[j][col]!=firstVal) return 0;
        }
        
        return firstVal;
        
    }
    
    
    public int checkDL(){
        int firstVal = board[0][0];
        if(firstVal == 0) return 0;
        for(int i=0;i<boardL;i++){
            if(board[i][i] != firstVal){
                return 0;
            }
        }
       return firstVal;
    }
    
    public int checkDR(){
        
        int firstVal = board[0][boardL-1];
        if(firstVal == 0) return 0;
        
        for(int i=0,j=boardL-1;i<boardL;i++,j--){
            if(board[i][j] != firstVal){
                return 0;
            }
        }
        
       return firstVal;
    }
           
    public static void main(String[] args) {
		
    	TicTacToe ttt = new TicTacToe(3);
    	
    	ttt.move(1,2, 2);
    	ttt.move(0,2, 1);
    	ttt.move(0,0, 2);
    	ttt.move(2,0, 1);
    	ttt.move(0,1, 2);
    	ttt.move(1,1, 1);
    	
	}
	
}
