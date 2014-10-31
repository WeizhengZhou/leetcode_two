package searchRotatedSortedArrayII;
public class SearchRotatedSortedArrayII{
	public boolean search(int[] A, int target){
		if(A == null) return false;
		return helper(A,0,A.length-1,target);
		
	}
	private boolean helper(int[] A, int l, int r, int target){
		if(l< 0 || l>r || r >= A.length) return false;
		int m = l + (r-l)/2;
        if(A[m] == target) return true;
        if(A[m] > A[l]){
			if(target >= A[l] && target < A[m])
				return helper(A,l,m-1,target);
			else	
				return helper(A,m+1,r,target);
		} 
		else if(A[m] < A[l]){
			if(target <= A[r] && target > A[m])
				return helper(A,m+1,r,target);
			else
				return helper(A,l,m-1,target);
		}
        else
			return helper(A,l+1,r,target);
	}
	public static void main(String[] args){
		SearchRotatedSortedArrayII solu = new SearchRotatedSortedArrayII();
		int[] A = new int[]{1,3,5};
		int target = 3;
		System.out.println(solu.search(A,target) + ", expect = " + "true");

		A = new int[]{1,1,3};
	    target = 3;
		System.out.println(solu.search(A,target) + ", expect = " + "true");
		
		A = new int[]{1,3,3};
		target = 3;
		System.out.println(solu.search(A,target) + ", expect = " + "true");

		A = new int[]{1,1,5};
		target = 3;
		System.out.println(solu.search(A,target) + ", expect = " + "false");


		A = new int[]{5,1,3};
		target = 3;
		System.out.println(solu.search(A,target) + ", expect = " + "true");
	}
    
}
