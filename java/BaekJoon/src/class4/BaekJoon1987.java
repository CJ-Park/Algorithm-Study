package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 알파벳 - 백트래킹, dfs
public class BaekJoon1987 {
    int n, m, result;
    String[][] map;
    Map<String, Boolean> visited = new HashMap<>();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new String[n][m];

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = str[j];
            }
        }

        // map 이 단 한개만 입력됐을 경우를 위해 result = 1 로 초기화
        result = 1;

        // 0,0 부터 탐색 시작
        getResult(0, 0, 0);

        System.out.println(result);
    }

    // 0,0 좌표부터 상하좌우 탐색
    // map 범위 벗어나면 리턴
    // 중복방문시 리턴하며 리턴하기 전에 result 값과 비교해서 더 크면 저장 후 리턴
    // 방문은 알파벳 A-Z 기준이므로 cnt 는 최대 26까지 가능
    // 모든 방향 탐색 후 종료 시 방문처리 취소 -> 그래야 이전으로 돌아가서 정상적으로 다른 부분 탐색 가능
    public void getResult(int x, int y, int cnt) {
        if (x < 0 || y < 0 || x >= n || y >= m)
            return;

        Boolean isVisited = visited.getOrDefault(map[x][y], false);
        if (isVisited || cnt == 26) {
            result = Math.max(result, cnt);
            return;
        }

        visited.put(map[x][y], true);

        getResult(x + 1, y, cnt + 1);
        getResult(x - 1, y, cnt + 1);
        getResult(x, y + 1, cnt + 1);
        getResult(x, y - 1, cnt + 1);

        visited.put(map[x][y], false);
    }
}
