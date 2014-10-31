package palindromePartitionII;
import java.util.*;
public class PalindromePartitionII{
	public int minCut(String s){
		if(s == null || s.length() < 2) return 0;
        int n = s.length();
        boolean[][] isPal = buildIsPalTable(s);
        int[] minCut = new int[n+1];//min cuts to partition s.substring(0,i)
        minCut[0] = 0;
        minCut[1] = 0; 
        for(int i=2;i<=n;i++){
            int min = Integer.MAX_VALUE;
            if(isPal[0][i-1])
            	minCut[i] = 0;
            else{
            	for(int k=1;k<i;k++){//
    				if(isPal[k][i-1] && minCut[k]+1 < min)
                    	min = minCut[k]+1;
    			}
                minCut[i] = min;
            }		
		}
//        System.out.println(Arrays.toString(minCut));
		return minCut[n];
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
		PalindromePartitionII solu = new PalindromePartitionII();
        String s = "abcddcb";
        System.out.println(solu.minCut(s));	
	}
}
