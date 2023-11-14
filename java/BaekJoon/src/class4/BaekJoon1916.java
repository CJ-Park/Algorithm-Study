package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

// 최소비용 구하기 - 다익스트라 알고리즘
public class BaekJoon1916 {
    class BusStation implements Comparable<BusStation> {
        int v; // 다음 정류장 위치
        int cost; // 비용

        public BusStation(int end, int cost) {
            v = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(BusStation o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    ArrayList<BusStation>[] graph;    // 버스 정류장마다 경로 정보들 저장
    int[] costs;    // 시작지점 ~ 도착지점 드는 비용
    boolean[] visited;    // 도달한 버스정류장 체크

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        // 정류장 개수만큼 초기화
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        costs = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            costs[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        for (int i = 1; i <= m; i++) { // 버스 정류장 경로 정보들 저장
            String[] s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0]);
            int end = Integer.parseInt(s[1]);
            int cost = Integer.parseInt(s[2]);

            graph[start].add(new BusStation(end, cost));
        }
        String s[] = br.readLine().split(" ");
        int start = Integer.parseInt(s[0]);
        int destination = Integer.parseInt(s[1]);
        dijkstra(start, destination);

        System.out.println(costs[destination]);
    }

    public void dijkstra(int start, int end) {
        PriorityQueue<BusStation> pq = new PriorityQueue<>();
        pq.add(new BusStation(start, 0)); // 시작지점은 cost 0
        visited[start] = true;
        costs[start] = 0;

        while (!pq.isEmpty()) { //
            BusStation now = pq.poll();
            if (now.v == end) break; // 도착지점 도달 시 종료

            // 다음 정류장 방문한 적 없으면 방문처리
            if (!visited[now.v]) visited[now.v] = true;

            // 최소 비용이 드는 경로 탐색
            for (BusStation nextStation : graph[now.v]) { // 현재 정류장 경로 정보로 다음 정류장 가져오기
                // 다음 정류장까지의 전체 비용에 현재 비용 + 다음 비용기
                if (costs[nextStation.v] > costs[now.v] + nextStation.cost) {
                    costs[nextStation.v] = costs[now.v] + nextStation.cost;
                    pq.add(new BusStation(nextStation.v, costs[nextStation.v]));
                }
            }
        }
    }
}
