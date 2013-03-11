import java.util.LinkedList;

public class bstJava {
	public static void main(String args[]) {
		BST bst = new BST(10);
		Node node = new Node(5);
		bst.insert(node);
	
		node = new Node(20);
		bst.insert(node);

		node = new Node(7);
        bst.insert(node);

		node = new Node(12);
        bst.insert(node);

		bst.dfsPrint();
		bst.bfsPrint();


		LinkedList<LinkedList<Node>> lists = bst.make_level_lists(bst.root);
		for (LinkedList<Node> list : lists) {
			for (Node traverse : list)
				System.out.print(traverse.data + " ");
			System.out.println("\n");
		}
	}

}

class Node {
    public int data;
	public Node lChild;
    public Node rChild;
	public Node parent;

    public Node (int data) {
        this.data = data;
        this.lChild = null;
        this.rChild = null;
		this.parent = null;
    }
}

class BST {
	Node root;
	int nodeCount;

	public BST(int rootData) {
		root = new Node(rootData);
		this.nodeCount = 1;
	}

	public void insert(Node node) {
		insertHelper(this.root, node);
		this.nodeCount++;
		
		return;
	}

	private void insertHelper(Node node, Node toBeInsert) {
		if (toBeInsert.data <= node.data) { // insert in left subtree
			if (null != node.lChild) {
				insertHelper(node.lChild, toBeInsert);
			} else {
				node.lChild = toBeInsert;
				toBeInsert.parent = node;
			}
		} else { // insert in right subtree
			if (null != node.rChild) {
				insertHelper(node.rChild, toBeInsert);
			} else {
				node.rChild = toBeInsert;
				toBeInsert.parent = node;
			}
		}

		return;
	}

	/*
	public void delete(Node node, int target) {
		if (target == node.data) {
			if (node.rChild == null) && (node.lChild != null)
				if (null != node.parent)
					node.parent. = node.lChild;
			else if (node.lChild == null) && (node.rChild != null))
				node = node.rChild;
			else if (node.lChild == null) && (node.rChild == null)
				node = null;
		}
			
			deleteHelper(root, target);

			return;
	}

	private void deleteHelper (Node node, int target) {
		if (target == node.data) {
			
		}
	}
	*/

	public void dfsPrint() {
		if (null != this.root)
			dfsPrintHelper(root);

		System.out.println("\n" + this.nodeCount + " nodes\n");
		return;
	}

	private void dfsPrintHelper(Node node) {
		if (null == node)
			return;

		if (null != node.lChild)
			dfsPrintHelper(node.lChild);
		
		System.out.print(node.data + " ");

		if (null != node.rChild)
			dfsPrintHelper(node.rChild);

		return;
	}

	public void bfsPrint() {
		if (null == this.root)
			return;

		LinkedList<Node> queue= new LinkedList<>();
		queue.addFirst(this.root);
	
		while (0 < queue.size()) {
			Node node = queue.removeLast();
			System.out.print(node.data + " ");

			if (null != node.lChild)
				queue.addFirst(node.lChild);
		
			if (null != node.rChild)
				queue.addFirst(node.rChild);
		}

		System.out.print("\n" + this.nodeCount + " nodes.\n");
		return;
	}

	public LinkedList<LinkedList<Node>> make_level_lists(Node root) {
		if (null == root)
			return null;
		
		LinkedList<LinkedList<Node>> lists = new LinkedList<LinkedList<Node>>();
		LinkedList<Node> list = new LinkedList<Node>();
		list.add(root);
		
		while (0 < list.size()) {
			lists.add(list);
			LinkedList<Node> parents = list;
			list = new LinkedList<Node>();
			for (Node parent : parents) {
				if (null != parent.lChild)
					list.add(parent.lChild);
				
				if (null != parent.rChild)
					list.add(parent.rChild);
			}
		}

		return lists;
	}
}
