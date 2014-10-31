package pathSum;
import util.TreeNode;


public class PathSum{
    public boolean hasPathSum(TreeNode root, int sum){
		if(root == null)
        	return sum==0;
        return helper(root,sum);

    }
	public boolean helper(TreeNode root, int sum){
        assert root != null;
		if(root.left == null && root.right == null){//root is a leaf
        	return root.val == sum;
         }
         else{
            boolean pathSum = false;
            if(root.left != null) //has left child
            	pathSum = pathSum || hasPathSum(root.left,sum-root.val);
            if(root.right != null)//has right child
			     pathSum = pathSum || hasPathSum(root.right,sum-root.val);
            return pathSum; 
        }
		

    }

}
