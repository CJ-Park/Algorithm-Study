package Heap.level2;

import java.util.PriorityQueue;

public class 더맵게 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int val : scoville) {
            pq.add(val);
        }

        return getResult(pq, K);
    }

    public static int getResult(PriorityQueue<Integer> pq, int k) {
        int count = 0;

        while (!pq.isEmpty()) {
            if (pq.size() == 1) {
                if (pq.poll() < k) {
                    count = -1;
                }
                break;
            }

            int first = pq.poll();

            if (first >= k) {
                break;
            }

            int sum = first + pq.poll() * 2;
            pq.add(sum);
            count++;
        }

        return count;
    }
}
