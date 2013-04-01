/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
// 2 cases:

// 1. swap 2 nodes that are not neighbors
// 2. swap 2 nodes that are neighbors



import java.util.ArrayList;

public class Solution {
    public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        traverse(root, list);
        int err1 = -1;
        int err2 = -1;
        
        int i;
        int prev = java.lang.Integer.MIN_VALUE;
        
        for (i = 0; i < list.size(); i++) {
            if (list.get(i).val <= prev) {
                err1 = i - 1;
                break;
            }
                
            prev = list.get(i).val;
        }
        
        prev = java.lang.Integer.MIN_VALUE;
        for (; i < list.size(); i++) {
            if (list.get(i).val <= prev) {
                err2 = i;
                break;
            }
                
            prev = list.get(i).val;
        }
        
        if (-1 == err1)
            return;
        
        if (-1 == err2) {
            err2 = err1 + 1;
        }
        
        int tmp = list.get(err1).val;
        list.get(err1).val = list.get(err2).val;
        list.get(err2).val = tmp;
        
        return;
    }
    
    private void traverse (TreeNode node, ArrayList<TreeNode> list) {
        if (null == node)
            return;
        
        traverse(node.left, list);
        list.add(node);
        traverse(node.right, list);
        
        return;
    }
}
