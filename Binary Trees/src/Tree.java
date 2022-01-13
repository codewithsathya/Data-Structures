public class Tree {
	private class Node{
		private int value;
		private Node left, right;

		public Node(int value){
			this.value = value;
		}
	}

	private Node root;

	public void insert(int value){
		if(root == null){
			root = new Node(value);
			return;
		}
		Node current = root;
		while(true){
			if(value < current.value){
				if(current.left == null){
					current.left = new Node(value);
					return;
				}
				current = current.left;
			}else{
				if(current.right == null){
					current.right = new Node(value);
					return;
				}
				current = current.right;
			}
		}
	}

	public void print(){
		print(root);
	}

	private void print(Node node){
		if(node == null) return;
		print(node.left);
		print(node.right);
		System.out.println(node.value);
	}

	public void printSorted(){
		printSorted(root);
	}

	private void printSorted(Node node){
		if(node == null) return;
		printSorted(node.left);
		System.out.println(node.value);
		printSorted(node.right);
	}
}