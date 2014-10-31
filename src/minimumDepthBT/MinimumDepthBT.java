package minimumDepthBT;

import util.TreeNode;
public class MinimumDepthBT{
	public int minDepth(TreeNode root){
		if(root == null) return 0;
        return helper(root);	
	}
    private int helper(TreeNode root){
        if(root.left == null && root.right == null) return 1;
        if(root.left == null) return helper(root.right)+1;
        if(root.right == null) return helper(root.left) +1;
        return Math.min(helper(root.left),helper(root.right))+1;
	}
}
