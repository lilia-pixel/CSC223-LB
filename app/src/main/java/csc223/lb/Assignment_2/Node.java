package csc223.lb.Assignment_2;

public class Node {
    public Node prev;
    public Node next;
    public char data;
    public Node(Node prev, char data, Node next){
        this.data = data;
        this.next = next;
        this.prev = prev;

    }
}
