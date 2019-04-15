package com.leetcode.problempackage;

public class Minesweaper {

	public static void main(String[] args) {
		
		Minesweaper ms= new Minesweaper();
		
		char [] [] board = {{'E','E','E','E','E'},{'E','E','M','E','E'},{'E','E','E','E','E'},{'E','E','E','E','E'}};
		int [] click = {3,0};
		
		ms.updateBoard(board, click);

	}
	
	int[] dx = {-1, 0, 1, -1, 1, 0, 1, -1};
    int[] dy = {-1, 1, 1, 0, -1, -1, 0, 1};
    public char[][] updateBoard(char[][] board, int[] click){
        
        int x = click[0];
        int y = click[1];
        
        if(board[x][y] == 'M'){
            board[x][y] = 'X';
            return board;
        }
        
        
        dfs(board,x,y);
        return board;
    }
    
    
    private void dfs(char [][] board, int x, int y){
        
        if(x < 0 || x >= board.length || y<0 || y>=board[0].length || board[x][y] != 'E'){
            return;
        }
        
        int num = countNeighbours(board, x ,y);
        
        if(num == 0){
            board[x][y] = 'B';
            for(int i=0;i<8;i++){
                
                int newx = x + dx[i];
                int newy = y + dy[i];
                
                dfs(board, newx,newy);
            }
        }else{
            board[x][y] = (char)('0' + num);
        }
        
    }
    
    
    public int countNeighbours(char [][] board, int x, int y){
    
        int cnt =0;
        for(int i=0;i<8;i++){
                
            int newx = x + dx[i];
            int newy = y + dy[i];
                
            if (newx < 0 || newx >= board.length 
                || newy < 0 || newy >= board[0].length)    continue;
            
            if(board[newx][newy] == 'M' || board[newx][newy] == 'X') cnt++;
            
        }
        
        return cnt;
    }    
}
