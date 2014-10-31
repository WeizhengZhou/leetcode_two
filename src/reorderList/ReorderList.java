package reorderList;
import util.ListNode;
public class ReorderList{
	public void reorderList(ListNode head){
        if(head == null) return;
        ListNode middle = getMiddle(head);//middle point of the list
        assert middle != null;
        ListNode left = head;//left half of the list
        ListNode right = middle.next;//right half of the list
        middle.next = null;//cut at middle
        right = reverse(right);//reverse right half
        head = merge(left,right);//merge two halves
        
    }
    private ListNode getMiddle(ListNode head){
    	ListNode one = head;
        ListNode two = head;	
		while(two != null && two.next != null){
  	    	one = one.next;
  			two = two.next.next;
		}
        return one;
    }
    private ListNode reverse(ListNode head){
        if(head == null) return null;
        ListNode nh = head;
        ListNode next = head.next;
        head.next = null;
        head = next;
        while(head != null){
        	next = head.next;
            head.next = nh;
            nh = head;
            head = next;
        }
        return nh;
    }
    private ListNode merge(ListNode a, ListNode b){
    	ListNode dh = new ListNode(0);
        ListNode tail = dh;
        boolean isANext = true;
        while(a != null && b != null){
             if(isANext == true){
                 tail.next = a;
                 a = a.next;
             }
             else{
                 tail.next = b;
                 b = b.next;
             }
             tail = tail.next;
             isANext = !isANext;
        }
        tail.next = (a != null)?a:b;
        return dh.next;
    }
    public static void main(String[] args){
    	ListNode head = new ListNode(1);
    	head.next = new ListNode(2);
    	head.next.next = new ListNode(3);
    	head.next.next.next = new ListNode(4);
    	head.next.next.next.next = new ListNode(5);
    	
    	ReorderList solution = new ReorderList();
    	solution.reorderList(head);
    	solution.print(head);

    }
    private void print(ListNode head){
    	while(head != null){
    		System.out.print(head.val + ", ");
    		head = head.next;
    	}
    	System.out.println();
    }
}
