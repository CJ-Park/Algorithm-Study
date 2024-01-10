package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 파이프 옮기기 1 - dp / 그래프 탐색
// 그래프 탐색 + 재귀로 해결
public class BaekJoon17070 {
    int n, res;
    int[][] map;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        map = new int[n + 2][n + 2];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 파이프 위치는 (1,1), (1,2) 에서 가로방향 시작
        movePipe(1, 2, 0);
        System.out.println(res);
    }

    // type = 0 : 가로
    // type = 1 : 세로
    // type = 2 : 대각선
    public void movePipe(int x, int y, int type) {
        if (x < 1 || y < 1 || x > n || y > n)
            return;

        if (type == 0) {
            if (map[x][y] == 1) // 해당 위치가 벽이면 불가능
                return;
            else { // 가로 방향은 가로 / 대각선만 가능
                movePipe(x, y + 1, 0);
                movePipe(x + 1, y + 1, 2);
            }
        }

        if (type == 1) {
            if (map[x][y] == 1)
                return;
            else { // 세로 방향은 세로 / 대각선만 가능
                movePipe(x + 1, y, 1);
                movePipe(x + 1, y + 1, 2);
            }
        }

        if (type == 2) {
            if (map[x - 1][y] == 1 || map[x][y - 1] == 1 || map[x][y] == 1) // 이 위치가 벽이면 불가능
                return;
            else { // 대각선은 모든 방향 다 가능
                movePipe(x, y + 1, 0);
                movePipe(x + 1, y, 1);
                movePipe(x + 1, y + 1, 2);
            }
        }

        if (x == n && y == n) { // 모든 조건 만족하고 리턴 이전에 res 증가 조건 확인
            if (map[x][y] != 1)
                res += 1;
        }
    }
}
