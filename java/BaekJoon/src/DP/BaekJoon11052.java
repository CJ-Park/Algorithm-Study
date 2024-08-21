package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
카드 구매하기 - dp

0 5 2 8 10
0 - 0
1 - 5 => 5
2 - 5+5 / 2 => 10
3 - dp[1] + dp[2] / arr[3] => 5 + 10 = 15
4 - dp[3] + dp[1] / dp[2] + dp[2] / arr[4] => 20 / 20 / 10 = 20

=================================
0 3 5 15 16
0 - 0
1 - 3 => 3
2 - dp[0] + dp[2] / dp[1] + dp[1] => 5 / 6 = 6
3 - dp[0] + dp[3] / dp[1] + dp[2] => 15 / 9 = 15
4 - dp[0] + dp[4] / dp[1] + dp[3] / dp[2] + dp[2] => 16 / 18 / 10 = 18
 */
public class BaekJoon11052 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int count = Integer.parseInt(br.readLine());
        int[] dp = new int[count + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= count; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= count; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i - j] + dp[j], dp[i]);
            }
        }

        System.out.println(dp[count]);
    }
}
