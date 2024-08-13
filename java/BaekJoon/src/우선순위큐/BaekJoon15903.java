package 우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
카드 합체 놀이 - 실버1
요소 최대 100만 + 합체 최대 15000번 => Integer 범위 초과 가능
=> Long 타입 사용
 */
public class BaekJoon15903 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.naturalOrder());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.add(Long.parseLong(st.nextToken()));
        }

        int count = 0;
        while (count < cnt) {
            long n1 = pq.poll();
            long n2 = pq.poll();

            long sum = n1 + n2;

            pq.add(sum);
            pq.add(sum);

            count++;
        }

        long result = 0;
        while (!pq.isEmpty()) {
            result += pq.poll();
        }

        System.out.print(result);
    }
}
