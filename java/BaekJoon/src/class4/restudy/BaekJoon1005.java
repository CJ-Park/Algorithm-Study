package class4.restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// ACM Craft - 위상정렬, dp
// 각 노드까지의 건물 짓는데 걸리는 최대 시간을 갱신해야됨 (dp)
public class BaekJoon1005 {
    int T, n, k, target, result;
    ArrayList<Integer>[] graph;
    int[] connectCnt, maxBuild;
    Map<Integer, Integer> buildTime;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            result = 0;

            // 간선 연결 개수 정보
            connectCnt = new int[n + 1];

            // 그래프 초기화
            graph = new ArrayList[n + 1];
            for (int j = 1; j <= n; j++) {
                graph[j] = new ArrayList<>();
            }

            // 건설 시간 저장
            buildTime = new HashMap<>();

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                buildTime.put(j, Integer.parseInt(st.nextToken()));
            }

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                graph[start].add(end);
                connectCnt[end]++;
            }

            target = Integer.parseInt(br.readLine());

            // 해당 건물 짓는데 필요한 최대 시간
            maxBuild = new int[n + 1];

            // 어떤 건물을 지으려면 연결된 이전 건물들 먼저 다 지어져야 됨
            // connectCnt[i] = 0 일 때 i 인 요소부터 시작해서 target 까지 탐색
            searchRoot();

            sb.append(maxBuild[target]).append("\n");
        }

        System.out.print(sb);
    }

    public void searchRoot() {
        Queue<Integer> q = new LinkedList<>();

        // 시작점이 여러개일 수 있음 => 시작점에 해당되는 node 는 전부 queue 에 넣고 시작
        for (int i = 1; i <= n; i++) {
            if (connectCnt[i] == 0) {
                maxBuild[i] = buildTime.get(i);
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            Integer now = q.poll();

            for (int next : graph[now]) {
                // 건물 짓는데 걸리는 최대 시간 갱신
                maxBuild[next] = Math.max(maxBuild[next], maxBuild[now] + buildTime.get(next));
                connectCnt[next]--;

                // 카운트 0 일 때 queue 에 추가
                if (connectCnt[next] == 0) {
                    q.add(next);
                }
            }
        }
    }
}
