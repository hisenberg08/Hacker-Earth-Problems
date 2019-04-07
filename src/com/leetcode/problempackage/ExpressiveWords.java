package com.leetcode.problempackage;

import java.util.ArrayList;
import java.util.List;

public class ExpressiveWords {

	public static void main(String[] args) {
		
		ExpressiveWords ew = new ExpressiveWords();
		
		String S = "heeeeellooo";
		String [] words = {"hello", "hi", "helo","heeello"};
		System.out.println(ew.expressiveWords(S, words));

	}
	
public int expressiveWords(String S, String[] words) {
     
        
        createObj co = new createObj(S);
        int finalCnt = 0;
        
        for(int i=0;i<words.length;i++){
            boolean flag = true;
            createObj co1 = new createObj(words[i]);
            if(!co1.s.equals(co.s)) continue;
            else{
                for(int j=0;j<co.lis.size();j++){

                	int c1 = co.lis.get(j);
                	int c2 = co1.lis.get(j);
                	
                	if(c1 >= (c2-1) + 3 ||  c1 == c2) continue;
                	else {
                		flag = false; 
                        break; 
                	}
                }
                if(flag) finalCnt++;
            }
        }
        return finalCnt;
    }
    

}
class createObj{
    
    String s;
    List<Integer> lis;
    
    public createObj(String S){
        
        StringBuilder sb1 = new StringBuilder();
        List<Integer> si = new ArrayList<>();
        char lastChar = S.charAt(0);
        int cnt = 1;
        for(int i = 1;i<S.length();i++){
            if(S.charAt(i) == lastChar) cnt++;
            else{
                sb1.append(lastChar);
                si.add(cnt);
                lastChar = S.charAt(i);
                cnt = 1;
            }
        }
        if(cnt>0){
            sb1.append(S.charAt(S.length()-1));
            si.add(cnt);
        }
        
        s = sb1.toString();
        lis = si;
    }
}
