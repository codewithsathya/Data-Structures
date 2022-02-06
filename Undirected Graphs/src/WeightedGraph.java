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

	private class NodeEntry{
		Node node;
		int priority;
		NodeEntry(Node node, int priority){
			this.node = node;
			this.priority = priority;
		}
	}

	public int findShortestDistance(String from, String to){
		Node fromNode = nodes.get(from);
		Node toNode = nodes.get(to);
		if(fromNode == null){
			throw new IllegalArgumentException();
		}
		if(toNode == null){
			throw new IllegalArgumentException();
		}
		PriorityQueue<NodeEntry> queue = new PriorityQueue<>(Comparator.comparingInt(ne -> ne.priority));
		Map<Node, Integer> distances = new HashMap<>();
		Map<Node, Node> previous = new HashMap<>();
		distances.put(fromNode, 0);
		for(Node node: nodes.values()){
			distances.putIfAbsent(node, Integer.MAX_VALUE);
		}
		Set<Node> visited = new HashSet<>();
		queue.add(new NodeEntry(fromNode, 0));

		while(!queue.isEmpty()){
			Node first = queue.remove().node;
			if(visited.contains(first)) continue;
			for(Edge edge: first.getEdges()){
				if(distances.get(edge.from) + edge.weight < distances.get(edge.to)){
					distances.put(edge.to, distances.get(edge.from) + edge.weight);
					previous.put(edge.to, edge.from);
					queue.add(new NodeEntry(edge.to, edge.weight));
				}
			}
			visited.add(first);
		}
		return distances.get(toNode);
	}
}