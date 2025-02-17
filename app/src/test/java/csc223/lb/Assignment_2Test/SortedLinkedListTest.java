package csc223.lb.Assignment_2Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import csc223.lb.Assignment_2.SortedLinkedList;


public class SortedLinkedListTest {
    
    @Test
    public void insertTest(){
        SortedLinkedList SDll = new SortedLinkedList();
        SDll.insert('B');
        SDll.insert('A');
        SDll.insert('C');
        SDll.insert('H');
        SDll.insert('A');
        assertEquals("AABCH", SDll.toString());
        SDll.insert('C');
        assertEquals("AABCCH", SDll.toString());

    }

    @Test
    public void insertSameElement() {
        SortedLinkedList SDll = new SortedLinkedList();
        SDll.insert('A');
        SDll.insert('A');
        SDll.insert('A');
        assertEquals("AAA", SDll.toString());
    }

    @Test
    public void insertReverseOrder() {
        SortedLinkedList SDll = new SortedLinkedList();
        SDll.insert('C');
        SDll.insert('B');
        SDll.insert('A');
        assertEquals("ABC", SDll.toString());
    }

    @Test
    public void testInsertIntoEmptyList() {
        SortedLinkedList Sll = new SortedLinkedList();
        Sll.insert('A');
        assertEquals(1, Sll.size());  
        assertEquals("A", Sll.toString());  
    }

    @Test
    public void testInsertAlphabeticalOrder() {
        SortedLinkedList Sll = new SortedLinkedList();
        Sll.insert('A');
        Sll.insert('Z');
        Sll.insert('M');

        assertEquals("AMZ", Sll.toString()); 
    }

    @Test
    public void testInsertLargeItem() {
        SortedLinkedList Sll = new SortedLinkedList();
        Sll.insert('A');
        Sll.insert('C');
        Sll.insert('B');
        Sll.insert('Z');

        assertEquals("ABCZ", Sll.toString());
    }

    @Test
    public void testInsertDuplicate() {
        SortedLinkedList Sll = new SortedLinkedList();
        Sll.insert('A');
        Sll.insert('B');
        Sll.insert('A');  // Insert duplicate

        assertEquals("AAB", Sll.toString()); 
    }

    @Test
    public void testInsertBeforeHead() {
        SortedLinkedList Sll = new SortedLinkedList();
        Sll.insert('B');
        Sll.insert('A');  // Insert smaller than first element

        assertEquals("AB", Sll.toString());  
    }

    @Test
    public void testToStringNoSentinels() {
        SortedLinkedList Sll = new SortedLinkedList();
        Sll.insert('A');
        Sll.insert('B');

        assertEquals("AB", Sll.toString());  
    }
}
