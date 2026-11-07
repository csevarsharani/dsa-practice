
package Heap.Basics;

import java.util.ArrayList;

public class Pop {

    public static int pop(ArrayList<Integer> heap) {

        if (heap.isEmpty()) {
            System.out.println("Heap is empty");
            return -1;
        }

        int min = heap.get(0);

        // Replace root with last element
        int last = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, last);

            // Heapify down
            int i = 0;
            int n = heap.size();

            while (true) {
                int left = 2 * i + 1;
                int right = 2 * i + 2;
                int smallest = i;

                if (left < n &&
                    heap.get(left) < heap.get(smallest)) {
                    smallest = left;
                }

                if (right < n &&
                    heap.get(right) < heap.get(smallest)) {
                    smallest = right;
                }

                if (smallest == i) {
                    break;
                }

                int temp = heap.get(i);
                heap.set(i, heap.get(smallest));
                heap.set(smallest, temp);

                i = smallest;
            }
        }

        return min;
    }

    public static void main(String[] args) {

        ArrayList<Integer> heap = new ArrayList<>();

        heap.add(10);
        heap.add(20);
        heap.add(15);
        heap.add(30);
        heap.add(40);

        System.out.println("Original Min Heap: " + heap);

        int removed = pop(heap);

        System.out.println("Removed Element: " + removed);
        System.out.println("Updated Min Heap: " + heap);
    }
}
