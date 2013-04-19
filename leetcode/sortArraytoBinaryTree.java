/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (num.length == 0) return null;
        
        int mid = (num.length - 1) / 2;
        TreeNode root = new TreeNode(num[mid]);
        
        recur(num, 0, mid - 1, root);
        recur(num, mid+1, num.length - 1, root);
        
        return root;
    }
    
    private void recur(int num[], int left, int right, TreeNode root) {
        if (left > right) return;
        
        int mid = left + (right - left) / 2;
        bst(root, num[mid]);
        
        recur(num, left, mid - 1, root);
        recur(num, mid+1, right, root);
        
        return;
    }
    
    private void bst(TreeNode root, int insert) {
        
        TreeNode node = root;
        
        while (true) {
            if (insert <= node.val) { // go left
                if (node.left == null) {
                    node.left = new TreeNode(insert);
                    return;
                } else {
                    node = node.left;
                }
                
            } else { // go right
                if (node.right == null) {
                    node.right = new TreeNode(insert);
                    return;
                } else {
                    node = node.right;
                }
            }
        }
        
        
    }
}
