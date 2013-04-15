/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null || head.next == null)
            return head;
        
        ListNode node;
        ListNode pre;
        ListNode tmp1;
        ListNode tmp2;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //head = dummy;
        
        pre = dummy;
        node = dummy.next;
        
        while (node != null && node.next != null) {
                
            //tmp1 = node;
            //tmp2 = node.next;
            
            // swp
            pre.next = node.next;
            node.next = pre.next.next;
            pre.next.next = node;
            
            // next
            pre = pre.next.next;
            node = pre.next;
        }
        
        return dummy.next;
    }
}
