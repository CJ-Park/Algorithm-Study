package Graph.level2;

import java.util.PriorityQueue;

// bfs + PriorityQueue 로 해결
public class 게임맵최단거리 {
    static class Point implements Comparable<Point> {
        int x;
        int y;
        int count;

        public Point(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.count = c;
        }

        public int compareTo(Point p) {
            return this.count - p.count;
        }
    }

    static boolean[][] visited;

    public int solution(int[][] maps) {
        int x = maps.length;
        int y = maps[0].length;
        int result = 0;

        visited = new boolean[x][y];

        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(0, 0, 1));

        while (!pq.isEmpty()) {
            Point p = pq.poll();

            if (p.x == x - 1 && p.y == y - 1) {
                result = p.count;
                break;
            }

            if (p.x < 0 || p.y < 0 || p.x >= x || p.y >= y) {
                continue;
            }

            if (maps[p.x][p.y] == 0) {
                continue;
            }

            if (visited[p.x][p.y]) {
                continue;
            }

            visited[p.x][p.y] = true;
            pq.add(new Point(p.x + 1, p.y, p.count + 1));
            pq.add(new Point(p.x - 1, p.y, p.count + 1));
            pq.add(new Point(p.x, p.y + 1, p.count + 1));
            pq.add(new Point(p.x, p.y - 1, p.count + 1));
        }

        return result == 0 ? -1 : result;
    }
}
