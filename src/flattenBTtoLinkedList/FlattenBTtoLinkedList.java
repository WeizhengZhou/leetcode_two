package flattenBTtoLinkedList;
import java.util.*;
import util.*;

public class FlattenBTtoLinkedList{
	//the tail of the linked list
	//must be a global variable, cannot be a argument passing to helper
//	private TreeNode tail = new TreeNode(0);
//	public void flatten(TreeNode root){
//		helper(root);
//    }
//    private void helper(TreeNode root){   	
//         if(root == null) return;   
//         
//         TreeNode left = root.left;//store left child
//         TreeNode right = root.right;//store right child
//         root.left = null;//isolate root
//         root.right = null;//isolate root
//         
//         tail.right = root;//append root to end of list
//         tail = tail.right;
//       
//         helper(left);//recursive flatten left subtree
//         helper(right);//recursive flatten right subtree
//    }
    public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);	
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		
		FlattenBTtoLinkedList s = new FlattenBTtoLinkedList();
		TreeNode res = s.flatten(root);
		while(res != null){
			System.out.print(res.val + "->");
			res = res.right;
		}
//		TreeNode cur = root;
//		while(cur != null){
//			if(cur.left != null)
//				System.out.println(cur.left.val);
//			System.out.print(cur.val + "->");
//			cur = cur.right;
//		}
	}
    public TreeNode flatten(TreeNode root){
    	if(root == null) return null;
    	TreeNode dummyHead = new TreeNode(0);
    	TreeNode tail = dummyHead;
    	TreeNode cur = root;
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	while(cur != null || !stack.isEmpty()){
    		if(cur != null){
    			stack.push(cur);
    			cur = cur.left;
    		}
    		else{
    			cur = stack.pop();
    			tail.right = cur;
    			cur.left = tail;
    			tail = tail.right;
    			cur = cur.right;
    		}
    	}
    	return dummyHead.right;
    	
    }
    
}

