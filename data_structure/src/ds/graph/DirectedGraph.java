package ds.graph;

import java.util.*;

public class DirectedGraph {

    class Node {
        int value;
        List<Node> neighbors;

        public Node(int value) {
            this.value = value;
            this.neighbors = new ArrayList<>();
        }

        public void addNeighbor(Node neighbor) {
            this.neighbors.add(neighbor);
        }
    }

    List<Node> nodes;

    public DirectedGraph() {
        this.nodes = new ArrayList<>();
    }

    public void addNode(int value) {
        nodes.add(new Node(value));
    }

    public void addEdge(int from, int to) {
        Node fromNode = getNode(from);
        Node toNode = getNode(to);

        if (fromNode != null && toNode != null) {
            fromNode.addNeighbor(toNode);
        }
    }

    private Node getNode(int value) {
        for (Node node : nodes) {
            if (node.value == value) {
                return node;
            }
        }
        return null;
    }

    public void printGraph() {
        for (Node node : nodes) {
            System.out.print("Node " + node.value + " is connected to: ");
            for (Node neighbor : node.neighbors) {
                System.out.print(neighbor.value + " ");
            }
            System.out.println();
        }
    }


    public static void execute() {
        DirectedGraph graph = new DirectedGraph();

        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);

        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 1);

        graph.printGraph();
    }
}