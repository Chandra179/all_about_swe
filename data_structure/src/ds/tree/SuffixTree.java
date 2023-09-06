package ds.tree;

class SuffixTree {

    class SuffixTreeNode {
        SuffixTreeNode[] children;
        boolean isEndOfWord;

        public SuffixTreeNode() {
            children = new SuffixTreeNode[26]; // Assuming lowercase English letters
            isEndOfWord = false;
        }
    }

    private SuffixTreeNode root;

    public SuffixTree() {
        root = new SuffixTreeNode();
    }

    // Insert a string into the suffix tree
    public void insert(String word) {
        for (int i = 0; i < word.length(); i++) {
            insertSuffix(word.substring(i));
        }
    }

    private void insertSuffix(String suffix) {
        SuffixTreeNode currentNode = root;
        for (int i = 0; i < suffix.length(); i++) {
            char ch = suffix.charAt(i);
            int index = ch - 'a'; // Assuming lowercase English letters

            if (currentNode.children[index] == null) {
                currentNode.children[index] = new SuffixTreeNode();
            }

            currentNode = currentNode.children[index];
        }
        currentNode.isEndOfWord = true;
    }

    // Search for a word in the suffix tree
    public boolean search(String word) {
        SuffixTreeNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';

            if (currentNode.children[index] == null) {
                return false; // The word is not in the suffix tree
            }

            currentNode = currentNode.children[index];
        }
        return currentNode.isEndOfWord;
    }

    public static void execute() {
        SuffixTree suffixTree = new SuffixTree();

        // Insert a string into the suffix tree
        suffixTree.insert("banana");

        // Search for words in the suffix tree
        System.out.println(suffixTree.search("banana")); // Should print true
        System.out.println(suffixTree.search("apples")); // Should print false
    }
}