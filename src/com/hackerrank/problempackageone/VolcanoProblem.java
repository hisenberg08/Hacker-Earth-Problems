package com.hackerrank.problempackageone;

/*This is the solution of volcano problem. In which coordintes of volcano eruption are given along with its 
power. Volcano loses its power as it grows larger. This code computes the point of maximum intensity if
several volcanos erupts in a given area.*/
public class VolcanoProblem { 
	static int [][] a;
	static int n;
	static int max= -324324324;
	public static void main(String[] args) {
		n=100;
		a = new int[n][n];
		
		createArr(50,50,150);
		createArr(10,10,4);
		createArr(50,50,150);
		createArr(50,50,150);
		createArr(50,50,150);
		createArr(50,50,150);
		createArr(50,50,150);
		createArr(50,50,150);
		createArr(50,50,150);
		createArr(50,50,150);
		createArr(50,50,150);
		createArr(50,50,150);
		createArr(50,50,150);
		createArr(50,50,150);
		createArr(50,50,150);
		createArr(50,50,150);
		createArr(50,50,150);
		createArr(50,50,150);
		createArr(50,50,150);
		createArr(50,50,150);
		createArr(50,50,150);
		createArr(50,50,150);
		createArr(50,50,150);
		
		
		System.out.println(max);
		
	}
	
	public static void createArr(int x, int y, int w){
		
		if(max<w) max=w;
		int loop =1;
		a[x][y] =w;
		while(w-loop>0 && x<n && y<n){
			for(int i=x-loop,j=y-loop;j<=y+loop;j++){
				if(j<n && i>-1 && j>-1) {
					a[i][j] += w-loop;
					if(a[i][j]>max) max = a[i][j];
				}
				else break;
				
				}
			for(int i=x+loop,j=y-loop;j<=y+loop;j++){
				if(j<n && i<n && j>-1) {
					a[i][j] += w-loop;
					if(a[i][j]>max) max = a[i][j];
				}
				else break;
				
				}
			
			for(int i=x-loop+1,j=y-loop;i<=x+loop-1;i++){
				if(i>-1 && i<n && j>-1) {
					a[i][j] += w-loop;
					if(a[i][j]>max) max = a[i][j];
				}
				else break;
				}
			for(int i=x-loop+1,j=y+loop;i<=x+loop-1;i++){
				if(j<n && i<n && i>-1) {
					a[i][j] += w-loop;
					if(a[i][j]>max) max = a[i][j];
				}
				else break;
				 
				}
			loop++;
		}

	}
}
