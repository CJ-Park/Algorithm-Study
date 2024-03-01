package DP.restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 내리막길 - dp + 그래프 탐색
public class BaekJoon1520 {
    int n, m;
    int[][] map, dp;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n + 2][m + 2];
        dp = new int[n + 2][m + 2];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // map 의 모든 내부 탐색하며 dp 채우기
        // 도달 가능한 위치면 dp[i][j] += 1;
        // bfs 돌리면서 도달 가능하면 위의 조건 추가 후 큐에 넣기
        bfs(1,1);

        int res = dp[n][m];
        System.out.print(res);
    }

    public void bfs(int x, int y) {
        PriorityQueue<Point> q = new PriorityQueue<>();
        q.add(new Point(x, y, map[x][y]));
        dp[1][1] = 1;

        while (!q.isEmpty()) {
            Point now = q.poll();

            if (now.h > map[now.x + 1][now.y] && now.x + 1 <= n) { // 우측 진행
                if (dp[now.x + 1][now.y] == 0) { // 다음 좌표 큐에 담은적이 없음
                    q.add(new Point(now.x + 1, now.y, map[now.x + 1][now.y]));
                    dp[now.x + 1][now.y] += dp[now.x][now.y];
                } else { // 다음 좌표 큐에 이미 담김 => dp 값 갱신만 진행
                    dp[now.x + 1][now.y] += dp[now.x][now.y];
                }
            }

            if (now.h > map[now.x - 1][now.y] && now.x - 1 > 0) { // 좌측 진행
                if (dp[now.x - 1][now.y] == 0) {
                    q.add(new Point(now.x - 1, now.y, map[now.x - 1][now.y]));
                    dp[now.x - 1][now.y] += dp[now.x][now.y];
                } else {
                    dp[now.x - 1][now.y] += dp[now.x][now.y];
                }
            }

            if (now.h > map[now.x][now.y - 1] && now.y - 1 > 0) { // 상측 진행
                if (dp[now.x][now.y - 1] == 0) {
                    q.add(new Point(now.x, now.y - 1, map[now.x][now.y - 1]));
                    dp[now.x][now.y - 1] += dp[now.x][now.y];
                } else {
                    dp[now.x][now.y - 1] += dp[now.x][now.y];
                }
            }

            if (now.h > map[now.x][now.y + 1] && now.y + 1 <= m) { // 하측 진행
                if (dp[now.x][now.y + 1] == 0) {
                    q.add(new Point(now.x, now.y + 1, map[now.x][now.y + 1]));
                    dp[now.x][now.y + 1] += dp[now.x][now.y];
                } else {
                    dp[now.x][now.y + 1] += dp[now.x][now.y];
                }
            }
        }
    }

    static class Point implements Comparable<Point> {
        int x;
        int y;
        int h;

        public Point(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }

        public int compareTo(Point point) { // 내림차순 정렬
            return point.h - this.h;
        }
    }
}
