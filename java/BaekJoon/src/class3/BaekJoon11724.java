package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 연결 요소의 개수 - 그래프 문제 (양방향으로 저장해야됨!)
public class BaekJoon11724 {
    int n, m, count;
    boolean[] visited;
    Map<Integer, ArrayList<Integer>> graph = new HashMap<>();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];

        // 그래프 완성
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            if (!graph.containsKey(now)) { // now 노드에 이어진 정보 없음
                graph.put(now, new ArrayList<>());
            }
            if (!graph.containsKey(next)) { // 양방향이므로 반대 경우도 저장해야 됨
                graph.put(next, new ArrayList<>());
            }
            graph.get(now).add(next);
            graph.get(next).add(now);
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                searchGraph(i);
                count++;
            }
        }

        System.out.println(count);
    }

    public void searchGraph(int start) {
        if (visited[start]) return; // 이미 탐색했으면 리턴
        if (!graph.containsKey(start)) return; // 그래프에 이어진 정보 없으면 리턴
        visited[start] = true;
        for (int next : graph.get(start)) { // 재귀로 이어진 노드 탐색
            searchGraph(next);
        }
    }
}
