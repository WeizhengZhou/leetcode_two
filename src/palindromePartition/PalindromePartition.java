package palindromePartition;


import java.util.*;

import util.Util;
public class PalindromePartition{
	List<List<String>> res = new ArrayList<List<String>>();
	public List<List<String>> partition(String s){
    	if(s == null) 
			return res;
        boolean[][] isPal = buildIsPalTable(s);
        helper(s,0,isPal,new ArrayList<String>());
        return res;
	}
    private void helper(String s, int start, boolean[][] isPal, List<String> list){
    	if(start >= s.length()){
			res.add(new ArrayList<String>(list));
		}
        for(int end=start;end<s.length();end++){
			if(isPal[start][end] == true){
                list.add(s.substring(start,end+1));
				helper(s,end+1,isPal,list);
                list.remove(list.size()-1);
			}
		}
	}
    private boolean[][] buildIsPalTable(String s){
    	if(s == null) return null;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int i=0;i<n;i++)
        	dp[i][i] = true;
		for(int len=2;len<=n;len++){
			for(int i=0;i<=n-len;i++){
				int j = i+len-1;
                if(s.charAt(i) != s.charAt(j))
					dp[i][j] = false;
                else if(len == 2)
                    dp[i][j] = true;
                else
                    dp[i][j] = dp[i+1][j-1];	
			}
		}
        return dp;
	}
    public static void main(String[] args){
		String t = "abbacdc";
		PalindromePartition solution = new PalindromePartition ();
		List<List<String>> res = solution.partition(t);
		Util.printLists(res);
	}
}
