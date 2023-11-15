package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 숨바꼭질 3 - 다익스트라 알고리즘
public class BaekJoon13549 {
    class Point {
        int nextPoint;
        int second;
        public Point(int nextPoint, int second) {
            this.nextPoint = nextPoint;
            this.second = second;
        }
    }
    ArrayList<Point>[] graph; // 경로 저장 리스트
    boolean[] visited; // 방문한 위치 저장
    int[] seconds; // 해당 위치까지 걸린 최단시간 저장
    int MAX_SIZE = 100000;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 시작지점
        int k = Integer.parseInt(st.nextToken()); // 목표지점

        graph = new ArrayList[MAX_SIZE + 1];
        visited = new boolean[MAX_SIZE + 1];
        seconds = new int[MAX_SIZE + 1];

        for (int i = 0; i <= MAX_SIZE; i++) {
            graph[i] = new ArrayList<>();
            if (i == 0) {
                graph[i].add(new Point(i + 1, 1));
                graph[i].add(new Point(0, 0));
            } else if (i == MAX_SIZE) {
                graph[i].add(new Point(i - 1, 1));
            } else if (i <= MAX_SIZE / 2) {
                graph[i].add(new Point(i - 1, 1));
                graph[i].add(new Point(i + 1, 1));
                graph[i].add(new Point(2 * i, 0));
            } else {
                graph[i].add(new Point(i - 1, 1));
                graph[i].add(new Point(i + 1, 1));
            }

            seconds[i] = Integer.MAX_VALUE;
        }

        dijkstra(n, k);

        System.out.println(seconds[k]);
    }

    public void dijkstra(int start, int end) {
        PriorityQueue<Point> pq = new PriorityQueue<>((Comparator.comparingInt(o -> o.second)));
        pq.add(new Point(start, 0));
        visited[start] = true;
        seconds[start] = 0;

        while (!pq.isEmpty()) {
            Point nowPoint = pq.poll(); // 현재 저장된 Point 중 시간 제일 덜 걸리는거 가져오기
            if (nowPoint.nextPoint == end) break; // 다음 지점이 도착 지점이면 종료

            if (!visited[nowPoint.nextPoint]) visited[nowPoint.nextPoint] = true; // 다음 위치 방문한적 없으면 방문처리
            for (Point nextPoint: graph[nowPoint.nextPoint]) { // 다음 위치 데이터 가져옴
                if (seconds[nextPoint.nextPoint] > seconds[nowPoint.nextPoint] + nextPoint.second) {
                    seconds[nextPoint.nextPoint] = seconds[nowPoint.nextPoint] + nextPoint.second; // 다다음 최단시간 저장
                    pq.add(new Point(nextPoint.nextPoint, seconds[nextPoint.nextPoint])); // 우선순위 큐에 다다음 위치 저장
                }
            }
        }
    }
}