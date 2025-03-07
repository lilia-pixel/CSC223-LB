package csc223.lb.Assignment_4Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import csc223.lb.Assignment_4.BinaryTreeSearch;

public class BinaryTreeSearchTest {
    @Test
    public void deleteTest(){
        BinaryTreeSearch tree = new BinaryTreeSearch();

        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        assertEquals("20 30 40 50 60 70 80", tree.inOrder());

        tree.delete(50);

        assertEquals("20 30 40 60 70 80", tree.inOrder());

        tree.delete(80);

        assertEquals("20 30 40 60 70", tree.inOrder());
    }

    @Test

    public void sortedArrayToBSTTest(){
        BinaryTreeSearch tree = new BinaryTreeSearch();
        int[] nums = {-10, -3, 0, 9, 5};
        assertEquals(0, tree.sortedArrayToBST(nums));
        assertEquals("-10 -3 0 5 9", tree.inOrder());

        BinaryTreeSearch tree2 = new BinaryTreeSearch();
        int[] nums2 = {7, 8, 9, 10, 11};
        assertEquals(9, tree2.sortedArrayToBST(nums2));
        assertEquals("7 8 9 10 11", tree2.inOrder());
    }

    @Test

    public void searchTest(){
        BinaryTreeSearch tree = new BinaryTreeSearch();
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        assertTrue(tree.search(40));
        assertTrue(tree.search(80));
        assertTrue(tree.search(50));
        assertTrue(tree.search(70));

        assertFalse(tree.search(90));
        assertFalse(tree.search(100));
        assertFalse(tree.search(10));
        
    }
    @Test

    public void updateTest(){
        BinaryTreeSearch tree = new BinaryTreeSearch();
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        assertEquals("20 30 40 50 60 70 80", tree.inOrder());

        tree.update(40, 90);
        tree.update(50,30);
        tree.update(20,21);


        assertEquals("21 30 90 30 60 70 80", tree.inOrder());

        tree.update(100, 110);

        assertEquals("21 30 90 30 60 70 80", tree.inOrder());
    }
    @Test

    public void LCATest(){
        BinaryTreeSearch tree = new BinaryTreeSearch();
        tree.insert(6);
        tree.insert(2);
        tree.insert(8);
        tree.insert(0);
        tree.insert(4);
        tree.insert(7);
        tree.insert(9);
        tree.insert(3);
        tree.insert(5);

        assertEquals(6,tree.lowestCommonAncestor(2, 8));
        assertEquals(2,tree.lowestCommonAncestor(2, 4));
        assertEquals(-1,tree.lowestCommonAncestor(10, 4));

    }
    
}
