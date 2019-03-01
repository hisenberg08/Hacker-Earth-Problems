package com.leetcode.problempackage;

public class RangeBitwise {

	public static void main(String[] args) {
		
		RangeBitwise rb = new RangeBitwise();
		System.out.println(rb.rangeBitwiseAnd(Integer.MIN_VALUE,Integer.MAX_VALUE));
		//System.out.println(Integer.MAX_VALUE);
	}
	
//	public int rangeBitwiseAnd(int m, int n) {
//		
//		int res = m;
//		for(int i = m+1;i<=n;i++) {
//			if(i == Integer.MIN_VALUE) return res;
//			res &=i;
//			if(res == 0) return 0;
//		}
//		return res;
//    }
	
	public int rangeBitwiseAnd(int m, int n) {
		// initial mask with all 1111111.....111111
        int tmp = -1;
        while (m != n) {
			// set the lowest bit as 0 one at a time
            tmp <<= 1;
            m &= tmp;
            n &= tmp;
        }
        return m;
    }

}
