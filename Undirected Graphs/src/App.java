public class App {
    public static void main(String[] args) throws Exception {
        WeightedGraph graph = new WeightedGraph();
        graph.addNode("A");
        graph.addNode("C");
        graph.addNode("B");
        graph.addNode("D");
        graph.addNode("E");
        graph.addEdge("A", "B", 3);
        graph.addEdge("A", "D", 2);
        graph.addEdge("A", "C", 4);
        graph.addEdge("C", "D", 1);
        graph.addEdge("B", "E", 1);
        graph.addEdge("D", "E", 5);
        System.out.println(graph.findShortestDistance("C", "E"));
    }
}
