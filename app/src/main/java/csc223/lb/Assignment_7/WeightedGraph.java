package csc223.lb.Assignment_7;

import java.util.*;

public class WeightedGraph implements WeightedGraphInterface {

    // Data Structures
    int[][] matrix; 
    PriorityQueue<int[]> minHeap;
    int[] predecessors;
    int[] distances;


    public WeightedGraph(int numVertices) {
        // this.directed = directed;
        this.matrix = new int[numVertices][numVertices];
        this.predecessors = new int[numVertices];
        this.distances= new int[numVertices];

        // Initalize Adjacency Matrix
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                this.matrix[i][j] = Integer.MAX_VALUE;
            }
            this.matrix[i][i] = 0; // Distance to itself is zero
        }
    }


    // Add Edge Method
    @Override
    public void addEdge(int v1, int v2, int weight) {
        this.matrix[v1][v2] = (int) weight;
        this.matrix[v2][v1] = (int) weight; 
    }
        
    @Override
    public void addEdge(int v1, int v2) {
        // Default weight if not specified
        addEdge(v1, v2, 1);
    }


    // Remove Edge Method
    @Override
    public void removeEdge(int v1, int v2) {
        this.matrix[v1][v2] = Integer.MAX_VALUE;
        this.matrix[v2][v1] = Integer.MAX_VALUE;
    }

    // Has Edge Method
    @Override
    public boolean hasEdge(int v1, int v2) {
        return this.matrix[v1][v2] != Integer.MAX_VALUE;
    }

    // Get Neighbors Method
    @Override
    public int[] getNeighbors(int vertex) {
        int[] neighbors = new int[this.matrix.length];
        int curr = 0;
        for (int i = 0; i < this.matrix.length; i++) {
            if (this.matrix[vertex][i] != Integer.MAX_VALUE) {
                neighbors[curr] = i;
                curr += 1;
            }
        }
        return neighbors;
    }


    // Get Vertices Method
    @Override
    public int getNumVertices() {
        return this.matrix.length;
    }


    // Print Graph Method
    @Override
    public void printGraph() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.matrix.length; i++) {
            sb.append(i).append(": ");
            for (int j = 0; j < this.matrix.length; j++) {
                if (matrix[i][j] == Integer.MAX_VALUE) {
                    sb.append("∞");
                } else {
                    sb.append(matrix[i][j]);
                }
                if (j < this.matrix.length - 1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
    }
    

    // Add Edge Weight Method
    @Override
    public int getEdgeWeight(int v1, int v2) {
        if (this.matrix[v1][v2] == Integer.MAX_VALUE) {
            return -1;
        }
        return (int) this.matrix[v1][v2];

    }


    // Shortest Path Method
    @Override
    public String shortestPath(int startVertex, int endVertex) {
    
        // Initalize Predecessor Array
        Arrays.fill(this.predecessors, -1); // -1 indicates no predecessors
        this.predecessors[startVertex] = startVertex;
        

        // Initalize Distances Array
        this.distances[startVertex] = 0; // Distance to start is 0
        Arrays.fill(this.distances, Integer.MAX_VALUE);

        // Initalize MinHeap to start at indice 1
        this.minHeap = new PriorityQueue<int[]>(Comparator.comparingInt(v -> v[1]));
        this.minHeap.offer(new int[]{startVertex, 0}); // Add start vertex to the heap

        // Initialize Visited Array
        boolean[] visited = new boolean[this.matrix.length]; 
        Arrays.fill(visited, false);

        // Recurisuvely Call Helper Method
        shortestPath(endVertex, this.minHeap, this.distances, this.predecessors, visited);

        // Check if endVertex is reachable
        if (this.predecessors[endVertex] == -1) {
            return "No path exists from " + startVertex + " to " + endVertex;
        }
    
        // Build the path from start to end vertex
        StringBuilder path = new StringBuilder();
        int curr = endVertex;
        while (curr != startVertex) {
            path.insert(0, curr + " ");
            curr = this.predecessors[curr]; // Move to predecessor
        }
        path.insert(0, startVertex + ", "); // Add start vertex to path

        return "Path: [" + startVertex + " " + path.toString() + endVertex + "], Distance: " + this.distances[endVertex] + "\n";
    
        
    }

    private void shortestPath(int endVertex, PriorityQueue<int[]> minHeap, int[] distances, int[] predecessors, boolean[] visited) {
        // Base case: no more vertices to process
        if (minHeap.isEmpty()) {
            return; 
        }

        int[] current = minHeap.poll(); // Get vertex with smallest distance
        int u = current[0];        // Current vertex being processed
        

        if (visited[u]) {
            shortestPath(endVertex, minHeap, distances, predecessors, visited); 
            // Skip already visited
            return;
        }

        // Mark vertex as visited
        visited[u] = true; 

        // Check all neighbors of the current vertex (u)
        for (int v = 0; v < this.matrix.length; v++) {
            // Edge must exist and neighbor must be unvisited
            if (matrix[u][v] != Integer.MAX_VALUE && !visited[v]) {
                int newDist = (int) (distances[u] + this.matrix[u][v]); // Potential new shorter path
                if (newDist < distances[v]) {
                    distances[v] = newDist; // Update distance
                    predecessors[v] = u;    // Update path
                    minHeap.offer(new int[]{v, newDist}); // Add neighbor to queue
                }
            }
        }

        // Recur with updated queue
        shortestPath(endVertex, minHeap, distances, predecessors, visited);
    }

}