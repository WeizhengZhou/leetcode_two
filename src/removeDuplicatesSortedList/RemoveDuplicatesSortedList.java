package removeDuplicatesSortedList;
import util.*;
public class RemoveDuplicatesSortedList{
	public ListNode deleteDuplicates(ListNode head){
		if(head == null || head.next == null) return head;
		ListNode dh = new ListNode(head.val-1);
        ListNode tail = dh;
        while(head != null){
			if(tail.val != head.val){
				tail.next = head;
				tail = tail.next;
			}
			head = head.next;
		}
 		return dh.next;
	}
}
