package btInorderTraversal;

import util.TreeNode;
import java.util.*;
public class BTInorderTraversal{
	public List<Integer> inorderTraversal(TreeNode root){
       
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> res = new LinkedList<>();

        while(cur != null || !stack.isEmpty()){
			if(cur != null){
            	stack.push(cur);
                cur = cur.left;
            }
            else{
				cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
	}

}

