package sameTree;
import util.TreeNode;
public class SameTree{
	public boolean isSameTree(TreeNode a, TreeNode b){
		if(a == null && b == null) return true; 
        if(a == null || b == null) return false;
        return (a.val == b.val) &&
               isSameTree(a.left,b.left) && 
               isSameTree(a.right,b.right); 

	}
}
