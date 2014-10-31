package longestPalinSubstring;
public class LongestPalinSubstring{
	public String longestPalindrome(String s){
		if(s == null || s.length() == 0) return "";
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++)
			dp[i][i] = 1;
        
        int start = 0;
        int end = 0;
        int maxL = 1;
        for(int len=2;len<=n;len++){
			for(int i=0;i<=n-len;i++){
				int j = i+len-1;
                if(s.charAt(i) != s.charAt(j))
     				dp[i][j] = 0;
                else if(len == 2)
                    dp[i][j] = 2;
                else if(dp[i+1][j-1] > 0)
                    dp[i][j] = dp[i+1][j-1] +2;
                else
                    dp[i][j] = 0;
                if(dp[i][j] > maxL){//s.substring(i,j+1) is a palindrome 
                	maxL = dp[i][j];//update maxLength
                    start = i;
                    end = j;
                }
			}
		}
        return s.substring(start,end+1);
	}
}
