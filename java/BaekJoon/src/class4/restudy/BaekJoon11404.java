package class4.restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 플로이드 - 플로이드워셜 / 최단경로
// 다익스트라로 풀었음
public class BaekJoon11404 {
    int n, m;
    ArrayList<Node>[] graph;
    long[] minCost; // cost 비용이 최대 100,000 이므로 누적 비용은 10^10 까지 가능 => long 타입이여야 됨

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new ArrayList[n + 1];
        minCost = new long[n + 1];

        // graph 정보 초기화
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // graph 에 노선 정보 채우기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(cost, next));
        }

        for (int i = 1; i <= n; i++) {
            Arrays.fill(minCost, Long.MAX_VALUE);
            makeCostGraph(i);
            for (int j = 1; j <= n; j++) {
                if (minCost[j] == Long.MAX_VALUE)
                    minCost[j] = 0;
                sb.append(minCost[j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public void makeCostGraph(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, start));
        minCost[start] = 0;

        while (!pq.isEmpty()) {
            Node poll = pq.poll();

            if (minCost[poll.next] < poll.cost) {
                continue;
            }

            for (Node nextNode : graph[poll.next]) {
                if (minCost[nextNode.next] > minCost[poll.next] + nextNode.cost){
                    minCost[nextNode.next] = minCost[poll.next] + nextNode.cost;
                    pq.add(new Node(minCost[nextNode.next], nextNode.next));
                }
            }
        }
    }

    public class Node implements Comparable<Node> {
        long cost;
        int next;

        public Node(long cost, int next) {
            this.cost = cost;
            this.next = next;
        }

        @Override
        public int compareTo(Node o) {
            return (int) (this.cost - o.cost);
        }
    }
}
