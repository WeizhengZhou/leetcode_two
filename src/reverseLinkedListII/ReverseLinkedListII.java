package reverseLinkedListII;

import util.ListNode;

public class ReverseLinkedListII{
	public ListNode reverseBetween(ListNode head, int m, int n){
		ListNode dh = new ListNode(0);	
		ListNode tail = dh;
		ListNode preTail = null;
		ListNode nextHead = null;	
		int count = 0;
		while(head != null){
			count ++;
			if(count <= m){
				preTail = tail;
				tail.next = head;
				tail = tail.next;
				head = head.next;
			}
			else if(count <= n){	
			    nextHead = head.next;
				head.next = preTail.next;
				preTail.next = head;	
 				head = nextHead;
		   }
           else
				break;	
		}
		tail.next = head;
		return dh.next;
	}
	public static void main(String[] args){
		ReverseLinkedListII solu = new ReverseLinkedListII();

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		ListNode res = solu.reverseBetween(head,1,3);
		while(res != null){
			System.out.print(res.val + "->");
			res = res.next;
		}

		System.out.println();
	}
}
