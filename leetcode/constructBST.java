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
    int index;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (preorder.length == 0) return null;
        
        this.index = 0;
        TreeNode n = recur(preorder, inorder, 0, inorder.length - 1);
        
        
        return n;
    }
    
    private TreeNode recur(int preorder[], int inorder[], int l, int r) {
        if (index >= preorder.length || l > r) return null;
        
        TreeNode node = new TreeNode(preorder[index]);
        int in_index = find(inorder, preorder[index]);
        
        index++;
        node.left = recur(preorder, inorder, l, in_index - 1);
        node.right = recur(preorder, inorder, in_index + 1, r);

        return node;
    }
    
    private int find(int arr[], int val) {
        for (int i = 0; i < arr.length; i++) {
            
            if (arr[i] == val) return i;
        }
        
        return -1;
    }
}
