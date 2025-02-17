package csc223.lb;

public interface Queue {
    int[] enqueue(int item);
    int dequeue();
    int peek();
    boolean isEmpty();
    int size();
}
