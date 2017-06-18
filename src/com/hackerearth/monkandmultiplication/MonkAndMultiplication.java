package com.hackerearth.monkandmultiplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MonkAndMultiplication {

	String [] heapArray = null;
	int size=0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int arraySize = Integer.parseInt(bf.readLine());
		String [] heapArrayString = bf.readLine().split(" "); 
		int i=0;
		while(i<heapArrayString.length){
			String [] tempArray = new String [i+1];
			System.arraycopy(heapArrayString, 0, tempArray, 0, i+1);
			if(i<2) System.out.println(-1);
			else{
				MonkAndMultiplication mn = new MonkAndMultiplication();
				mn.heapArray = new String [tempArray.length];
				int j=0;
				while(j<=tempArray.length-1){
					mn.addToHeap(tempArray[j]);
					j++;
				}
				int max = mn.removeMax();
				int secondMax = mn.removeMax();
				int thirdMax = mn.removeMax();
				long mul = max*secondMax*thirdMax;
				System.out.println(mul);
			}
			i++;
		}
	}
	
	//This method gets the max element from the present set of elements.
		public int removeMax(){
			int max = Integer.parseInt(heapArray[0]);
			heapArray[0] = heapArray[size-1];
			size--;
			resizeArray();
			adjustHeapDownward();
			return max;
		}
		
		//This method adds a new element to the heap
		public void addToHeap(String i){
			heapArray[size] = i;
			adjustHeapUpward();
			size++;
		}
		
		/*When a max element is removed, an element at the last index is put to the first index.
		 This method adjusts the element downward until it reaches it new adjusted place.*/
		
		public void adjustHeapDownward(){
			int start = 0;
			while(hasRightChild(start) || hasLeftChild(start)){
				if(hasRightChild(start)){
					int rightChild = Integer.parseInt(heapArray[getRightChildIndex(start)]);
					int leftChild = Integer.parseInt(heapArray[getLeftChildIndex(start)]);
					if(rightChild>Integer.parseInt(heapArray[start]) || leftChild > Integer.parseInt(heapArray[start])){
						if(rightChild>=leftChild){
							swap(start,getRightChildIndex(start));
							start = getRightChildIndex(start);
						}
						else if(leftChild > rightChild) {
							swap(start, getLeftChildIndex(start));
							start = getLeftChildIndex(start);
						}
					}else break;
				}else{
					int leftChild = Integer.parseInt(heapArray[getLeftChildIndex(start)]);
					if(leftChild>Integer.parseInt(heapArray[start])){
						swap(start,getLeftChildIndex(start));
						start = getLeftChildIndex(start);
					}else break;
				}
			}
		}
		
		/*A new element is always added to the end of heap. 
		 * This method adjusts the element upwards to it appropiate place.*/
		
		public void adjustHeapUpward(){
			if(size>0){
				int start = size;
				while(start > 0 ){
					int parentIndex = getParent(start);
					if(Integer.parseInt(heapArray[start]) > Integer.parseInt(heapArray[parentIndex])){
						swap(start,parentIndex);
						start = parentIndex;
					}else break;
				}	
			}
		}
		
		/*This method gets the index of left child of any node.*/
		public int getLeftChildIndex(int n){
			return 2*n+1;
		}
		
		/*This method gets the index of right child of any node.*/
		public int getRightChildIndex(int n){
			return 2*n+2;
		}
		
		/*This method gets the index of parent of any node.*/
		public int getParent(int n){
			return (n-1)/2;
		}
		
		/*This method return true/false if a node has right child or not.*/
		public boolean hasRightChild(int n){
			int rightchildIndex = getRightChildIndex(n);
			if(size>rightchildIndex)
				return true;
			else
				return false;
		}
		
		/*This method return true/false if a node has left child or not.*/
		public boolean hasLeftChild(int n){
			int lefttchildIndex = getLeftChildIndex(n);
			if(size>lefttchildIndex)
				return true;
			else
				return false;
		}
		
		/*This method swaps the elements at two given indexes.*/
		public void swap(int i , int j){
			
			String temp = heapArray[i];
			heapArray[i] = heapArray[j];
			heapArray[j] = temp;
		}
		
		/*This method resize the array after an element is removed from the array.*/
		public void resizeArray(){
			String [] temp = new String [heapArray.length-1];
			System.arraycopy(heapArray, 0, temp, 0, heapArray.length-1);
			heapArray = temp;
		}
}
