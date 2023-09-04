package ds.tree;

public class BinarySearchTree {

    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    // Function to insert a new node into the BST
    public void insert(int data) {
        root = insertRec(root, data);
    }

    private TreeNode insertRec(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }

    // Function to perform an inorder traversal of the BST
    public void inorderTraversal(TreeNode node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.data + " ");
            inorderTraversal(node.right);
        }
    }

    // Function to perform a preorder traversal of the BST
    public void preorderTraversal(TreeNode node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }

    // Function to perform a postorder traversal of the BST
    public void postorderTraversal(TreeNode node) {
        if (node != null) {
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            System.out.print(node.data + " ");
        }
    }

    public static void execute() {
        BinarySearchTree bst = new BinarySearchTree();

        // Insert some elements into the BST
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        /*

           50
          /  \
         30   70
        / \   / \
       20  40 60 80

       */

        // Perform inorder, preorder, and postorder traversals
        System.out.println("Inorder traversal of the BST:");
        bst.inorderTraversal(bst.root);

        System.out.println("\nPreorder traversal of the BST:");
        bst.preorderTraversal(bst.root);

        System.out.println("\nPostorder traversal of the BST:");
        bst.postorderTraversal(bst.root);
        System.out.println();
    }
}
