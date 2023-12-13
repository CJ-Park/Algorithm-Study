package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 토마토 - bfs / 3차원 배열
public class BaekJoon7569 {
    int m, n, h, days;
    int[][][] box;
    boolean[][][] visited;
    Queue<Point> q = new LinkedList<>();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // m, n, h 모두 100 이하이므로 3중 for 문 문제 없음
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        box = new int[h][n][m];
        visited = new boolean[h][n][m];

        // 토마토 정보 저장
        for (int i = 0; i < h; i++) { // 층수
            for (int j = 0; j < n; j++) { // 세로
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) { // 가로
                    int value = Integer.parseInt(st.nextToken());
                    box[i][j][k] = value;
                    if (value == 1) {
                        q.add(new Point(k, j, i, 0));
                    }
                }
            }
        }

        // bfs 이전에 박스 점검 => 모든 토마토가 익었다면 0 출력하고 끝
        if (checkBox()) {
            System.out.println(0);
            return;
        }
        bfs();
        if (!checkBox()) { // 안익은 토마토 존재
            System.out.println(-1);
        } else {
            System.out.println(days);
        }
    }

    public void bfs() {
        while (!q.isEmpty()) {
            Point p = q.poll();
            if (p.x < 0 || p.y < 0 || p.height < 0 || p.x >= m || p.y >= n || p.height >= h) continue;
            if (visited[p.height][p.y][p.x]) continue;
            if (box[p.height][p.y][p.x] == -1) continue;
            days = Math.max(days, p.day);
            visited[p.height][p.y][p.x] = true;
            box[p.height][p.y][p.x] = 1;

            q.add(new Point(p.x + 1, p.y, p.height, p.day + 1));
            q.add(new Point(p.x - 1, p.y, p.height, p.day + 1));
            q.add(new Point(p.x, p.y + 1, p.height, p.day + 1));
            q.add(new Point(p.x, p.y - 1, p.height, p.day + 1));
            q.add(new Point(p.x, p.y, p.height + 1, p.day + 1));
            q.add(new Point(p.x, p.y, p.height - 1, p.day + 1));
        }
    }

    public boolean checkBox() {
        for (int i = 0; i < h; i++) { // 층수
            for (int j = 0; j < n; j++) { // 세로
                for (int k = 0; k < m; k++) { // 가로
                    if (box[i][j][k] == 0) return false;
                }
            }
        }
        return true;
    }

    public class Point {
        int x;
        int y;
        int height;
        int day;

        public Point(int x, int y, int height, int day) {
            this.x = x;
            this.y = y;
            this.height = height;
            this.day = day;
        }
    }
}
