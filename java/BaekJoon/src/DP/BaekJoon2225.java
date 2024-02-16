package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 합분해 - dp / 수학
public class BaekJoon2225 {
    final int MOD = 1000000000;
    int n, k;
    long[][] dp;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dp = new long[n + 1][k + 1];

        // 0 ~ 10 / 3개
        // 0 0 10
        // 0 1 9
        // ...
        // 0 10 0 ==> dp[10][2] => 10까지 2개 고르는 경우
        // ============
        // 1 0 9
        // 1 1 8
        // 1 2 7
        // ...
        // 1 9 0 ==> dp[9][2] => 9까지 2개 고르는 경우
        // ============
        // ..........
        // ============
        // 10 0 0 ==> dp[1][2] => 1까지 2개 고르는 경우
        // ==> dp[10][3] = dp[10][2] + dp[9][2] + ... + dp[0][2];
        // ==> dp[10][2] = dp[10][1] + dp[9][1] + ... + dp[0][1];
        // => dp[n][k] = dp[n][k - 1] + dp[n - 1][k - 1] + ... + dp[0][k - 1];
        // => dp[3][2] = dp[3][1] + dp[2][1] + dp[1][1] + dp[0][1] = 4
        // 0 3 / 3 0 / 2 1 / 1 2
        // => dp[2][2] = dp[2][1] + dp[1][1] + dp[0][1] = 3
        // 0 2 / 2 0 / 1 1
        // => dp[1][2] = dp[1][1] + dp[0][1] = 2
        // 0 1 / 1 0
        // => dp[3][3] = dp[3][2] + dp[2][2] + dp[1][2] + dp[0][2] = 10
        // => 0 0 3 / 0 1 2 / 0 2 1 / 0 3 0 / 1 1 1 / 2 0 1 / 2 1 0 / 3 0 0 / 1 0 2 / 1 2 0

        for (int i = 0; i <= n; i++) {
            dp[i][1] = 1;
        }

        long res = getDp(n, k);
        System.out.print(res);
    }

    public long getDp(int a, int b) {
        if (a == 0 || b == 1) {
            return 1;
        }

        if (dp[a][b] == 0) { // 값이 채워지지 않았을 경우만 연산
            for (int i = 0; i <= a; i++) {
                dp[a][b] += getDp(i, b - 1);
                dp[a][b] %= MOD;
            }
        }

        return dp[a][b] % MOD;
    }
}
