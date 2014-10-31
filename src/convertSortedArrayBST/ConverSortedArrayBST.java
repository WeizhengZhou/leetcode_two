package convertSortedArrayBST;
import util.*;
public class ConvertSortedArrayBST{
	public TreeNode sortedArrayToBST(int[] A){
		if(A == null) return null;
		return helper(A,0,A.length-1);
	}
	private TreeNode helper(int[] A, int l, int r){
		if(l<0 || r>= A.length || l>r) return null;
		int m = l+(r-l)/2;
		TreeNode root = new TreeNode(A[m]);
		root.left = helper(A,l,m-1);
		root.right = helper(A,m+1,r);
 		return root;
	}
}
