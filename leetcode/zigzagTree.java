import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        if (null == root)
            return lists;
            
        LinkedList <TreeNode> q = new LinkedList<TreeNode>();
        
        ArrayList<Integer> levelList = new ArrayList<Integer>();
        
        q.addLast(root);
        TreeNode dummy = new TreeNode(0);
        q.addLast(dummy);
        boolean seq = true;
        
        while (true) {
            TreeNode node = q.removeFirst();
            
            if (dummy == node) {
                
                lists.add(levelList);
                
                if (q.size() == 0) // no more nodes    
                    return lists;
                
                
                q.addLast(node);
                levelList = new ArrayList<Integer>();
                seq = seq == true ? false : true;
                continue;
            }
            
            if (seq == true) 
                levelList.add(node.val);
            else
                levelList.add(0, node.val);
            
            if (null != node.left)
                q.addLast(node.left);
                
            if (null != node.right)
                q.addLast(node.right);
        }
    }
}
