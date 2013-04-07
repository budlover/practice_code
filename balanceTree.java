// leetcode Balanced Binary Tree

import java.lang.Math;
import java.util.HashMap;

public class Solution {
    public boolean isBalanced(TreeNode node) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (null == node)
            return true;
        
        HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        if (Math.abs(getH(node.left, map) - getH(node.right, map)) > 1)
            return false;
        
        boolean lret = isBalanced(node.left);
        boolean rret = isBalanced(node.right);
        
        return (lret && rret); 
    }
    
    private int getH(TreeNode node, HashMap<TreeNode, Integer> map) {
        if (null == node)
            return 0;
        
        if (map.containsKey(node)) // dp
            return map.get(node);
            
        int lret = getH(node.left, map);
        int rret = getH(node.right, map);
        int ret = Math.max(lret, rret) + 1;
        
        map.put(node, ret);
        return ret;
    }
}
