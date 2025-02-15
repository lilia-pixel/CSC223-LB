package csc223.lb.Assignment_2Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import csc223.lb.Assignment_2.SinglyLinkedList;

public class SinglyLinkedListTest {
    
    @Test
    public void testInsert(){
        SinglyLinkedList Sll = new SinglyLinkedList();
        Sll.insert('A');
        Sll.insert('B');
        Sll.insert('C');
        assertEquals("ABC", Sll.toString());

    }

    @Test
    public void testRemove(){
        SinglyLinkedList Sll = new SinglyLinkedList();
        Sll.insert('A');
        Sll.insert('B');
        Sll.insert('C');
        Sll.insert('D');
        Sll.insert('E');
        assertEquals("ABCDE", Sll.toString());

        Sll.remove('E');

        assertEquals("ABCD", Sll.toString());
        Sll.remove('A');
        Sll.remove('B');
        Sll.remove('C');
        Sll.remove('D');

        assertTrue(Sll.isEmpty());
    
    }

    @Test
    public void getFirstTest(){
        SinglyLinkedList Sll = new SinglyLinkedList();
        assertEquals('☠', Sll.getFirst());

        Sll.insert('A');
        Sll.insert('B');
        Sll.insert('C');
        Sll.insert('D');
        Sll.insert('E');

        assertEquals('A', Sll.getFirst());

        Sll.remove('A');

        assertEquals('B', Sll.getFirst());
    }

    @Test
    public void getLastTest(){
        SinglyLinkedList Sll = new SinglyLinkedList();
        assertEquals('☠', Sll.getLast());

        Sll.insert('A');
        Sll.insert('B');
        Sll.insert('C');
        Sll.insert('D');
        Sll.insert('E');

        assertEquals('E', Sll.getLast());

        Sll.remove('E');

        assertEquals('D', Sll.getLast());

    }

    @Test
    public void getTest(){
        SinglyLinkedList Sll = new SinglyLinkedList();
        Sll.insert('A');
        Sll.insert('B');
        Sll.insert('C');
        Sll.insert('D');
        Sll.insert('E');

        assertEquals('B', Sll.get(1));
        assertEquals('☠', Sll.get(5));
    }

    @Test
    public void sizeTest(){
        SinglyLinkedList Sll = new SinglyLinkedList();
        assertEquals(0, Sll.size());

        Sll.insert('A');
        Sll.insert('B');
        Sll.insert('C');
        Sll.insert('D');
        Sll.insert('E');
        
        assertEquals(5, Sll.size());
    }

    @Test
    public void clearTest(){
        SinglyLinkedList Sll = new SinglyLinkedList();
        Sll.insert('A');
        Sll.insert('B');
        Sll.insert('C');
        Sll.insert('D');
        Sll.insert('E');

        assertEquals(5, Sll.size());
        Sll.clear();
        assertEquals(0, Sll.size());
        assertTrue(Sll.isEmpty());

    }

    @Test
    public void containsTest(){
        SinglyLinkedList Sll = new SinglyLinkedList();
        Sll.insert('A');
        Sll.insert('B');
        Sll.insert('C');
        Sll.insert('D');
        Sll.insert('E');
        assertTrue(Sll.contains('D'));

        assertEquals(5, Sll.size());
        Sll.clear();
        assertEquals(0, Sll.size());
        assertFalse(Sll.contains('A'));
        assertFalse(Sll.contains('B'));
        assertFalse(Sll.contains('C'));
        assertFalse(Sll.contains('D'));

        Sll.insert('T');
        Sll.insert('O');
        assertTrue(Sll.contains('T'));
        assertTrue(Sll.contains('O'));
    }

    @Test
    public void indexOfTest(){
        SinglyLinkedList Sll = new SinglyLinkedList();
        assertEquals(-1, Sll.indexOf('a'));

        Sll.insert('A');
        Sll.insert('B');
        Sll.insert('C');
        Sll.insert('D');
        Sll.insert('E');
        assertEquals(2, Sll.indexOf('C'));
        assertEquals(-1, Sll.indexOf('T'));
    }

    @Test
    public void LastIndexOfTest(){
        SinglyLinkedList Sll = new SinglyLinkedList();
        assertEquals(-1, Sll.indexOf('a'));
        Sll.insert('A');
        Sll.insert('B');
        Sll.insert('C');
        Sll.insert('D');
        Sll.insert('E');
        Sll.insert('A');
        Sll.insert('B');
        Sll.insert('C');
        Sll.insert('D');
        Sll.insert('E');

        assertEquals(5, Sll.lastIndexOf('A'));
        assertEquals(9, Sll.lastIndexOf('E'));
    }

    @Test
    public void reverseTest(){
        SinglyLinkedList Sll = new SinglyLinkedList();
        Sll.insert('A');
        Sll.insert('B');
        Sll.insert('C');
        Sll.insert('D');
        Sll.insert('E');
        assertEquals("ABCDE", Sll.toString());
        Sll.reverse();
        assertEquals("EDCBA", Sll.toString());
        
    }
}
