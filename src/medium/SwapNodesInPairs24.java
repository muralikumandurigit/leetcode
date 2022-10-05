package medium;

public class SwapNodesInPairs24 {
/*
 * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)

 

Example 1:


Input: head = [1,2,3,4]
Output: [2,1,4,3]
Example 2:

Input: head = []
Output: []
Example 3:

Input: head = [1]
Output: [1]
 

Constraints:

The number of nodes in the list is in the range [0, 100].
0 <= Node.val <= 100
 */
	
	  public class ListNode {
		      int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
        	return head;
        }
        
        ListNode newHead = head.next;
        head.next = newHead.next;
        newHead.next = head;
        
        for (ListNode t = head; t.next != null && t.next.next!=null;) {
        	ListNode n1 = t.next;
        	ListNode n2 = t.next.next;
        	n1.next = n2.next;
        	n2.next = n1;
        	t.next = n2;
        	t = n1;
        }
        return newHead;
    }
}
