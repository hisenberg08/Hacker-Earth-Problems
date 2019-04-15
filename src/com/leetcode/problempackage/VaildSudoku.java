package com.leetcode.problempackage;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class VaildSudoku {

	public static void main(String[] args) {
		
		VaildSudoku vs = new VaildSudoku();
		
		char [][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},
									  {'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},
									  {'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
		
		vs.isValidSudoku(board);

	}
	
public boolean isValidSudoku(char[][] board) {
        
        Map<Integer,Set<Character>> row = new HashMap<>();
        Map<Integer,Set<Character>> col = new HashMap<>();
        Map<Integer,Set<Character>> box = new HashMap<>();
        
        
        for(int i=0;i<board.length;i++){
            
            for(int k=0;k<board[0].length;k++){
                
                if(board[i][k] != '.'){
                    
                    if(!row.containsKey(i)){
                        row.put(i, new HashSet<Character>());
                        row.get(i).add(board[i][k]);
                    }else{

                        if(row.get(i).contains(board[i][k])) {
                            System.out.println("returning here row for x "+i + " y " + k);
                            return false;
                        }
                        row.get(i).add(board[i][k]);
                    }


                    if(!col.containsKey(k)){
                        col.put(k, new HashSet<Character>());
                        col.get(k).add(board[i][k]);
                    }else{
                        if(col.get(k).contains(board[i][k])) {
                            System.out.println("returning here col for x "+i + "y" + k);
                            return false;
                        }
                        col.get(k).add(board[i][k]);
                    }

                    int boxIdx = (i/3)*3 + k/3;

                    if(!box.containsKey(boxIdx)){
                        box.put(boxIdx, new HashSet<Character>());
                        box.get(boxIdx).add(board[i][k]);
                    }else{
                        if(box.get(boxIdx).contains(board[i][k])) {
                            System.out.println("returning here box for x "+i + "y" + k);
                            return false;
                        }
                        box.get(boxIdx).add(board[i][k]);
                    }
                }
            }
        }
        return true;
    }

}
