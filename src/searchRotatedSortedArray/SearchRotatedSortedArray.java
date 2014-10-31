package searchRotatedSortedArray;
public class SearchRotatedSortedArray{
	public int search(int[] A, int target){
    	if(A == null || A.length == 0) return -1;
        return helper(A,0,A.length-1,target);
     
    }
    private int helper(int[] A, int l, int r, int target){
    	if(l < 0 || r >= A.length || l>r) 
 			return -1;
        int m = l + (r-l)/2;
        if(A[m] == target) 
            return m;
        else if(A[m] > A[l]){
        	if(target < A[m] && target > A[l])
            	return helper(A,l,m-1,target);
            else
   				return helper(A,m+1,r,target);
        }
        else{
            if(target < A[r] && target > A[m])
                return helper(A,m+1,r,target);
            else
                return helper(A,l,m-1,target);
        }
    }
}
