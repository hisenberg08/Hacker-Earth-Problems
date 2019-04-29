package com.leetcode.problempackage;

import java.util.Arrays;

public class RedundantConnection {

	public int[] findRedundantConnection(int[][] edges) {
        
		UnionFind uf = new UnionFind(edges.length+1);
		
		for(int [] edge : edges) {
			
			if(uf.isConnected (edge[0] , edge[1])) return edge;
			uf.union(edge[0], edge[1]);
		}
		return null;
		
    }
	
	
	public static void main(String[] args) {
		
		
		RedundantConnection rc = new RedundantConnection();
		int [][] edges = {{1,2},{1,3},{2,3}};
		
		System.out.println(Arrays.toString(rc.findRedundantConnection(edges)));
	}

}
class UnionFind {

	int [] id;
    int [] sz;
    
    UnionFind(int size){
        
        this.id = new int[size];
        this.sz = new int[size];
        
        for(int i=0;i<size;i++){
            
            id[i] = i;
            sz[i] =1;
        }
    }
    
    public void union(int a, int b){
        
       int root1 = find(a);
       int root2 = find(b);
       
       if(sz[root1] > sz[root2]) {
    	   id[root2] = root1;
    	   sz[root1] += sz[root2];
       }else {
    	   id[root1] = root2;
    	   sz[root2] += sz[root1];
       }
    }
    
    public int find(int a){
        
    	
    	int root = a;
    	while(root != id[root]) {
    		root = id[root];
    	}
    	
    	
    	while(a != root) {
    		
    		int next = id[a];
    		id[a] = root;
    		a = next;
    	}
    	
    	return root;
    }
    
    public boolean isConnected(int a , int b){
        return find(a) == find(b);
    }
}
