package class3.restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 이중 우선순위 큐 - 우선순위 큐 사용
// PriorityQueue 의 remove 는 시간복잡도 O(n) -> 시간 초과 발생
// Map 사용을 통해 삭제 로직 별도 구성 Map 의 get, remove 는 시간복잡도 O(1)
public class BaekJoon7662 {
    int T;
    PriorityQueue<Integer> naturalPq = new PriorityQueue<>(); // 최소값부터 빠짐
    PriorityQueue<Integer> reversePq = new PriorityQueue<>(Comparator.reverseOrder()); // 최대값부터 빠짐
    Map<Integer, Integer> map = new HashMap<>(); // 우선순위 큐에 들어가는 요소 삭제를 위함
    BufferedReader br;
    StringBuilder sb = new StringBuilder();

    public void solution() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            map.clear();
            naturalPq.clear();
            reversePq.clear();
            getResult(Integer.parseInt(br.readLine()));

            if (map.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                int max = removeFromMap(1);
                if (map.isEmpty()) {
                    sb.append(max).append(" ").append(max).append("\n");
                } else {
                    int min = removeFromMap(-1);
                    sb.append(max).append(" ").append(min).append("\n");
                }
            }
        }

        System.out.print(sb);
    }

    public void getResult(int num) throws IOException {
        for (int i = 0; i < num; i++) {
            String[] s = br.readLine().split(" ");

            if (Objects.equals(s[0], "I")) {
                int input = Integer.parseInt(s[1]);
                naturalPq.add(input);
                reversePq.add(input);

                map.put(input, map.getOrDefault(input, 0) + 1);
            } else { // 삭제 로직
                if (map.isEmpty())
                    continue;
                int input = Integer.parseInt(s[1]);

                if (input == 1) { // 최대값 삭제 -> reversePq
                    removeFromMap(input);

                } else { // 최소값 삭제 -> naturalPq
                    removeFromMap(input);
                }
            }
        }
    }

    public int removeFromMap(int type) {
        PriorityQueue<Integer> pq;
        int poll;
        if (type == 1) {
            pq = reversePq;
        } else {
            pq = naturalPq;
        }

        while (true) {
            poll = pq.poll();
            int count = map.getOrDefault(poll, 0);

            if (count == 0) { // map 에 없음
                continue;
            }
            if (count == 1) { // map 에서 삭제
                map.remove(poll);
            } else { // 2개 이상 존재 -> 카운트 하나 줄이기
                map.put(poll, count - 1);
            }
            break;
        }

        return poll;
    }
}
