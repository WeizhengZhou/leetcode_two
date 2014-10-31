package removeDuplicatesSortedListII;
import util.*;
public class RemoveDuplicatesSortedListII{
	public ListNode deleteDuplicates(ListNode head) {
    	if(head == null || head.next == null) return head;
        ListNode dh = new ListNode(head.val-1);
        dh.next = head;
        ListNode tail = head;
        head = head.next;
        ListNode preTail = dh;
      
        int previous = tail.val; 
        while(head != null){
			if(head.val == previous){
				preTail.next = null;
                tail = preTail;
			}
            else{
				tail.next = head;
                preTail = tail;
 				tail = head;
                previous = tail.val;
			}
            head = head.next;
		}
        tail.next= null;
        return dh.next; 
    }
    public static void main(String[] args){
		RemoveDuplicatesSortedListII solu = new RemoveDuplicatesSortedListII();
        ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
        head = solu.deleteDuplicates(head);
        while(head != null){
			System.out.print(head.val + "->");
			head = head.next;
		}
		System.out.println();
	}
}
