package populateNextRightPointer;
import java.util.*;
public class PopulateNextRightPointer{
	public void connect(TreeLinkNode root){
    	if(root == null) return;
        TreeLinkNode pre = null;
        TreeLinkNode cur = root;
        cur.next = null;

        Queue<TreeLinkNode> curLevel = new LinkedList<>();//List interface does not have method list.remove()
        Queue<TreeLinkNode> nextLevel = new LinkedList<>();
        curLevel.add(cur);
        while(!curLevel.isEmpty()){
			cur = curLevel.remove();
            if(pre != null) pre.next = cur;
		    pre = cur;	

            if(cur.left != null) nextLevel.add(cur.left);
            if(cur.right != null) nextLevel.add(cur.right);

            if(curLevel.isEmpty()){
				curLevel = new LinkedList<>(nextLevel);
                nextLevel.clear();
                pre = null;
			}
		}
	}
}
class TreeLinkNode{
	int val;
    TreeLinkNode left,right,next;
    TreeLinkNode(int x){this.val = x;}
}
