package uniqueBST;

import util.TreeNode;
import java.util.*;
public class UniqueBSTII{
	public List<TreeNode> generateTrees(int n){
		return helper(1,n);
	}

	private List<TreeNode> helper(int l, int r){
		if(l>r){
			List<TreeNode> res = new ArrayList<>();
			res.add(null);
			return res;
		}
		List<TreeNode> res = new ArrayList<>();
		for(int i=l;i<=r;i++){
			List<TreeNode> leftList = helper(l,i-1);
			List<TreeNode> rightList = helper(i+1,r);
			for(TreeNode left:leftList){
				for(TreeNode right:rightList){
					TreeNode root = new TreeNode(i);
					root.left = left;
					root.right = right;
					res.add(root);
				}
			}	
		}
		return res;
	}
}
