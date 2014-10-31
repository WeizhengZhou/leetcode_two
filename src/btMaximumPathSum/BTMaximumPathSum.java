package btMaximumPathSum;

import util.TreeNode;


public class BTMaximumPathSum{
    private int maxPathSum = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root){
        if(root == null) return 0;
		helper(root);
        return this.maxPathSum;
	}
    private Result helper(TreeNode root){
    	if(root == null) 
           return new Result(0,0);
        Result leftRes = helper(root.left);
        Result rightRes = helper(root.right);
        int crossSum = leftRes.startSum + rightRes.startSum + root.val;
        int startSum = Math.max(0,Math.max(leftRes.startSum,rightRes.startSum)) + root.val; 
        maxPathSum = Math.max(Math.max(crossSum,startSum), maxPathSum);
        return new Result(crossSum, startSum);
	}
    class Result{
		int crossSum = 0;
        int startSum = 0;
        Result(int c, int s){
			this.crossSum = c;
            this.startSum = s;
		}
	}
    public static void main(String[] args){

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(4);
		root.right.left = new TreeNode(10);
		BTMaximumPathSum s = new BTMaximumPathSum();
		System.out.println(s.maxPathSum(root));
				
	}
}
