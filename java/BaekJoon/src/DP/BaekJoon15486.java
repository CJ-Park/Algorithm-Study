package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 퇴사 2 - dp
public class BaekJoon15486 {
    int n;
    Consulting[] con;
    int[] dp;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        con = new Consulting[n];
        dp = new int[n + 1];

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            con[i] = new Consulting(day, cost);
        }

        // dp[5] = 50
        // dp[6] = dp[5] + 10 = 60
        // dp[8] = dp[6] + 20 = 80
        // dp[10] = dp[7] + 30 = 90
        for (int i = 0; i < n; i++) {
            if (i + con[i].day <= n) {
                dp[i + con[i].day] = Math.max(dp[i + con[i].day], dp[i] + con[i].cost);
            }
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }

        Arrays.sort(dp);
        System.out.print(dp[n]);
    }

    static class Consulting {
        int day;
        int cost;

        public Consulting(int d, int c) {
            this.day = d;
            this.cost = c;
        }
    }
}
