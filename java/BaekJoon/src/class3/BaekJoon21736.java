package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

// 헌내기는 친구가 필요해 - 그래프 탐색 문제
public class BaekJoon21736 {
    String[][] map;
    boolean[][] visited;
    int n, m, res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new String[n][m];
        visited = new boolean[n][m];

        int targetX = 0;
        int targetY = 0;

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = s[j];
                if (Objects.equals(s[j], "I")) {
                    targetX = i;
                    targetY = j;
                }
            }
        }

        bfs(targetX, targetY);
        if (res == 0) System.out.println("TT");
        else System.out.println(res);
    }

    public void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));

        while (!q.isEmpty()) {
            Point p = q.poll();
            if (p.x < 0 || p.y < 0 || p.x >= n || p.y >= m) continue; // 범위 벗어나면 스킵
            if (visited[p.x][p.y]) continue; // 방문했으면 스킵
            if (Objects.equals(map[p.x][p.y], "X")) continue; // 벽이면 스킵

            visited[p.x][p.y] = true; // 방문처리
            if (Objects.equals(map[p.x][p.y], "P")) res++;
            q.add(new Point(p.x + 1, p.y));
            q.add(new Point(p.x - 1, p.y));
            q.add(new Point(p.x, p.y + 1));
            q.add(new Point(p.x, p.y - 1));
        }
    }

    public class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
