package btZigZagLevelTraversal;


import util.*;
import java.util.*;

public class BTZigZagLevelTraversal{
	public List<List<Integer>> zigzagLevelOrder(TreeNode root){
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;
        Stack<TreeNode> curLevel = new Stack<>();//current Level stack
        Stack<TreeNode> nextLevel = new Stack<>();//next Level stack
        List<Integer> list = new LinkedList<>();//current level's result
        curLevel.push(root);
		boolean isLeft2Right = true;//is left to right order in this level
        while(!curLevel.isEmpty()){
			TreeNode curNode = curLevel.pop();//pop a node from current level
            list.add(curNode.val);//add it to current level's result
            if(isLeft2Right){//is left to right order
				if(curNode.left != null) nextLevel.add(curNode.left);
                if(curNode.right != null) nextLevel.add(curNode.right);
			}
            else{
                if(curNode.right != null) nextLevel.add(curNode.right);	
	 			if(curNode.left != null) nextLevel.add(curNode.left);
			}
            if(curLevel.isEmpty()){
                curLevel = (Stack<TreeNode>) nextLevel.clone();
                nextLevel = new Stack<>();
				res.add(new LinkedList<>(list));
                list.clear();
                isLeft2Right = !isLeft2Right;
			}
		}
        return res;
	}
	public  static void main(String[] args){
		   
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		
		root.right.right = new TreeNode(7);
		BTZigZagLevelTraversal s = new BTZigZagLevelTraversal();
		List<List<Integer>> lists = s.zigzagLevelOrder(root);
		Util.printLists(lists);
	
	}
}
