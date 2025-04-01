package csc223.lb.Assignment_6Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import csc223.lb.Assignment_6.MaxHeap;


public class MaxHeapTest {


    @Test
    public void testInsertOneElement() {
        MaxHeap heap = new MaxHeap();
        heap.insert('a');

        assertEquals(1, heap.size());
        assertEquals('a', heap.peek());
    }

    @Test
    public void testInsertMultipleElements() {
        MaxHeap heap = new MaxHeap();
        heap.insert('c');
        heap.insert('g');
        heap.insert('b');

        assertEquals(3, heap.size());
        assertEquals('g', heap.peek()); 
    }


    @Test
    public void testInsertDuplicates() {
        MaxHeap heap = new MaxHeap();
        heap.insert('k');
        heap.insert('k');
        heap.insert('k');

        assertEquals(3, heap.size());
        assertEquals('k', heap.peek());
    }

    @Test
    public void testDeleteFromEmptyHeap() {
        MaxHeap heap = new MaxHeap();
        heap.delete();
        assertEquals(0, heap.size());
        assertTrue(heap.isEmpty());
    }

    @Test
    public void testDeleteSingleElement() {
        MaxHeap heap = new MaxHeap();
        heap.insert('f');
        heap.delete();

        assertEquals(0, heap.size());
        assertTrue(heap.isEmpty());
    }

    @Test
    public void testDeleteRoot() {
        MaxHeap heap = new MaxHeap();
        heap.insert('e');
        heap.insert('f');
        heap.insert('g'); 

        heap.delete(); 

        assertEquals(2, heap.size());
        assertEquals('f', heap.peek());
    }

    @Test
    public void testDeleteManyTimes() {
        MaxHeap heap = new MaxHeap();
        heap.insert('y');
        heap.insert('z');
        heap.insert('t');
        heap.insert('m');

        heap.delete(); 
        assertEquals('y', heap.peek());

        heap.delete(); 
        assertEquals('t', heap.peek());

        heap.delete();
        assertEquals('m', heap.peek());

        heap.delete(); 
        assertTrue(heap.isEmpty());
    }

    @Test
    public void testIsEmptyOnNewHeap() {
        MaxHeap heap = new MaxHeap();
        assertTrue(heap.isEmpty());
    }

    @Test
    public void testIsEmptyAfterInsert() {
        MaxHeap heap = new MaxHeap();
        heap.insert('a');
        assertFalse(heap.isEmpty());
    }

    @Test
    public void testIsEmptyAfterManyInserts() {
        MaxHeap heap = new MaxHeap();
        heap.insert('r');
        heap.insert('f');
        assertFalse(heap.isEmpty());
    }

    @Test
    public void testIsEmptyAfterDelete() {
        MaxHeap heap = new MaxHeap();
        heap.insert('s');
        heap.insert('x');

        heap.delete(); 
        assertFalse(heap.isEmpty());

        heap.delete(); 
        assertTrue(heap.isEmpty());
    }

    @Test
    public void testIsEmptyAfterClear() {
        MaxHeap heap = new MaxHeap();
        heap.insert('l');
        heap.insert('i');

        heap.clear();
        assertTrue(heap.isEmpty());
    }

    @Test
    public void testClearOnEmptyHeap() {
        MaxHeap heap = new MaxHeap();
        heap.clear(); 
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
    }

    @Test
    public void testClearAfterInsertions() {
        MaxHeap heap = new MaxHeap();
        heap.insert('u');
        heap.insert('i');
        heap.insert('x');

        heap.clear(); 
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
        assertEquals("{}", heap.toString());
    }

    @Test
    public void testToStringOnEmptyHeap() {
        MaxHeap heap = new MaxHeap();
        assertEquals("{}", heap.toString());
    }

    @Test
    public void testToStringAfterSingleInsert() {
        MaxHeap heap = new MaxHeap();
        heap.insert('e');
        assertEquals("{e}", heap.toString());
    }

    @Test
    public void testToStringAfterManyInserts() {
        MaxHeap heap = new MaxHeap();
        heap.insert('s');
        heap.insert('w');
        heap.insert('e');

        assertEquals("{w,s,e}", heap.toString()); 
    }

    @Test
    public void testToStringAfterDelete() {
        MaxHeap heap = new MaxHeap();
        heap.insert('t');
        heap.insert('o');
        heap.insert('g');

        heap.delete(); 
        assertEquals("{o,g}", heap.toString());
    }

    @Test
    public void testToStringAfterClear() {
        MaxHeap heap = new MaxHeap();
        heap.insert('a');
        heap.insert('j');

        heap.clear();
        assertEquals("{}", heap.toString());
    }

}
