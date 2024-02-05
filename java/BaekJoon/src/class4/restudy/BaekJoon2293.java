package class4.restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 동전 1 - dp 문제
// 점화식 세우는거 고민하기
public class BaekJoon2293 {
    int n, result;
    int[] coin, dp;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        result = Integer.parseInt(st.nextToken());
        coin = new int[n];
        dp = new int[result + 1];

        for (int i = 0; i < n; i++) {
            int c = Integer.parseInt(br.readLine());
            coin[i] = c;
        }

        Arrays.sort(coin);

        dp[0] = 1;

        // dp     0 1 2 3 4 5 6 7 8 9 10
        //coin 1  1 1 1 1 1 1 1 1 1 1 1
        //coin 2  1 1 2 2 3 3 4 4 5 5 6
        //coin 5  1 1 2 2 3 4 5 6 7 8 10

        // => dp[10] = dp[10 - 5] (== 4) + dp[10] (== 6)
        // dp[i] = dp[i - cost] + dp[i]


        // coin 1 2 5
        for (int i = 0; i < n; i++) {
            int cost = coin[i];
            for (int j = cost; j <= result; j++) {
                dp[j] = dp[j] + dp[j - cost];
            }
        }

        System.out.print(dp[result]);
    }
}
