package addTwoNumbers;

import util.ListNode;

public class AddTwoNumbers{
	public ListNode addTwoNumbers(ListNode a, ListNode b){
    	ListNode dh = new ListNode(0);//dummy head
        ListNode tail = dh;//tail of result list
        int carry = 0;//carry 
        while(a != null || b != null){//until both list is empty
        	if(a != null){//a is not null
            	carry += a.val; //add a to carry
 				a = a.next;//a move to next
            }
            if(b != null){
				carry += b.val;
                b = b.next;
			}
            tail.next = new ListNode(carry%10);//append to result
            tail = tail.next;//tail moves to next
            carry /= 10;//next carry
        }
        if(carry == 1)//remember carry might equals 1
        	tail.next = new ListNode(1);
        return dh.next;//return dummy head 's next
    }
}
