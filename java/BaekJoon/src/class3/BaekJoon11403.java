package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 경로 찾기 - 그래프 탐색 / 플로이드 워셜 알고리즘
// dfs 로 해결했음
public class BaekJoon11403 {
    int n;
    boolean[][] list;
    int[][] result;
    boolean[] visited;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        // 결과값 배열 저장 공간
        result = new int[n][n];

        // list 초기화
        list = new boolean[n + 1][n + 1];

        // list 에 정보 저장
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) list[i][j] = true;
            }
        }

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            dfs(i, i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    // 이미 방문했던 idx 면 리턴
    public void dfs(int originIdx, int nextIdx) {
        // 방문했었다면 리턴
        if (visited[nextIdx]) { // originIdx 와 같은 곳으로 돌아왔을 경우 결과값에 1 넣어주고 리턴
            if (originIdx == nextIdx) result[originIdx - 1][nextIdx - 1] = 1;
            return;
        }

        // 방문처리
        visited[nextIdx] = true;
        if (originIdx != nextIdx) result[originIdx - 1][nextIdx - 1] = 1;
        boolean[] isConnect = list[nextIdx];

        for (int i = 1; i <= n; i++) {
            if (isConnect[i]) dfs(originIdx, i);
        }
    }
}
