package BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
촌수 계산 - 실버2
 */
public class BaekJoon2644 {
    ArrayList<Integer>[] graph;
    boolean[] visited;
    int result;

    public void solution() throws IOException {
        int n, start, end, m;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            graph[parent].add(child);
            graph[child].add(parent);
        }

        if (dfs(start, end, 0)) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }

    // 7 3 0 => 2 3 1 => 1 3 2 => 3 3 3
    private boolean dfs(int start, int end, int count) {
        if (start == end) {
            result = count;
            return true;
        }

        if (visited[start]) {
            return false;
        }

        visited[start] = true;
        for (int node : graph[start]) {
            if (dfs(node, end, count + 1)) {
                return true;
            }
        }
        return false;
    }
}
