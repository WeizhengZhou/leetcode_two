package jumpGame;
public class JumpGame{
	public boolean canJump(int[] A){
		if(A == null) return false;
        int l = 0;//maintain a window [l,r] that can be reached
        int r = 0;
        while(r<A.length){
            int max = r;//right most index can be reached from [l,r]
			for(int i=l;i<=r;i++){
            	max = Math.max(max,i+A[i]);//update max
            }
            if(r == max) break;//can go any further
            l = r+1;
            r = max;
		}
        if(r < A.length-1) return false;
        else return true;
	}
}
