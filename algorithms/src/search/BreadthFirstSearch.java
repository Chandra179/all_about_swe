package search;

import java.util.LinkedList;
import java.util.Queue;

// Class to represent a graph
class BreadthFirstSearch {
    private int V; // Number of vertices
    private LinkedList<Integer>[] adj; // Adjacency list

    // Constructor
    BreadthFirstSearch(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    // Function to add an edge to the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // BFS traversal starting from a given source vertex
    void BFS(int s) {
        boolean[] visited = new boolean[V]; // Mark all vertices as not visited
        Queue<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            s = queue.poll(); // Dequeue a vertex from the queue
            System.out.print(s + " "); // 0, 1, 2, 3, 4, 5, 6

            // Get all adjacent vertices of the dequeued vertex
            for (Integer n : adj[s]) { // 0:[1, 2], 1:[3, 4], 2:[5,6]
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n); // 1, 2, 3, 4, 5, 6
                }
            }
        }
    }

    public static void main(String[] args) {
        BreadthFirstSearch g = new BreadthFirstSearch(7);

        // Adding edges to the graph
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.addEdge(2, 6);

        // 0 - 1 - 3
        // |   |
        // 2   4
        // |\
        // 5 6

        System.out.println("Breadth-First Traversal (starting from vertex 0): ");
        g.BFS(0);
    }
}

