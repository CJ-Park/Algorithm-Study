package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 다리놓기 - 조합문제 / dp
public class BaekJoon1010 {
    int T;
    StringBuilder sb = new StringBuilder();
    int[][] dp = new int[30][30];

    // 직관적으로 조합 사용해서 해결
    public void solution_1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        int n, m;

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            long res = 1;

            // m 개 중에 n 개 고르는 조합수
            for (int j = 1; j <= n; j++) {
                res *= m;
                res /= j;
                m--;
            }

            sb.append(res).append("\n");
        }

        System.out.print(sb);
    }

    // 조합을 dp 로 해결
    // nCr = n-1 C r-1 + n-1 C r
    // nC0 = nCn = 1
    public void solution_2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        int n, m;

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            sb.append(recur(m, n)).append("\n");
        }

        System.out.print(sb);
    }

    public int recur(int n, int r) {
        if (dp[n][r] != 0) {
            return dp[n][r];
        }

        if (r == 0 || n == r) {
            dp[n][r] = 1;
            return dp[n][r];
        }

        return dp[n][r] = recur(n - 1, r - 1) + recur(n - 1, r);
    }
}
