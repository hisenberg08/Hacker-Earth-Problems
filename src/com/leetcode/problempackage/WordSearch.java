package com.leetcode.problempackage;

public class WordSearch {

	public static void main(String[] args) {
		
		WordSearch ws = new WordSearch();
		
		char [][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "ABCCED";
		ws.exist(board, word);
		

	}
	
public boolean exist(char[][] board, String word) {
        
        for(int i=0;i<board.length;i++){
            
            for(int k = 0;k<board[i].length;k++){
                    
                if(dfs(board,i,k,word)) return true;
                    
            }
        }
        
        return false;
    }
    
    
    private boolean dfs(char [] [] board, int x, int y , String word){
        
        if(word.length() == 0) return true;
        
        if(x < 0 || x >= board.length || y < 0 || y>= board[0].length) return false;
        
        if(board[x][y]!=word.charAt(0)) return false;
        
        board[x][y]^=256;
        
        boolean ans =  dfs(board, x+1, y , word.substring(1))
            || dfs(board, x-1, y , word.substring(1))
            || dfs(board, x, y+1 , word.substring(1))
            || dfs(board, x, y-1 , word.substring(1));
        
        board[x][y]^=256;
        return ans;
    }
}
