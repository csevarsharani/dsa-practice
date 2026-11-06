package Heap.Basics;

import java.util.ArrayList;

public class Push {

    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        void push(int data) {

            // Add element at last
            arr.add(data);

            int x = arr.size() - 1;
            int par = (x - 1) / 2;

            // Heapify
            while (arr.get(x) < arr.get(par)) {

                // Swap child and parent
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;
                par = (x - 1) / 2;
            }
        }

        void printHeap() {
            for (int i = 0; i < arr.size(); i++) {
                System.out.print(arr.get(i) + " ");
            }
        }
    }

    public static void main(String[] args) {

        Heap h = new Heap();

        h.push(10);
        h.push(20);
        h.push(5);
        h.push(30);
        h.push(2);

        h.printHeap();
    }
}