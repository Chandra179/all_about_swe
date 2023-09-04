package ds.tree;

public class AvlTree {

    class Node {
        int data;
        Node left, right;
        int height;

        Node(int data) {
            this.data = data;
            this.height = 1;
        }
    }

    Node root;

    int height(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    int getBalanceFactor(Node node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    Node rotateLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    Node insert(Node node, int data) {
        if (node == null)
            return new Node(data);

        if (data < node.data)
            node.left = insert(node.left, data);
        else if (data > node.data)
            node.right = insert(node.right, data);
        else
            return node; // Duplicate data not allowed

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalanceFactor(node);

        // Left-Left Case
        if (balance > 1 && data < node.left.data)
            return rotateRight(node);

        // Right-Right Case
        if (balance < -1 && data > node.right.data)
            return rotateLeft(node);

        // Left-Right Case
        if (balance > 1 && data > node.left.data) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Right-Left Case
        if (balance < -1 && data < node.right.data) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.data + " ");
            inorderTraversal(node.right);
        }
    }

    public static void execute() {
        AvlTree tree = new AvlTree();
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);

        System.out.println("Inorder Traversal:");
        tree.inorderTraversal(tree.root);
        System.out.println();
    }
}
