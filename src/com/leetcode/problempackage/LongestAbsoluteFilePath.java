package com.leetcode.problempackage;

public class LongestAbsoluteFilePath {

//this code is not correct and does not pass all the test cases.
public static void main(String[] args) {
		
		LongestAbsoluteFilePath lafp = new LongestAbsoluteFilePath();
		
		String input ="dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
		System.out.println(lafp.lengthLongestPath(input));
	}
	
public int lengthLongestPath(String input) {
        
        String [] arr = input.split("\n");;
        String [] mySt = new String[arr.length];
        int maxLength = 0;
        int start = 0;
        for(String st: arr){
            
            int lvl = countLevel(st);
            
            if(lvl < start){
            	if(!isFile(st)) {
            		start = start - (start - lvl) +1;
            	}else{
            		lvl = start;
                	st = removeSpaces(st, start -lvl);
            	}
            }
            
            if(lvl == start){
                mySt[start] = "\\" + st.replaceAll("\t","");
                start+=1;
            }
            
            if(isFile(st)){
                int pathLen = createPath(mySt, start);
                if(pathLen > maxLength) maxLength = pathLen;

                start-=1;
            }
        }
        return maxLength;
    }
    
    private String removeSpaces(String st, int i) {
    	
    	char [] ipArr = st.toCharArray();
		for(int k=0;k<st.length();k++) {
			if(ipArr[k] == ' ') {
				ipArr[k] = '\t';
				i--;
			}
			
			if(i == 0) break;
 		}

		StringBuilder sb = new StringBuilder();
		for(char ch : ipArr) sb.append(ch);
		
	return sb.toString();
}

	private int createPath(String [] arr, int start) {
		
		int ret = 0;
		for(int i=0;i<start;i++) {
			
			ret +=arr[i].length();
		}
		
		return ret-1;
	}
    
    private int countLevel(String st){
        
        int len = st.length();
        
        String newStr = st.replace("\t","");
        
        return len - newStr.length();
    }
    
    private boolean isFile(String s){
        
        return s.indexOf(".") > 0;
        
    }
}
