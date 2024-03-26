package StackQueue.level1;

import java.util.ArrayDeque;
import java.util.Queue;

public class 같은숫자는싫어 {
    public int[] solution (int[] arr) {
        int beforeValue = -1;
        int count = 0;
        Queue<Integer> queue = new ArrayDeque<>();

        for (int val : arr) {
            if (beforeValue == val) {
                continue;
            }
            beforeValue = val;
            queue.add(val);
            count++;
        }

        int[] answer = new int[count];

        int idx = 0;

        while (!queue.isEmpty()) {
            answer[idx++] = queue.poll();
        }

        return answer;
    }
}
