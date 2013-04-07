public class removeRepeat {
	public static void main(String args[]) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(2);

		n1.next = n2;
		n2.next = n3;

		Solution cl = new Solution();


		ListNode node = cl.deleteDuplicates(n1);

		if (node != null) {
			while(node != null) {

				System.out.println(node.val);
				node = node.next;
			}

		} else {

			System.out.println("null");
		}
	}

}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode node = head;
        ListNode next = null;
        ListNode prev = null;
        ListNode tmpHead = head;
        
        while (node != null && node.next != null) {
            next = node.next;
            
            if (next != null && next.val == node.val)
                next = next.next;
            
            if (node.next != next) {
                if (prev == null) {
                    tmpHead = next;
                    prev = null;
                    node = next;
                } else {
                    prev.next = next;
                    //prev = node;
                    node = next;
                }
                
            } else {
                prev = node;
                node = node.next;
            }
            
            
            
        }
        
        return tmpHead;
    }
}
