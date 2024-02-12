package class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 줄 세우기 - 위상 정렬
// 사람 == 노드 / 줄세우기 == 엣지
public class BaekJoon2252 {
    int n, m;
    List<Integer>[] graph;
    int[] connection;
    boolean[] wrote;
    StringBuilder sb = new StringBuilder();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new List[n + 1];
        connection = new int[n + 1];
        wrote = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int front = Integer.parseInt(st.nextToken());
            int back = Integer.parseInt(st.nextToken());

            graph[front].add(back);
            connection[back]++;
        }

        for (int i = 1; i <= n; i++) {
            if (connection[i] == 0 && !wrote[i]) {
                getResult(i);
            }
        }

        System.out.print(sb);
    }

    public void getResult(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            Integer poll = q.poll();
            sb.append(poll).append(" ");
            wrote[poll] = true;

            for (int next : graph[poll]) {
                connection[next]--;

                if (connection[next] == 0) {
                    q.add(next);
                }
            }
        }
    }
}
