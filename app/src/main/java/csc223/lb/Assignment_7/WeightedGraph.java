package csc223.lb.Assignment_7;

import java.util.*;

public class WeightedGraph implements WeightedGraphInterface {

    private double[][] matrix; // Adjacency Matrix
    private int numVertices;
    // private boolean directed; // Boolean to determine if graph is directed or undirected (not implemented)
    private static final double INF = Integer.MAX_VALUE;

    public WeightedGraph(int numVertices) {
        this.numVertices = numVertices;
        // this.directed = directed;
        this.matrix = new double[numVertices][numVertices];

        // Initalize all weight 
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                this.matrix[i][j] = WeightedGraph.INF;
            }
            this.matrix[i][i] = 0; // Distance to itself is zero
        }
        

    }

    @Override
    public void addEdge(int v1, int v2, double weight) {
        this.matrix[v1][v2] = weight;
        this.matrix[v2][v1] = weight; // assuming undirected
    }
        
    @Override
    public void addEdge(int v1, int v2) {
        // Default weight if not specified
        addEdge(v1, v2, 1.0);
    }


    @Override
    public void removeEdge(int v1, int v2) {
        this.matrix[v1][v2] = WeightedGraph.INF;
        this.matrix[v2][v1] = WeightedGraph.INF; // undirected
    }

    @Override
    public boolean hasEdge(int v1, int v2) {
        return this.matrix[v1][v2] != WeightedGraph.INF;
    }

    @Override
    public int[] getNeighbors(int vertex) {
        List<Integer> neighbors = new ArrayList<>();
        for (int i = 0; i < this.numVertices; i++) {
            if (this.matrix[vertex][i] != WeightedGraph.INF && i != vertex) {
                // i is a neighbor if there is an edge
                neighbors.add(i);
            }
        }

        // Convert List<Integer> to primitive int[]
        int[] result = new int[neighbors.size()];
        for (int i = 0; i < neighbors.size(); i++) {
            result[i] = neighbors.get(i);
        }
        return result;

    }

    @Override
    public int getNumVertices() {
        return this.numVertices;
    }


    // Prints the graph in matrix form
    @Override
    public void printGraph() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numVertices; i++) {
            sb.append(i).append(": ");
            for (int j = 0; j < numVertices; j++) {
                if (matrix[i][j] == INF) {
                    sb.append("∞");
                } else {
                    sb.append(matrix[i][j]);
                }
                if (j < numVertices - 1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    

    @Override
    public double getEdgeWeight(int v1, int v2) {
        if (this.matrix[v1][v2] == WeightedGraph.INF) {
            return -1;
        }
        return this.matrix[v1][v2];

    }


    @Override
    public String shortestPath(int startVertex, int endVertex) {
        int[] dist = new int[this.numVertices];         // Distance from start to each vertex
        int[] prev = new int[this.numVertices];         // To reconstruct the shortest path
        boolean[] visited = new boolean[this.numVertices]; // Marks visited vertices

        Arrays.fill(dist, (int) INF);     // Initialize distances as infinite
        Arrays.fill(prev, -1);      // No predecessors initially
        dist[startVertex] = 0;      // Distance to start is 0

        // Min-heap based on current distance (second element in the array)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        pq.offer(new int[]{startVertex, 0}); // Start with the source node

        // Begin recursive Dijkstra
        shortestPath(pq, dist, prev, visited);

        // If there's no path to the destination
        if (dist[endVertex] == WeightedGraph.INF) {
            return null;
        }

        // Reconstruct path from `prev` array
        List<Integer> path = new ArrayList<>();
        for (int at = endVertex; at != -1; at = prev[at]) {
            path.add(at);
        }
        Collections.reverse(path); // Because we reconstructed it backwards

        return "Path: " + path + ", Distance: " + dist[endVertex];
    }

    // Recursive helper for Dijkstra's algorithm using PriorityQueue
    private void shortestPath(PriorityQueue<int[]> pq, int[] dist, int[] prev, boolean[] visited) {
        if (pq.isEmpty()) {
            return; // Base case: no more vertices to process
        }

        int[] current = pq.poll(); // Get vertex with smallest distance
        int u = current[0];        // Current vertex being processed

        if (visited[u]) {
            shortestPath(pq, dist, prev, visited); // Skip already visited
            return;
        }

        visited[u] = true; // Mark vertex as visited

        // Check all neighbors of u
        for (int v = 0; v < this.numVertices; v++) {
            // Edge must exist and neighbor must be unvisited
            if (matrix[u][v] != WeightedGraph.INF && !visited[v]) {
                int newDist = (int) (dist[u] + this.matrix[u][v]); // Potential new shorter path
                if (newDist < dist[v]) {
                    dist[v] = newDist; // Update distance
                    prev[v] = u;       // Update path
                    pq.offer(new int[]{v, newDist}); // Add neighbor to queue
                }
            }
        }

        // Recur with updated queue
        shortestPath(pq, dist, prev, visited);
    }

    // ---------------------------- Testing ---------------------------- //
    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph(5);

        // Add some weighted edges
        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 3, 5);
        graph.addEdge(1, 2, 1);
        graph.addEdge(3, 1, 3);
        graph.addEdge(3, 2, 9);
        graph.addEdge(2, 4, 4);
        graph.addEdge(4, 0, 7);

        graph.printGraph(); // Show the adjacency matrix
        System.out.println(graph.shortestPath(0, 4)); // Show shortest path from 0 to 4
    }

    

}
