package StackQueue.level2;

import java.util.*;
import java.util.stream.Collectors;

public class 기능개발 {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        List<Integer> speedList = Arrays.stream(speeds)
                .boxed().collect(Collectors.toList());
        Queue<Integer> queue = new ArrayDeque<>();

        for (int progress : progresses) {
            queue.add(progress);
        }

        while (!queue.isEmpty()) {
            int count = 0;

            while (queue.peek() < 100) { // 제일 앞의 작업이 안끝남
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int poll = queue.poll();
                    queue.add(poll + speedList.get(i));
                }
            }

            while (!queue.isEmpty() && queue.peek() >= 100) {
                queue.poll();
                speedList.remove(0);
                count++;
            }

            result.add(count);
        }

        return result;
    }
}
