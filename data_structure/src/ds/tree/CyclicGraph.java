package ds.tree;

import java.util.ArrayList;
import java.util.List;

public class CyclicGraph {

    class Node {
        int data;
        List<Node> neighbors;

        public Node(int data) {
            this.data = data;
            this.neighbors = new ArrayList<>();
        }

        // Add a neighbor to the node
        public void addNeighbor(Node neighbor) {
            this.neighbors.add(neighbor);
        }
    }

    public CyclicGraph() {
        // Create three nodes
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        // Define cyclic connections
        node1.addNeighbor(node2);
        node2.addNeighbor(node3);
        node3.addNeighbor(node1);

        // Print the cyclic graph
        System.out.println("Cyclic Graph:");
        System.out.println("Node 1 is connected to: " + node1.neighbors.get(0).data);
        System.out.println("Node 2 is connected to: " + node2.neighbors.get(0).data);
        System.out.println("Node 3 is connected to: " + node3.neighbors.get(0).data);
    }
}
