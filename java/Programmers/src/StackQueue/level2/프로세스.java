package StackQueue.level2;

import java.util.*;
import java.util.stream.Collectors;

public class 프로세스 {
    public int solution(int[] priorities, int location) {
        int count = 1;
        List<Integer> list = Arrays.stream(priorities)
                .boxed().sorted().collect(Collectors.toList());

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.add(priorities[i]);
        }

        while (true) {
            int num = queue.poll();

            // 우선순위가 제일 높은 경우
            if (num == list.get(list.size() - 1)) {
                list.remove(list.size() - 1);
                if (location == 0) {
                    return count;
                } else {
                    location -= 1;
                    count += 1;
                }
            } else {
                queue.add(num);
                location -= 1;
            }


            if (location < 0) {
                location = queue.size() - 1;
            }
        }
    }
}
