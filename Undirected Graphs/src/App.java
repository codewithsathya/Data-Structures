public class App {
    public static void main(String[] args) throws Exception {
        WeightedGraph graph = new WeightedGraph();
        graph.addNode("A");
        graph.addNode("C");
        graph.addNode("B");
        graph.addNode("D");
        graph.addEdge("B", "C", 4);
        graph.addEdge("A", "B", 8);
        graph.addEdge("D", "C", 9);
        graph.print();
    }
}
