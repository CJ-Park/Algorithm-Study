package class3.restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1, 2, 3 더하기 - dp 문제
public class BaekJoon9095 {
    int n;
    int[] dp;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[11];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
//        dp[4] = 7; // n >= 4 에서 dp[n] = dp[n - 1] + dp[n - 2] + dp[n - 3] 이 성립
        recur(10);
        for (int i = 0; i < n; i++) {
            int idx = Integer.parseInt(br.readLine());
            System.out.println(dp[idx]);
        }
    }

    public int recur(int num) {
        if (num <= 3) return dp[num];
        return dp[num] = recur(num - 1) + recur(num - 2) + recur(num - 3);
    }
}
