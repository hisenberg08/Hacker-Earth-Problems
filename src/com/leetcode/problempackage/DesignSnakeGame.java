package com.leetcode.problempackage;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class DesignSnakeGame {

	int [][] food;
    Deque<Integer> snake;
    int foodIdx;
    int width;
    int height;
    Set<Integer> body;
    int score;
    
    public DesignSnakeGame(int width, int height, int[][] food) {
        
        this.width = width;
        this.height = height;
        this.food = food;
        this.snake = new LinkedList<>();
        this.foodIdx = 0;  
        this.body = new HashSet<>();
        this.score = 0;
        
        body.add(0);
        snake.addFirst(0);
        
    }
    
    
    public int move(String direction) {
        
        if(score == -1)
            return -1;
        
        // get last head
        int lastHead = snake.peekFirst();
        
        
        //convert head to row and cols.
        int rowHead = lastHead/ width;
        int colHead = lastHead%width;
        
        // update the appropiate counter (row or col) based on direction
        
        if(direction.equals("U"))
            rowHead--;
        else if(direction.equals("D"))
            rowHead++;
        else if(direction.equals("R"))
            colHead++;
        else
            colHead--;
        
        //check if new row and cols are in boundary and do not colide with body.
        int newHead = rowHead* width + colHead;
        
        System.out.print("rowHead: "+rowHead);
        System.out.println(" colHead: "+colHead);
        
        body.remove(snake.peekLast());
        if(rowHead <0 || rowHead == height 
           || colHead <0 || colHead == width || body.contains(newHead)) return -1;
        
        body.add(newHead);
        snake.addFirst(newHead);
        
        //check for the food
        if(foodIdx < food.length && food[foodIdx][0] == rowHead 
           && food[foodIdx][1] == colHead){
            foodIdx++;
            body.add(snake.peekLast());
            return ++score;
        }
        
        snake.pollLast();
        return score;
    }


	
	public static void main(String[] args) {
		
		int width = 3;
		int height = 2;
		int [][] food = {{1,2},{0,1}};
		DesignSnakeGame  dsg = new DesignSnakeGame(width, height, food);
		dsg.move("R");
		dsg.move("D");
		dsg.move("R");
		dsg.move("U");
		dsg.move("L");
		dsg.move("U");
		
	}

}
