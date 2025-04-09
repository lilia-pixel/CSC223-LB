package csc223.lb.Assignment_7Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;
import csc223.lb.Assignment_7.UnWeightedGraph;

public class UnweightedGraphTest {
    
    @Test
    public void testAddEdge() {

        UnWeightedGraph graph = new UnWeightedGraph(3);
        graph.addEdge(0, 1);

        assertTrue(graph.hasEdge(0, 1));
        assertTrue(graph.hasEdge(1, 0));
        assertFalse(graph.hasEdge(0, 2));
    }

    @Test
    public void testAddMultipleEdges() {

        UnWeightedGraph graph = new UnWeightedGraph(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        assertTrue(graph.hasEdge(0, 1));
        assertTrue(graph.hasEdge(1, 0));
        assertTrue(graph.hasEdge(1, 2));
        assertTrue(graph.hasEdge(2, 1));
        assertTrue(graph.hasEdge(2, 3));
        assertTrue(graph.hasEdge(3, 2));
    }

    @Test
    public void testAdjacencyMatrixCheck() {

        UnWeightedGraph graph = new UnWeightedGraph(3);
        graph.addEdge(0, 2);

        assertTrue(graph.hasEdge(0, 2));
        assertTrue(graph.hasEdge(2, 0));
    }



    @Test
    public void testAddEdgeMaxVertices() {

        UnWeightedGraph graph = new UnWeightedGraph(1000);
        graph.addEdge(0, 999);

        assertTrue(graph.hasEdge(0, 999));
        assertTrue(graph.hasEdge(999, 0));
    }


    @Test
    public void testRemoveEdge() {

        UnWeightedGraph graph = new UnWeightedGraph(3);
        graph.addEdge(0, 1);
        graph.removeEdge(0, 1);
        
        assertFalse(graph.hasEdge(0, 1));
        assertFalse(graph.hasEdge(1, 0));
        assertFalse(graph.hasEdge(0, 2));
    }


    @Test
    public void testRemoveEdgeNonExistent() {

        UnWeightedGraph graph = new UnWeightedGraph(3);
        graph.addEdge(0, 1);
        graph.removeEdge(0, 2);
        
        assertTrue(graph.hasEdge(0, 1));
        assertTrue(graph.hasEdge(1, 0));
    }

    @Test
    public void testRemoveMultipleEdges() {

        UnWeightedGraph graph = new UnWeightedGraph(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.removeEdge(1, 2);
        
        assertTrue(graph.hasEdge(0, 1));
        assertTrue(graph.hasEdge(1, 0));
        assertFalse(graph.hasEdge(1, 2));
        assertFalse(graph.hasEdge(2, 1));
        assertTrue(graph.hasEdge(2, 3));
        assertTrue(graph.hasEdge(3, 2));
    }


    @Test
    public void testRemoveEdgeOnEmpty() {

        UnWeightedGraph graph = new UnWeightedGraph(3);
        graph.removeEdge(0, 1);
        
        assertFalse(graph.hasEdge(0, 1));
        assertFalse(graph.hasEdge(1, 0));
    }

    @Test
    public void testRemoveEdgeFromMaxVertices() {

        UnWeightedGraph graph = new UnWeightedGraph(1000);
        graph.addEdge(0, 999);
        graph.removeEdge(0, 999);
        
        assertFalse(graph.hasEdge(0, 999));
        assertFalse(graph.hasEdge(999, 0));
    }


    @Test
    public void testHasEdge() {

        UnWeightedGraph graph = new UnWeightedGraph(3);
        graph.addEdge(0, 1);
        graph.addEdge(0, 1);

        assertTrue(graph.hasEdge(0, 1));
        assertTrue(graph.hasEdge(1, 0));
        assertFalse(graph.hasEdge(0, 2));
        assertFalse(graph.hasEdge(1, 2));
    }


    @Test
    public void testHasEdgeAfterRemove() {

        UnWeightedGraph graph = new UnWeightedGraph(3);
        graph.addEdge(0, 1);
        graph.removeEdge(0, 1);

        assertFalse(graph.hasEdge(0, 1));
        assertFalse(graph.hasEdge(1, 0));
    }


    @Test
    public void testHasEdgeWithMultipleEdges() {

        UnWeightedGraph graph = new UnWeightedGraph(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        assertTrue(graph.hasEdge(0, 1));
        assertTrue(graph.hasEdge(1, 2));
        assertTrue(graph.hasEdge(2, 3));
        assertFalse(graph.hasEdge(0, 2));
        assertFalse(graph.hasEdge(1, 3));
    }



        @Test
    public void testGetNeighbors() {

        UnWeightedGraph graph = new UnWeightedGraph(3);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        
        int[] expectedNeighbors0 = {1};
        int[] expectedNeighbors1 = {0, 2};
        int[] expectedNeighbors2 = {1};
        
        assertArrayEquals(expectedNeighbors0, graph.getNeighbors(0));
        assertArrayEquals(expectedNeighbors1, graph.getNeighbors(1));
        assertArrayEquals(expectedNeighbors2, graph.getNeighbors(2));
    }

    @Test
    public void testGetNeighborsNoEdges() {
        UnWeightedGraph graph = new UnWeightedGraph(3);
        
        int[] expectedNeighbors0 = {};
        int[] expectedNeighbors1 = {};
        int[] expectedNeighbors2 = {};
        
        assertArrayEquals(expectedNeighbors0, graph.getNeighbors(0));
        assertArrayEquals(expectedNeighbors1, graph.getNeighbors(1));
        assertArrayEquals(expectedNeighbors2, graph.getNeighbors(2));
    }


    @Test
    public void testGetNeighborsAfterEdgeRemoval() {
        UnWeightedGraph graph = new UnWeightedGraph(3);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.removeEdge(0, 1);
        
        int[] expectedNeighbors0 = {};
        int[] expectedNeighbors1 = {2};
        int[] expectedNeighbors2 = {1};
        
        assertArrayEquals(expectedNeighbors0, graph.getNeighbors(0));
        assertArrayEquals(expectedNeighbors1, graph.getNeighbors(1));
        assertArrayEquals(expectedNeighbors2, graph.getNeighbors(2));
    }

    @Test
    public void testGetNeighborsWithMultipleEdges() {
        UnWeightedGraph graph = new UnWeightedGraph(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        
        int[] expectedNeighbors0 = {1};
        int[] expectedNeighbors1 = {0, 2};
        int[] expectedNeighbors2 = {1, 3};
        int[] expectedNeighbors3 = {2};
        
        assertArrayEquals(expectedNeighbors0, graph.getNeighbors(0));
        assertArrayEquals(expectedNeighbors1, graph.getNeighbors(1));
        assertArrayEquals(expectedNeighbors2, graph.getNeighbors(2));
        assertArrayEquals(expectedNeighbors3, graph.getNeighbors(3));
    }


        @Test
    public void testGetNumVertices() {
        UnWeightedGraph graph = new UnWeightedGraph(5);
        assertEquals(5, graph.getNumVertices());
    }

    @Test
    public void testGetNumVerticesAfterEdgeAddition() {
        UnWeightedGraph graph = new UnWeightedGraph(3);
        graph.addEdge(0, 1);
        assertEquals(3, graph.getNumVertices());
    }

    @Test
    public void testGetNumVerticesAfterEdgeRemoval() {
        UnWeightedGraph graph = new UnWeightedGraph(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.removeEdge(0, 1);
        assertEquals(4, graph.getNumVertices());
    }

    @Test
    public void testGetNumVerticesWithMultipleVertices() {
        UnWeightedGraph graph = new UnWeightedGraph(10);
        assertEquals(10, graph.getNumVertices());
    }

    @Test
    public void testGetNumVerticesWithNoEdges() {
        UnWeightedGraph graph = new UnWeightedGraph(7);
        assertEquals(7, graph.getNumVertices());
    }

    @Test
    public void testGetNumVerticesMaxSize() {
        UnWeightedGraph graph = new UnWeightedGraph(1000);
        assertEquals(1000, graph.getNumVertices());
    }

    @Test
    public void testGetNumVerticesAfterGraphReinitialization() {
        UnWeightedGraph graph = new UnWeightedGraph(5);
        graph.addEdge(0, 1);
        graph = new UnWeightedGraph(10); 
        assertEquals(10, graph.getNumVertices());
    }


    @Test
    public void testPrintGraph() {

        UnWeightedGraph graph = new UnWeightedGraph(3);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);


        String expectedOutput = 
            "0 1 0 \n" +
            "1 0 1 \n" +
            "0 1 0 \n";

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        graph.printGraph();

        System.setOut(System.out);

        assertEquals(expectedOutput, outContent.toString());
    }


    @Test
    public void testPrintGraphEmpty() {
        UnWeightedGraph graph = new UnWeightedGraph(3);
    
        String expectedOutput = "0 0 0 \n0 0 0 \n0 0 0 \n";
    
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
    
        graph.printGraph();
    
        System.setOut(originalOut);
    
        assertEquals(expectedOutput, outputStream.toString());
    }


    @Test
    public void testPrintGraphAfterRemovingEdge() {
        UnWeightedGraph graph = new UnWeightedGraph(3);
        graph.addEdge(0, 1);
        graph.removeEdge(0, 1);
    
        String expectedOutput = "0 0 0 \n0 0 0 \n0 0 0 \n";
    
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
    
        graph.printGraph();
    
        System.setOut(originalOut);
    
        assertEquals(expectedOutput, outputStream.toString());
    }



    @Test
    public void testShortestPath() {
        UnWeightedGraph graph = new UnWeightedGraph(3);
        graph.addEdge(0, 1);
    
        String result = graph.shortestPath(0, 1);
        assertEquals("[0, 1]", result);
    }


    @Test
    public void testShortestPathMultipleJumps() {
        UnWeightedGraph graph = new UnWeightedGraph(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
    
        String result = graph.shortestPath(0, 3);
        assertEquals("[0, 1, 2, 3]", result);
    }


    @Test
    public void testShortestPathNoPath() {
        UnWeightedGraph graph = new UnWeightedGraph(4);
        graph.addEdge(0, 1);
        graph.addEdge(2, 3);
    
        String result = graph.shortestPath(0, 3);
        assertNull(result);
    }


    @Test
    public void testShortestPathCycle() {
        UnWeightedGraph graph = new UnWeightedGraph(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0); 
        graph.addEdge(2, 3); 
    
        String result = graph.shortestPath(0, 3);
        assertEquals("[0, 2, 3]", result);
    }

}
