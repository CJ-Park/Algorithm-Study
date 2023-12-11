package class3.restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 케빈 베이컨의 6단계 법칙 - dfs / bfs / 다익스트라 / 플로이드-워셜 전부 가능
// dfs 로 풀었음
public class BaekJoon1389 {
    int n, m, res;
    boolean[] visited;
    int[] result;
    ArrayList<Integer>[] graph;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1]; // 사람의 개수만큼 간선들의 정보 그래프가 생성됨
        visited = new boolean[n + 1];
        result = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int perA = Integer.parseInt(st.nextToken());
            int perB = Integer.parseInt(st.nextToken());

            graph[perA].add(perB);
            graph[perB].add(perA);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                res = 0;
                Arrays.fill(visited, false);
                dfs(i, j, 0);
                result[i] += res;
            }
        }

        int minIdx = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            if (result[i] < min) {
                minIdx = i;
                min = result[i];
            }
        }

        System.out.println(minIdx);
    }

    public void dfs(int start, int end, int value) {
        visited[start] = true;
        for (int next : graph[start]) {
            if (visited[next]) continue; // 이미 방문했던 idx -> 스킵
            if (next == end) {
                res = value + 1;
                return;
            }
            dfs(next, end, value + 1); // next 지점을 시작으로 가중치 1 추가해서 재귀
        }
    }
}
