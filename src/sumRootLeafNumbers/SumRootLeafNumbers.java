package sumRootLeafNumbers;
import util.TreeNode;
public class SumRootLeafNumbers{
	private int totalSum = 0;
	public int sumNumbers(TreeNode root){
		helper(root,0);	
		return totalSum;
	}
    private void helper(TreeNode root, int sum_so_far){
		if(root == null) return;
		if(root.left == null && root.right == null){
			this.totalSum += sum_so_far *10 + root.val;
			return;
		}
		helper(root.left,sum_so_far*10 + root.val);
		helper(root.right,sum_so_far*10 + root.val);
	}
}
