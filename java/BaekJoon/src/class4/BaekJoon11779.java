package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 최소비용 구하기 2 - 다익스트라, 최단경로
// 거쳐온 도시를 확인해야됨
public class BaekJoon11779 {
    int n, m;
    ArrayList<Bus>[] busGraph;
    ArrayList<Integer>[] visitedCity;
    int[] totalCost;
    StringBuilder sb = new StringBuilder();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        busGraph = new ArrayList[n + 1];
        visitedCity = new ArrayList[n + 1];
        totalCost = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            totalCost[i] = Integer.MAX_VALUE;
            busGraph[i] = new ArrayList<>();
            visitedCity[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            busGraph[start].add(new Bus(end, cost, 0));
        }

        st = new StringTokenizer(br.readLine());
        int startPoint = Integer.parseInt(st.nextToken());
        int endPoint = Integer.parseInt(st.nextToken());

        dijkstra(startPoint, endPoint);

        System.out.print(sb);
    }

    public void dijkstra(int start, int end) {
        PriorityQueue<Bus> pq = new PriorityQueue<>();
        pq.add(new Bus(start, 0, 1));
        totalCost[start] = 0;
        visitedCity[start].add(start);

        while (!pq.isEmpty()) {
            Bus poll = pq.poll();

            if (poll.next == end) {
                sb.append(poll.cost).append("\n").append(poll.count).append("\n");
                break;
            }

            for (Bus bus : busGraph[poll.next]) {
                if (totalCost[bus.next] > totalCost[poll.next] + bus.cost) {
                    totalCost[bus.next] = totalCost[poll.next] + bus.cost;

                    // 방문했던 도시도 갱신됨 => 지우고 다시 구성
                    visitedCity[bus.next].clear();
                    visitedCity[bus.next].addAll(visitedCity[poll.next]);
                    visitedCity[bus.next].add(bus.next);

                    pq.add(new Bus(bus.next, totalCost[bus.next], poll.count + 1));
                }
            }
        }

        for (int city : visitedCity[end]) {
            sb.append(city).append(" ");
        }
    }

    static class Bus implements Comparable<Bus> {
        int next;
        int cost;
        int count;

        public Bus(int n, int c, int cnt) {
            this.next = n;
            this.cost = c;
            this.count = cnt;
        }

        public int compareTo(Bus b) {
            return this.cost - b.cost;
        }
    }
}
