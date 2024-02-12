package class5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// 최소 스패닝 트리 - MST 문제 (최소 신장 트리)
// 유니온-파인드 알고리즘과 함께 사용
public class BaekJoon1197 {
    int n, e, res;
    List<Edge> edges = new ArrayList<>();
    int[] parent;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.add(new Edge(start, end, cost));
        }

        Collections.sort(edges);

        MST();
        System.out.print(res);
    }

    // 정점개수 - 1 만큼 간선이 생겼을 때 메서드 종료
    public void MST() {
        int count = 0;

        for (Edge e : edges) {
            if (count == n - 1)
                break;

            // 싸이클 발생하면 해당 간선은 스킵
            if (find(e.start) == find(e.end)) {
                continue;
            }

            union(e.start, e.end);
            res += e.cost;
            count++;
        }
    }

    public void union(int n1, int n2) {
        int i = find(n1);
        int j = find(n2);

        if (i < j) {
            parent[j] = i;
        } else {
            parent[i] = j;
        }
    }

    public int find(int node) {
        if (parent[node] == node) {
            return node;
        }
        return find(parent[node]);
    }

    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int cost;

        public Edge(int s, int e, int c) {
            this.start = s;
            this.end = e;
            this.cost = c;
        }

        @Override
        public int compareTo(Edge e) {
            return this.cost - e.cost;
        }
    }
}
