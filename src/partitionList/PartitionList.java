package partitionList;

import util.ListNode;
public class PartitionList{
	public ListNode partition(ListNode head, int x){
		ListNode smallHead = new ListNode(0);
 		ListNode smallTail = smallHead;
		ListNode largeHead = new ListNode(0);
		ListNode largeTail = largeHead;
		while(head != null){
			if(head.val < x){
				smallTail.next = head;
				smallTail = smallTail.next;
			}
			else{
				largeTail.next = head;
				largeTail = largeTail.next;
			}
			head = head.next;
		}
		smallTail.next = largeHead.next;
		return smallHead.next;	
	}
	public static void main(String[] args){
		ListNode head = new ListNode(1);
		head.next = new ListNode(3);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(5);
		PartitionList solu = new PartitionList();
		ListNode res = solu.partition(head,3);
		while(res != null){
				System.out.print(res.val + "->");
				res = res.next;
		}
	}
}
