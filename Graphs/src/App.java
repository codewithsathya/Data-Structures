public class App {
    public static void main(String[] args) throws Exception {
        Graph graph = new Graph();
        graph.addNode("Sathya");
        graph.addNode("Ram");
        graph.addNode("Madhav");
        graph.addNode("Nikhilesh");
        graph.addNode("Teja");
        graph.addEdge("Sathya", "Ram");
        graph.addEdge("Madhav", "Sathya");
        graph.addEdge("Teja", "Sathya");
        graph.addEdge("Ram", "Nikhilesh");
        graph.addEdge("Teja", "Ram");
        graph.addEdge("Sathya", "Madhav");
        graph.removeNode("Sathya");
        graph.removeEdge("Ram", "Nikhilesh");
        graph.print();
    }
}
