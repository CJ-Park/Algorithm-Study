package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 단지 번호 붙이기 - 그래프 문제 (bfs 사용했음)
public class BaekJoon2667 {
    int n;
    int[][] map;
    boolean[][] visited;
    ArrayList<Integer> house = new ArrayList<>();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());

        // 맵과 방문여부 초기화
        map = new int[n + 2][n + 2];
        visited = new boolean[n + 2][n + 2];

        // 맵 정보 저장
        for (int i = 1; i <= n; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < s.length; j++) {
                map[i][j + 1] = Integer.parseInt(s[j]);
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!visited[i][j] || map[i][j] == 1) searchMap(i, j);
            }
        }

        Collections.sort(house, Comparator.naturalOrder());
        sb.append(house.size()).append("\n");
        for (int val : house) {
            sb.append(val).append("\n");
        }

        System.out.print(sb);
    }

    // bfs 방식 사용
    public void searchMap(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        int count = 0;

        while (!q.isEmpty()) {
            Point p = q.poll();
            if (p.x < 1 || p.y < 1 || p.x > n || p.y > n) continue; // 범위 넘었다면 스킵
            if (visited[p.x][p.y]) continue; // 방문했다면 스킵
            if (map[p.x][p.y] == 0) continue; // 위치에 집이 없다면 스킵

            // ========= 여기부턴 집이 있으며 방문 안했고 범위에 해당해야 작동 =========
            visited[p.x][p.y] = true; // 방문처리
            count++; // poll 지점 위치 개수 추가
            // 상하좌우 큐에 추가
            q.add(new Point(p.x + 1, p.y));
            q.add(new Point(p.x - 1, p.y));
            q.add(new Point(p.x, p.y + 1));
            q.add(new Point(p.x, p.y - 1));
        }

        // 탐색이 끝났고 count != 0 이라면 추가
        if (count != 0) house.add(count);
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
