package editDistance;
public class EditDistance{
	public int minDistance(String w1, String w2){
    	if(w1 == null && w2 == null) return 0;
        if(w1 == null || w2 == null) 
        	return (w1 != null) ? w1.length():w2.length();
        int l1 = w1.length();
        int l2 = w2.length();
        int[][] dp = new int[l1+1][l2+1];
        for(int i=0;i<=l1;i++)
            dp[i][0] = i;
        for(int j=0;j<=l2;j++)
            dp[0][j] = j;

        for(int i=1;i<=l1;i++){
			for(int j=1;j<=l2;j++){
 			   int min = Math.min(dp[i-1][j],dp[i][j-1])+1;
               if(w1.charAt(i) == w2.charAt(j))
 					min = Math.min(dp[i-1][j-1],min);
               dp[i][j] = min;
 			}
		}
        return dp[l1][l2];
    }
}
