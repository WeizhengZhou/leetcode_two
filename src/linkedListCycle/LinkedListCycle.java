package linkedListCycle;
import util.ListNode;

public class LinkedListCycle{
	public boolean hasCycle(ListNode head){
        if(head == null) return false;
		ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            if(fast == slow) break;//meet in the cycle
			slow = slow.next;//move one step
            fast = fast.next.next;//move one step
		}
        if(fast == null || fast.next == null) return false; //fast exists the list
        else return true;//they meet in the cycle 
	}
}
