package linkedListCycleII;

import util.ListNode;

public class LinkedListCycleII{
	public ListNode detectCycle(ListNode head){
		if(head == null || head.next == null) return null;
		
        ListNode slow = head;//both start at head
        ListNode fast = head;

        while(fast != null && fast.next != null){
			slow = slow.next;
            fast = fast.next.next;	
            if(slow == fast) break;//move first, then check, which makes it easier
		}
        if(fast == null || fast.next == null) return null;
        ListNode start = head;
 		while(start != fast){
			start = start.next;
            fast = fast.next; 
		}
        return start;
    }
	public static void main(String[] args){
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
//		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(4);
//		head.next.next.next.next = head.next;
		head.next.next = head;
		
		LinkedListCycleII s = new LinkedListCycleII();
		ListNode enter = s.detectCycle(head);
		System.out.println(enter.val);
		
	}
}
