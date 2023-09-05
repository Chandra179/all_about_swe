package ds.graph;

import java.util.*;

public class UndirectedGraph {
    private int V; // Number of vertices
    private LinkedList<Integer>[] adjList; // Adjacency list

    // Constructor
    public UndirectedGraph(int vertices) {
        this.V = vertices;
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Add an edge to the graph
    public void addEdge(int v, int w) {
        adjList[v].add(w);
        adjList[w].add(v); // Undirected graph, so we add an edge in both directions
    }

    // Print the graph
    public void printGraph() {
        for (int i = 0; i < V; i++) {
            System.out.print("Vertex " + i + " is connected to: ");
            for (Integer neighbor : adjList[i]) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void execute() {
        int numVertices = 5;
        UndirectedGraph graph = new UndirectedGraph(numVertices);

        // Adding edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        // Print the graph
        graph.printGraph();
    }
}

