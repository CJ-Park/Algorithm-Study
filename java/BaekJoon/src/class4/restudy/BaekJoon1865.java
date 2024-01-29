package class4.restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 웜홀 - 벨만포드 알고리즘 / 그래프 탐색
// 벨만포드 알고리즘 다시 공부하기
// Integer 범위 생각해서 초기화하기
public class BaekJoon1865 {
    final int MAX = Integer.MAX_VALUE / 10;
    int n, m, w, T;
    ArrayList<Edge>[] graph;
    int[] totalCost;
    StringBuilder sb = new StringBuilder();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            totalCost = new int[n + 1];
            graph = new ArrayList[n + 1];

            for (int j = 1; j <= n; j++) {
                graph[j] = new ArrayList<>();
            }

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                graph[s].add(new Edge(e, t));
                graph[e].add(new Edge(s, t));
            }

            for (int j = 0; j < w; j++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                t *= -1;
                graph[s].add(new Edge(e, t));
            }

            if (bellmanford()) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }

        System.out.print(sb);
    }

    // 음수 싸이클이 발생하면 true 반환
    public boolean bellmanford() {
        Arrays.fill(totalCost, MAX); // totalCost 를 Integer.MAX_VALUE 로 채우면 안됨
        // => 아래에서 totalCost[j] + e.cost 시 Integer 범위 벗어날 수 있음
        // => 최대 10^7 더해질 수 있으므로 해당 부분만큼 뺀 값보다 낮은 값으로 totalCost 초기화 해야 됨

        totalCost[1] = 0;
        boolean update;

        // 정점의 개수 - 1 만큼 반복
        for (int i = 1; i < n; i++) {
            update = false;

            // totalCost 정보 최신화
            for (int j = 1; j <= n; j++) {
                for (Edge e : graph[j]) {
                    if (totalCost[e.next] > totalCost[j] + e.cost) {
                        totalCost[e.next] = totalCost[j] + e.cost;
                        update = true;
                    }
                }
            }

            if (!update) {
                return false;
            }
        }

        // 싸이클 갱신 여부 확인을 위해 간선 정보 한번 더 최신화
        for (int j = 1; j < graph.length; j++) {
            for (Edge e : graph[j]) {
                if (totalCost[e.next] > totalCost[j] + e.cost) { // 갱신이 다시 된 경우 => 음수 싸이클 존재
                    return true;
                }
            }
        }

        return false;
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
