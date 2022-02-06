import java.util.*;

public class WeightedGraph{
	private class Node{
		private String label;
		private List<Edge> edges = new ArrayList<>();
		Node(String label){
			this.label = label;
		}

		public void addEdge(Node to, int weight){
			edges.add(new Edge(this, to, weight));
		}

		public List<Edge> getEdges(){
			return edges;
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

	public void addNode(String label){
		nodes.putIfAbsent(label, new Node(label));
	}

	public void addEdge(String from, String to, int weight){
		Node fromNode = nodes.get(from);
		Node toNode = nodes.get(to);
		if(fromNode == null)
			throw new IllegalArgumentException();
		if(toNode == null)
			throw new IllegalArgumentException();

		fromNode.addEdge(toNode, weight);
		toNode.addEdge(fromNode, weight);
	}

	public void print(){
		for(Node node: nodes.values()){
			List<Edge> edges = node.getEdges();
			if(!edges.isEmpty()){
				System.out.println(node + " is connected to " + edges);
			}
		}
	}
}