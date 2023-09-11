package graph;

import java.util.*;

public class DepthFirstSearch {
    private int V; // Number of vertices
    private LinkedList<Integer>[] adjList; // Adjacency list

    // Constructor
    DepthFirstSearch(int vertices) {
        V = vertices;
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Add an edge to the graph
    void addEdge(int v, int w) {
        adjList[v].add(w);
    }

    // Depth-First Search from a given vertex
    void DFS(int v) {
        // Create a boolean array to mark visited vertices
        boolean[] visited = new boolean[V];

        // Call the recursive helper function to perform DFS
        DFSUtil(v, visited);
    }

    // Recursive function to perform DFS
    private void DFSUtil(int v, boolean[] visited) {
        // Mark the current vertex as visited
        visited[v] = true;
        System.out.print(v + " ");

        // Recur for all adjacent vertices
        for (Integer neighbor : adjList[v]) {
            System.out.println(", current vertice:" + v + "-> " + adjList[v] + ", neighbor: " + neighbor);
            if (!visited[neighbor]) {
                DFSUtil(neighbor, visited);
            }
        }
    }

    // Driver method to start DFS from a given vertex
    public static void main(String[] args) {
        DepthFirstSearch graph = new DepthFirstSearch(7); // Create a graph with 7 vertices

        // Add edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 6);

        // 0 - 1 - 3 - 5
        // |
        // 2 - 4 - 6
        System.out.println("Depth-First Traversal (starting from vertex 0):");
        graph.DFS(0);
    }
}

