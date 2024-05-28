package Heap.level3;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 이중우선순위큐 {
    static PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
    static PriorityQueue<Integer> minQueue = new PriorityQueue<>();
    static int count = 0;

    public int[] solution(String[] operations) {
        int[] result = new int[2];

        // 우선순위 큐 2개로 작업
        for (String operation : operations) {
            calculate(operation);
        }

        if (count != 0) {
            result[0] = maxQueue.poll();
            result[1] = minQueue.poll();
        }

        return result;
    }

    public void calculate(String operation) {
        String[] s = operation.split(" ");
        int num = Integer.parseInt(s[1]);
        if (count == 0) {
            maxQueue.clear();
            minQueue.clear();
        }

        if (s[0].equals("I")) { // 삽입 연산
            maxQueue.add(num);
            minQueue.add(num);
            count++;
        } else { // 삭제 연산
            if (count == 0) { // 큐가 비었는데 삭제 연산
                return;
            }

            if (num == 1) { // 최댓값 삭제
                maxQueue.poll();
            }

            if (num == -1) { // 최소값 삭제
                minQueue.poll();
            }

            count--;
        }
    }
}
