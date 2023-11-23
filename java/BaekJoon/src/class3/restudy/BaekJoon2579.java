package class3.restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 계단 오르기 - DP
// dp 문제 좀 더 풀어보기
public class BaekJoon2579 {
    int n;
    int[] scores;
    int[] dp;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        scores = new int[n + 1];
        dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = scores[0];
        dp[1] = scores[1];

        if (n >= 2) {
            dp[2] = scores[1] + scores[2];
        }

        System.out.println(goUp(n));
    }

    public int goUp(int idx) {
        if (idx >= 3) {
            if (dp[idx] == 0) { // 해당 idx 계단 방문 합계 안나왔으면
                dp[idx] = Math.max(goUp(idx - 2), goUp(idx - 3) + scores[idx - 1]) + scores[idx];
            }
        }
        return dp[idx];
    }
}
