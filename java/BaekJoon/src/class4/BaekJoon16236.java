package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 아기상어 - 그래프 탐색 / bfs
// 우선순위 큐 사용해서 탐색 조건 만족시킴
public class BaekJoon16236 {
    int n, sharkSize, step, eatCount;
    int[][] map;
    int[] fishCount; // 물고기 사이즈는 6까지 존재

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        map = new int[n + 2][n + 2];
        fishCount = new int[7];
        Point start = new Point();

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= n; j++) {
                int size = Integer.parseInt(st.nextToken());
                if (size < 7 && size > 0) {
                    fishCount[size]++;
                }
                map[i][j] = size;

                if (size == 9) {
                    start = new Point(i, j, 0);
                    map[i][j] = 0;
                }
            }
        }

        sharkSize = 2;
        sharkStart(start);

        System.out.println(step);
    }

    // 먹을 수 있는 물고기가 있으면 bfs 탐색 진행
    public void sharkStart(Point start) {
        boolean canEat = false;

        if (start.x == -1 && start.y == -1) {
            return;
        }

        if (sharkSize == eatCount) {
            eatCount = 0;
            sharkSize++;
        }

        if (sharkSize <= 7) {
            for (int i = 1; i < sharkSize; i++) {
                if (fishCount[i] > 0) {
                    canEat = true;
                    break;
                }
            }
        } else {
            for (int i = 1; i < 7; i++) {
                if (fishCount[i] > 0) {
                    canEat = true;
                    break;
                }
            }
        }

        if (canEat) {
            Point next = bfs(start);
            eatCount++;
            sharkStart(next);
        }

        step = Math.max(step, start.count);
    }


    // 갈 수 없는 경우
    // 상어 크기보다 클 경우 / 범위 벗어났을 경우 / 이미 지나온 길일 경우
    public Point bfs(Point p) {
        PriorityQueue<Point> q = new PriorityQueue<>();
        q.add(p);

        boolean[][] visited = new boolean[n + 2][n + 2];

        Point next = new Point(-1, -1, 0);

        while (!q.isEmpty()) {
            Point poll = q.poll();

            if (visited[poll.x][poll.y] || poll.x < 1 || poll.x > n || poll.y < 1 || poll.y > n) {
                continue;
            }

            if (map[poll.x][poll.y] > sharkSize) {
                continue;
            }

            visited[poll.x][poll.y] = true;

            if (map[poll.x][poll.y] < sharkSize && map[poll.x][poll.y] != 0) {
                next = new Point(poll.x, poll.y, poll.count);
                fishCount[map[poll.x][poll.y]]--;
                map[poll.x][poll.y] = 0;
                break;
            }

            q.add(new Point(poll.x - 1, poll.y, poll.count + 1));
            q.add(new Point(poll.x, poll.y - 1, poll.count + 1));
            q.add(new Point(poll.x, poll.y + 1, poll.count + 1));
            q.add(new Point(poll.x + 1, poll.y, poll.count + 1));
        }

        return next;
    }

    static class Point implements Comparable<Point> {
        int x;
        int y;
        int count;

        public Point(){}

        public Point(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.count = c;
        }

        // 거리가 같으면 가장 위에 있는 물고기 먹음
        // 그조차 같으면 가장 왼쪽 물고기 먹음
        @Override
        public int compareTo(Point o) {
            if (this.count == o.count) {
                if (this.x == o.x) {
                    return this.y - o.y;
                }
                return this.x - o.x;
            }
            return this.count - o.count;
        }
    }
}
