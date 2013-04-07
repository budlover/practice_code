// leetcode Binary Tree Maximum Path Sum

import java.lang.Integer;
import java.lang.Math;

public class longestTreePath {
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
	
	TreeNode node7 = new TreeNode(0);
	node6.right = node7;

	Solution cl = new Solution();
	System.out.println(cl.longpath(root));
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; left = null; right = null;}
}

class Pair {
	int round;
	int path;
	Pair(int r, int p) {round = r; path = p;}
}

class Solution {
    
    public int longpath(TreeNode root) {
        Pair p = recur(root);

		return p.round;
    }
    
    private Pair recur(TreeNode node) {
   		 if (null == node)
			return new Pair(0, 0);

		Pair lret = recur(node.left);
		Pair rret = recur(node.right);
		int maxPath = Math.max(lret.path, rret.path) + 1;
		int maxRound = Math.max(lret.round, rret.round);
		maxRound = Math.max(maxRound, lret.path + rret.path + 1);

		return new Pair(maxRound, maxPath);
	}
}
