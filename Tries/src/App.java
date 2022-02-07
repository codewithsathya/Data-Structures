public class App {
    public static void main(String[] args) throws Exception {
        Trie trie = new Trie();
        trie.insert("boy");
        trie.insert("book");
        trie.insert("car");
        trie.insert("cat");
        trie.insert("cargo");
        trie.insert("careful");
        System.out.println(trie.findWords(null));
    }
}
