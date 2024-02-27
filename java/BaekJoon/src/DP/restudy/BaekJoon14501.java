package DP.restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 퇴사 - dp
public class BaekJoon14501 {
    int n;
    int[] dp;
    Talk[] talks;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new int[n + 1];
        talks = new Talk[n + 1];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            talks[i] = new Talk(day, p);
        }

        // 0  1  2  3  4  5  6  7  8  9
        // 5  4  3  2  1  1  2  3  4  5
        // 50 40 30 20 10 10 20 30 40 50

        // dp  0  0  0  0  0  50 60  0 80  0

        // dp[0 + 5] = dp[0 + 5] / dp[0] + talks[0].price = 50
        // dp[1 + 4] = dp[1 + 4] = 50 / dp[1] + talks[1].price = 40
        // dp[2 + 3] =
        // dp[3 + 2]
        // dp[4 + 1]
        // dp[5 + 1] = dp[5 + 1] / dp[5] + talks[5].price = 60
        // dp[6 + 2] = dp[6 + 2] / dp[6] + talks[6].price = 80
        // dp[7] = dp[6] + talks[7].price = 90

        for (int i = 0; i < n; i++) {
            if (i + talks[i].day <= n) {
                dp[i + talks[i].day] = Math.max(dp[i + talks[i].day], dp[i] + talks[i].price);
            }
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }

        Arrays.sort(dp);
        System.out.println(dp[dp.length - 1]);
    }

    static class Talk {
        int day;
        int price;

        public Talk(int d, int p) {
            this.day = d;
            this.price = p;
        }
    }
}
