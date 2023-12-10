package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

// 최대 힙 - 우선순위 큐 사용
public class BaekJoon11279 {
    int n;
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (pq.isEmpty()) sb.append(0).append("\n");
                else sb.append(pq.poll()).append("\n");
            } else {
                pq.add(input);
            }
        }
        System.out.print(sb);
    }
}
