package uniqueBT;

import java.util.Arrays;
public class UniqueBT{
    public int numTrees(int n){
        if(n < 0) return 0;
        int[] dp = new int[n+1];//number of trees with n nodes
        dp[0] = 1; //
        for(int i=1;i<=n;i++){//number of trees with i nodes
            int nTrees = 0;
            for(int k=0;k<i;k++){//k = number of nodes in left subtree, can go from 0 to i-1, one used as root
       			nTrees = nTrees + dp[k]*dp[i-k-1];
            }
            dp[i] = nTrees;
        }
        return dp[n];
    }
    public static void main(String[] args){
		int n = 2;
        UniqueBT s = new UniqueBT();
        System.out.println(s.numTrees(n));
	}
}
