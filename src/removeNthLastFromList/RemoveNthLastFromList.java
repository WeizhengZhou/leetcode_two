package removeNthLastFromList;
import util.ListNode;
public class RemoveNthLastFromList{
//	public ListNode removeNthFromList(ListNode head, int n) {
//        ListNode pre = head;
//        ListNode cur = head;
//        while(cur != null){
//            if(n<=0)				
//                pre = pre.next;
//            cur = cur.next;
//            n--;
//		}
//		if(n>=0)
//             return head.next;
//        else{
//	 		pre.next = pre.next.next;
// 			return head;
//		}
//    }
    public ListNode removeNthFromList(ListNode head, int n){
        if(head == null) return null;
   		ListNode dh = new ListNode(0);
        dh.next = head;
        ListNode pre = dh;
        ListNode cur = head;
        n++;
        while(cur != null){
			if(n<=0)
				pre = pre.next;
            cur = cur.next;
            n--;	
		}
        pre.next = pre.next.next;
        return dh.next;
    }
}
