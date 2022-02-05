public class App {
    public static void main(String[] args) throws Exception {
        Graph graph = new Graph();
        graph.addNode("0");
        graph.addNode("1");
        graph.addNode("2");
        graph.addNode("3");
        graph.addNode("4");
        graph.addEdge("0", "1");
        graph.addEdge("1", "2");
        graph.addEdge("2", "3");
        graph.addEdge("3", "4");
        graph.addEdge("4", "0");
        System.out.println(graph.hasCycle());
    }
}
