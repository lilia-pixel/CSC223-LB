package csc223.lb.Assignment_4;

public class BinaryTreeSearch {
    TreeNodeInt root;

    public BinaryTreeSearch(){

    }
    // inserts a node in the Binary search tree
    public void insert(int value) {
        root = insert(value, root); 
    }
    
    private TreeNodeInt insert(int value, TreeNodeInt curr) {
        if (curr == null) {
            return new TreeNodeInt(value);
        }
        if (value < curr.data) {
            curr.left = insert(value, curr.left);
        } else {
            curr.right = insert(value, curr.right);
        }
        return curr;
    }
    
    // deletes a node keeping the binary search tree properties
    public void delete(int value) {
        root = delete(value, root); 
    }
    
    private TreeNodeInt delete(int value, TreeNodeInt curr) {
        if (curr == null) {
            return null;
        }
    
        if (value < curr.data) {
            curr.left = delete(value, curr.left);
        } else if (value > curr.data) {
            curr.right = delete(value, curr.right);
        } else {
            // Removes node with only one child or no child
            if (curr.left == null) {
                return curr.right;
            } else if (curr.right == null) {
                return curr.left;
            }
    
            // removes node with two children get the inorder successor
            TreeNodeInt node = curr.right;
            int min = node.data;
            while (node.left != null) {
                min = node.left.data;
                node = node.left;
            }
            curr.data = min;
            curr.right = delete(curr.data, curr.right);
        }
        return curr;
    }
    
    // print an a string of in order traversal 
    public String inOrder() {
        return inOrder(root).trim(); 
    }
    
    private String inOrder(TreeNodeInt node) {
        if (node == null) {
            return "";
        }
        String leftStr = inOrder(node.left);
        String rightStr = inOrder(node.right);
        return leftStr +node.data + " " + rightStr;
    }

    // converts a sorted array into a Binary search tree
    public int sortedArrayToBST(int[] values) {
        root = null;
        sortedArrayToBST(values, 0, values.length -1);
        return root.data;
    }

    private void sortedArrayToBST(int[] values, int start, int end) {
        if (start > end){
            return;
        }

        int mid = (start + end)/2;

        insert(values[mid]);
        sortedArrayToBST(values, start, mid - 1);
        sortedArrayToBST(values, mid + 1, end);
    }

   
    // tells us if a node is in the tree or not
    public boolean search(int value) {
        return search(value, root);
    }

    private boolean search(int value, TreeNodeInt curr) {
        if (curr.data == value) {
            return true;
        }
            if (value < curr.data && curr.left != null) {
                if (search(value, curr.left)){
                    return true;
                }
            } else if(value > curr.data && curr.right != null) {
                if (search(value, curr.right)){
                    return true;
                }
            }return false;
        
    }

    // updates the element of a node in a tree
    public void update(int oldValue, int newValue) {
        update(oldValue, newValue, root);
    }
    private boolean update(int oldValue, int newValue, TreeNodeInt curr) {
        if (root.data == oldValue){
            root.data = newValue;
            return true;
        }
        if (curr.data == oldValue) {
            return true;
        }
            if (oldValue < curr.data && curr.left != null) {
                if (update(oldValue, newValue, curr.left)){
                    curr.left.data = newValue;
                }
            } else if(oldValue > curr.data && curr.right != null) {
                if (update(oldValue, newValue, curr.right)){
                    curr.right.data = newValue;
                }
            }return false;
    }


    // finds the lowest common root of two elements
    public int lowestCommonAncestor(int p, int q) {
        return lowestCommonAncestor(p, q, root);

    }

    private int lowestCommonAncestor(int p, int q, TreeNodeInt curr){
        int LCA = -1;
        if (curr == null || !search(p) || !search(q)){
            return LCA;
        }

        if (q < curr.data && p < curr.data){
            LCA = lowestCommonAncestor(p, q, curr.left);
        } else if (q > curr.data && p > curr.data){
            LCA = lowestCommonAncestor(p, q, curr.right);
        } else if ((q <= curr.data && p >= curr.data) || (q >= curr.data && p <= curr.data)){
            LCA = curr.data;
        }
        return LCA;
    }

}
