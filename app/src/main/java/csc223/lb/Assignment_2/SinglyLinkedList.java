package csc223.lb.Assignment_2;

public class SinglyLinkedList implements LinkedList{
    protected Node head;
    protected Node tail;
    protected int size;


    public SinglyLinkedList(){
        this.head = new Node(null, '\0', null);
        this.size = 0;
    }
     // Insert an item at the end of the list for unsorted lists
    public void insert(char item){
        Node newNode = new Node(null, item, null);
        Node curr = this.head;

        while (curr.next!=null){
            curr = curr.next;
        }
        curr.next = newNode;
        newNode.next = null;
        this.size++;
    }

     // Removes an item from the list
    public void remove(char item){
        Node curr = this.head;

        while (curr.next.data != item){
            curr = curr.next;
        }
        curr.next = curr.next.next;
        this.size --;
    }
 
     // Get the first item, return '☠' if the list is empty
    public char getFirst(){
        if (isEmpty()){
            return '☠';
        }
        return this.head.next.data;
    }
 
     // Get the last item, return '☠' if the list is empty
    public char getLast(){
        if (isEmpty()){
            return '☠';
        }
        Node curr = this.head;
        while (curr.next != null){
            curr = curr.next;
        }
        return curr.data;
    }
 
     // Get an item at a specific index, return '☠' if index is out of bounds
    public char get(int index){
        if (index<0 || index > size()-1){
            return '☠';
        }
        int i = 0;
        Node curr = this.head.next;
        while (i!=index){
            curr=curr.next;
            i++;
        }
        return curr.data;
    }
 
     // Get the size of the list
    public int size(){
        return this.size;
    }
 
     // Check if the list is empty
    public boolean isEmpty(){
        return this.head.next==null;
    }
 
     // Clear the list
    public void clear(){
        this.size=0;
        this.head.next = null;
    }
 
     // Check if the list contains an item
    public boolean contains(char item){
        Node curr = this.head.next;
        while (curr != null){
            if (curr.data == item){
                return true;
            }
            curr= curr.next;
        }
        return false;

    }
 
     // Get the index of an item, if it exists else return -1
    public int indexOf(char item){
        if (!contains(item)){
            return -1;
        }
        int i = 0;
        Node curr = this.head.next;
        while (curr.data!=item){
            curr=curr.next;
            i++;
        }
        return i;
    }
 
     // Get the last index of an item, if it exists else return -1
    public int lastIndexOf(char item){
        if (!contains(item)){
            return -1;
        }
        Node curr = this.head;
        int i = 0;
        int indx = 0;
        while (curr.next != null){
            if (curr.next.data == item){
                indx=i;
            }
            curr = curr.next;
            i++;
        }
        return indx;
    }
 
     // Reverse the list
    public void reverse(){
        Node prev = null;
        Node curr = this.head.next;
        Node next = null;

        while (curr != null) {  
            next = curr.next;
            curr.next =prev; 
            prev = curr;
            curr = next;

        }
  
        this.head.next = prev; 
    }
 
     // Creates and returns a String representation of the list
     // e.g. `A -> B -> C -> D` should return "ABCD"
    public String toString(){
        String s = "";
        Node curr = this.head.next; 
        while (curr != this.tail) { 
            s +=curr.data;
            curr = curr.next;
        }
        return s;
    }

    public static void main(String[] arg){
                SinglyLinkedList Sll = new SinglyLinkedList();
        Sll.insert('A');
        Sll.insert('B');
        Sll.insert('C');
        Sll.insert('D');
        System.out.println(Sll.toString());

        Sll.reverse();
        System.out.println(Sll.toString());

        
    }
}
