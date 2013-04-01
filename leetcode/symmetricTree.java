public class Solution {
    public boolean isSymmetric(TreeNode root) { // BFS
        // Start typing your Java solution below
        // DO NOT write main() function
        if (null == root)
            return true;
        
        return recur(root.left, root.right);
    }
    
    private boolean recur(TreeNode left, TreeNode right) {
        if (null == left && null == right)
            return true;
            
        if ((null == left && null != right) ||
            (null != left && null == right))
            return false;
        
        if (left.val != right.val)
            return false;
            
        return recur(left.right, right.left) && recur(left.left, right.right);
    }
}
