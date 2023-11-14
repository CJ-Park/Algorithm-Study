package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 최단경로 - 다익스트라 알고리즘 문제
public class BaekJoon1753 {
    class Node implements Comparable<Node>{
        int v; // 간선과 이어진 정점
        int cost; // 가중치
        public Node(int nextNode, int cost) {
            this.v = nextNode;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    ArrayList<Node>[] graph; // 각 노드에 연결된 그래프 정보 담는 리스트 => 노드 개수 + 1 만큼 필요 (노드 0은 생략이므로)
    boolean[] visited; // 해당 노드 방문 여부 저장 배열
    int[] distance; // 각 노드까지의 최단거리 저장 배열

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        graph = new ArrayList[v + 1];
        visited = new boolean[v + 1];
        distance = new int[v + 1];

        for (int i = 1; i <= v; i++) {
            graph[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE; // 최단거리 저장해나갈 예정이므로 최대값 초기화
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // idx 노드
            int b = Integer.parseInt(st.nextToken()); // 다음 정점 노드
            int cost = Integer.parseInt(st.nextToken()); // 가중치

            graph[a].add(new Node(b, cost));
        }

        dijkstra(k);
        for (int i = 1; i < distance.length; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }
    }

    public void dijkstra(int startNode) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(startNode, 0));
        visited[startNode] = true;
        distance[startNode] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll(); // 현재 노드 가져오기

            if (!visited[now.v]) { // 다음 정점 방문한적 없으면
                visited[now.v] = true; // 방문처리
            }

            for (Node next : graph[now.v]) { // 다음 정점의 노드 정보 가져옴
                // 방문 안했고 다음 노드까지의 거리가 더 짧으면 pq 에 추가 및 거리 정보 업데이트
                if (!visited[next.v] && distance[next.v] > distance[now.v] + next.cost) {
                    distance[next.v] = distance[now.v] + next.cost;
                    pq.add(new Node(next.v, distance[next.v]));
                }
            }
        }
    }
}
