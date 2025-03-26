package csc223.lb.Assignment_1;

public interface Queue {
    int[] enqueue(int item);
    int dequeue();
    int peek();
    boolean isEmpty();
    int size();
}
