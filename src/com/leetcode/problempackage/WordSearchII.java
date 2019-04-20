package com.leetcode.problempackage;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {

	public static void main(String[] args) {
		
		
		WordSearchII ws = new WordSearchII();
		
		
		char [][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
		String [] words = {"oath","pea","eat","rain"};
		
		ws.findWords(board, words);

	}
	
public List<String> findWords(char[][] board, String[] words) {
        
        List<String> lis = new ArrayList<String>();
        for(String word : words){
            
            char [] ch = word.toCharArray();
            for(int x=0 ;x < board.length;x++){
                
                for(int y=0; y< board[x].length ;y++){
                    
                    if(board[x][y] == ch[0] && dfs(board, x, y , 0, ch)){
                        
                        lis.add(word);
                    }
                    
                }
                
            }
            
        }
        return lis;
    }
    
    private boolean dfs(char [][] board, int x, int y ,int i, char [] word){
        
        
        if(i == word.length) return true;
        
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length) return false;
        
        if(board[x][y]!= word[i]) return false;
        
        board[x][y]^=256;
        
        boolean ans = dfs(board,x+1,y,i+1,word) ||
                   dfs(board,x,y+1,i+1,word) ||
            dfs(board,x-1,y,i+1,word) ||
            dfs(board,x,y-1,i+1,word);
    
        board[x][y]^= 256;
           
        return ans;
           
    }

}
