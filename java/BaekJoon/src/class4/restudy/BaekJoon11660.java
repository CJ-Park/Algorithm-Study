package class4.restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 구간 합 구하기 5 - dp 문제
// bfs 접근 불가 -> n, m 범위로 인한 시간초과 발생
public class BaekJoon11660 {
    int n, m, result;
    int[][] map;
    int[][] dp;
    //   boolean[][] visited;
    //   Point start, end;
    StringBuilder sb = new StringBuilder();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n + 2][n + 2];
        dp = new int[n + 2][n + 2];

        // map 작성 완료
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = map[1][1];

        // dp 배열 초기화
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = map[i][j] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }


        // 1 2 3 4 5
        // 2 3 4 5 6
        // 3 4 5 6 7
        // 4 5 6 7 8
        // 8 7 6 5 4
        // (3,4), (4,4) => dp[4][4] - (dp[2][4] + dp[4][3]) + dp[2][3]
        // (x1, y1), (x2, y2) => dp[x2][y2] - (dp[x1 - 1][y2] + dp[x2][y1 - 1]) + dp[x1 - 1][y1 - 1];

        // dp 기준으로 결과값 산출
        for (int i = 0; i < m; i++) {
            result = 0;
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            result = dp[x2][y2] - (dp[x1 - 1][y2] + dp[x2][y1 - 1]) + dp[x1 -1][y1 - 1];
            sb.append(result).append("\n");
        }

//        for (int i = 0; i < m; i++) {
//            result = 0;
//            st = new StringTokenizer(br.readLine());
//            int x1 = Integer.parseInt(st.nextToken());
//            int y1 = Integer.parseInt(st.nextToken());
//            int x2 = Integer.parseInt(st.nextToken());
//            int y2 = Integer.parseInt(st.nextToken());
//            start = new Point(x1, y1);
//            end = new Point(x2, y2);
//
//            visited = new boolean[n + 2][n + 2]; // 방문정보 초기화
//            getResult(start);
//
//            // 재귀 작업 끝나고 sb 에 result 값 추가
//            sb.append(result).append("\n");
//        }

        System.out.print(sb);
    }



// ===============================================================================

// n 범위가 1 이상 1024 이하 이며 m 범위가 10^5 이하이므로 반복탐색 시 시간초과 문제 발생

//    // start 와 end 범위에서 나가면 return
//    // visited 로 체크하면서 검사 / 이미 방문했으면 return
//    // 끝나고 나서 해당 범위 내에서 최대값 찾아서 sb 에 넣기
//    // 재귀방식 - dfs
//    public void getResult(Point p) {
//        if (p.x < start.x || p.x > end.x || p.y < start.y || p.y > end.y) return;
//        if (visited[p.x][p.y]) return;
//
//        // 방문처리 후 result 값에 더해주기
//        visited[p.x][p.y] = true;
//        result += map[p.x][p.y];
//
//        // 네 방향 전부 재귀로 돌려야됨
//        getResult(new Point(p.x + 1, p.y));
//        getResult(new Point(p.x - 1, p.y));
//        getResult(new Point(p.x, p.y + 1));
//        getResult(new Point(p.x, p.y - 1));
//    }
//
//    public class Point {
//        int x;
//        int y;
//
//        public Point(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
}
