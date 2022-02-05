import java.util.*;
public class Graph {
	private class Node{
		private String label;

		public Node(String label){
			this.label = label;
		}

		@Override
		public String toString(){
			return label;
		}
	}

	private Map<String, Node> nodes = new HashMap<>();
	private Map<Node, List<Node>> adjacencyList = new HashMap<>();

	public void addNode(String label){
		Node newNode = new Node(label);
		nodes.putIfAbsent(label, newNode);
		adjacencyList.putIfAbsent(newNode, new ArrayList<>());
	}

	public void addEdge(String from, String to){
		Node fromNode = nodes.get(from);
		Node toNode = nodes.get(to);
		if(fromNode == null || toNode == null){
			throw new IllegalArgumentException();
		}
		adjacencyList.get(fromNode).add(toNode);
	}

	public void removeNode(String label){
		Node node = nodes.get(label);
		if(node == null)
			return;
		for(Node source : adjacencyList.keySet()){
			adjacencyList.get(source).remove(node);
		}
		adjacencyList.remove(node);
		nodes.remove(label);
	}

	public void removeEdge(String from, String to){
		Node fromNode = nodes.get(from);
		Node toNode = nodes.get(to);
		if(fromNode == null || toNode == null){
			return;
		}
		adjacencyList.get(fromNode).remove(toNode);
	}

	public void print(){
		for(Node source : adjacencyList.keySet()){
			List<Node> targets = adjacencyList.get(source);
			if(!targets.isEmpty()){
				System.out.println(source + " is connected to " + targets);
			}
		}
	}

	public void traverseDepthFirst(String root){
		Node node = nodes.get(root);
		if(node == null)
			return;
		traverseDepthFirst(node, new HashSet<>());
	}

	private void traverseDepthFirst(Node node, Set<Node> visited){
		System.out.println(node.label);
		visited.add(node);
		for(Node n : adjacencyList.get(node)){
			if(!visited.contains(n)){
				traverseDepthFirst(n, visited);
			}
		}
	}

	public List<String> topologicalSort(){
		Set<Node> visited = new HashSet<>();
		Stack<Node> stack = new Stack<>();
		for(Node node: nodes.values()){
			topologicalSort(node, visited, stack);
		}

		List<String> list = new ArrayList<>();
		while(!stack.isEmpty()){
			list.add(stack.pop().label);
		}
		return list;
	}

	private void topologicalSort(Node node, Set<Node> visited, Stack<Node> stack){
		if(visited.contains(node)) return;
		visited.add(node);
		for(Node neighbour: adjacencyList.get(node)){
				topologicalSort(neighbour, visited, stack);
		}
		stack.push(node);
	}

		public void traverseDepthFirstIterative(String root){
		Node node = nodes.get(root);
		if(node == null){
			return;
		}
		Stack<Node> stack = new Stack<>();
		Set<Node> visited = new HashSet<>();
		stack.push(node);
		while(!stack.isEmpty()){
			Node current = stack.pop();
			if(!visited.contains(current)){
				System.out.println(current.label);
				visited.add(current);
				for(Node neighbour : adjacencyList.get(current)){
					stack.push(neighbour);
				}
			}
		}
	}

	public void traverseBreadthFirst(String root){
		Node node = nodes.get(root);
		if(node == null){
			return;
		}
		Queue<Node> queue = new ArrayDeque<>();
		Set<Node> visited = new HashSet<>();
		queue.add(node);
		while(!queue.isEmpty()){
			Node current = queue.remove();
			if(!visited.contains(current)){
				System.out.println(current.label);
				visited.add(current);
				for(Node neighbour : adjacencyList.get(current)){
					queue.add(neighbour);
				}
			}
		}
	}

	public boolean hasCycle(){
		Set<Node> all = new HashSet<>();
		Set<Node> visiting = new HashSet<>();
		Set<Node> visited = new HashSet<>();
		all.addAll(nodes.values());
		while(!all.isEmpty()){
			Node node = all.iterator().next();
			if(hasCycle(node, all, visiting, visited))
				return true;
		}
		return false;
	}

	private boolean hasCycle(Node node, Set<Node> all, Set<Node> visiting, Set<Node> visited){
		all.remove(node);
		visiting.add(node);
		for(Node neighbour: adjacencyList.get(node)){
			if(visited.contains(neighbour))
				continue;
			if(visiting.contains(neighbour))
				return true;
			if(hasCycle(neighbour, all, visiting, visited)){
				return true;
			}
		}
		visited.add(node);
		visiting.remove(node);
		return false;
	}
}
