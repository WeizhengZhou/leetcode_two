package buySellStockIII/;

public class BuySellStockIII{
	public int maxProfit(int[] A){
		if(A == null || A.length < 2) return 0;
		int[] left = new int[A.length];//max profit end at i
		int[] right = new int[A.length];//max profit start at i
		int cur = 0;//current sum
		int max = Integer.MIN_VALUE;//max one transition profit earned end at i
		for(int i=1;i<A.length;i++){
			cur += A[i]-A[i-1];//compute new sum
			cur = Math.max(cur,0);//if cur < 0, clear it
			max = Math.max(max,cur);//update new max
			left[i] = max;//store max profit in this arry
		}
        cur = 0;//current sum
		max = Integer.MIN_VALUE;//max on transition profit earned start at i
		for(int i=A.length-2;i>=0;i--){
			cur += A[i+1] - A[i];	
			cur = Math.max(cur,0);
			max = Math.max(max,cur);
			right[i] = max;		
		}
		max = Integer.MIN_VALUE;
		for(int i=0;i<A.length;i++){
			max = Math.max(max,left[i]);//one transition end at i
			max = Math.max(max,right[i]);//one transition start at i
			max = Math.max(max,left[i]+right[i]);//two transitions
		}
		return max;
	}
}
