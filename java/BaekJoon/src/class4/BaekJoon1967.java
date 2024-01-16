package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 트리의 지름 - dfs, 브루트포스
public class BaekJoon1967 {
    int n, maxResult;
    ArrayList<Node>[] graph;
    boolean[] visitedNode;

    // 트리에서 두 노드를 골라서 사이 거리의 가중치가 최대인 경우 찾기 => 브루트포스
    // 노드가 12개면 1,2 부터 11,12 까지 간선 가중치 비교
    // 노드는 최대 1만개
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n + 1];

        // graph 초기화
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            graph[parent].add(new Node(child, value));
            graph[child].add(new Node(parent, value));
        }

        for (int i = 1; i < n; i++) {
            visitedNode = new boolean[n + 1];
            findMaxResult(i, 0);
        }

        System.out.print(maxResult);
    }

    public void findMaxResult(int startNode, int value) {
        visitedNode[startNode] = true;
        maxResult = Math.max(maxResult, value);

        for (Node next : graph[startNode]) {
            if (visitedNode[next.num]) {
                continue;
            }
            findMaxResult(next.num, value + next.val);
        }
    }

    private static class Node {
        int num;
        int val;

        public Node(int num, int val) {
            this.num = num;
            this.val = val;
        }
    }
}
