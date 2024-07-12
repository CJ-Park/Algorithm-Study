package restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// dp + dfs
// 그래프탐색과 dp 섞인 문제
// dp 부분 아이디어 떠올리지 못했음

// 아이디어
/*
말이 특정 노드부터 자식노드로만 최적의 경로를 찾아갈 경우 선공이 이길지 후공이 이길지 판단
1 - 2 - 4 => 1시작 선공 / 2시작 후공 / 4시작 선공
1 - 2 - 4 - 3 => 1시작 선공 / 2시작 선공 / 3시작 선공 / 4시작 선공
후공이 이기는 경우 = 뒤에서부터 볼 때 4 - 3 > 0 선공 승 / 2 - 4 < 0 후공 승 /
2 - (4 - 3) > 0 선공 승 / 1 - (2 - (4 - 3)) >= 0 선공 승
제일 마지막 노드의 dp 부터 올라오면서 탐색 => 재귀 사용
최적의 경로는 자식의 dp값 중 가장 작은 값을 가진 부분이 최적의 경로 => 그만큼 자식 노드들의 값이 크기 때문
 */
public class 트리위의_게임 {
    int INF = Integer.MAX_VALUE;

    // 정점 개수
    int N;

    // 해당 노드의 하위 트리 정보
    ArrayList<Integer>[] graph;

    int[] dp;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder result = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start].add(end);
            graph[end].add(start);
        }

        dfs(1, 0);

        for (int i = 1 ; i <= N; i++) {
            if (dp[i] >= 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    private void dfs(int start, int parent) {
        int res = INF;

        for (int child : graph[start]) {
            if (child == parent) {
                continue;
            }

            dfs(child, start);

            res = Math.min(res, dp[child]);
        }

        if (res == INF) { // 자식노드가 없는 경우 => dp값 자기 자신
            res = 0;
        }

        dp[start] = start - res;
    }
}
