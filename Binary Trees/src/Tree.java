import java.util.LinkedList;
import java.util.Queue;

public class Tree {
	private class Node {
		private int value;
		private Node left, right;

		public Node(int value) {
			this.value = value;
		}
	}

	public Node root;

	public void insert(int value) {
		if (root == null) {
			root = new Node(value);
			return;
		}
		Node current = root;
		while (true) {
			if (value < current.value) {
				if (current.left == null) {
					current.left = new Node(value);
					return;
				}
				current = current.left;
			} else {
				if (current.right == null) {
					current.right = new Node(value);
					return;
				}
				current = current.right;
			}
		}
	}

	public boolean find(int k) {
		Node current = root;
		while (current != null) {
			if (current.value == k) {
				return true;
			}
			if (k < current.value) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		return false;
	}

	public void printByPreOrder() {
		printByPreOrder(root);
	}

	private void printByPreOrder(Node node) {
		if (node == null)
			return;
		System.out.println(node.value);
		printByPreOrder(node.left);
		printByPreOrder(node.right);
	}

	public void printByInOrder() {
		printByInOrder(root);
	}

	private void printByInOrder(Node node) {
		if (node == null)
			return;
		printByInOrder(node.left);
		System.out.println(node.value);
		printByInOrder(node.right);
	}

	public void printByPostOrder() {
		printByPostOrder(root);
	}

	public void printByLevelOrder() {
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			System.out.println(node.value);
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
		}
	}

	private void printByPostOrder(Node node) {
		if (node == null)
			return;
		printByPostOrder(node.left);
		printByPostOrder(node.right);
		System.out.println(node.value);
	}

	public int height() {
		return height(root);
	}

	private int height(Node node) {
		if (node == null)
			return 0;
		if (node.left == null && node.right == null)
			return 0;
		return 1 + Math.max(height(node.left), height(node.right));
	}

	public int minValue() {
		if (root == null)
			return -1;
		return minValue(root);
	}

	private int minValue(Node node) {
		if (node.left == null)
			return node.value;
		return minValue(node.left);
	}

	public boolean equals(Tree other) {
		Node root1 = root, root2 = other.root;
		return equals(root1, root2);
	}

	private boolean equals(Node node1, Node node2) {
		if (node1 == null && node2 == null)
			return true;
		if (node1 != null && node2 != null)
			return node1.value == node2.value && equals(node1.left, node2.left) && equals(node1.right, node2.right);
		return false;
	}

	public int[] nodesAtKthDistance(){
		
	}

}