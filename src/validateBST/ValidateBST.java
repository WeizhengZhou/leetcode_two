package validateBST;

import util.TreeNode;
public class ValidateBST{
	public boolean isValidBST(TreeNode root){
   		return isInRange(root,Integer.MIN_VALUE,Integer.MAX_VALUE)	;
    }
    private boolean isInRange(TreeNode root, int min, int max){
    	if(root == null) return true;
        if(root.val <= min || root.val >= max) return false;
        return isInRange(root.left,min,root.val) && isInRange(root.right,root.val,max);
	}
}
