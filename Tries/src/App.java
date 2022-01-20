public class App {
    public static void main(String[] args) throws Exception {
        Trie trie = new Trie();
        trie.insert("boy");
        trie.insert("book");
        trie.traverse();
    }
}
