// print nth element when traverse a tree in post-order

import java.lang.Integer;
import java.lang.Math;

public class nthPostorder {
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
	node2.right = node5;

	TreeNode node6 = new TreeNode(-1);
	node3.left = node6;
	
	TreeNode node7 = new TreeNode(0);
	node6.right = node7;

	Solution cl = new Solution();
	System.out.println(cl.postorder(root, 7));
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; left = null; right = null;}
}

class Solution {
    int count;

    public int postorder(TreeNode root, int n) {
		this.count = n;		
		int arr[] = {0};

		recur(root, arr);

		return arr[0];
	}

	private void recur(TreeNode node, int arr[]) {
		if (null == node || 0 == this.count)
			return;

		recur(node.left, arr);
		recur(node.right, arr);

		this.count--;
		if (0 == this.count) {
			arr[0] = node.val;
			return;
		}

		return;
	}
}
