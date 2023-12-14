package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 절댓값 힙 - 우선순위 큐
// Comparable 인터페이스 구현
public class BaekJoon11286 {
    PriorityQueue<Value> pq = new PriorityQueue<>();
    int n;
    StringBuilder sb = new StringBuilder();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int res = Integer.parseInt(br.readLine());
            getResult(res);
        }

        System.out.print(sb);
    }

    public void getResult(int input) {
        if (input == 0) {
            if (!pq.isEmpty()) {
                sb.append(pq.poll().originalValue).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        } else {
            pq.add(new Value(input));
        }
    }

    public class Value implements Comparable<Value> {
        int originalValue; // 원래값
        int absoluteValue; // 절대값

        public Value(int num) {
            this.originalValue = num;
            this.absoluteValue = num < 0 ? num * -1 : num;
        }

        @Override
        public int compareTo(Value o) {
            // 절대값 먼저 비교
            if (this.absoluteValue < o.absoluteValue) {
                return -1;
            } else if (this.absoluteValue > o.absoluteValue) {
                return 1;
            }

            // 절대값 같으면 원래값 비교
            if (this.originalValue < o.originalValue) {
                return -1;
            } else if (this.originalValue > o.originalValue) {
                return 1;
            }

            // 둘 다 같으면 그대로
            return 0;
        }
    }
}
