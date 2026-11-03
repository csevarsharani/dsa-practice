package Heap.Basics;

import java.util.PriorityQueue;

public class ConnectNRopes {

    public static int minCost(int[] ropes) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int rope : ropes) {
            pq.add(rope);
        }

        int totalCost = 0;

        while (pq.size() > 1) {

            int first = pq.poll();
            int second = pq.poll();

            int cost = first + second;

            totalCost += cost;

            pq.add(cost);
        }

        return totalCost;
    }

    public static void main(String[] args) {

        int[] ropes = {4, 3, 2, 6};

        System.out.println("Minimum Cost: " + minCost(ropes));
    }
}