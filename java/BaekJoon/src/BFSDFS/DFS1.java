package BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 음료수 얼려먹기
public class DFS1 {
    int[][] ices;
    int N, M;
    int count = 0;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ices = new int[N + 2][M + 2];

        // 모든 요소 1로 초기화
        for (int i = 0; i < N + 2; i++) {
            for (int j = 0; j < M + 2; j++) {
                ices[i][j] = 1;
            }
        }

        // ices 배열에 값 넣기
        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 1; j <= M; j++) {
                ices[i][j] = s.charAt(j - 1) - '0';
            }
        }

        // 배열 (1,1)부터 순회하면서 0 발견 시 인접 인덱스 확인
        // 재귀함수로 작성 4방향 확인
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if(countIce(i, j)) {
                    count++;
                }
            }
        }
        System.out.print(count);
    }

    // 방문
    public boolean countIce(int x, int y) {
        if (x < 1 || y < 1 || x > N || y > M) {
            return false;
        }

        if(ices[x][y] == 0) {
            ices[x][y] = 1;
            countIce(x - 1, y);
            countIce(x, y - 1);
            countIce(x + 1, y);
            countIce(x, y + 1);

            return true;
        }
        return false;
    }
}
