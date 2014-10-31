package swapNodesinPairs;

import util.ListNode;

public class SwapNodesinPairs{
	public ListNode swapPairs(ListNode head){
		if(head == null) return head;
        
        ListNode dh = new ListNode(0);//dummy head
        ListNode tail = dh;//tail of result list
        ListNode one = head;//first node in pair
        ListNode two = null;//second node in pair
        ListNode nextOne = null;//store next One node

        while(one != null && one.next != null){//until has at least two nodes
            two = one.next;//assign two
			nextOne = two.next;//store next one
            tail.next = two;//append two to the tail
            two.next = one;//append one to the tail
            one.next = null;//tail.next == null
            tail = one;//assign new tail
            one = nextOne;//go to next one node
		}
        if(one != null) tail.next = one;//only one node left, append it to the tail
        return dh.next;
	}
}
