package mergeKSortedLists;

import java.util.*;
import util.*;
public class MergeKSortedLists{
	public ListNode mergeKLists(List<ListNode> lists){
		if(lists == null || lists.size() == 0) return null;
		if(lists.size() == 1) return lists.get(0);
		if(lists.size() == 2){
			return megerTwoLists(lists.get(0),lists.get(1));	
		}
		int m = lists.size()/2;
		ListNode l1 = mergeKLists(lists.subList(0,m));
		ListNode l2 = mergeKLists(lists.subList(m,lists.size()));
		return mergeTwoLists(l1,l2);
	
	}
	private ListNode mergeTwoLists(ListNode l1, ListNode l2){
		ListNode dh = new ListNode(0);
		ListNode tail = dh;
		while(l1 != null && l2 != null){
		    if(l1.val < l2.val){
				tail.next = l1;
				l1 = l1.next;
			}
			else{
				tail.next = l2;
				l2 = l2.next;
			}
            tail = tail.next;
		}
		tail.next = (l1 != null) ? l1:l2;
		return dh.next;
	}
}
