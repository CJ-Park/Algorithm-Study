package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 타임머신 - 벨만 포드, 최단경로
// minCost 의 최소 최대 범위 확인할 것
public class BaekJoon11657 {
    // minCost 범위 (5 * 10^2) * (-6 * 10^6 ~ 6 * 10^6) => 절대값 3 * 10^9 => 따라서 minCost 는 long 타입이여야 됨
    final long MAX = Long.MAX_VALUE;
    long[] minCost;
    int n, m;
    ArrayList<Edge>[] graph;
    StringBuilder sb = new StringBuilder();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];
        minCost = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start].add(new Edge(end, cost));
        }

        bellmanford();
        System.out.print(sb);
    }

    public void bellmanford() {
        Arrays.fill(minCost, MAX);
        minCost[1] = 0;
        boolean update = false;

        // 정점개수 - 1 만큼 반복 탐색
        // minCost 범위 (5 * 10^2) * (-6 * 10^6 ~ 6 * 10^6) => 절대값 3 * 10^9 => 따라서 minCost 는 long 타입이여야 됨
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                for (Edge e : graph[j]) {
                    if (minCost[j] != MAX && minCost[e.next] > e.cost + minCost[j]) {
                        minCost[e.next] = e.cost + minCost[j];
                    }
                }
            }
        }

        // 음수 싸이클 유무 확인을 위해 1회 탐색 추가
        for (int i = 1; i <= n; i++) {
            for (Edge e : graph[i]) {
                if (minCost[i] != MAX && minCost[e.next] > e.cost + minCost[i]) {
                    update = true;
                }
            }
        }

        if (update) { // 음수 싸이클 있음
            sb.append("-1");
        } else {
            for (int i = 2; i <= n; i++) {
                long min = minCost[i] == MAX ? -1 : minCost[i];
                sb.append(min).append("\n");
            }
        }
    }

    static class Edge {
        int next;
        int cost;

        public Edge(int n, int c) {
            this.next = n;
            this.cost = c;
        }
    }
}
