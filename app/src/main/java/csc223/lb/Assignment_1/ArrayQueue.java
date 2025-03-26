
package csc223.lb.Assignment_1;

import java.util.Arrays;

public class ArrayQueue implements Queue{

    private int[] queue;
    private int rear;
    private int front;
    private int capacity;
    private int size;


    public ArrayQueue(int capacity){
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.rear=0;
        this.front=0;
        this.size=0;
        }

        public int[] enqueue(int item){
            if (this.peek()==this.size){
                return null;
            }
            
            this.queue[this.rear] = item;
            this.rear = (this.rear + 1) % this.capacity;
            this.size++;
            return this.queue;
        }

        public int dequeue(){
            if (this.isEmpty()){
                return 0;
             }
            int item = this.queue[this.front];  // Remove from front
            this.queue[this.front] = 0;  // Optional: Clear old value
            this.front ++;  // Move front forward
            this.size--;
            return item;

        }

        public int peek(){
            return this.capacity;
        }

        public boolean isEmpty(){
            return this.queue.length == 0;
        }

        public int size(){
            return this.size;
        }
    
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        System.out.println(Arrays.toString(queue.enqueue(5)));  

        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());
        
        System.out.println(Arrays.toString(queue.enqueue(5)));  
        System.out.println(Arrays.toString(queue.enqueue(6)));
        System.out.println(Arrays.toString(queue.enqueue(7)));
    }
}



