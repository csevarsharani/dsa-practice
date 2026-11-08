
package Heap.Basics;

import java.util.PriorityQueue;

public class NearbyCars {

    static class Point implements Comparable<Point> {
        int x;
        int y;
        int index;
        int distance;

        Point(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
            this.distance = x * x + y * y;
        }

        @Override
        public int compareTo(Point p) {
            return this.distance - p.distance;
        }
    }

    public static void main(String[] args) {

        int[][] cars = {
            {3, 3},
            {5, -1},
            {-2, 4}
        };

        PriorityQueue<Point> pq = new PriorityQueue<>();

        for (int i = 0; i < cars.length; i++) {
            pq.add(new Point(cars[i][0], cars[i][1], i));
        }

        System.out.println("Cars nearest to origin:");

        while (!pq.isEmpty()) {
            Point p = pq.remove();

            System.out.println(
                "Car " + p.index +
                " -> (" + p.x + ", " + p.y + ")" +
                " Distance Squared: " + p.distance
            );
        }
    }
}
