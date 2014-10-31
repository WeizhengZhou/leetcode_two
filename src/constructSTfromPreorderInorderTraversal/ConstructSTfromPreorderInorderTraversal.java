package constructSTfromPreorderInorderTraversal;
import util.*;
public class ConstructSTfromPreorderInorderTraversal{
	public TreeNode buildTree(int[] preorder, int[] inorder){
		if(preorder == null || inorder == null || preorder.length != inorder.length) return null;
		return helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
	}

    private TreeNode helper(int[] pre, int pL, int pR, int[] in, int iL, int iR){
		if(pR - pL != iR - iL) return null;//throw invalid state exception
		if(pL > pR) return null;
		TreeNode root = new TreeNode(pre[pL]);//first element in preorder traversal is root
        int inRootIndex = findElement(in,iL,iR,pre[pL]);//find root's index in inorder traversal
        int lengthLeftSubtree = inRootIndex - iL;//length of leftsubtree
        int pLeftSubtreeEndIndex = pL+1 + lengthLeftSubtree - 1;//preorder traversal left subtree's end index
        int pRightSubtreeStartIndex = pLeftSubtreeEndIndex+1;//preorder traversal right subtree's start index
		root.left = helper(pre,pL+1,pLeftSubtreeEndIndex,in,iL,inRootIndex-1);//recursively build left subtree
        root.right = helper(pre,pRightSubtreeStartIndex,pR,in,inRootIndex+1,iR);
        return root;
       
	}
    private int findElement(int[] A, int l, int r, int target){
		for(int i=l;i<=r;i++)
			if(A[i] == target) return i;
		return -1;
	}
}
