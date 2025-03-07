package csc223.lb.Assignment_2Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import csc223.lb.Assignment_2.DoublyLinkedList;

public class DoublyLinkedListTest {
    
        @Test
        public void testInsertSingleElement() {
            DoublyLinkedList Dll = new DoublyLinkedList();
            Dll.insert('A');
            assertEquals("A", Dll.toString());  
        }
    
        @Test
        public void testReverse() {
            DoublyLinkedList Dll = new DoublyLinkedList();
            Dll.insert('A');
            Dll.insert('B');
            Dll.insert('C');
    
            Dll.reverse();
            assertEquals("CBA", Dll.toString());
    
            assertEquals('C', Dll.getFirst());  
            assertEquals('A', Dll.getLast());   
        }
        
        @Test
        public void testGetIndex() {    
            DoublyLinkedList Dll = new DoublyLinkedList();
            Dll.insert('A');
            Dll.insert('B');
            Dll.insert('C');
    
            assertEquals('B', Dll.get(1)); 
            assertEquals('☠', Dll.get(-1)); 
            assertEquals('☠', Dll.get(3));
        }
    
        @Test
        public void testInsert(){
            DoublyLinkedList Dll = new DoublyLinkedList();
            Dll.insert('A');
            Dll.insert('B');
            Dll.insert('C');
            assertEquals("ABC", Dll.toString());
    
        }
    
        @Test
        public void testRemove(){
            DoublyLinkedList Dll = new DoublyLinkedList();
            Dll.insert('A');
            Dll.insert('B');
            Dll.insert('C');
            Dll.insert('D');
            Dll.insert('E');
    
            Dll.remove('E');
    
            assertEquals("ABCD", Dll.toString());
            Dll.remove('A');
            Dll.remove('B');
            Dll.remove('C');
            Dll.remove('D');
    
            assertTrue(Dll.isEmpty());
            // assertThrows(Exception.class,() ->{Dll.remove('V');} );
        }
    
        @Test
        public void getFirstTest(){
            DoublyLinkedList Dll = new DoublyLinkedList();
            assertEquals('☠', Dll.getFirst());
    
            Dll.insert('A');
            Dll.insert('B');
            Dll.insert('C');
            Dll.insert('D');
            Dll.insert('E');
    
            assertEquals('A', Dll.getFirst());
    
            Dll.remove('A');
    
            assertEquals('B', Dll.getFirst());
        }
    
        @Test
        public void getLastTest(){
            DoublyLinkedList Dll = new DoublyLinkedList();
            assertEquals('☠', Dll.getLast());
    
            Dll.insert('A');
            Dll.insert('B');
            Dll.insert('C');
            Dll.insert('D');
            Dll.insert('E');
    
            assertEquals('E', Dll.getLast());
    
            Dll.remove('E');
    
            assertEquals('D', Dll.getLast());
    
        }
    
        @Test
        public void getTest(){
            DoublyLinkedList Dll = new DoublyLinkedList();
            Dll.insert('A');
            Dll.insert('B');
            Dll.insert('C');
            Dll.insert('D');
            Dll.insert('E');
    
            assertEquals('B', Dll.get(1));
            assertEquals('☠', Dll.get(5));
        }
    
        @Test
        public void sizeTest(){
            DoublyLinkedList Dll = new DoublyLinkedList();
            assertEquals(0, Dll.size());
    
            Dll.insert('A');
            Dll.insert('B');
            Dll.insert('C');
            Dll.insert('D');
            Dll.insert('E');
    
            assertEquals(5, Dll.size());
        }
    
        @Test
        public void clearTest(){
            DoublyLinkedList Dll = new DoublyLinkedList();
            Dll.insert('A');
            Dll.insert('B');
            Dll.insert('C');
            Dll.insert('D');
            Dll.insert('E');
    
            assertEquals(5, Dll.size());
            Dll.clear();
            assertEquals(0, Dll.size());
            assertTrue(Dll.isEmpty());
    
        }
    
        @Test
        public void containsTest(){
            DoublyLinkedList Dll = new DoublyLinkedList();
            Dll.insert('A');
            Dll.insert('B');
            Dll.insert('C');
            Dll.insert('D');
            Dll.insert('E');
            assertTrue(Dll.contains('D'));
    
            assertEquals(5, Dll.size());
            Dll.clear();
            assertEquals(0, Dll.size());
            assertFalse(Dll.contains('A'));
            assertFalse(Dll.contains('B'));
            assertFalse(Dll.contains('C'));
            assertFalse(Dll.contains('D'));
    
            Dll.insert('T');
            Dll.insert('O');
            assertTrue(Dll.contains('T'));
            assertTrue(Dll.contains('O'));
        }
    
        @Test
        public void indexOfTest(){
            DoublyLinkedList Dll = new DoublyLinkedList();
            Dll.insert('A');
            Dll.insert('B');
            Dll.insert('C');
            Dll.insert('D');
            Dll.insert('E');
    
            assertEquals(2, Dll.indexOf('C'));
            assertEquals(-1, Dll.indexOf('T'));
        }
    
        @Test
        public void LastIndexOfTest(){
            DoublyLinkedList Dll = new DoublyLinkedList();
            Dll.insert('A');
            Dll.insert('B');
            Dll.insert('C');
            Dll.insert('D');
            Dll.insert('E');
            Dll.insert('A');
            Dll.insert('B');
            Dll.insert('C');
            Dll.insert('D');
            Dll.insert('E');
    
            assertEquals(5, Dll.lastIndexOf('A'));
            assertEquals(9, Dll.lastIndexOf('E'));
        }
    
        @Test
        public void reverseTest(){
            DoublyLinkedList Dll = new DoublyLinkedList();
            Dll.insert('A');
            Dll.insert('B');
            Dll.insert('C');
            Dll.insert('D');
            Dll.insert('E');
            Dll.reverse();
            assertEquals("EDCBA", Dll.toString());
        }
}
