package balancedBT;

import util.TreeNode;
public class BalancedBT{
	public boolean isBalanced(TreeNode root){
 		return helper(root) != -1;

    }
    //
    // return height of tree if it is balanced
    // else return -1
    private int helper(TreeNode root){
       if(root == null) 
       		return 0;
       int leftHeight = helper(root.left);
       int rightHeight = helper(root.right);
       if(leftHeight == -1 || rightHeight == -1 
          || Math.abs(leftHeight - rightHeight) > 1)
           return -1;
       else
           return Math.max(leftHeight,rightHeight)+1;
    }

}
