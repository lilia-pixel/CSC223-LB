package csc223.lb.Assignment_3;

import java.util.Queue;
import java.util.LinkedList;


public class BinaryTree implements Tree{
    private TreeNode root;
    private int size;

    public BinaryTree(){
        this.root = null;
        this.size = 0;

    }

    public String inorder(){
        return inorder(root);
    }
     
     
    private String inorder(TreeNode node){
        if (node == null){
            return "";
        }
        String leftStr  = inorder(node.left);
        String rightStr = inorder(node.right);
        return leftStr + node.data + rightStr;
    }

    public String preorder(){
        return preorder(root);
    }

    private String preorder(TreeNode node){
        if (node == null) {
            return "";
        }
        String leftStr  = preorder(node.left);
        String rightStr = preorder(node.right);
        return node.data + leftStr + rightStr;
    }

    public String postorder(){
        return postorder(root);
    }
     
     
    private String postorder(TreeNode node){
        if (node == null) {
            return "";
        }
        String leftStr  = postorder(node.left);
        String rightStr = postorder(node.right);
        return leftStr + rightStr + node.data;
    }


    public String levelorder(){
        if (root == null){
            return "";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        String result = ""; 
    
        while (!queue.isEmpty()){
            TreeNode curr = queue.poll(); 
            result += curr.data;     
            
            if (curr.left != null){
                queue.add(curr.left);
            }
            if (curr.right != null){
            
                queue.add(curr.right);
            }
        }
        return result;

    }


       /**
     * Insert an item into the tree,
     * using level order traversal to find the correct position
     * If the tree is empty, insert the item at the root node.
     */

    public void insert(char item){
        this.size++;
        if (isEmpty()){
            this.root = new TreeNode(item);
            return;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode newNode = new TreeNode(item);

        queue.add(root);   
        while (!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr.left == null){
                curr.left = newNode;
                return;
            }else{
                queue.add(curr.left);
            }
            if(curr.right == null){
                curr.right = newNode;
                return;
            }else{
                queue.add(curr.right);
            }
        }
    }
 
 
    // Check if the tree contains an item
    public boolean search(char item){
        return search(root, item);
    }
    private boolean search(TreeNode curr, char item){
        if (curr == null){
            return false;
        }
        if (curr.data == item){
            return true;
        }else if (search(curr.left, item)){
            return true;
        }else if (search(curr.right, item)){
            return true;
        }
            return false;

    }
 
 
    // Get the number of nodes in the tree
    public int size(){
        return this.size;
    }
 
 
    // Check if the tree is empty
    public boolean isEmpty(){
        return this.root == null;
    }

    // Get the height of the tree (number of nodes along the longest path from the root node down to the farthest leaf node)
    public int height() {
        return height(root);
    }

    private int height(TreeNode curr){
        if (curr == null){
            return 0;
        }
        return 1 + Math.max(height(curr.left), height(curr.right));
    }
 
}
