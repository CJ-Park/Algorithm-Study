package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 유기농 배추 - dfs / bfs
public class BaekJoon1012 {
    int T, n, m, count;
    boolean[][] map;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < T; i++) {
            count = 0;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            map = new boolean[n + 2][m + 2];
            int k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x + 1][y + 1] = true; // 배추 심어진곳 표시
            }
            checkNear();
            System.out.println(count);
        }
    }

    public void checkNear() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j]) {
                    count++;
                    dfs(i, j);
                }
            }
        }
    }

    public void dfs(int x, int y) { // 상하좌우 탐색하면서 true 있으면 false 로 수정
        if (x == 0 || y == 0 || x == n + 1 || y == m + 1) return; // 범위 벗어나면 return;
        if (map[x][y]) { // true 발견 -> 상하좌우 탐색
            map[x][y] = false;
            dfs(x + 1, y);
            dfs(x - 1, y);
            dfs(x, y + 1);
            dfs(x, y - 1);
        }

    }
}
