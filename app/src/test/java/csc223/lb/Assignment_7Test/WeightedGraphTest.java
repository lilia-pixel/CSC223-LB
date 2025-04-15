package csc223.lb.Assignment_7Test;

import org.junit.jupiter.api.Test;
import csc223.lb.Assignment_7.WeightedGraph;

import static org.junit.jupiter.api.Assertions.*;

public class WeightedGraphTest {

    @Test
    public void testAddEdge() {

        WeightedGraph graph = new WeightedGraph(5);
        graph.addEdge(0, 1, 1);
        
        assertEquals(1, graph.getEdgeWeight(0, 1));
        assertEquals(1, graph.getEdgeWeight(1, 0));
    }

    @Test
    public void testAddEdgeTwice() {

        WeightedGraph graph = new WeightedGraph(5);
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 1, 1);

        assertEquals(1, graph.getEdgeWeight(0, 1));
        assertEquals(1, graph.getEdgeWeight(1, 0));
    }

    @Test
    public void testUpdateWeight() {
        WeightedGraph graph = new WeightedGraph(5);
        graph.addEdge(2, 2, 4);
        graph.addEdge(2, 2, 10);
    
        assertEquals(10, graph.getEdgeWeight(2, 2));
    }
    


    @Test
    public void testUndirectedXtics() {

        WeightedGraph graph = new WeightedGraph(5);
        graph.addEdge(3, 4, 8);

        assertEquals(8, graph.getEdgeWeight(3, 4));
        assertEquals(8, graph.getEdgeWeight(4, 3));
    }

    @Test
    public void testAddEdgeHasWeight() {

        WeightedGraph graph = new WeightedGraph(5);
        graph.addEdge(0, 1, 3);

        assertEquals(3, graph.getEdgeWeight(0, 1));
        assertEquals(3, graph.getEdgeWeight(1, 0));
    }

    @Test
    public void testAddEdgeTwiceWithDiffWeights() {

        WeightedGraph graph = new WeightedGraph(5);
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 1, 4);

        assertEquals(4, graph.getEdgeWeight(0, 1));
        assertEquals(4, graph.getEdgeWeight(1, 0));
    }

    @Test
    public void testAddEdgeWithZeroWeight() {

        WeightedGraph graph = new WeightedGraph(5);
        graph.addEdge(1, 2, 0);

        assertEquals(0, graph.getEdgeWeight(1, 2));
        assertEquals(0, graph.getEdgeWeight(2, 1));
    }

    @Test
    public void testNegEdgeWeight() {
        WeightedGraph graph = new WeightedGraph(5);
        graph.addEdge(0, 1, -5);
    
        assertEquals(-5, graph.getEdgeWeight(0, 1));
    }
    


    @Test
    public void testRemoveEdge() {

        WeightedGraph graph = new WeightedGraph(5);
        graph.addEdge(0, 1, 3);
        graph.removeEdge(0, 1);

        assertEquals(-1, graph.getEdgeWeight(0, 1));
        assertEquals(-1, graph.getEdgeWeight(1, 0));
    }

    @Test
    public void testRemoveNonExistingEdge() {

        WeightedGraph graph = new WeightedGraph(5);
        graph.removeEdge(0, 1);

        assertEquals(-1, graph.getEdgeWeight(0, 1));
        assertEquals(-1, graph.getEdgeWeight(1, 0));
    }

    @Test
    public void testRemoveEdgeTwice() {

        WeightedGraph graph = new WeightedGraph(5);
        graph.addEdge(3, 4, 8);
        graph.removeEdge(3, 4);
        graph.removeEdge(3, 4);

        assertEquals(-1, graph.getEdgeWeight(3, 4));
        assertEquals(-1, graph.getEdgeWeight(4, 3));
    }

        

    @Test
    public void testHasEdge() {

        WeightedGraph graph = new WeightedGraph(5);
        graph.addEdge(0, 1, 3);

        assertTrue(graph.hasEdge(0, 1));
        assertTrue(graph.hasEdge(1, 0));
    }

    @Test
    public void testHasEdgeNonExistent() {

        WeightedGraph graph = new WeightedGraph(5);
        graph.addEdge(0, 1, 3);

        assertFalse(graph.hasEdge(1, 2));
    }


    @Test
    public void testGetNeighbors() {

        WeightedGraph graph = new WeightedGraph(5);
        graph.addEdge(0, 1, 3);
        graph.addEdge(0, 2, 4);
        int[] neighbors = graph.getNeighbors(0);

        assertArrayEquals(new int[]{1, 2}, neighbors);
    }

    @Test
    public void testGetNeighborsNoNeighbors() {

        WeightedGraph graph = new WeightedGraph(5);
        int[] neighbors = graph.getNeighbors(4);

        assertArrayEquals(new int[]{}, neighbors);
    }

    @Test
    public void testShortestPathPathExists() {

        WeightedGraph graph = new WeightedGraph(5);
        graph.addEdge(0, 1, 2);
        graph.addEdge(1, 2, 3);
        graph.addEdge(0, 2, 6);

        String result = graph.shortestPath(0, 2);
        String expected = "Path: [0, 1, 2], Distance: 5";

        assertEquals(expected, result);
    }

    @Test
    public void testShortestPathNoPathExists() {
        WeightedGraph graph = new WeightedGraph(5);
        graph.addEdge(0, 1, 2);
        graph.addEdge(1, 2, 3);

        String result = graph.shortestPath(0, 3);
        assertNull(result);
    }

    @Test
    public void testShortestPathToSelf() {
        WeightedGraph graph = new WeightedGraph(5);
        graph.addEdge(0, 1, 1);
    
        String result = graph.shortestPath(2, 2);
        String expected = "Path: [2], Distance: 0";
    
        assertEquals(expected, result);
    }

    @Test
    public void testGraphWithNoEdges() {
        WeightedGraph graph = new WeightedGraph(3);
    
        assertFalse(graph.hasEdge(0, 1));
        assertEquals(-1, graph.getEdgeWeight(0, 1));
        assertArrayEquals(new int[]{}, graph.getNeighbors(0));
        assertNull(graph.shortestPath(0, 2));
    }

    
    @Test
    public void testFullConnectivity() {
        WeightedGraph graph = new WeightedGraph(4);
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 2, 2);
        graph.addEdge(1, 2, 1);
        graph.addEdge(2, 3, 1);
    
        assertEquals("Path: [0, 2, 3], Distance: 3", graph.shortestPath(0, 3));
    }
    
    
}
