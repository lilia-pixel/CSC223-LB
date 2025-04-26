package csc223.lb.Assignment_9;

import java.util.ArrayList;

public class MyHashTable {

    private ArrayList<Tuple>[] arr;
    private int capacity;
    private int size;

    public MyHashTable(int capacity){
        this.capacity = capacity;
        this.arr = new ArrayList[capacity];
        this.size = 0;

    }

    public void put(String key, Integer value) {
        int index = Math.abs(key.hashCode()) % capacity;
        if (arr[index] == null){
            arr[index] = new ArrayList<>();
        }

        // Check if key already exists; if so, update it
        for (Tuple t : arr[index]) {
            if (t.key == key) {
                t.value = value;
                return;
            } else {
                arr[index].add(new Tuple(key, value));
            }
            size++;

        }
    }

    public Integer get(String key){
        int index = Math.abs(key.hashCode()) % capacity;

        for (Tuple t : arr[index]) {
            if (t.key == key) {
                return t.value;

            }    
        }return null;

    }    public void remove(String key) {
        // Calculate the index
        int index = Math.abs(key.hashCode()) % capacity;
        // Get the list of items stored at the address
        ArrayList<Tuple> items = this.arr[index];
        // Find the key
        index = 0;
        while (items.get(index).key != key) {
            index += 1;
        }
        items.remove(index);
    }
    
    public boolean containsKey(String key) {
        // Calculate the index
        int index = Math.abs(key.hashCode()) % capacity;
        // Get the list of items stored at the address
        ArrayList<Tuple> items = this.arr[index];
        // Find the key
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).key == key) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return this.size;
    }
}
