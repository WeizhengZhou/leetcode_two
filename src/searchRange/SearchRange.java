package searchRange;

public class SearchRange{
	public int[] searchRange(int[] A, int target){
        int start = helper(A,0,A.length-1,target,true);
        int end = helper(A,0,A.length-1,target,false);
        return new int[]{start,end};

    }
    private int helper(int[] A, int l, int r, int target, boolean isStart){
        if(A == null) return -1;
        if(l<0 || r>=A.length || l>r) return -1;
        int m = l + (r-l)/2;
        if(A[m] == target){
            if(isStart == true){
				if(m ==0 || A[m-1] < target)//m is the start of target
                	return m; 
                else
                    return helper(A,l,m-1,target,isStart);//m is not the start
            }
            else{
				if(m == A.length-1 || A[m+1] > target)//m is the end of target
                	return m;
                else
                    return helper(A,m+1,r,target,isStart);//m is not the end of target
            }
        }
        else if(target < A[m]){//target is smaller than A[m], search on left half
 			return helper(A,l,m-1,target,isStart);
        }
        else//search on right half
            return helper(A,m+1,r,target,isStart);
    }
}
