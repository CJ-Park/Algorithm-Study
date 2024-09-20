package DP.restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
동물원 - dp

dp[2][0] = dp[1][0] + dp[1][1] + dp[1][2]; // 이전층 어디든 존재해도 됨
dp[2][1] = dp[1][0] + dp[1][2]; // 사자가 이전층에 없거나 대각선에 존재
dp[2][2] = dp[1][0] + dp[1][1]; // 사자가 이전층에 없거나 대각선에 존재
=================================================================
dp[N][0] = dp[N - 1][0] + dp[N - 1][1] + dp[N - 1][2];
dp[N][1] = dp[N - 1][0] + dp[N - 1][2];
dp[N][2] = dp[N - 1][0] + dp[N - 1][1];

점화식 세우기 너무 어렵다..
 */
public class BaekJoon1309 {
    int MOD = 9901;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        // dp[i][j] => i번째 줄 j번째 칸에 사자 넣는 경우
        int[][] dp = new int[size + 1][3];
        Arrays.fill(dp[1], 1); // 첫번째 줄에 사자가 없거나 두 칸중 하나만 들어갈 수 있음

        for (int i = 2; i <= size; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
        }

        int result = 0;
        for (int i = 0; i < 3; i++) {
            result += dp[size][i];
        }
        System.out.println(result % MOD);
    }
}
