package distinctSubsequences;
public class DistinctSubsequences{
	public int numDistinct(String S, String T){
		if(S == null || T == null || S.length() < T.length()) return 0;
        int m = S.length();
        int n = T.length();
        //dp[i][j] = num. of distinct subsequences of T.substring(0,j) can be found in S.substring(0,i)
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = 1;//both empty strings can be matched
        for(int i=1;i<=m;i++)//empty T can be found in any substring of S
         	dp[i][0] = 1;
        for(int j=1;j<=n;j++)//nonEmpty T cannot be found in any substring of S
            dp[0][j] = 0;
  
        for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				if(S.charAt(i-1) != T.charAt(j-1))
                    dp[i][j] = dp[i-1][j];//try to match S.charAt(i-2) with T.charAt(j-1)
                else
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-1];//
			}
		}
        return dp[m][n];
    }
}
