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
}
