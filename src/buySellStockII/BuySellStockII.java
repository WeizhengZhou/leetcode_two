package buySellStockII;

public class BuySellStockII{
	public int maxProfit(int[] A){
		if(A == null || A.length < 2) return 0;
        int maxProfit = 0;
        for(int i=1;i<A.length;i++){
			if(A[i] > A[i-1]) maxProfit += A[i] - A[i-1];
		}
        return maxProfit;
	}
}
