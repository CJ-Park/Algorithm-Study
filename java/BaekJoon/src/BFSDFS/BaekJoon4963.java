package BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
섬의 개수
bfs 로 풀었음 근데 dfs 가 더 편할듯
 */
public class BaekJoon4963 {
    int w, h, count;
    int[][] map;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    public void solution() throws IOException {
        while (!input()) {
            map = new int[h + 2][w + 2];
            count = 0;

            for (int i = 1; i <= h; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 1; j <= w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 1; i <= h; i++) {
                for (int j = 1; j <= w; j++) {
                    if (map[i][j] == 1) {
                        bfs(i, j);
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
    private void bfs(int x, int y) {
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(x, y));

        while (!q.isEmpty()) {
            Point p = q.poll();

            if (p.x < 1 || p.y < 1 || p.x > h || p.y > w || map[p.x][p.y] == 0) {
                continue;
            }

            map[p.x][p.y] = 0;

            q.add(new Point(p.x + 1, p.y));
            q.add(new Point(p.x + 1, p.y + 1));
            q.add(new Point(p.x + 1, p.y - 1));
            q.add(new Point(p.x - 1, p.y));
            q.add(new Point(p.x - 1, p.y + 1));
            q.add(new Point(p.x - 1, p.y - 1));
            q.add(new Point(p.x, p.y + 1));
            q.add(new Point(p.x, p.y - 1));
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private boolean input() throws IOException {
        st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        return w == 0 && h == 0;
    }
}
