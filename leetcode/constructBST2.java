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
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        this.index = inorder.length - 1;
        
        return recur(postorder, inorder, 0, inorder.length - 1);
    }
    
    private int find(int arr[], int val) {
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] == val) return i;
        }
        
        return -1;
        
    }
    
    private TreeNode recur(int postorder[], int inorder[], int l, int r) {
        if (l > r) return null;
        
        TreeNode node = new TreeNode(postorder[index]);
        int in_index = find (inorder, postorder[index]);
        
        index--;
        
        node.right = recur(postorder, inorder, in_index + 1, r);
        node.left = recur(postorder, inorder, l, in_index - 1);
        
        return node;
    }
}
