package jumpGameII;
public class JumpGameII{
	public int jump(int[] A){
		if(A == null || A.length <2) return 0;
        int l = 0;
		int r = 0;
		int nSteps = 0;
		while(r < A.length-1){
			int max = r;
			for(int i=l;i<=r;i++){
				max = Math.max(max,A[i]+i);
			}
			if(max == r) break;
			l = r+1;
			r = max;	
			nSteps++;
		}
		if(r < A.length-1) return Integer.MAX_VALUE;
		else return nSteps;
	}
	public static void main(String[] ags){
		JumpGameII solu = new JumpGameII();
//		int[] A = new int[]{2,3,1,1,4};
		int[] A = {2,1};
//		int[] A = {0};
		System.out.println(solu.jump(A));
	}
}
