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
    public ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode node = head;
        int len = 0;
        ListNode tail = null;
        
        if (node == null)
            return null;
            
        while(node != null) {
            len++;
            if (null == node.next)
                tail = node;
            node = node.next;
        }
        
        int aftern = len - (n % len);
        if (aftern == 0 || aftern == len)
            return head;
            
        node = head;
        while(node != null) {
            aftern--;
            if (aftern == 0)
                break;
                
            node = node.next;
        }
        
        
        ListNode tmphead = node.next;
        node.next = null;
        tail.next = head;
        
        return tmphead;
    }
}
