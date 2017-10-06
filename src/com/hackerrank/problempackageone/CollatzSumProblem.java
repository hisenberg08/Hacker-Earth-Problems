package com.hackerrank.problempackageone;
/*This is was a problem in hacker rank code optimization contest.
 * Commented code is the one which had to be optimized*/
import java.util.HashMap;
import java.util.Map;

public class CollatzSumProblem {

	private static Map<Integer, Integer> map = new HashMap<Integer,Integer>();
	public static void main(String[] args) {
	
		int T = 3, A =1, B =4;
		int result =collatzSequenceSum(T, A, B);
		System.out.println(result);
		
	}
/*	static int collatzSequenceLen(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n % 2 == 0) {
            return 1 + collatzSequenceLen(n/2);
        }
        return 1 + collatzSequenceLen(3*n+1);
    }
	*/
	static int collatzSequenceLen(int n) {
         
		int count =0;
		while(n>1){
			if(n%2==0)
				n=n/2;
			else
				n=3*n +1;
			count++;
		}
		
		return count++;
    }

    static int collatzSequenceSum(int T, int A, int B) {
        int n = 0;
        int result = 0;
        while (T-- > 0) {
            n = (A*n + B) % 5003;
            int best_len = 0;
            int best_num = 0;
            for (int k = 0; k <= n; ++k) {
                int cur_len =0;
            	if(map.containsKey(k))
                	cur_len = map.get(k);
                else{
                	cur_len = collatzSequenceLen(k);
                	map.put(k, cur_len);
                }
                if (cur_len >= best_len) {
                    best_len = cur_len;
                    best_num = k;
                }
            }
            result += best_num;
        }
        return result;
    }
    
  /*  static int collatzSequenceSum(int T, int A, int B) {
        int n = 0;
        int result = 0;
        while (T-- > 0) {
            n = (A*n + B) % 5003;
            int best_len = 0;
            int best_num = 0;
            for (int k = 0; k <= n; ++k) {
                int cur_len = collatzSequenceLen(k);
                if (cur_len >= best_len) {
                    best_len = cur_len;
                    best_num = k;
                }
            }
            result += best_num;
        }
        return result;
    }*/
}
