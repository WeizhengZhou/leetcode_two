package constructSTfromInorderPostOrderTraversal;


import util.TreeNode;

import java.util.Arrays;
public class ConstructSTfromInorderPostOrderTraversal{
	public TreeNode buildTree(int[] inorder, int[] postorder) {
       if(inorder == null || postorder == null || inorder.length != postorder.length)
           return null;
       return helper(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    	    
    }
    private TreeNode helper(int[] in, int inL, int inR, int[] post, int postL, int postR){
//    	System.out.println("inL = " + inL + ", inR = " + inR + ", postL = " + postL + ", postR = " + postR);
    	if(inR - inL != postR - postL) return null;
        if(inL > inR) return null;

        TreeNode root = new TreeNode(post[postR]);
        int inRootIndex = search(in,inL,inR,post[postR]);
        //inorder traversal is divided into left and right subtree at inRootIndex
        int inLeftSubtreeLastIndex = inRootIndex - 1;//index of left subtree's last element in inorder 
        int inRightSubtreeFirstIndex = inRootIndex + 1;//index of right subtree's first element in inorder
       
        int leftSubtreeLength = inLeftSubtreeLastIndex - inL + 1;//length of left subtree
        //postorder traversal, the fisrt (leftSubtreeLength) elements are in left subtree
        int postLeftSubtreeLastIndex = postL + leftSubtreeLength - 1;
        int postRightSubtreeFirstIndex = postLeftSubtreeLastIndex + 1;
        //recursively construct left subtree and right subtree
        root.left = helper(in,inL,inLeftSubtreeLastIndex,post,postL,postLeftSubtreeLastIndex);
        root.right = helper(in,inRightSubtreeFirstIndex,inR,post,postRightSubtreeFirstIndex,postR-1);
        return root; 
    }
    private int search(int[] A, int l, int r,int target){
    	if(A == null || l<0 || r>=A.length) return -1;
    	for(int i=l;i<=r;i++)
    		if(A[i] == target) return i;
    	return -1;   	
    }
    public static void main(String[] args){
    	int[] inorder = new int[]{1,2};
		int[] postorder = new int[]{2,1};
		
		ConstructSTfromInorderPostOrderTraversal s = new ConstructSTfromInorderPostOrderTraversal ();
		TreeNode root = s.buildTree(inorder, postorder);
		System.out.println(root);		
	}
}
