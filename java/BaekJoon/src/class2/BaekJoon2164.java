package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 큐 자료구조
public class BaekJoon2164 {
    int n, count;
    Queue<Integer> q;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        q = new LinkedList<>();
        n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        while (q.size() != 1) {
            if(count % 2 == 0) {
                q.poll();
            } else {
                q.offer(q.poll());
            }
            count++;
        }

        System.out.println(q.poll());
    }
}
