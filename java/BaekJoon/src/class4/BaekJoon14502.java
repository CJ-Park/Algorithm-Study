package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 연구소 - 그래프 탐색 / 브루트포스 / dfs + bfs
// dfs 와 bfs 를 함께 사용하는 문제였음
public class BaekJoon14502 {
    int n, m, maxArea;
    int[][] map;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n + 2][m + 2];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        makeWall(0);

        System.out.print(maxArea);
    }

    public void makeWall(int count) { // dfs
        if (count == 3) {
            propagation();
            return;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    makeWall(count + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    public void propagation() { // bfs
        int[][] pollutionMap = new int[n + 2][m + 2];
        Queue<Point> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                pollutionMap[i][j] = map[i][j];
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (pollutionMap[i][j] == 2)
                    q.add(new Point(i, j));
            }
        }

        while(!q.isEmpty()) {
            Point virus = q.poll();

            if (virus.x == 0 || virus.y == 0 || virus.x == n + 1 || virus.y == m + 1)
                continue;

            if (pollutionMap[virus.x + 1][virus.y] == 0) {
                pollutionMap[virus.x + 1][virus.y] = 2;
                q.add(new Point(virus.x + 1, virus.y));
            }
            if (pollutionMap[virus.x - 1][virus.y] == 0) {
                pollutionMap[virus.x - 1][virus.y] = 2;
                q.add(new Point(virus.x - 1, virus.y));
            }
            if (pollutionMap[virus.x][virus.y - 1] == 0) {
                pollutionMap[virus.x][virus.y - 1] = 2;
                q.add(new Point(virus.x, virus.y - 1));
            }
            if (pollutionMap[virus.x][virus.y + 1] == 0) {
                pollutionMap[virus.x][virus.y + 1] = 2;
                q.add(new Point(virus.x, virus.y + 1));
            }

        }
        searchMap(pollutionMap);
    }

    // 바이러스 전파 끝난 맵 탐색
    public void searchMap(int[][] myMap) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (myMap[i][j] == 0)
                    count++;
            }
        }

        maxArea = Math.max(maxArea, count);
    }

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
