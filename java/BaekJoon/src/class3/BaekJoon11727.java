package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2xn 타일링 2 - dp 문제
public class BaekJoon11727 {
    int n;
    int MOD = 10007;
    int[] dp;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new int[n + 2];
        dp[1] = 1;

        // => n이 짝수일땐 dp[n + 1] = 2 * dp[n] - 1
        // => n이 홀수일땐 dp[n + 1] = 2 * dp[n] + 1
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                dp[i + 1] = (2 * dp[i] - 1) % MOD;
            } else {
                dp[i + 1] = (2 * dp[i] + 1) % MOD;
            }
        }
        System.out.println(dp[n]);
    }
}
