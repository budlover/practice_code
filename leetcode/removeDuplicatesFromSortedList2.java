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
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return recur(head);
    }
    
    private ListNode recur(ListNode head) {
        if (null == head) return null;
        if (head.next == null) return head;
        
        ListNode l;
        ListNode r;
        ListNode tmphead = head;
        
        if (head.next.val == head.val) {
            l = head.next;
            while(l != null && l.val == head.val) l = l.next;
            
            if (l == null) return null;
            else {
                return recur(l);
            }
        } else {
            tmphead.next = recur(head.next);
            return tmphead;
        }
    }
}
