package singleNumberII;
public class SingleNumberII{
	public int singleNumber(int[] A){
		if(A == null) return -1;
		int one = 0;
		int two = 0;
		int mask = 0;
		for(int i=0;i<A.length;i++){
			two = two | (one & A[i]);
			one = one ^ A[i]; 
			mask = one & two;
			one = one^mask;
			two = two^mask;	
		}
		return one;
	}
	public static void main(String[] args){
		SingleNumberII solu = new SingleNumberII();
		int[] A = new int[]{-1,-1,-1,2,1,1,1,0,0,0};
		System.out.println(solu.singleNumber(A) + ", expected = " + 2);
	}
}
