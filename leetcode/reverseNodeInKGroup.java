tion for singly-linked list.
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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode beg = head;
        ListNode end = head;
        ListNode pre = null;
        ListNode post = null;
        
        if (head == null) return null;
        if (k <= 1) return head;
        
        int count = 1;
        while (true) {
            if (beg == head) {
                while(count < k) {
                    end = end.next;
                    if (end == null) return head;
                    
                    count++;
                }
                
                post = end.next;  // store post
                
                head = reverse(beg, end);
                beg.next = post;
                pre = beg;
                beg = post;
            } else {
                count = 1;
                end = beg;
                if (end == null) return head;
                
                while(count < k) {
                    end = end.next;
                    if (end == null) return head;
                    
                    count++;
                }
                
                post = end.next;  // store post
                
                pre.next = reverse(beg, end);  
                beg.next = post;
                pre = beg;
                beg = post;
            }
        }
        
        //return head;
    }
    
    private ListNode reverse(ListNode beg, ListNode end) {
        ListNode tmphead = beg;
        ListNode node = beg.next;
        ListNode tmp = null;
        
        while (node != end) {
            tmp = node.next;
            
            node.next = tmphead;
            tmphead = node;
            
            node = tmp;
        }
        
        end.next = tmphead;
        tmphead = end;
        
        return tmphead;
    }
}
