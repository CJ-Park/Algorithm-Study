package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 최소 힙 - 우선순위 큐 자료구조를 이용해서 해결
public class BaekJoon1927 {
    int n;
    PriorityQueue<Integer> pq;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        pq = new PriorityQueue<>(Integer::compareTo);
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (pq.isEmpty()) sb.append(0).append("\n");
                else sb.append(pq.poll()).append("\n");
            } else {
                pq.add(num);
            }
        }

        System.out.print(sb);
    }
}
