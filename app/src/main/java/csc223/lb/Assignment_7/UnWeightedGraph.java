package csc223.lb.Assignment_7;

import java.util.*;

public class UnWeightedGraph {
    public int[][] adjacencyMatrix;
    public int vertices;

    public UnWeightedGraph(int vertices) {
        this.vertices = vertices;
        adjacencyMatrix = new int[vertices][vertices];
    }

    public void addEdge(int v1, int v2) {
        if (v1 >= 0 && v1 < vertices && v2 >= 0 && v2 < vertices){
            adjacencyMatrix[v1][v2] = 1;
            adjacencyMatrix[v2][v1] = 1;
        }else {
            return;
        }

    }

    public void removeEdge(int v1, int v2) {
        if (v1 >= 0 && v1 < vertices && v2 >= 0 && v2 < vertices){
            adjacencyMatrix[v1][v2] = 0;
            adjacencyMatrix[v2][v1] = 0;
        }else{
            return;
        }
    }

    public boolean hasEdge(int v1, int v2) {
        if (v1 >= 0 && v1 < vertices && v2 >= 0 && v2 < vertices) {
            return adjacencyMatrix[v1][v2] == 1;
        }
        return false;
    }
    

    public int[] getNeighbors(int vertex) {
        if (vertex < 0 || vertex >= vertices) {
            return new int[0]; 
        }
    
        List<Integer> neighbors = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            if (adjacencyMatrix[vertex][i] == 1) {
                neighbors.add(i);
            }
        } 
        int[] neighborsInt = new int[neighbors.size()];
        for (int i = 0; i < neighbors.size(); i++) {
            neighborsInt[i] = neighbors.get(i);
        }
        return neighborsInt;
    }
    

    public int getNumVertices() {
        return vertices;

    }

    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public String shortestPath(int startVertex, int endVertex) {

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[vertices];
        Map<Integer, Integer> parent = new LinkedHashMap<>();
        
        queue.add(startVertex);
        visited[startVertex] = true;
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();

            if (curr == endVertex) {
                break;
            }
            for (int neighbor: getNeighbors(curr)) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                    parent.put(neighbor, curr);
                }
            }
        }
        
        if (!visited[endVertex]) {
            return null;
        }
        
        List<Integer> path = new ArrayList<>();
        int at = endVertex;
        while (at != startVertex) {
            path.add(at);
            at = parent.get(at);
        }
        path.add(startVertex);

        Collections.reverse(path);
        return path.toString();
    }

}
