tion for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        int path[] = new int[1000];
        
        if (root == null) return lists;
        
        recur(root, sum, path, 0, 0, lists);
        
        return lists;
        
        
        
    }
    
    private void recur(TreeNode node, int sum, int path[], int index, int total, ArrayList<ArrayList<Integer>> lists) {
        path[index] = node.val;
        
        if (node.left == null && node.right == null) {
            if (sum == total + node.val) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                for (int i = 0; i <= index; i++) 
                    list.add(path[i]);
                    
                lists.add(list);
            }
            
            return;
        }    
        
        if (node.left != null && node.right != null) {
            recur(node.left, sum, path, index + 1, total+node.val, lists);
            recur(node.right, sum, path, index + 1, total+node.val, lists);
            
            return;
        }
        
        if (node.left != null) recur(node.left, sum, path, index+1, total+node.val, lists);
        
        if (node.right != null) recur(node.right, sum, path, index+1, total+node.val, lists);
    
        return;
    }
}
