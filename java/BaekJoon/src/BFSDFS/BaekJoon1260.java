package BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon1260 {
    int N, M, V;
    ArrayList<ArrayList<Integer>> graph;
    boolean[] isVisited;
    StringBuilder sb;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        graph = new ArrayList<>();
        graph.add(new ArrayList<>());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        isVisited = new boolean[N + 1];

        // 그래프 생성
        // 그래프는 정점의 개수만큼 있음
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>()); // 정점 수만큼 초기화
        }

        // 그래프의 노드 값 추가
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // 그래프 내부 리스트 정렬 진행
        for (int i = 0; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        // V부터 방문한 점을 출력 - DFS
        dfs(V);
        sb.deleteCharAt(sb.length() - 1).append("\n");
        isVisited = new boolean[N + 1];
        // V부터 방문한 점을 출력 - BFS
        bfs(V);
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }
    // 재귀함수로 구현 - 종료 조건 필요
    public void dfs(int V) {
        isVisited[V] = true;
        sb.append(V).append(" ");
        // 현재 노드와 연결된 노드를 재귀적으로 방문
        // 만약 방문한 적 있는 값이면 패스 없다면 dfs 재귀
        for (int i : graph.get(V)) {
            if(!isVisited[i]) dfs(i);
        }
    }

    // 큐 알고리즘 사용
    // 그래프 V 노드 탐색 시작
    public void bfs(int V) {
        Queue<Integer> q = new LinkedList<>();
        // q 에 방문 노드 기록
        q.offer(V);

        // q 가 빌때까지 반복
        while (!q.isEmpty()) {
            V = q.poll();
            isVisited[V] = true;
            sb.append(V).append(" ");
            for (int i : graph.get(V)) {
                if (!isVisited[i]) {
                    q.offer(i);
                    isVisited[i] = true;
                }
            }
        }
    }
}
