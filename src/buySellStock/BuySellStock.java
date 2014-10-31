package buySellStock;
public class BuySellStock{
	public int maxProfit(int[] A){
		if(A == null || A.length < 2) return 0;
		int maxP = 0;
		int sum = 0;
		for(int i=1;i<A.length;i++){
			sum += A[i] - A[i-1];	
			sum = Math.max(sum,0);
			maxP = Math.max(maxP,sum);
		}
        return maxP;
	}
}
