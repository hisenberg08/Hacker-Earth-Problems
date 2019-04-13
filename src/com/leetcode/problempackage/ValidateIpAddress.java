package com.leetcode.problempackage;

public class ValidateIpAddress {

	public static void main(String[] args) {
		
		ValidateIpAddress vip = new ValidateIpAddress();
		String IP = "15.16.0.1";
		System.out.println(vip.validIPAddress(IP));

	}
	
public String validIPAddress(String IP) {
        
        if(IP == null ||IP.length() == 0) return "Neither";
        
        
        if(IP.indexOf(":") > 0){
            if(versionSCheck(IP)) return "IPv6";
        }else if(IP.indexOf(".") > 0){
            if(versionFCheck(IP)) return "IPv4";
        }
        
        return "Neither";
    }
    
    
    public boolean versionSCheck(String ip){
        
        if(ip.charAt(0) == ':' 
           || ip.charAt(ip.length() -1) == ':') return false;
        
        String [] ipArr = ip.split(":");
        if(ipArr.length!=8) return false;
        
        for(String str : ipArr){
            
            if(!validIpv6Num(str)) return false;
            
        }
        
        return true;
    }
    
    public boolean validIpv6Num(String str){
        
        if(str.length() == 0 || str.length() > 4 
           || !str.matches("[a-fA-F0-9]+")) return false;
        
        return true;
    }
    
    
    public boolean versionFCheck(String ip){
        
        if(ip.charAt(0) == '.' 
           || ip.charAt(ip.length() -1) == '.') return false;
        
        String [] ipArr = ip.split("\\.");
        if(ipArr.length != 4) return false;
        
        for(String str : ipArr){
            
            if(!validIpv4Num(str)) return false;
            
        }
        return true;
    }
    
    public boolean validIpv4Num(String str){
        
        if(str.length() == 0 || (str.length()>1 && str.charAt(0) == '0') 
        		|| !Character.isDigit(str.charAt(0))) return false;
        try{
            
            int val = Integer.parseInt(str);
            if(val > 255 || val < 0) return false;
            
        }catch(Exception e){
            return false;
        }
        return true;
    }
}
