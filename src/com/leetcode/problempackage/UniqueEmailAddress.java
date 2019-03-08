package com.leetcode.problempackage;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress {

	public static void main(String[] args) {
		
			UniqueEmailAddress uea = new UniqueEmailAddress();
			String [] emails = {"test.email+alex@leetcode.c.om","test.e.mail+bob.cathy@leetcode.co+m","testemail+david@lee.tcode.com"};
			System.out.println(uea.numUniqueEmails(emails));
	}

public int numUniqueEmails(String[] emails) {
        
        Set<String> se = new HashSet<String>();
        
        for(String str: emails){
            StringBuilder sb = new StringBuilder();
            int i = 0;
            boolean lname = false;
            while(i<str.length()){
                if(str.charAt(i) != '.' && str.charAt(i)!='+'){
                    sb.append(str.charAt(i));
                }else if(str.charAt(i) == '+'){
                    while(i+1<str.length() && str.charAt(i+1)!='@') i++;
                    sb.append('@');
                    i++;
                    lname = true;
                }else if(str.charAt(i) == '.' && lname){
                    sb.append(str.charAt(i));
                }
                i++;
            }
            se.add(sb.toString());
        }
        return se.size();
    }
	
}
