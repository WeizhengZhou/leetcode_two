package rotateList;

import util.ListNode;
public class RotateList{
	public ListNode rotateRight(ListNode head, int k){
		if(head == null || head.next == null) return head;
        int length = length(head);
        k = k%length;
        if(k == 0) return head;
        ListNode preNewHead = head;
        ListNode cur = head;
        while(cur.next != null){
			if(k>0)
                k--;
            else 
				preNewHead = preNewHead.next;
             cur = cur.next;
		}
        ListNode newHead = preNewHead.next;
        preNewHead.next = null;
        cur.next = head;
        return newHead;
		
	}
    private int length(ListNode head){
		int length = 0;
        while(head != null){
			length++;
            head = head.next;
		}
        return length;
	}
}
