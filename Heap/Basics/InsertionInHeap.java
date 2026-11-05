
package Heap.Basics;

import java.util.ArrayList;

public class InsertionInHeap {

    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        // Insert element into Max Heap
        public void add(int data) {
            arr.add(data);

            int child = arr.size() - 1;
            int parent = (child - 1) / 2;

            // Heapify Up
            while (child > 0 && arr.get(child) > arr.get(parent)) {

                int temp = arr.get(child);
                arr.set(child, arr.get(parent));
                arr.set(parent, temp);

                child = parent;
                parent = (child - 1) / 2;
            }
        }

        // Display Heap
        public void display() {
            System.out.println(arr);
        }
    }

    public static void main(String[] args) {

        Heap h = new Heap();

        h.add(10);
        h.add(20);
        h.add(15);
        h.add(30);
        h.add(40);

        System.out.println("Max Heap after insertion:");
        h.display();
    }
}
