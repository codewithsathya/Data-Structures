import java.util.*;

public class Trie {
	private class Node{
		private char value;
		private HashMap<Character, Node> children = new HashMap<>();
		private boolean isEndOfWord;

		public Node(char value){
			this.value = value;
		}

		@Override
		public String toString(){
			return "value=" + value;
		}

		public boolean hasChild(char ch){
			return children.containsKey(ch);
		}

		public void addChild(char ch){
			children.put(ch, new Node(ch));
		}

		public Node getChild(char ch){
			return children.get(ch);
		}

		public Node[] getChildren(){
			return children.values().toArray(new Node[0]);
		}

		public boolean hasChildren(){
			return !children.isEmpty();
		}

		public void removeChild(char ch){
			children.remove(ch);
		}
	}

	private Node root = new Node(' ');

	public void insert(String word){
		Node current = root;
		for(char ch : word.toCharArray()){
			if(!current.hasChild(ch)){
				current.addChild(ch);
			}
			current = current.getChild(ch);
		}
		current.isEndOfWord = true;
	}

	public boolean contains(String word){
		if(word == null)
			return false;
		Node current = root;
		for(char ch : word.toCharArray()){
			if(!current.hasChild(ch)){
				return false;
			}
			current = current.getChild(ch);
		}
		return current.isEndOfWord;
	}

	public void remove(String word){
		if(word == null) return;
		remove(root, word, 0);
	}

	private void remove(Node node, String word, int index){
		if(index == word.length()){
			node.isEndOfWord = false;
			return;
		}
		char ch = word.charAt(index);
		Node child = node.getChild(ch);
		if(child == null) return;

		remove(child, word, index + 1);
		if(!child.hasChildren() && !child.isEndOfWord){
			child.removeChild(ch);
		}
	}

	public List<String> findWords(String prefix){
		List<String> list = new ArrayList<>();
		Node lastNode = getLastNodeOf(prefix);
		findWords(lastNode, prefix, list);
		return list;
	}
	
	private void findWords(Node node, String prefix, List<String> list){
		if(node == null){
			return;
		}

		if(node.isEndOfWord){
			list.add(prefix);
		}

		for(Node child: node.getChildren()){
			findWords(child, prefix + child.value, list);
		}
	}

	private Node getLastNodeOf(String prefix){
		if(prefix == null) return null;
		Node current = root;
		for(char ch : prefix.toCharArray()){
			Node child = current.getChild(ch);
			if(child == null){
				return null;
			}
			current = child;
		}
		return current;
	}
	
	public void traverse(){
		traverse(root);
	}

	private void traverse(Node node){
		for(Node current : node.getChildren()){
			traverse(current);
		}
		// post order traversal
		System.out.println(node.value);
	}
}
