public class App {

    public static void main(String[] args) throws Exception {
        Tree tree = new Tree();
        tree.insert(5);
        tree.insert(3);
        tree.insert(8);
        tree.insert(1);
        tree.insert(2);
        tree.insert(4);
        tree.printSorted();
    }
}
