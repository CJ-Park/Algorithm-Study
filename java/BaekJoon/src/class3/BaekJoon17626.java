package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Four Squares - dp 문제
public class BaekJoon17626 {
    int n;
    int[] dp;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        // 1 - 1 / 2 - 2 / 3 - 3 / 4 - 1 / 5 - 2 / 6 - 3 / 7 - 4 / 8 - 2 / 9 - 1 / 10 - 2 / 11 - 3 / 12 - 3 / 13 - 2
        // 14 - 3 / 15 - 4 / 16 - 1
        // dp[2] = dp[2 - 1] = 1 + 1
        // dp[12] = dp[12 - 1] = 3 + 1 / dp[12] = dp[12 - 4] = 2 + 1 / dp[12] = dp[12 - 9] = 3 + 1
        // dp[26] = dp[26 - 25] = 1 + 1 / dp[26 - 16] = 2 + 1 / dp[26 - 9] = 2 + 1 / dp[26 - 4]
        for (int i = 2; i <= n; i++) {
            int min = 4;
            for (int j = 1; j * j <= i; j++) { // j * j가 i보다 작거나 같을때까지
                min = Math.min(dp[i - j * j] + 1, min);
            }
            dp[i] = min;
        }

        System.out.println(dp[n]);
    }
}
