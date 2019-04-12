package com.leetcode.problempackage;

public class StringCopression {

	public static void main(String[] args) {
		
		
		StringCopression sc = new StringCopression();
		char [] ch = {'a','a','b','b'};
		sc.compress(ch);

	}

public int compress(char[] ch) {
        
        char lastCh = ch[0];
        int cnt = 1;
        int lastLoc = 0;
        for(int i=1;i<ch.length;i++){
            if(ch[i]!=lastCh){
                ch[lastLoc] = lastCh;
                if(cnt > 1){
                    String st = String.valueOf(cnt);
                    int len = 0;
                    while(len<st.length()){
                        ch[++lastLoc] = st.charAt(len);
                        len++;
                    }
                }
                lastLoc++;
                cnt =1;
                lastCh = ch[i];
            }else cnt++;
        }
        
        ch[lastLoc] = lastCh;
        if(cnt > 1){
            String st = String.valueOf(cnt);
            int len = 0;
            while(len<st.length()){
                ch[++lastLoc] = st.charAt(len);
                len++;
            }
            lastLoc+=1;
        }
        
        
        for(int i=0;i<lastLoc;i++) System.out.print(ch[i] + " ");
        
        return lastLoc;
    }
	
}
