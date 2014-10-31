package btLevelTraversal;
import java.util.*;
import util.TreeNode;
public class BTLevelOrderTraversal{
	public List<List<Integer>> levelOrder(TreeNode root){
        if(root == null) return new LinkedList<List<Integer>>();
        List<Integer> list = new LinkedList<>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> curLevel = new LinkedList<>();
        Queue<TreeNode> nextLevel = new LinkedList<>();
        TreeNode cur = root;
        curLevel.add(cur);
        while(!curLevel.isEmpty()){
			cur = curLevel.remove();
            list.add(cur.val);
            if(cur.left != null) nextLevel.add(cur.left);
            if(cur.right != null) nextLevel.add(cur.right);
            if(curLevel.isEmpty()){
				res.add(new LinkedList<>(list));
                curLevel = new LinkedList<>(nextLevel);
                nextLevel.clear();
                list.clear();
			}
		}
        return res;
       

	}
}
