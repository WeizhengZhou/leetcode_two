package maximumDepthBT;

import util.TreeNode;
public class MaximumDepthBT{
	public int maxDepth(TreeNode root){
   		if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth,rightDepth)+1;
    }
}
