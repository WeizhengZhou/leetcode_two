package  convertSortListToBST;

import util.*;
public class ConvertSortListToBST{
	public TreeNode sortedListToBST(ListNode head){
		if(head == null) 
			return null;	
        if(head.next == null) 
            return new TreeNode(head.val);
        
        //list has at least two nodes
        // divide the list into two half, middle node as the root 
        //left half start with head and end with preMiddle
        // right haft start with middle.next
        ListNode cur = head;
        ListNode preMiddle = null;//node before middle node
        ListNode middle = head;//middle node of list
        while(cur != null && cur.next != null){
            preMiddle = middle;
			middle = middle.next;
            cur = cur.next.next;
		}
        assert preMiddle != null;//since list has at least two nodes 
        preMiddle.next = null;//cut list into two halves 
         
        TreeNode root = new TreeNode(middle.val);//create root node
        root.left = sortedListToBST(head);//recursively convert left subtree
        root.right = sortedListToBST(middle.next);//recursively convert right subtree
        return root; 
	}
}
