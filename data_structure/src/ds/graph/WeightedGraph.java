package ds.graph;

import java.util.*;

public class WeightedGraph {
    private int V; // Number of vertices
    private Map<Integer, List<Edge>> adjacencyList;

    // Constructor to initialize the weighted graph
    public WeightedGraph(int vertices) {
        V = vertices;
        adjacencyList = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }
    }

    // Helper class to represent an edge with a weight
    class Edge {
        int destination;
        int weight;

        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    // Add an edge to the graph
    public void addEdge(int source, int destination, int weight) {
        Edge edge = new Edge(destination, weight);
        adjacencyList.get(source).add(edge);
    }

    // Print the graph
    public void printGraph() {
        for (int i = 0; i < V; i++) {
            System.out.print("Vertex " + i + " is connected to: ");
            List<Edge> edges = adjacencyList.get(i);
            for (Edge edge : edges) {
                System.out.print("(" + edge.destination + ", " + edge.weight + ") ");
            }
            System.out.println();
        }
    }

    public static void execute() {
        int V = 5; // Number of vertices
        WeightedGraph graph = new WeightedGraph(V);

        // Adding edges to the graph
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 3, 1);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 4, 5);
        graph.addEdge(3, 4, 4);

        // Print the weighted graph
        graph.printGraph();
    }
}
