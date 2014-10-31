package btPostTraversal;

import java.util.*;
import util.TreeNode;
public class BTPostTraversal{
	public List<Integer> postorderTraversal(TreeNode root){
		if(root == null) return new ArrayList<>();	
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> res = new ArrayList<>();
		TreeNode cur = root;
		TreeNode lastVisited = null;
		while(cur != null || !stack.isEmpty()){
			if(cur != null || stack.isEmpty()){
				stack.push(cur);
				cur = cur.left;
			}
			else{
				TreeNode peek = stack.peek();
				if(peek.right != null && peek.right != lastVisited){
					cur = peek.right;
				}
				else{
					res.add(peek.val);
					stack.pop();					
					lastVisited = peek;
				}
			}
		}
		return res;
	}

}
