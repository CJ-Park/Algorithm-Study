package Graph.level3;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class 가장먼노드 {
    static class Node implements Comparable<Node> {
        int next;
        int dis;

        public Node(int n, int dis) {
            this.next = n;
            this.dis = dis;
        }

        public int compareTo(Node n) {
            return this.dis - n.dis;
        }
    }

    public int solution(int n, int[][] edge) {
        // 1번 노드로부터 다른 노드까지의 최단 거리 리스트 필요
        //   1 2 3 4 5 6
        // 1 0 1 1 0 0 0
        // 2 1 0 1 1 1 0
        // 3 1 1 0 1 0 1
        // 4 0 1 1 0 0 0
        // 5 0 1 0 0 0 0
        // 6 0 0 1 0 0 0

        // graph 초기화
        ArrayList<Node>[] graph = new ArrayList[n + 1];
        int[] distance = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        distance[1] = 0;

        for (int i = 0; i < edge.length; i++) {
            int x = edge[i][0];
            int y = edge[i][1];

            graph[x].add(new Node(y, 1));
            graph[y].add(new Node(x, 1));
        }


        // graph 탐색하면서 distance 갱신
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // 1번 노드부터 시작
        pq.add(new Node(1, 0));

        int maxDistance = 0;
        int count = 0;

        while (!pq.isEmpty()) {
            Node start = pq.poll();

            for (Node node : graph[start.next]) {
                if (distance[node.next] > distance[start.next] + node.dis) {
                    distance[node.next] = distance[start.next] + node.dis;

                    if (maxDistance == distance[node.next]) {
                        count++;
                    }

                    if (maxDistance < distance[node.next]) {
                        maxDistance = distance[node.next];
                        count = 1;
                    }

                    pq.add(new Node(node.next, distance[node.next]));
                }
            }
        }

        return count;
    }
}
