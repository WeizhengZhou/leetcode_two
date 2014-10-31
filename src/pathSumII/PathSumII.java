package pathSumII;

import util.TreeNode;
import java.util.*;
public class PathSumII{
    private List<List<Integer>> res = new ArrayList<List<Integer>>();
	public List<List<Integer>> pathSum(TreeNode root, int sum){
		helper(root,sum,new ArrayList<Integer>());
        return res;
	}
    private void helper(TreeNode root, int sum, List<Integer> list){
		if(root == null) return;
        list.add(root.val);//add current 
        if(root.left == null && root.right == null && root.val == sum)//root to path found
            res.add(new ArrayList<>(list));//add to result
        helper(root.left,sum-root.val,list);
        helper(root.right,sum-root.val,list);
        list.remove(list.size()-1);
	}

    
}
