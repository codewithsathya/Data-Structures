public class App {
    public static void main(String[] args) throws Exception {
        WeightedGraph graph = new WeightedGraph();
        for(int i = 0; i < 26; i++){
            graph.addNode("" + ((char)(65 + i)) + "");
        }
        for(int i = 1; i <= 40; i++){
            graph.addEdge("" + ((char)(65 + Math.random() * 26)) + "", "" + ((char)(65 + Math.random() * 26)) + "", (int)Math.random() * 10);
        }
        graph.printShortestPath("A", "E");
    }
}
