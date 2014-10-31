package trappingRainWater;

public class TrappingRainWater{
	public int trap(int[] A){
		if(A == null || A.length < 3) return 0;
        int n = A.length;
        int[] leftBar = new int[n];
        int[] rightBar = new int[n];	
        int max = A[0];
        for(int i=1;i<n;i++){
			leftBar[i] = max;
            max = Math.max(max,A[i]);
		}
        max = A[n-1];
        for(int i=n-2;i>=0;i--){
            rightBar[i] = max;
            max = Math.max(max,A[i]);
        }
        int totalWater = 0;
        for(int i=0;i<n;i++){
 			totalWater += Math.max(Math.min(leftBar[i],rightBar[i]) - A[i],0);
        }   
        return totalWater; 
	}
}
