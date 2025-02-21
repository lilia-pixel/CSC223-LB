package csc223.lb.Assignment_3Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import csc223.lb.Assignment_3.BinaryTree;

public class BinaryTreeTest {
    @Test
    public void TreeTest(){
        BinaryTree tree1 = new BinaryTree();
        tree1.insert('J'); //root
        tree1.insert('B');
        tree1.insert('K');


        assertEquals("BJK", tree1.inorder());

        assertEquals("BKJ", tree1.postorder());

        assertEquals("JBK", tree1.levelorder());

        assertEquals("JBK", tree1.preorder());
        
        assertEquals(3, tree1.size());

        BinaryTree tree = new BinaryTree();
        tree.insert('A'); //root
        tree.insert('B');
        tree.insert('C');
        tree.insert('D');
        tree.insert('E');

        assertEquals("DBEAC", tree.inorder());

        assertEquals("ABDEC", tree.preorder());
    
        assertEquals("DEBCA", tree.postorder());

        assertEquals("ABCDE", tree.levelorder());

        assertEquals(5, tree.size());

    }
    @Test
    public void SearchTest(){
        BinaryTree tree = new BinaryTree();
        tree.insert('A'); //root
        tree.insert('B');
        tree.insert('C');
        tree.insert('D');
        tree.insert('E');
        tree.insert('F'); 

        //Test search
        assertTrue(tree.search('D'));
        assertTrue(tree.search('A'));
        assertFalse(tree.search('J'));

        tree.insert('J');

        assertTrue(tree.search('J'));
    }

    @Test
    public void HeightTest(){
        BinaryTree tree = new BinaryTree();
        tree.insert('A'); //root
        tree.insert('B');
        tree.insert('C');
        tree.insert('D');
        tree.insert('E');
        tree.insert('F'); 

        //check the height
        assertEquals(3, tree.height());
        tree.insert('G');
        tree.insert('H');
        assertEquals(4, tree.height());
        
    }
}
