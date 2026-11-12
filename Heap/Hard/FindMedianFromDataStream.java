package Heap.Hard;

import java.util.PriorityQueue;

public class FindMedianFromDataStream {

    // Max Heap - stores smaller half
    PriorityQueue<Integer> leftMaxHeap;

    // Min Heap - stores larger half
    PriorityQueue<Integer> rightMinHeap;

    public FindMedianFromDataStream() {
        leftMaxHeap = new PriorityQueue<>((a, b) -> b - a);
        rightMinHeap = new PriorityQueue<>();
    }

    // Add number to the data stream
    public void addNum(int num) {

        if (leftMaxHeap.isEmpty() || num <= leftMaxHeap.peek()) {
            leftMaxHeap.add(num);
        } else {
            rightMinHeap.add(num);
        }

        // Balance both heaps
        if (leftMaxHeap.size() > rightMinHeap.size() + 1) {
            rightMinHeap.add(leftMaxHeap.poll());
        } 
        else if (rightMinHeap.size() > leftMaxHeap.size()) {
            leftMaxHeap.add(rightMinHeap.poll());
        }
    }

    // Find median
    public double findMedian() {

        if (leftMaxHeap.size() == rightMinHeap.size()) {
            return (leftMaxHeap.peek() + rightMinHeap.peek()) / 2.0;
        }

        return leftMaxHeap.peek();
    }

    public static void main(String[] args) {

        FindMedianFromDataStream obj =
                new FindMedianFromDataStream();

        obj.addNum(1);
        obj.addNum(2);

        System.out.println(obj.findMedian()); // 1.5

        obj.addNum(3);

        System.out.println(obj.findMedian()); // 2.0
    }
}

