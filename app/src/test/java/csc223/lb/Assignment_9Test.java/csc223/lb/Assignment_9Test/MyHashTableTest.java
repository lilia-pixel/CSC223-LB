package csc223.lb.Assignment_9Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import csc223.lb.Assignment_9.MyHashTable;

public class MyHashTableTest {

    private MyHashTable hashTable;

    @BeforeEach
    public void setUp() {
        hashTable = new MyHashTable(100);
    }

    @Test
    public void putTest() {
        hashTable.put("Emily", 0);
        assertEquals(1, hashTable.size());
        hashTable.put("Lilia", 1);
        assertEquals(2, hashTable.size());
        hashTable.put("Andrew", 2);
        assertEquals(3, hashTable.size());
        assertEquals(2, hashTable.get("Andrew"));

        // Test updating an existing key
        hashTable.put("Emily", 5);
        assertEquals(3, hashTable.size());
        assertEquals(5, hashTable.get("Emily"));

    }

    @Test
    public void getTest() {
        hashTable.put("Andrew", 10);
        hashTable.put("Lilia", 20);

        assertEquals(10, hashTable.get("Andrew"));
        assertEquals(20, hashTable.get("Lilia"));
        assertNull(hashTable.get("Emily")); // Non-existent key
    }

    @Test
    public void removeTest() {
        hashTable.put("Emily", 10);
        hashTable.put("Lilia", 20);
        assertEquals(2, hashTable.size());

        hashTable.remove("Lilia");
        assertEquals(1, hashTable.size());
        assertNull(hashTable.get("Lilia"));
        assertEquals(10, hashTable.get("Emily"));

    }


    @Test
    public void containsKeyTest() {
        hashTable.put("Andrew", 10);
        hashTable.put("Lilia", 20);

        assertTrue(hashTable.containsKey("Andrew"));
        assertTrue(hashTable.containsKey("Lilia"));
        assertFalse(hashTable.containsKey("Emily")); 
    }

    @Test
    public void sizeTest() {
        assertEquals(0, hashTable.size());

        hashTable.put("Andrew", 10);
        assertEquals(1, hashTable.size());

        hashTable.put("Lilia", 20);
        assertEquals(2, hashTable.size());

        hashTable.remove("Andrew");
        assertEquals(1, hashTable.size());
    }
}