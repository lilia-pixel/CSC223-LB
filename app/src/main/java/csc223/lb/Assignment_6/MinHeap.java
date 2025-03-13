package csc223.lb.Assignment_6;

public class MinHeap {
    
    int[] heapArray;
    int size;
    int root;
    int end;
    int capacity;

    public MinHeap(){
        this.root = 0;
        this.end = 0;
        this.size = 0;
        this.capacity = 10;
        this.heapArray = new int[this.capacity];

    }

    public void insert(char value){
        if (this.size == this.capacity){
            this.capacity *= 2;
            int[] temp = new int[this.capacity];
            for (int j = 0; j < this.size; j++)
                temp[j] = this.heapArray[j];
            this.heapArray = temp;
        }
        this.heapArray[this.end] = value;
        this.end += 1;
        this.size += 1;
        bubbleup(this.end);
    }

    private void bubbleup(int index){
        if (this.heapArray[index] < this.heapArray[(index-1)/2]){
            int temp = this.heapArray[index];
            this.heapArray[index] = this.heapArray[(index-1)/2];
            this.heapArray[(index-1)/2] = temp;
        }
        if (index-1 >= 1){
            bubbleup(index-1);
        }
    }

    public void delete(){
        if (isEmpty())
            return;
        this.heapArray[this.root] = this.heapArray[this.end];
        delete(0);
    }

    private int delete(int index){
        if ((2*index+1) > this.size){
            this.end -= 1;
            return -1;
        }
        else if (this.heapArray[index] > this.heapArray[2*index+1]){
            int temp = this.heapArray[index];
            this.heapArray[index] = this.heapArray[2*index+1];
            this.heapArray[2*index+1] = temp;
            delete(2*index+1);
        }
        else if (this.heapArray[index] > this.heapArray[2*index+2]){
            int temp = this.heapArray[index];
            this.heapArray[index] = this.heapArray[2*index+2];
            this.heapArray[2*index+2] = temp;
            delete(2*index+2);
        }
        return -1;
    }

    public int peek(){
        return this.heapArray[this.root];
    }

    public int size(){
        return this.size;
    }

    public Boolean isEmpty(){
        return (this.root==this.end);
    }

    public void clear(){
        this.heapArray = new int[10];
        this.capacity = 10;
    }
    
    public String toString(){
        String heapString = "{";
        for (int i = 0; i<this.size; i++){
            heapString = heapString + this.heapArray[i] + ",";
        }
        heapString = heapString + "}";
        return heapString;
    }
}
