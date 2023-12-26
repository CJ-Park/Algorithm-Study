package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

// 적녹색약 - 그래프 탐색 (bfs 사용)
public class BaekJoon10026 {
    int n, count;
    String[][] colors;
    boolean[][] visited;
    StringBuilder sb = new StringBuilder();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        colors = new String[n + 2][n + 2];
        visited = new boolean[n + 2][n + 2];

        for (int i = 1; i <= n; i++) {
            String[] lines = br.readLine().split("");
            for (int j = 1; j <= n; j++) {
                colors[i][j] = lines[j - 1];
            }
        }

        // 적녹색약 아닌 사람 기준 탐색
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (visited[i][j]) continue;
                searchArea(i, j, colors[i][j]);
            }
        }

        sb.append(count).append(" ");

        // 적녹색약 기준 탐색을 위한 초기화
        visited = new boolean[n + 2][n + 2];
        count = 0;

        // 적녹색약 기준 탐색
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (visited[i][j]) continue;
                searchArea(i, j, colors[i][j]);
            }
        }
        sb.append(count);

        System.out.print(sb);
    }

    public void searchArea(int x, int y, String value) {
        Queue<Point> q = new LinkedList<>();

        q.add(new Point(x, y));

        while (!q.isEmpty()) {
            Point poll = q.poll();

            if (poll.x < 1 || poll.x > n || poll.y < 1 || poll.y > n) continue; // 범위 이탈
            if (visited[poll.x][poll.y]) continue; // 이미 방문
            if (!Objects.equals(colors[poll.x][poll.y], value)) continue; // 해당 좌표 value 값이 다름

            visited[poll.x][poll.y] = true;

            // 다음 탐색은 적녹색약 기준이므로 colors 배열 수정
            if (Objects.equals(colors[poll.x][poll.y], "G")) colors[poll.x][poll.y] = "R";

            // 이후 네 방향 다시 queue 에 넣기
            q.add(new Point(poll.x + 1, poll.y));
            q.add(new Point(poll.x - 1, poll.y));
            q.add(new Point(poll.x, poll.y + 1));
            q.add(new Point(poll.x, poll.y - 1));
        }

        count++;
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
