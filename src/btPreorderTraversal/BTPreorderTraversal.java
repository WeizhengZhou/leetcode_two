package btPreorderTraversal;
import util.TreeNode;
import java.util.*;
public class BTPreorderTraversal{
	public List<Integer> preordderTraversal(TreeNode root){
		Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> res =  new LinkedList<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
			if(cur != null){
				res.add(cur.val);
                stack.push(cur);
                cur = cur.left;
			}
            else{
				cur = stack.pop();
                cur = cur.right;
			}
		}
        return res;
	}

}
