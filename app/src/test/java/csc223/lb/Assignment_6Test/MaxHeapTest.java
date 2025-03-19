package csc223.lb.Assignment_6Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MaxHeapTest {

    @Test
    public void testInsertSingleElement() {
        MaxHeap heap = new MaxHeap();
        heap.insert('5');

        assertEquals(1, heap.size());
        assertEquals('5', heap.peek());
    }

    @Test
    public void testInsertMultipleElements() {
        MaxHeap heap = new MaxHeap();
        heap.insert('3');
        heap.insert('5');
        heap.insert('1');

        assertEquals(3, heap.size());
        assertEquals('5', heap.peek()); 
    }

    @Test
    public void testInsertMaintainsMaxHeapProperty() {
        MaxHeap heap = new MaxHeap();
        heap.insert('1');
        heap.insert('3');
        heap.insert('5');
        heap.insert('7');
        heap.insert('9');

        assertEquals('9', heap.peek()); 
    }

    @Test
    public void testInsertDuplicates() {
        MaxHeap heap = new MaxHeap();
        heap.insert('4');
        heap.insert('4');
        heap.insert('4');

        assertEquals(3, heap.size());
        assertEquals('4', heap.peek());
    }

    @Test
    public void testInsertAlphabetCharacters() {
        MaxHeap heap = new MaxHeap();
        heap.insert('a');
        heap.insert('z');
        heap.insert('m');

        assertEquals('z', heap.peek()); 
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
        heap.insert('5');
        heap.delete();

        assertEquals(0, heap.size());
        assertTrue(heap.isEmpty());
    }

    @Test
    public void testDeleteRootMaintainsMaxHeapProperty() {
        MaxHeap heap = new MaxHeap();
        heap.insert('1');
        heap.insert('3');
        heap.insert('5'); 

        heap.delete(); 

        assertEquals(2, heap.size());
        assertEquals('3', heap.peek());
    }

    @Test
    public void testDeleteMultipleTimes() {
        MaxHeap heap = new MaxHeap();
        heap.insert('8');
        heap.insert('4');
        heap.insert('2');
        heap.insert('1');

        heap.delete(); 
        assertEquals('4', heap.peek());

        heap.delete(); 
        assertEquals('2', heap.peek());

        heap.delete();
        assertEquals('1', heap.peek());

        heap.delete(); 
        assertTrue(heap.isEmpty());
    }

    @Test
    public void testDeleteWithOnlyOneChild() {
        MaxHeap heap = new MaxHeap();
        heap.insert('5');
        heap.insert('2');

        heap.delete(); 

        assertEquals(1, heap.size());
        assertEquals('2', heap.peek());
    }

    @Test
    public void testDeleteMaintainsHeapOrder() {
        MaxHeap heap = new MaxHeap();
        heap.insert('1');
        heap.insert('3');
        heap.insert('5');
        heap.insert('7');
        heap.insert('9');

        heap.delete(); 
        assertEquals('7', heap.peek());

        heap.delete(); 
        assertEquals('5', heap.peek());
    }

    @Test
    public void testDeleteUntilHeapIsEmpty() {
        MaxHeap heap = new MaxHeap();
        heap.insert('8');
        heap.insert('4');
        heap.insert('2');
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
        MaxHeap heap = new MaxHeap();
        assertTrue(heap.isEmpty());
    }

    @Test
    public void testIsEmptyAfterInsert() {
        MaxHeap heap = new MaxHeap();
        heap.insert('5');
        assertFalse(heap.isEmpty());
    }

    @Test
    public void testIsEmptyAfterMultipleInserts() {
        MaxHeap heap = new MaxHeap();
        heap.insert('2');
        heap.insert('8');
        assertFalse(heap.isEmpty());
    }

    @Test
    public void testIsEmptyAfterDelete() {
        MaxHeap heap = new MaxHeap();
        heap.insert('4');
        heap.insert('2');

        heap.delete(); 
        assertFalse(heap.isEmpty());

        heap.delete(); 
        assertTrue(heap.isEmpty());
    }

    @Test
    public void testIsEmptyAfterClear() {
        MaxHeap heap = new MaxHeap();
        heap.insert('3');
        heap.insert('7');

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
        heap.insert('5');
        heap.insert('3');
        heap.insert('8');

        heap.clear(); 
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.size());
    }

    @Test
    public void testToStringOnEmptyHeap() {
        MaxHeap heap = new MaxHeap();
        assertEquals("{}", heap.toString());
    }

    @Test
    public void testToStringAfterSingleInsert() {
        MaxHeap heap = new MaxHeap();
        heap.insert('5');
        assertEquals("{5}", heap.toString());
    }

    @Test
    public void testToStringAfterMultipleInserts() {
        MaxHeap heap = new MaxHeap();
        heap.insert('7');
        heap.insert('4');
        heap.insert('2');

        assertEquals("{7,4,2}", heap.toString()); 
    }

    @Test
    public void testToStringAfterDelete() {
        MaxHeap heap = new MaxHeap();
        heap.insert('9');
        heap.insert('6');
        heap.insert('1');

        heap.delete(); 
        assertEquals("{6,1}", heap.toString());
    }

    @Test
    public void testToStringAfterClear() {
        MaxHeap heap = new MaxHeap();
        heap.insert('3');
        heap.insert('7');

        heap.clear();
        assertEquals("{}", heap.toString());
    }

}
