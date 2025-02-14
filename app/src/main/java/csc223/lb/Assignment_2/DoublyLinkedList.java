package csc223.lb.Assignment_2;

public class DoublyLinkedList extends SinglyLinkedList{
    protected Node tail;
    protected Node head;
    protected int size;

    public DoublyLinkedList(){
        this.tail = new Node(null, '\0', null);
        this.head = new Node(null,'\0', this.tail);
        this.tail.prev = this.head;
        this.size = 0;


    }
     // Insert an item at the end of the list for unsorted lists
    public void insert(char item){
        Node newNode = new Node(null, item, null);
        newNode.prev = this.tail.prev;
        this.tail.prev.next = newNode;
        newNode.next = this.tail;
        this.tail.prev = newNode;
        this.size ++;    

    }

     // Removes an item from the list
    public void remove(char item){ //throws Exception
        // if (isEmpty()){
        //     throw new Exception("There is no item to remove");
        // }
        Node curr = this.head.next;
        while (curr != this.tail){
            if (curr.data == item){
                curr.prev.next =curr.next;
                curr.next.prev = curr.prev;
                this.size --;
                return; 
            }
                curr=curr.next;
        }
        // throw new Exception("This element is not in the list");

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
        return this.tail.prev.data;
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
        return this.head.next==this.tail;
    }
 
     // Clear the list
    public void clear(){
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.size=0;
    }
 
     // Check if the list contains an item
    public boolean contains(char item){

        Node curr = this.head.next;
        while (curr != this.tail){
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
        // return super.lastIndexOf(item);
        if (!contains(item)){
            return -1;
        }
        int i = this.size-1;
        Node curr = this.tail.prev;
        while (curr.data!=item){
            curr=curr.prev;
            i--;
        }
        return i;
    }
 
     // Reverse the list
    public void reverse(){
        Node curr = this.head.next;
        Node a = null;
    
        while (curr != null) {
            a = curr.prev;
            curr.prev = curr.next;
            curr.next = a;
            curr = curr.prev; 
        }

        if (a != null) {
            this.tail = this.head;
            this.head = a.prev;
        }
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
        DoublyLinkedList Dll = new DoublyLinkedList();
        Dll.insert('A');
        Dll.insert('B');
        Dll.insert('C');
        Dll.insert('D');
        Dll.insert('E');

        System.out.println(Dll.toString());

        Dll.reverse();

        System.out.print(Dll.toString());
        
    }
}
