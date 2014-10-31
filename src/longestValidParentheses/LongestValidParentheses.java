package longestValidParentheses;

import java.util.*;
public class LongestValidParentheses{
	public int longestValidParentheses(String s){
    	if(s == null || s.length() < 2)
            return 0;
        int n = s.length();
        int[] dp = new int[n];//length of longest valid paren. start at i
        int max = 0;
        for(int i=n-2;i>=0;i--){
			if(s.charAt(i) == ')') //valid paren. cannot start with ")"
				dp[i] = 0;
            else if(s.charAt(i) == '('){
				int j = (i+1) + dp[i+1] - 1 + 1;
                if(j < s.length() && s.charAt(j) == ')'){//s[i] has matched right parentheses s[j]
					if(i+1 == j || dp[i+1] != 0){//inner parentheses is valid
						dp[i] = dp[i+1]+2;
					    if(j+1 < s.length())//more valid paren. on the right e.g. (()) ()()
                            dp[i] += dp[j+1];
					} 
				}	
			}
            max = Math.max(max,dp[i]);
		}
        System.out.println(Arrays.toString(dp));
        return max;	
	}
    public static void main(String[] args){
		LongestValidParentheses solu = new LongestValidParentheses();

        String s = "(";
        System.out.println("s = " + s + ", res = " + solu.longestValidParentheses(s) + ", exp = " + 0);
        s = "()";
        System.out.println("s = " + s + ", res = " + solu.longestValidParentheses(s) + ", exp = " + 2);
        s = "(()";
        System.out.println("s = " + s + ", res = " + solu.longestValidParentheses(s) + ", exp = " + 2);
        s = "()()";
        System.out.println("s = " + s + ", res = " + solu.longestValidParentheses(s) + ", exp = " + 4);
        s = "(()())";
        System.out.println("s = " + s + ", res = " + solu.longestValidParentheses(s) + ", exp = " + 6);
        s = "()(()";
        System.out.println("s = " + s + ", res = " + solu.longestValidParentheses(s) + ", exp = " + 2);
        s = "())()()";
        System.out.println("s = " + s + ", res = " + solu.longestValidParentheses(s) + ", exp = " + 4);
        s = "(((()(()";
        System.out.println("s = " + s + ", res = " + solu.longestValidParentheses(s) + ", exp = " + 2);

	}
}
