package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 특정한 최단 경로 - 다익스트라, 유니온파인드
// 유니온파인드로 지나야하는 네 정점이 같은 그래프에 있는지 확인
// 거쳐가는 두 점을 시작점으로 최단거리 탐색
public class BaekJoon1504 {
    int n, e, n1, n2;
    int[] parent; // 지나야하는 모든 정점이 연결되어 있는지 확인
    int[] minDist;
    int[] minDist_2;
    ArrayList<Edge>[] graph;
    StringBuilder sb = new StringBuilder();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        minDist = new int[n + 1];
        minDist_2 = new int[n + 1];
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        Arrays.fill(minDist, Integer.MAX_VALUE);
        Arrays.fill(minDist_2, Integer.MAX_VALUE);

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            graph[node1].add(new Edge(node2, dist));
            graph[node2].add(new Edge(node1, dist));
            union(node1, node2);
        }

        st = new StringTokenizer(br.readLine());
        n1 = Integer.parseInt(st.nextToken());
        n2 = Integer.parseInt(st.nextToken());

        if (find(n) == 1 && find(n1) == 1 && find(n2) == 1) {
            dijkstra(n1, 1);
            int home_N1 = minDist[1];
            int N1_N2 = minDist[n2];
            int N1_N = minDist[n];

            dijkstra(n2, 2);
            int home_N2 = minDist_2[1];
            int N2_N = minDist_2[n];

            int res = Math.min(home_N1 + N1_N2 + N2_N, home_N2 + N1_N2 + N1_N);
            sb.append(res);
        } else {
            sb.append(-1);
        }

        System.out.print(sb);
    }

    public void union(int n1, int n2) {
        int x = find(n1);
        int y = find(n2);

        if (x == y)
            return;

        if (x < y) {
            parent[y] = parent[x];
        } else {
            parent[x] = parent[y];
        }
    }

    public int find(int node) {
        if (parent[node] == node)
            return node;

        return find(parent[node]);
    }

    public void dijkstra(int start, int type) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));

        if (type == 1) {
            minDist[start] = 0;
            while (!pq.isEmpty()) {
                Edge now = pq.poll();

                for (Edge e : graph[now.next]) {
                    if (minDist[e.next] < e.dist) {
                        continue;
                    }

                    if (minDist[e.next] > minDist[now.next] + e.dist) {
                        minDist[e.next] = minDist[now.next] + e.dist;
                        pq.add(new Edge(e.next, minDist[e.next]));
                    }
                }
            }
        }
        else {
            minDist_2[start] = 0;
            while (!pq.isEmpty()) {
                Edge now = pq.poll();

                for (Edge e : graph[now.next]) {
                    if (minDist_2[e.next] < e.dist) {
                        continue;
                    }

                    if (minDist_2[e.next] > minDist_2[now.next] + e.dist) {
                        minDist_2[e.next] = minDist_2[now.next] + e.dist;
                        pq.add(new Edge(e.next, minDist_2[e.next]));
                    }
                }
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int next;
        int dist;

        public Edge(int n, int d) {
            this.next = n;
            this.dist = d;
        }

        @Override
        public int compareTo(Edge e) {
            return this.dist - e.dist;
        }
    }
}
