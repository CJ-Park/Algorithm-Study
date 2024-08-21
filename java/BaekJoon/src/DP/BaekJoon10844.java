package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
계단 수 - dp
1 2 3 4 5 6 7 8 9 dp[1][0] = 0 / dp[1][1] = 1 ... d[1][9] = 1
dp[2][0] = dp[1][1] + dp[1][-1] / dp[2][1] = dp[1][2] + dp[1][0] / dp[2][2] = dp[1][1] + dp[1][3] ...
dp[2][9] = dp[1][8] + dp[1][10]
10 12 21 23 32 34 ... 87 89 98 / dp[2][0] = 1 / dp[2][1] = 1 / dp[2][2] = 2 .. dp[2][9] = 1
=> 끝이 0이거나 9면 가짓수 반토막임
 */
public class BaekJoon10844 {
    int MOD = 1_000_000_000;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][10];
        long result = 0;

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j + 1];
                    continue;
                }

                if (j == 9) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j + 1];
                }

                dp[i][j] %= MOD;
            }
        }

        for (int i = 0; i < 10; i++) {
            result += dp[n][i];
            result %= MOD;
        }

        System.out.println(result);
    }
}
