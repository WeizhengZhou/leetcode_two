package containMostWater;

public class ContainMostWater{
	public int maxArea(int[] A){
		if(A == null) return 0;
        int l = 0;
        int r = A.length-1;
        int area = 0;
        while(l<r){
			area = Math.max(area,Math.min(A[l],A[r]) * (r-l));
            if(A[l] < A[r]) l++;
            else r--;
		}
        return area;
	}
}
