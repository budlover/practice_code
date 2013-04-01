// reverse link list between node m and node n

public class reverseLinkelist {
	public static void main(String args[]) {
		ListNode n1 = new ListNode(1);

		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		

		Solution cl = new Solution();

		ListNode ret = cl.reverseBetween(n1, 3, 4);

		while (ret != null) {
			System.out.println(ret.val);
			ret = ret.next;
		}

	}

}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {val = x;next = null;}
}

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (m >= n)
            return head;
        
        int c = 1;
        ListNode realHead = head;
        ListNode node = head;
        ListNode stop = head;
        ListNode tmp;
        ListNode tmpHead = null;
        
		if (m == 1) {
			node = new ListNode(0);
			node.next = head;
			c = 0;
			realHead = node;
			
			System.out.println("m == 1");
        }
        
		System.out.println("c: " + c + " node: " + realHead.val);
        while (node != null) {
            if (c + 1 == m) {
				System.out.println("c: " + c + " node: " + node.val);
                stop = node;
                node = node.next;
                // tmpHead = node.next;
            } else if (c == m) {
				System.out.println("c == m, c: " + c + " node: " + node.val);
                
				tmpHead = node;
                node = node.next;

            } else if (c > m && c <= n) {
				System.out.println("c: " + c + " node: " + node.val);
                
				tmp = node.next;
                node.next = tmpHead;
                tmpHead = node;
                node = tmp;
                
                if (c == n) {
                    tmp = stop.next;
                    stop.next = tmpHead;
                    tmp.next = node;
                    
                    break;
                }
            } else {
				node = node.next;
			}
            
            c++;            
        }
        
        if (m == 1)
            realHead = realHead.next;
        
        return realHead;
    }
}
