
package Heap.Basics;

import java.util.PriorityQueue;

public class WeakestSoldier {

    static class Row implements Comparable<Row> {
        int soldiers;
        int index;

        Row(int soldiers, int index) {
            this.soldiers = soldiers;
            this.index = index;
        }

        @Override
        public int compareTo(Row r) {
            if (this.soldiers == r.soldiers) {
                return this.index - r.index;
            }
            return this.soldiers - r.soldiers;
        }
    }

    public static void main(String[] args) {

        int[][] matrix = {
            {1, 0, 0, 0},
            {1, 1, 1, 1},
            {1, 0, 0, 0},
            {1, 0, 0, 0},
            {1, 1, 1, 1}
        };

        int k = 3;

        PriorityQueue<Row> pq = new PriorityQueue<>();

        for (int i = 0; i < matrix.length; i++) {

            int soldiers = 0;

            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    soldiers++;
                }
            }

            pq.add(new Row(soldiers, i));
        }

        System.out.println("K Weakest Rows:");

        for (int i = 0; i < k; i++) {
            Row r = pq.remove();
            System.out.println("Row " + r.index);
        }
    }
}

