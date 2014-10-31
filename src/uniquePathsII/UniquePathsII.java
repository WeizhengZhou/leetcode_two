package uniquePathsII;
public class UniquePathsII{
	public int uniquePathsWithObstacles(int[][] A) {
     	if(A == null || A.length == 0 || A[0].length == 0) 
        	return 0;
        int m = A.length;
        int n = A[0].length;
        int[][] dp = new int[m][n];//number of ways to arrive A[i][j]

        dp[0][0] = (A[0][0] == 0) ? 1:0;//first grid 

        for(int i=1;i<m;i++){//first column
        	if(A[i][0] == 1)//blocked 
            	dp[i][0] = 0;
            else
                dp[i][0] = dp[i-1][0];
        }   

        for(int j=1;j<n;j++){//first row
            if(A[0][j] == 1)//blocked
                dp[0][j] = 0;
            else
                dp[0][j] = dp[0][j-1];
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
				if(A[i][j] == 1) 
 					dp[i][j] = 0;
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];//sum of two way to arrive this grid
			} 
        }
        return dp[m-1][n-1];
    }
}
