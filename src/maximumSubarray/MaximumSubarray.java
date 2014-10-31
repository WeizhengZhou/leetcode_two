package maximumSubarray;

public class MaximumSubarray{
/*
	public int maxSubArray(int[] A){
    	if(A == null) return 0;
        int max_so_far = Integer.MIN_VALUE;
        int max_cur = 0;
        for(int i=0;i<A.length;i++){
			max_cur += A[i];
            max_so_far = Math.max(max_so_far,max_cur);
            max_cur = Math.max(max_cur,0);	
        }
        return max_so_far;
    }
*/   
    public int maxSubArray(int[] A){
   		if(A == null) return 0;
        return helper(A,0,A.length-1);
    }
    private int helper(int[] A, int l, int r){
    	System.out.println("l = " + l + ", r= " + r);
    	if(l>r) return Integer.MIN_VALUE;
    	if(l==r) return A[l];
        int m = l+(r-l)/2;
        int leftMax = helper(A,l,m);//left max subarray's sum
        int rightMax = helper(A,m+1,r);//right max subarray's sum
        int max = Math.max(leftMax,rightMax);

        int leftCrossMax = Integer.MIN_VALUE;//left max cross middle
        int rightCrossMax = Integer.MIN_VALUE;//right max cross middle

        int sum = 0;
        int i = m;
        while(i>=l){
           sum += A[i--];
           leftCrossMax = Math.max(leftCrossMax,sum); 
        }
        i = m+1;
        sum = 0;
        while(i<=r){
   			sum += A[i++];
            rightCrossMax = Math.max(rightCrossMax,sum); 
 		}
        return Math.max(max,leftCrossMax+rightCrossMax);
    }
    public static void main(String[] args){
    	int[] A = new int[]{-1,2,3};
    	System.out.println(new MaximumSubarray().maxSubArray(A));
    }
}
