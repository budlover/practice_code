import java.util.ArrayList;

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        
        for (ListNode node = head; node != null; node = node.next)
            list.add(new TreeNode(node.val));
        
        if (list.size() <=0)
            return null;
        
        TreeNode arr[] = new TreeNode[list.size()];
        list.toArray(arr);
        
        int index = (0 + arr.length - 1) / 2;
        TreeNode root = arr[index];
        
        recur(arr, root, 0, index - 1);
        recur(arr, root, index + 1, arr.length - 1);
        
        return root;
    }
    
    private void recur(TreeNode arr[], TreeNode root, int start, int end) {
        if (start > end)
            return;
        
        if (start == end) {
            insert(arr[start], root);
            return;
        }
            
        int index = (start + end) / 2;
        
        insert(arr[index], root);
        
        recur(arr, root, start, index - 1);
        recur(arr, root, index + 1, end);
        
        return;
    }
    
    private void insert(TreeNode insert, TreeNode root) {
        TreeNode node = root;
        
        if (null == root)
            return;
            
        while (true) {
            if (insert.val <= node.val) { // go left
                if (null == node.left) {
                    node.left = insert;
                    return;
                } else {
                    node = node.left;
                }
            }
            else { // right
                if (null == node.right) {
                    node.right = insert;
                    return;
                } else {
                    node = node.right;
                }
            }  
        }
        

    }
}