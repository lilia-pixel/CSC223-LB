package csc223.lb.Assignment_2;

public class SortedLinkedList extends DoublyLinkedList{


    public SortedLinkedList(){
        super();
        this.tail = new Node(null, '9', null);
        this.head = new Node(null,'0', this.tail);
        this.tail.prev = this.head;
        this.size = 0;

    }

     // Insert an item 
    public void insert(char item){
        if(item >= this.tail.prev.data){
            super.insert(item);

        }else{
            Node newNode= new Node(null, item, null);
            if (isEmpty()){
                newNode.next = this.tail;
                newNode.prev = this.head;
                this.tail.prev = newNode;
                this.head.next = newNode;
            }
            else{
                Node curr = this.head.next;
                while ( curr.data < item ){
                    curr = curr.next;
                }
                newNode.next = curr;
                newNode.prev = curr.prev;
                curr.prev.next = newNode;
                curr.prev = newNode;
                this.size++;
            }
         }

    }

}
