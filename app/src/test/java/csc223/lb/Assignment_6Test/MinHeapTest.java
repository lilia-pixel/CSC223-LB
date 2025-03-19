package csc223.lb.Assignment_6Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import csc223.lb.Assignment_6.MinHeap;

public class MinHeapTest {
    @Test
    public void testInsertOneElement() {
        MinHeap heap = new MinHeap();
        heap.insert('5');

        assertEquals(1, heap.size());
        assertEquals('5', heap.peek());
    }

    @Test
    public void testInsertMultipleElements() {
        MinHeap heap = new MinHeap();
        heap.insert('3');
        heap.insert('5');
        heap.insert('1');

        assertEquals(3, heap.size());
        assertEquals('1', heap.peek()); 
    }

    @Test
    public void testInsertDuplicates() {
        MinHeap heap = new MinHeap();
        heap.insert('4');
        heap.insert('4');
        heap.insert('4');

        assertEquals(3, heap.size());
        assertEquals('4', heap.peek());
    }

    @Test
    public void testInsertChars() {
        MinHeap heap = new MinHeap();
        heap.insert('z');
        heap.insert('a');
        heap.insert('m');

        assertEquals('a', heap.peek());
    }


    @Test
    public void testDeleteFromEmptyHeap() {
        MinHeap heap = new MinHeap();
        heap.delete();
        assertEquals(0, heap.size());
        assertTrue(heap.isEmpty());
    }

    @Test
    public void testDeleteOneElement() {
        MinHeap heap = new MinHeap();
        heap.insert('5');
        heap.delete();

        assertEquals(0, heap.size());
        assertTrue(heap.isEmpty());
    }

    @Test
    public void testDeleteRoot() {
        MinHeap heap = new MinHeap();
        heap.insert('3');
        heap.insert('5');
        heap.insert('1'); 
        heap.delete(); 

        assertEquals(2, heap.size());
        assertEquals('3', heap.peek());
    }

    @Test
    public void testDeleteMultipleTimes() {
        MinHeap heap = new MinHeap();
        heap.insert('4');
        heap.insert('2');
        heap.insert('8');
        heap.insert('1');

        heap.delete(); 
        assertEquals('2', heap.peek());

        heap.delete();
        assertEquals('4', heap.peek());

        heap.delete(); 
        assertEquals('8', heap.peek());

        heap.delete(); 
        assertTrue(heap.isEmpty());
    }

    @Test
    public void testDeleteWithOnlyOneChild() {
        MinHeap heap = new MinHeap();
        heap.insert('2');
        heap.insert('5');

        heap.delete(); 

        assertEquals(1, heap.size());
        assertEquals('5', heap.peek());
    }

    @Test
    public void testDeleteUntilEmpty() {
        MinHeap heap = new MinHeap();
        heap.insert('4');
        heap.insert('2');
        heap.insert('8');
        heap.insert('1');

        heap.delete(); 
        heap.delete(); 
        heap.delete(); 
        heap.delete(); 

        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
    }


    @Test
    public void testIsEmptyOnNewHeap() {
        MinHeap heap = new MinHeap();
        assertTrue(heap.isEmpty());
    }


    @Test
    public void testIsEmptyAfterMultipleInserts() {
        MinHeap heap = new MinHeap();
        heap.insert('2');
        heap.insert('8');
        assertFalse(heap.isEmpty());
    }

    @Test
    public void testIsEmptyAfterDelete() {
        MinHeap heap = new MinHeap();
        heap.insert('4');
        heap.insert('2');

        heap.delete(); 
        assertFalse(heap.isEmpty());

        heap.delete(); 
        assertTrue(heap.isEmpty());
    }

    @Test
    public void testIsEmptyAfterClear() {
        MinHeap heap = new MinHeap();
        heap.insert('3');
        heap.insert('7');

        heap.clear();
        assertTrue(heap.isEmpty());
    }

    @Test
    public void testClearOnEmptyHeap() {
        MinHeap heap = new MinHeap();
        heap.clear(); 
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
    }

    @Test
    public void testClearAfterInsertions() {
        MinHeap heap = new MinHeap();
        heap.insert('5');
        heap.insert('3');
        heap.insert('8');

        heap.clear(); 
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
    }



    @Test
    public void testToStringOnEmptyHeap() {
        MinHeap heap = new MinHeap();
        assertEquals("{}", heap.toString());
    }

    @Test
    public void testToStringAfterSingleInsert() {
        MinHeap heap = new MinHeap();
        heap.insert('5');
        assertEquals("{5}", heap.toString());
    }

    @Test
    public void testToStringAfterMultipleInserts() {
        MinHeap heap = new MinHeap();
        heap.insert('4');
        heap.insert('2');
        heap.insert('7');

        assertEquals("{2,4,7}", heap.toString()); 
    }

    @Test
    public void testToStringAfterDelete() {
        MinHeap heap = new MinHeap();
        heap.insert('6');
        heap.insert('1');
        heap.insert('9');

        heap.delete(); 
        assertEquals("{6,9}", heap.toString());
    }

    @Test
    public void testToStringAfterClear() {
        MinHeap heap = new MinHeap();
        heap.insert('3');
        heap.insert('7');

        heap.clear();
        assertEquals("{}", heap.toString());
    }
    
}
