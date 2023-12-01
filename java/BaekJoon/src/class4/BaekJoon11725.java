package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 트리의 부모 찾기
public class BaekJoon11725 {
    int n;
    int[] result;
    ArrayList<Node>[] graph;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n + 1];
        result = new int[n + 1]; // value 를 키값으로 부모노드 value 저장
        result[1] = 0; // 노드 1은 루트이므로 부모 없음

        // 그래프 초기화
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 노드 관련 정보들 저장
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            graph[v].add(new Node(v, n));
            graph[n].add(new Node(n, v));
        }

        searchGraph(1); // 루트 노드부터 탐색 시작

        for (int i = 2; i <= n; i++) {
            sb.append(result[i]).append("\n");
        }
        System.out.print(sb);
    }

    public void searchGraph(int root) {
        for (Node node : graph[root]) {
            if (result[node.next] != 0) continue; // result 에 값이 채워졌다면 넘김
            result[node.next] = root;
            searchGraph(node.next); // 재귀방식으로 다음 노드도 탐색
        }
    }

    public class Node {
        int value;
        int next;

        public Node(int v, int n) {
            value = v;
            next = n;
        }
    }
}
