package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 테트로미노 - dfs 와 구현
public class BaekJoon14500 {
    int n, m, result;
    int[][] map;
    boolean[][] visited;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                getMaxResult(i, j, 0, 0);
                getUniqueResult(i, j);
                // visited 배열 이중포문 내에서 재선언해서 시간초과 발생 => 방문처리는 재귀 내에서 수정하기
//                visited = new boolean[n][m];
            }
        }

        System.out.println(result);
    }

    public void getMaxResult(int x, int y, int res, int cnt) {
        if (x < 0 || x >= n || y < 0 || y >= m) return;
        if (visited[x][y]) return;
        if (cnt == 3) { // 5번째 지점
            result = Math.max(result, res + map[x][y]);
            return;
        }

        visited[x][y] = true;
        res += map[x][y];

        getMaxResult(x, y + 1, res, cnt + 1);
        getMaxResult(x + 1, y, res, cnt + 1);
        getMaxResult(x, y - 1, res, cnt + 1);
        getMaxResult(x - 1, y, res, cnt + 1);

        visited[x][y] = false;
    }

    // 꼭지점 위치라면 결과 없음
    // 끝 변에 위치한다면 3점은 강제됨
    // 내부에 존재하면 4점 중 3점 고르기
    public void getUniqueResult(int x, int y) { // 시작 지점 기준 사방의 4 점 중 3개 골라서 최대값 비교
        if (x > 0 && x < n - 1 && y > 0 && y < m - 1) {
            int min = Integer.MAX_VALUE;
            min = Math.min(min, map[x - 1][y]);
            min = Math.min(min, map[x + 1][y]);
            min = Math.min(min, map[x][y - 1]);
            min = Math.min(min, map[x][y + 1]);
            result = Math.max(result,
                    map[x][y] + map[x - 1][y] + map[x + 1][y] + map[x][y - 1] + map[x][y + 1] - min);
        }
        if (x == 0 && y > 0 && y < m - 1) {
            result = Math.max(result, map[x][y] + map[x + 1][y] + map[x][y + 1] + map[x][y - 1]);
        }
        if (x == n - 1 && y > 0 && y < m - 1) {
            result = Math.max(result, map[x][y] + map[x - 1][y] + map[x][y + 1] + map[x][y - 1]);
        }
        if (y == 0 && x > 0 && x < n - 1) {
            result = Math.max(result, map[x][y] + map[x + 1][y] + map[x - 1][y] + map[x][y + 1]);
        }
        if (y == m - 1 && x > 0 && x < n - 1) {
            result = Math.max(result, map[x][y] + map[x + 1][y] + map[x - 1][y] + map[x][y - 1]);
        }
    }
}
