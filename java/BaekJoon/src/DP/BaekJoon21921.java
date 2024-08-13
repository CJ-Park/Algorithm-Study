package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
블로그 - 실버3
dp / 누적합
 */
public class BaekJoon21921 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] dp = new int[n + 1];
        int[] record = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            record[i] = Integer.parseInt(st.nextToken());
            dp[i + 1] = dp[i] + record[i];
        }

        int maxRecord = 0;
        int maxCount = 0;
        for (int i = x; i <= n; i++) {
            int visitor = dp[i] - dp[i - x];
            if (maxRecord == visitor) {
                maxCount++;
            }

            if (maxRecord < visitor) {
                maxRecord = visitor;
                maxCount = 1;
            }
        }

        if (maxRecord == 0) {
            System.out.println("SAD");
        } else {
            System.out.print(maxRecord + "\n" + maxCount);
        }
    }
}
