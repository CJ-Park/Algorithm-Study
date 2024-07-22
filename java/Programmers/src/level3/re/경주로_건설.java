package level3.re;

import java.util.Arrays;

/*
문제 의도:
다익스트라(bfs + dp)인듯 함

풀이 방법:
dfs + dp 로 풀이

과정:
1. 시작지점부터 종료지점까지 dfs 진행
2. 탐색하며 종료지점 도달했을 경우 요금 result 저장
3. 더 낮은 요금 발견시 최신화
=> dp 적용해서 각각의 지점마다 최소비용 갱신해가며 확인

- 기존 진행 방향과 달라질 경우 코너비용 추가
=> 92점 나옴

반례 :
0 0 0 0 0
0 1 1 1 0
0 0 1 0 0
1 0 0 0 1
1 1 1 0 0
가로출발 - 2200 2300 2400 - 3000
세로출발 - 2000 2100 2700 - 3300

=> 단순히 겹치는 위치만 대소비교하면 코너로 인한 오류 발생
=> 들어오는 방향에 따라 최소비용 구분 필요
*/
public class 경주로_건설 {
    int N;
    int[][][] minCost;
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // y 증가, x 증가, y 감소, x 감소

    public int solution(int[][] board) {
        N = board.length;
        minCost = new int[N][N][4]; // 들어오는 4방향의 최소 비용

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(minCost[i][j], Integer.MAX_VALUE);
            }
        }

        dfs(0, 0, -1, 0, board);

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            result = Math.min(minCost[N - 1][N - 1][i], result);
        }

        return result;
    }

    // direction == 0 아래 진행, 1 우측 진행, 2 위로 진행, 3 좌측 진행
    public void dfs(int x, int y, int direction, int cost, int[][] board) {
        // 도착 시 결과 최신화
        if (x == N - 1 && y == N - 1) {
            return;
        }

        // 네 방향 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + directions[i][0];
            int ny = y + directions[i][1];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N && board[nx][ny] == 0) {
                int newCost = cost + 100; // 추가 도로 비용

                if (direction != -1 && direction != i) { // 코너 발생
                    newCost += 500; // 비용 추가
                }

                if (minCost[nx][ny][i] > newCost) {
                    minCost[nx][ny][i] = newCost;
                    dfs(nx, ny, i, newCost, board);
                }
            }
        }
    }
}
