package insertionSortList;

import util.ListNode;
public class InsertionSortList{
	public ListNode insertionSortList(ListNode head){
		if(head == null || head.next == null) return head;
        ListNode nh = head;
        head = head.next;
        nh.next = null;
        while(head != null){
            ListNode nextHead = head.next;//isolate head
            head.next = null;
            if(head.val <  nh.val){
				head.next = nh;
                nh = head;	
			}
            else{
                ListNode p = nh;//previous node where head should locates         
                while(p.next != null && p.next.val < head.val)
 		     		p = p.next;
                head.next = p.next;
                p.next = head;
           }
           head = nextHead;
		}
        return nh;
	}
}
