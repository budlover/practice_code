import java.util.ArrayList;

public class pathSum {
	public static void main(String args[]) {
		path p = new path();
		TreeNode root = new TreeNode(2);
		TreeNode n1 = new TreeNode(0);
		root.left = n1;
		TreeNode n2 = new TreeNode(0);
		root.right = n2;

		System.out.println(p.sumNumbers(root));
	}
} 

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


class path {

	int sum;
    
    public int sumNumbers(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null)
            return 0;
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        recur(root, list, 0);
        
        //System.out.println(this.sum);
        return this.sum;
    }
    
    private void recur(TreeNode node, ArrayList<Integer> list, int index) {
        int tmp = 0;
        int base = 0;
        
		if (index <= list.size() - 1)
        	list.set(index, node.val);
		else
			list.add(node.val);
        
        if (node.left == null && node.right == null) {
            for(int i = 0; i <= index; i++) {
                if (i == 0)
                    tmp += list.get(i);
                else
                    tmp = tmp * 10 + list.get(i);
            }
            
            this.sum += tmp;
            return;
        }
        
        if (node.left != null) {
            recur(node.left, list, index + 1);
        }
        
        if (node.right != null) {
            recur(node.right, list, index + 1);
        }
        
        return;
    }
}
