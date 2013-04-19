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
    public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        
        return balance(root, map);
    }
    
    private boolean balance (TreeNode node, HashMap<TreeNode, Integer> map) {
        if (node == null) return true;
        
        if (!balance(node.left, map) || !balance(node.right, map)) return false;
        
        if (Math.abs(height(node.left, map) - height(node.right, map)) > 1) return false;
        
        return true;
    }
    
    private int height(TreeNode node, HashMap<TreeNode, Integer> map) {
        if (node == null) return 0;
        if (map.containsKey(node)) return map.get(node);
        
        int h = Math.max(height(node.left, map), height(node.right, map)) + 1;
        
        map.put(node, h);
        
        return h;
    }
}
