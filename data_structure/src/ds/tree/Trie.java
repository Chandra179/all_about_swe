package ds.tree;

class Trie {

    class TrieNode {
        // The number of possible characters (e.g., 26 for lowercase English letters)
        private static final int ALPHABET_SIZE = 26;
        TrieNode[] children;
        boolean isEndOfWord;

        public TrieNode() {
            children = new TrieNode[ALPHABET_SIZE];
            isEndOfWord = false;
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insert a word into the trie
    public void insert(String word) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a'; // Assuming lowercase English letters

            if (currentNode.children[index] == null) {
                currentNode.children[index] = new TrieNode();
            }

            currentNode = currentNode.children[index];
        }
        currentNode.isEndOfWord = true;
    }

    // Search for a word in the trie
    public boolean search(String word) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';

            if (currentNode.children[index] == null) {
                return false; // The word is not in the trie
            }

            currentNode = currentNode.children[index];
        }
        return currentNode.isEndOfWord; // Check if it's the end of a valid word
    }

    // Check if a word prefix exists in the trie
    public boolean startsWith(String prefix) {
        TrieNode currentNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';

            if (currentNode.children[index] == null) {
                return false; // The prefix is not in the trie
            }

            currentNode = currentNode.children[index];
        }
        return true; // The prefix exists in the trie
    }


    public static void execute() {
        Trie trie = new Trie();

        // Insert some words into the trie
        trie.insert("apple");
        trie.insert("banana");
        trie.insert("app");

        // Search for words in the trie
        System.out.println(trie.search("apple"));  // Should print true
        System.out.println(trie.search("app"));    // Should print true
        System.out.println(trie.search("orange")); // Should print false

        // Check for prefixes in the trie
        System.out.println(trie.startsWith("ban"));  // Should print true
        System.out.println(trie.startsWith("bat"));  // Should print false
    }
}