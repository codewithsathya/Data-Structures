import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}
