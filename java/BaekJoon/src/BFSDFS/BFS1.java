package BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 미로의 최단 경로 검색
public class BFS1 {
    int N, M;
    int[][] maze;
    Queue<Point> q;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        q = new LinkedList<>();
        maze = new int[N + 2][M + 2];

        // 모든 요소 1로 초기화
        for (int i = 0; i < N + 2; i++) {
            for (int j = 0; j < M + 2; j++) {
                maze[i][j] = 0;
            }
        }

        // 미로 배열에 값 넣기
        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 1; j <= M; j++) {
                maze[i][j] = s.charAt(j - 1) - '0';
            }
        }

        int result = findRoot(1, 1);
        System.out.println(result);
    }

    // 큐에 다음 좌표 저장 후 빼내면서 재검사
    public int findRoot(int x, int y) {
        q.offer(new Point(x, y));
        // 큐에 지점을 저장하면서 네 방향 검사 진행
        while (!q.isEmpty()) {
            Point p = q.poll();
            x = p.x;
            y = p.y;
            checkNext(x, y);
        }
        return maze[N][M];
    }

    // 4 방향 검사
    public void checkNext(int x, int y) {
        if (maze[x + 1][y] == 1) {
            maze[x + 1][y] = maze[x][y] + 1;
            q.offer(new Point(x + 1, y));
        }
        if (maze[x][y + 1] == 1) {
            maze[x][y + 1] = maze[x][y] + 1;
            q.offer(new Point(x, y + 1));
        }
        if (maze[x - 1][y] == 1) {
            maze[x - 1][y] = maze[x][y] + 1;
            q.offer(new Point(x - 1, y));
        }
        if (maze[x][y - 1] == 1) {
            maze[x][y - 1] = maze[x][y] + 1;
            q.offer(new Point(x, y - 1));
        }
    }

    public class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
