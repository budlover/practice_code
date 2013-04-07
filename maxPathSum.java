// leetcode Binary Tree Maximum Path Sum

import java.lang.Integer;
import java.lang.Math;

public class maxPathSum {
	public static void main(String args[]) {
	
	TreeNode root = new TreeNode(1);
	TreeNode node1 = new TreeNode(-2);
	TreeNode node2 = new TreeNode(-3);
	root.left = node1;
	root.right = node2;

	TreeNode node3 = new TreeNode(1);
	TreeNode node4 = new TreeNode(3);
	TreeNode node5 = new TreeNode(-2);
	node1.left = node3;
	node1.right = node4;
	node2.left = node5;

	TreeNode node6 = new TreeNode(-1);
	node3.left = node6;

	Solution cl = new Solution();
	System.out.println(cl.maxPathSum(root));
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; left = null; right = null;}
}

class Solution {
    private int curMax;
    
    public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        this.curMax = Integer.MIN_VALUE;
        int ret = recur(root);
        
        return this.curMax;
    }
    
    private int recur(TreeNode node) {
    
	    if (null == node) // add zero
            return Integer.MIN_VALUE / 10;
        
        int tmp = Integer.MIN_VALUE;
        
        int lMax = recur(node.left);
        tmp = Math.max(tmp, lMax);
        int rMax = recur(node.right);
        tmp = Math.max(tmp, rMax);

       
		 
        this.curMax = Math.max(this.curMax, rMax + lMax + node.val);
        //this.curMax = Math.max(tmp, this.curMax);
        //this.curMax = Math.max(this.curMax, rMax);
        //this.curMax = Math.max(this.curMax, lMax);
        this.curMax = Math.max(this.curMax, lMax + node.val);
        this.curMax = Math.max(this.curMax, rMax + node.val);
        this.curMax = Math.max(this.curMax, node.val);

		        
        tmp = tmp < 0 ? 0 : tmp;
        tmp += node.val;
        
		System.out.println("node: " + node.val + " tmp: " + tmp + " curMax: " + this.curMax + " lmax: " + lMax + " rmax: " + rMax);
        return tmp;

	}
}
