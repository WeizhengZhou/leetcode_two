package searchInsertPosition;
public class SearchInsertPosition{
	public int searchInsert(int[] A, int target){
		if(A == null) return 0;	
		return helper(A,0,A.length-1,target);	
	}
	private int helper(int[] A, int l, int r, int target){
		if(l>r){
			if(r < 0) return 0;
			else if(l >= A.length) return A.length;
			else if(target < A[r]) return r;
			else if(target > A[l]) return l+1; 
			else return  l;
		}
		int m = l + (r-l)/2;
		if(A[m] == target) return m;
		else if(target < A[m]) return helper(A,l,m-1,target);
		else return helper(A,m+1,r,target);
	}
	public static void main(String[] args){
		SearchInsertPosition solu = new SearchInsertPosition();
		int[] A = new int[]{1,3,5,6};
		int target = 3;
		System.out.println("target = " + target + ", position = " + solu.searchInsert(A,target) + " expect = " + 1);
		target = 0;
		System.out.println("target = " + target + ", position = " + solu.searchInsert(A,target) + ", expect = " + 0);
		target = 2;
		System.out.println("target = " + target + ", position = " + solu.searchInsert(A,target)+ ", except = " + 1);
		target = 7;
		System.out.println("target = " + target + ", position = " + solu.searchInsert(A,target) + ", except = " + 4);
	}
}
