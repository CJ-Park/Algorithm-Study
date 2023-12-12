package class4.restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 스티커 - dp 문제 (바텀업 사용)
public class BaekJoon9465 {
    int T;
    int[][] arr;
    int[][] dp;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    public void solution() throws IOException {
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            arr = new int[2][n + 1];

            fillArr(n);
            int max = getMaxScore(n);
            sb.append(max).append("\n");
        }
        System.out.print(sb);
    }


    // arr 채우기
    public void fillArr(int n) throws IOException {
        dp = new int[2][n + 1];
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    // 모든 경우의 수 dp[][] 에 저장
    public int getMaxScore(int n) {
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[0][i] = arr[0][i];
                dp[1][i] = arr[1][i];
                continue;
            }
            dp[0][i] = Math.max(dp[0][i -2], dp[1][i - 2]) + arr[0][i]; // 한칸 뛴 경우
            dp[0][i] = Math.max(dp[0][i], dp[1][i - 1] + arr[0][i]); // 한칸 뛴 경우의 최대값과 대각선으로 더하는 경우 비교
            dp[1][i] = Math.max(dp[0][i -2], dp[1][i - 2]) + arr[1][i];
            dp[1][i] = Math.max(dp[1][i], dp[0][i - 1] + arr[1][i]);
        }
        return Math.max(dp[0][n], dp[1][n]);
    }
}
