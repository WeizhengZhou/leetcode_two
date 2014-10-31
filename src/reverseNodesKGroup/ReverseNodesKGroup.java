package reverseNodesKGroup;

import util.ListNode;
public class ReverseNodesKGroup{
	public ListNode reverseKGroup(ListNode head, int k){
		if(head == null || head.next == null || k<=1) return head;//no need to reverse
        ListNode dh = new ListNode(0);//dummy head
        dh.next = head;
        ListNode tail = dh;//tail of result list

        ListNode subHead = head;//sublist's head
        ListNode subTail = null;//sublist's tail
        ListNode postSubTail = null;//post node of sublist' tail

        while(subHead != null){//traverse all nodes in list
            int count = 1;//counting how many nodes in sublist
            subTail = subHead;
			while(subTail.next != null && count < k){//find the sublist
			    subTail = subTail.next;
                count++;
			}
            if(count < k) break;//sublist's length is smaller than k, no need to reverse	
       
		    postSubTail = subTail.next;//store post sublist's tail
            subTail.next = null;//cut sublist 
            reverse(subHead);//reverse sublist
            
            tail.next = subTail;//append sublist's head (pointed by subTail) to the tail
            subHead.next = postSubTail;//connect sublist's tail with post subtail
            tail = subHead;//assign new tail of result list
            subHead = postSubTail;//assign next sublist's head
		}
        return dh.next;//dummy head's next node
	}
    private void reverse(ListNode head){//reverse list
		if(head == null) return;
        ListNode nh = head;
        ListNode next = head.next;
        head.next = null;
        head = next;
        while(head != null){
			next = head.next;
            head.next = nh;
            nh = head;
            head = next;
		}
	}
    public static void main(String[] args){
    	ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
    	
        ReverseNodesKGroup solution = new ReverseNodesKGroup();
    	ListNode res = solution.reverseKGroup(head, 3);

    	while(res != null){
    		System.out.print(res.val + "->");
    		res = res.next;
    	}
    	System.out.println();
    	
    }
}
