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
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        if (root == null) return lists;
        
        TreeNode dummy = new TreeNode(1);
        
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        q.offer(dummy);
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        while (0 != q.size()) {
            TreeNode n = q.poll();
            
            if (n == dummy) {
                lists.add(0, list);
                
                if (0 == q.size())
                    break;
                else {
                    list = new ArrayList<Integer>();
                    q.offer(n);
                }
            } else {
                list.add(n.val);
                if (n.left != null) q.offer(n.left);
                if (n.right != null) q.offer(n.right);
            }
        }
        
        return lists;
    }
}
