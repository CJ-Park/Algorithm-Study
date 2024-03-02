package DP.restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 파일합치기 - dp (매우 어려웠음)
public class BaekJoon11066 {
    int t;
    StringBuilder sb = new StringBuilder();

    public void solution() throws IOException {
        // m >= j && m <= k - 1
        // dp[j][k] = Math.min(dp[j][k], dp[j][m] + dp[m + 1][k]) + sum[k] - sum[j - 1]

        // dp[0][1] = Math.min(dp[0][1], dp[0][0] + dp[1][1] + sum[1])
        // dp[1][2] = Math.min(dp[1][2], dp[1][1] + dp[2][2] + sum[2] - sum[0])
        // dp[2][3] = Math.min(dp[2][3], dp[2][2] + dp[3][3] + sum[3] - sum[1])

        // dp[0][2] = Math.min(dp[0][1] + dp[2][2], dp[1][2] + dp[0][0]) + list[0] + list[1] + list[2] = 160
        // dp[1][3] = Math.min(dp[1][2], dp[2][3]) + list[1] + list[2] + list[3] = 170

        // dp[0][3] = Math.min(dp[0][2], dp[1][3]) + list[0] + list[1] + list[2] + list[3]
        // dp[0][3] = Math.min(dp[0][3], dp[0][1] + dp[2][3] + list[0] + list[1] + list[2] + list[3])

        // dp 테이블 그려봄
        //     0    1    2    3
        // 0   0   70    160   300
        // 1       0     60    170
        // 2             0     80
        // 3

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        int[][] dp;
        int[] sum;

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            sum = new int[n];
            dp = new int[n][n];

            for (int j = 0; j < n; j++) {
                int v = Integer.parseInt(st.nextToken());
                if (j == 0) {
                    sum[j] = v;
                } else {
                    sum[j] = sum[j - 1] + v;
                }
                dp[j][j] = 0;
            }

            // 탐색 순서 생각해서 반복문 구성하기
            // (0, 1) => (1, 2) => (2, 3) => (0, 2) => (1, 3) => (0, 3)
            for (int j = 1; j < n; j++) {
                for (int k = 0; j + k < n; k++) {
                    dp[k][j + k] = Integer.MAX_VALUE;
                    for (int m = k; m <= j + k - 1; m++) {
                        if (k == 0) {
                            dp[k][j + k] = Math.min(dp[k][j + k], dp[k][m] + dp[m + 1][j + k] + sum[j + k]);
                        } else {
                            dp[k][j + k] = Math.min(dp[k][j + k], dp[k][m] + dp[m + 1][j + k] + sum[j + k] - sum[k - 1]);
                        }
                    }
                }
            }

            sb.append(dp[0][n - 1]).append("\n");
        }

        System.out.print(sb);
    }
}
