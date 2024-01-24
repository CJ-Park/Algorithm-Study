package class4.restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 트리의 지름 - 그래프 탐색, dfs
// n 이 10^5 였는데 n^2 시간복잡도로 진행해서 시간초과 발생
// 트리의 특성 생각하기 (두 정점 간 경로는 단 하나)
public class BaekJoon1167 {
    int n, startNodeForResult;
    long maxResult;
    ArrayList<Edge>[] tree;
    boolean[] visited;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int idx = Integer.parseInt(s[0]);

            for (int j = 1; j < s.length; j++) {
                if (s[j].equals("-1")) {
                    break;
                }

                if (j % 2 == 1) {
                    tree[idx].add(new Edge(Integer.parseInt(s[j]), Integer.parseInt(s[j + 1])));
                }
            }
        }

        // node 의 최대 개수가 10^5 이므로 n^2 시간복잡도면 시간초과 발생
        // 트리에서 최장 정점을 찾으면 한 점은 무조건 트리 지름의 끝임 (두 노드 사이의 경로는 유일하기 때문)
        // 임의의 노드부터 제일 멀리 떨어진 노드를 찾고 ---- 1번
        // 해당 노드부터 제일 멀리 떨어진 노드를 찾으면 트리의 지름을 찾을 수 있음 ---- 2번

        // 1
        visited = new boolean[n + 1];
        findMaxDistance(1, 0);

        // 2
        visited = new boolean[n + 1];
        maxResult = 0;
        findMaxDistance(startNodeForResult, 0);

        System.out.println(maxResult);
    }

    public void findMaxDistance(int start, long dis) {
        visited[start] = true;
        if (maxResult < dis) {
            maxResult = dis;
            startNodeForResult = start;
        }

        for (Edge edge : tree[start]) {
            if (visited[edge.nextNode]) {
                continue;
            }
            findMaxDistance(edge.nextNode, dis + edge.value);
        }
    }

    public static class Edge {
        int nextNode;
        int value;

        public Edge(int next, int val) {
            this.nextNode = next;
            this.value = val;
        }
    }
}
