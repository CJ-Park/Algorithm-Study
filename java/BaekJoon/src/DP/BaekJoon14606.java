package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 피자 (Small)
public class BaekJoon14606 {
    int n;
    int[] dp;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new int[n + 1];
        dp[1] = 0;

        int result = recur(n);
        System.out.println(result);
    }

    public int recur(int num) {
        if (num == 1) return 0;
        else {
            if (dp[num] == 0 && num % 2 == 0) {
                dp[num] = (num / 2) * (num / 2) + recur(num / 2) + recur(num / 2);
            } else if (dp[num] == 0 && num % 2 == 1) {
                dp[num] = (num / 2) * (num / 2 + 1) + recur(num / 2) + recur(num / 2 + 1);
            }
            return dp[num];
        }
    }
}
