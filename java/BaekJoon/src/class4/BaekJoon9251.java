package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// LCS (최장 공통 부분 수열) - dp
public class BaekJoon9251 {
    String s1, s2;
    int[][] dp;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s1 = br.readLine();
        s2 = br.readLine();

        // ACAYKP
        // CAPCAK

        // dp => 1,1 부터 a, b 까지 진행
        // 해당 인덱스에서 s1 과 s2 가 같은 char 값이면 dp[i][j] = dp[i - 1][j - 1] + 1
        // 다른 값이면 dp[i - 1][j], dp[i][j - 1] 비교해서 더 큰값 채용
//        0 0 C A P C A K                 0 A B A A B A
//        0 0 0 0 0 0 0 0               0 0 0 0 0 0 0 0
//        A 0 0 1 1 1 1 1               A 0 1 1 1 1 1 1
//        C 0 1 1 1 2 2 2               A 0 1 1 2 2 2 2
//        A 0 1 2 2 2 3 3
//        Y 0 1 2 2 2 3 3
//        K 0 1 2 2 2 3 4
//        P 0 0 1 2 3 3 4

        int a = s1.length();
        int b = s2.length();

        dp = new int[a + 1][b + 1];

        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= b; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1))
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    else
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.print(dp[a][b]);
    }
}
