package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 토마토 - bfs 문제
public class BaekJoon7576 {
    int n, m, day;
    int[][] tomato;
    boolean[][] visited;
    Queue<Point> queue = new LinkedList<>();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        tomato = new int[m + 2][n + 2];
        visited = new boolean[m + 2][n + 2];
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int value = Integer.parseInt(st.nextToken());
                tomato[i][j] = value;
                if (value == 1) {
                    queue.add(new Point(i, j, 0)); // 0일차
                }
            }
        }

        bfs();
        if (checkTomato()) {
            System.out.println(-1);
        } else {
            System.out.println(day);
        }
    }

    // 탐색 시작
    public void bfs() {
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            if (point.x < 1 || point.y < 1 || point.x > m || point.y > n) continue;
            if (visited[point.x][point.y]) continue;
            if (tomato[point.x][point.y] == -1) continue;
            day = Math.max(point.days, day);
            visited[point.x][point.y] = true;
            tomato[point.x][point.y] = 1;

            queue.add(new Point(point.x + 1, point.y, point.days + 1));
            queue.add(new Point(point.x - 1, point.y, point.days + 1));
            queue.add(new Point(point.x, point.y + 1, point.days + 1));
            queue.add(new Point(point.x, point.y - 1, point.days + 1));
        }
    }

    // 토마토에 0이 없을 경우 false 반환
    // 토마토에 0이 하나라도 있다면 true 반환
    public boolean checkTomato() {
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (tomato[i][j] == 0) return true;
            }
        }
        return false;
    }

    public class Point {
        int x;
        int y;
        int days;

        public Point(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.days = day;
        }
    }
}
