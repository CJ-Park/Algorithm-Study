package class4.restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 파티 - 최단경로 / 다익스트라
// 다익스트라로 해결
// 배열 간 = 연산 시 같은 배열 가리킴 (.clone 사용해서 새로운 배열 만들기)
public class BaekJoon1238 {
    int n, m, target, result;
    ArrayList<Edge>[] graph;
    int[] resToTarget, resToHome, minDistance;
    boolean[] visited;

    public void solution() throws IOException {
        // 가는데 걸리는 최단 거리 배열과 오는데 걸리는 최단 거리 배열 두개 구하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        // 파티장소 가는 최단거리 저장 배열
        resToTarget = new int[n + 1];

        // 파티에서 집에 오는 최단거리 저장 배열
        resToHome = new int[n + 1];

        // 최단 거리 저장을 위한 배열
        minDistance = new int[n + 1];

        // 간선 정보 저장 그래프
        graph = new ArrayList[n + 1];

        // 각 인덱스의 그래프 초기화
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 그래프 작성
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start].add(new Edge(end, cost));
        }

        for (int i = 1; i <= n; i++) {
            Arrays.fill(minDistance, Integer.MAX_VALUE);
            dijkstra(i);

            if (i == target) {
                resToHome = minDistance.clone();
            }

            resToTarget[i] = minDistance[target];
        }

        for (int i = 1; i <= n; i++) {
            result = Math.max(result, resToTarget[i] + resToHome[i]);
        }

        System.out.println(result);
    }

    public void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        visited = new boolean[n + 1];
        minDistance[start] = 0;

        while (!pq.isEmpty()) {
            Edge poll = pq.poll();

            if (visited[poll.next])
                continue;

            if (minDistance[poll.next] < poll.value) { // 확인하려는 간선의 비용이 더 비싼 경우 스킵
                continue;
            }

            for (Edge edge : graph[poll.next]) {
                if (minDistance[edge.next] > minDistance[poll.next] + edge.value) {
                    minDistance[edge.next] = minDistance[poll.next] + edge.value;
                    pq.add(new Edge(edge.next, minDistance[edge.next]));
                }
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int next;
        int value;

        public Edge(int n, int v) {
            this.next = n;
            this.value = v;
        }

        @Override
        public int compareTo(Edge o) {
            return this.value - o.value;
        }
    }
}
