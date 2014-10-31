package candy;
public class Candy{
	public int candy(int[] A){
		if(A == null || A.length == 0)  return 0;
		int[] left = new int[A.length];
		int[] right = new int[A.length];
		left[0] = 1;
		for(int i=1;i<A.length;i++){
			if(A[i] > A[i-1]) left[i] = left[i-1]+1;
			else left[i] = 1;
		}	 
		right[A.length-1] = 1;
		for(int i=A.length-2;i>=0;i--){
			if(A[i] > A[i+1]) right[i] = right[i+1]+1;
			else right[i] = 1;
		}
		
		int sum = 0;
		for(int i=0;i<A.length;i++){
			sum += Math.max(left[i],right[i]);
		}
		return sum;
	}
}
