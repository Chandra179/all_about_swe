package graph;

public class DijkstraAlgorithm {
    public static void dijkstra(int[][] graph, int source) {
        int count = graph.length; //7
        boolean[] visitedVertex = new boolean[count];
        int[] distance = new int[count];
        for (int i = 0; i < count; i++) {
            visitedVertex[i] = false;
            distance[i] = Integer.MAX_VALUE;
        }

        // Distance of self loop is zero
        distance[source] = 0;
        for (int i = 0; i < count; i++) {

            // Update the distance between neighbouring vertex and source vertex
            int u = findMinDistance(distance, visitedVertex);
            visitedVertex[u] = true;

            // Update all the neighbouring vertex distances
            for (int v = 0; v < count; v++) {
                System.out.print("current vertex: " + u +
                                 ", visited vertex :" + visitedVertex[v] +
                                 ", weight["+u+"]"+"["+v+"] :" + graph[u][v] +
                                 ", shortest path["+v+"] :" + distance[v]);
                System.out.println();
                if (!visitedVertex[v] && graph[u][v] != 0 && (distance[u] + graph[u][v] < distance[v])) {
                    distance[v] = distance[u] + graph[u][v];
                }
            }
            System.out.println("============================================");
        }

    }

    // Finding the minimum distance
    private static int findMinDistance(int[] distance, boolean[] visitedVertex) {
        int minDistance = Integer.MAX_VALUE;
        int minDistanceVertex = -1;
        for (int i = 0; i < distance.length; i++) {
            if (!visitedVertex[i] && distance[i] < minDistance) {
                minDistance = distance[i];
                minDistanceVertex = i;
            }
        }
        return minDistanceVertex;
    }

    public static void main(String[] args) {
        int graph[][] = new int[][] {
                { 0, 0, 1, 2, 0, 0, 0 },
                { 0, 0, 2, 0, 0, 3, 0 },
                { 1, 2, 0, 1, 3, 0, 0 },
                { 2, 0, 1, 0, 0, 0, 1 },
                { 0, 0, 3, 0, 0, 2, 0 },
                { 0, 3, 0, 0, 2, 0, 1 },
                { 0, 0, 0, 1, 0, 1, 0 }
        };

        /**
         Index  |   Vertex (from, to)  |   Weight  |   Shortest Path
         -------------------------------------------------------------
         0      |   0, 0 = 0           |   0       |   0 -> 0
         1      |   0, 1 = 0           |   0       |   0 -> 1
         2      |   0, 2 = 1           |   1       |   0 -> 2
         3      |   0, 3 = 2           |   2       |   0 -> 2 -> 3
         4      |   0, 4 = 0           |   0       |   0 -> 4
         5      |   0, 5 = 0           |   0       |   0 -> 5
         6      |   0, 6 = 0           |   0       |   0 -> 6
         ==============================================================
         7      |   1, 0 = 0           |   0       |   1 -> 0
         8      |   1, 1 = 0           |   0       |   1 -> 1
         9      |   1, 2 = 2           |   2       |   1 -> 0 -> 2
         10     |   1, 3 = 0           |   0       |   1 -> 3
         11     |   1, 4 = 0           |   0       |   1 -> 4
         12     |   1, 5 = 3           |   3       |   1 -> 5
         13     |   1, 6 = 0           |   0       |   1 -> 6
         ===============================================================
         14     |   2, 0 = 1           |   1       |   2 -> 0
         15     |   2, 1 = 2           |   2       |   2 -> 1
         16     |   2, 2 = 0           |   0       |   2 -> 2
         17     |   2, 3 = 1           |   1       |   2 -> 3
         18     |   2, 4 = 3           |   3       |   2 -> 4
         19     |   2, 5 = 0           |   0       |   2 -> 5
         20     |   2, 6 = 0           |   0       |   2 -> 6
         ===============================================================
         21     |   3, 0 = 2           |   2       |   3 -> 0
         22     |   3, 1 = 0           |   0       |   3 -> 1
         23     |   3, 2 = 1           |   1       |   3 -> 2
         24     |   3, 3 = 0           |   0       |   3 -> 3
         25     |   3, 4 = 0           |   0       |   3 -> 4
         26     |   3, 5 = 0           |   0       |   3 -> 5
         27     |   3, 6 = 1           |   1       |   3 -> 6
         ===============================================================
         28     |   4, 0 = 0           |   0       |   4 -> 0
         29     |   4, 1 = 0           |   0       |   4 -> 1
         30     |   4, 2 = 3           |   3       |   4 -> 2 -> 0
         31     |   4, 3 = 0           |   0       |   4 -> 3
         32     |   4, 4 = 0           |   0       |   4 -> 4
         33     |   4, 5 = 2           |   2       |   4 -> 5
         34     |   4, 6 = 0           |   0       |   4 -> 6
         ===============================================================
         35     |   5, 0 = 0           |   0       |   5 -> 0
         36     |   5, 1 = 3           |   3       |   5 -> 1 -> 0
         37     |   5, 2 = 0           |   0       |   5 -> 2
         38     |   5, 3 = 0           |   0       |   5 -> 3
         39     |   5, 4 = 2           |   2       |   5 -> 4
         40     |   5, 5 = 0           |   0       |   5 -> 5
         41     |   5, 6 = 1           |   1       |   5 -> 6
         ===============================================================
         42     |   6, 0 = 0           |   0       |   6 -> 0
         43     |   6, 1 = 0           |   0       |   6 -> 1
         44     |   6, 2 = 0           |   0       |   6 -> 2
         45     |   6, 3 = 1           |   1       |   6 -> 3
         46     |   6, 4 = 0           |   0       |   6 -> 4
         47     |   6, 5 = 1           |   1       |   6 -> 5
         ===============================================================

         * */
        DijkstraAlgorithm T = new DijkstraAlgorithm();
        T.dijkstra(graph, 0);
    }
}