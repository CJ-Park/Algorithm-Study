package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon14940 {
    int n, m;
    int[][] map;
    boolean[][] visited;
    Point start;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n + 2][m + 2];
        visited = new boolean[n + 2][m + 2];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                int v = Integer.parseInt(st.nextToken());
                if (v == 2) start = new Point(i, j, 0);
                map[i][j] = v;
            }
        }

        searchMap(start);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (!visited[i][j] && map[i][j] == 1) map[i][j] = -1;
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public void searchMap(Point start) {
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            Point now = q.poll();

            if (now.x == 0 || now.y == 0 || now.x == n + 1 || now.y == m + 1) continue;
            if (visited[now.x][now.y] || map[now.x][now.y] == 0) continue;

            if (map[now.x][now.y] == 2 && !visited[now.x][now.y]) { // 시작좌표면 0 넣기
                visited[now.x][now.y] = true;
                map[now.x][now.y] = now.value;
            } else if (map[now.x][now.y] == 1) { // 좌표에 값이 1이면 이전 좌표값 + 1 저장
                visited[now.x][now.y] = true;
                map[now.x][now.y] = now.value;
            }
            q.add(new Point(now.x + 1, now.y, now.value + 1));
            q.add(new Point(now.x - 1, now.y, now.value + 1));
            q.add(new Point(now.x, now.y + 1, now.value + 1));
            q.add(new Point(now.x, now.y - 1, now.value + 1));
        }
    }

    public class Point {
        int x;
        int y;
        int value;

        public Point(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
}
