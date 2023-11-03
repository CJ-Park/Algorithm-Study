package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 장애물인식프로그램 {
    // m - 장애물 크기
    // res - 장애물 크기 저장하는 배열
    int n, m;
    int[][] map;
    List<Integer> res = new ArrayList<>();
    Queue<Point> q = new LinkedList<>();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n + 2][n + 2];

        // 맵 저장
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 1; j <= n; j++) {
                map[i][j] = s.charAt(j - 1) - '0';
            }
        }

        // bfs 사용해서 1,1 부터 탐색
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int result = bfs(i, j);
                res.add(result);
            }
        }
        res.sort(Comparator.naturalOrder());

        System.out.println(res.size());
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }

    public int bfs(int x, int y) {
        q.offer(new Point(x, y));
        while (!q.isEmpty()) {
            Point p = q.poll();
            x = p.x;
            y = p.y;
            goNext(x, y);
        }
        return map[x][y];
    }

    public void goNext(int x, int y) {
        if (map[x][y + 1] == 1) {
            q.offer(new Point(x, y + 1));
            map[x][y + 1] = map[x][y] + 1;
        }
        if (map[x + 1][y] == 1) {
            q.offer(new Point(x + 1, y));
            map[x + 1][y] = map[x][y] + 1;
        }
        if (map[x][y - 1] == 1) {
            q.offer(new Point(x, y - 1));
            map[x][y - 1] = map[x][y] + 1;
        }
        if (map[x - 1][y] == 1) {
            q.offer(new Point(x - 1, y));
            map[x - 1][y] = map[x][y] + 1;
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
