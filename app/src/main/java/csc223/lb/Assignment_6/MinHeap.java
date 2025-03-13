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
        for (int i = 1; i<this.end+1; i++){
            if (this.heapArray[i] < this.heapArray[(i-1)/2]){
                int temp = this.heapArray[i];
                this.heapArray[i] = this.heapArray[(i-1)/2];
                this.heapArray[(i-1)/2] = temp;
                this.size += 1;
                this.end += 1;
            }
        }
    }

    public void delete(){
        if (isEmpty())
            return;
        this.heapArray[this.root] = this.heapArray[this.end];
        for (int i = 0; i<this.end+1; i++){
            if ((2*i+1) > this.size){
                this.end -= 1;
                return;
            }
            else if (this.heapArray[i] > this.heapArray[2*i+1]){
                int temp = this.heapArray[i];
                this.heapArray[i] = this.heapArray[2*i+1];
                this.heapArray[2*i+1] = temp;
            }
            else if (this.heapArray[i] > this.heapArray[2*i+2]){
                int temp = this.heapArray[i];
                this.heapArray[i] = this.heapArray[2*i+2];
                this.heapArray[2*i+2] = temp;
            }
        }
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
