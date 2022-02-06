import java.util.*;

public class WeightedGraph{
	private class Node{
		private String label;
		Node(String label){
			this.label = label;
		}

		@Override
		public String toString(){
			return label;
		}
	}

	private class Edge{
		private Node from;
		private Node to;
		private int weight;
		Edge(Node from, Node to, int weight){
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public String toString(){
			return from + "->" + to;
		}
	}

	Map<String, Node> nodes = new HashMap<>();
	Map<Node, List<Edge>> adjacencyList = new HashMap<>();

	public void addNode(String label){
		Node node = new Node(label);
		nodes.putIfAbsent(label, node);
		adjacencyList.putIfAbsent(node, new ArrayList<>());
	}

	public void addEdge(String from, String to, int weight){
		Node fromNode = nodes.get(from);
		Node toNode = nodes.get(to);
		if(fromNode == null)
			throw new IllegalArgumentException();
		if(toNode == null)
			throw new IllegalArgumentException();
		
		adjacencyList.get(fromNode).add(new Edge(fromNode, toNode, weight));
		adjacencyList.get(toNode).add(new Edge(toNode, fromNode, weight));
	}

	public void print(){
		for(Node node: nodes.values()){
			List<Edge> edges = adjacencyList.get(node);
			if(!edges.isEmpty()){
				System.out.println(node + " is connected to " + edges);
			}
		}
	}
}