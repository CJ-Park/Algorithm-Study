package class3.restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 뱀과 사다리 게임 - 다시 풀어보기
// 재귀 방식으로 못푸나..?
public class BaekJoon16928 {
    int n, m, result;
    Map<Integer, Integer> graph = new HashMap<>();
    boolean[] visited;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        result = Integer.MAX_VALUE;

        visited = new boolean[101];

        // 사다리, 뱀 값 넣기
        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.put(x, y);
        }

        startGame();

        System.out.println(result);
    }


    public void startGame() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        int cnt = 0;
        while (!q.isEmpty()) {
            cnt++;
            int size = q.size();
            for (int i = 0; i < size; i++) { // 현재 큐에 있는거 전부 계산
                Integer now = q.poll();

                for (int j = 1; j <= 6; j++) {
                    int next = now + j;
                    if (next > 100 || visited[next]) continue;

                    if (next == 100) {
                        result = cnt;
                        return;
                    }

                    visited[next] = true;

                    if (graph.containsKey(next)) {
                        visited[graph.get(next)] = true;
                        q.add(graph.get(next));
                    } else {
                        q.add(next);
                    }
                }
            }
        }
    }
}
