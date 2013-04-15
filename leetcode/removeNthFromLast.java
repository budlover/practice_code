/*tion for singly-linked list.
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int count = n;
        int i;
        ListNode node = head;
        ListNode chase = head;
        
        while (node != null && node.next != null) {
            
                    
            if (count == 0) {
                node = node.next;
                chase = chase.next;
            } else {
                node = node.next;
                count--;
            }
        }
        
        ListNode ret;
        if (count > 1)
            return head;
        
        if (count == 1)
            return head.next;
            
        chase.next = chase.next.next;
        
        return head;
    }
}
