package csc223.lb.Assignment_6;


public class MaxHeap implements Heap{
    
    public char[] arr;
    public int size;

    public MaxHeap(){
        this.size = 0;
        this.arr = new char[10];
    }
    // Insert an item to the heap
    public void insert(char value) {
        arr[size] = value;
        int curr = size;
        while (arr[curr] > arr[(curr - 1)/2] && arr[curr] != arr[0]){
            char t = arr[curr];
            arr[curr] = arr[(curr - 1)/2];
            arr[(curr - 1)/2] = t;
            curr = (curr - 1)/2;
        }
        this.size++;

    }

    // Delete the root element from the heap
    public void delete() {
        if (this.size == 0) {
            return;
        }
        char t = arr[size-1];
        arr[size-1] = arr[0];
        arr[0] = t;
        arr[size-1] = ' ';
        this.size--;
        int curr = 0;
        while (arr[curr] != ' ' && arr[curr] != arr[arr.length - 1] && (!((2*curr + 1) > this.size - 1) || !((2*curr + 2) > this.size - 1))) {
            if (arr[curr] < arr[2*curr + 1] || arr[curr] < arr[2*curr + 2]) {
                if (arr[2*curr + 1] > arr[2*curr + 2]) {
                    char temp = arr[2*curr + 1];
                    arr[2*curr + 1] = arr[curr];
                    arr[curr] = temp; 
                    curr = 2*curr + 1;
                } else if (arr[2*curr + 1] < arr[2*curr + 2]) {
                    char temp = arr[2*curr + 2];
                    arr[2*curr + 2] = arr[curr];
                    arr[curr] = temp;
                    curr = 2*curr + 2;
                }

            } return;
        }
    }




    // Get the root element of the heap
    public char peek() {
        return arr[0];

    }

    // Get the size of the heap
    public int size() {
        return this.size;

    }

    // Check if the heap is empty
    public boolean isEmpty() {
        return this.size == 0;

    }

    // Clear the heap
    public void clear() {
        if(isEmpty())
            return;

        for (int i = 0; i < this.size; i++ ){
            arr[i] = ' ';
        }
        this.size = 0;

    }

    // Return a string representation of all elements in the heap
    public String toString() {
        String str = "";
        if (!isEmpty()){ 

            for (int i = 0; i < this.size; i++ ){
                str = str + arr[i] + ",";
            } str=str.substring(0, str.length()-1);
        }
        return "{"+str+"}";

    }
}