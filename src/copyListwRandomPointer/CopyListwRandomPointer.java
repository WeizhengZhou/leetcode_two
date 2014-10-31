package copyListwRandomPointer;



public class CopyListwRandomPointer{
	public RandomListNode copyRandomList(RandomListNode head){
	    RandomListNode dh = new RandomListNode(0);//dummy head of copied list
	    RandomListNode tail = dh;//tail of copied list
    	RandomListNode cur = head;//current node in original list
        RandomListNode next = null;//next of original list
        RandomListNode copy = null;//current copied node
        //for each cur node and its next node, insert a copied node between them
       
        while(cur != null){
        	next = cur.next;
            copy = new RandomListNode(cur.label);
            cur.next = copy;
            copy.next = next;
            cur = next;
        }

        //set random pointer for each copied node
        cur = head;
        while(cur != null){
        	copy = cur.next;
        	if(cur.random != null)
        		copy.random = cur.random.next;//set random pointer for copied node
            cur = copy.next;
        }
        //seperate two lists
        cur = head;
        while(cur != null){
        	copy = cur.next;
            cur.next = copy.next;
            tail.next = copy;
            tail = tail.next;
            cur = cur.next;
        }
        
        return dh.next;
    }
	public static void main(String[] args){
		CopyListwRandomPointer s = new CopyListwRandomPointer();
		RandomListNode head = new RandomListNode(1);
		head.next = new RandomListNode(2);
		head.next.next = new RandomListNode(3);
		head.random = head.next.next;
		head.next.next.random = head;	
		
		RandomListNode cp = s.copyRandomList(head);
		s.print(cp);
	}
	private void print(RandomListNode head){
		while(head != null){
			System.out.print(head.label + "->");
			head = head.next;	
		}
		System.out.println();
	}
}
class RandomListNode{
    int label;
    RandomListNode next,random;
    RandomListNode(int x){
   		this.label = x;
    }
}
