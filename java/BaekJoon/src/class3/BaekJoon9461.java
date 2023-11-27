package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 파도반 수열 - dp (long 타입 사용해야됨 - 범위 참조)
// 바텀업 방식 사용
public class BaekJoon9461 {
    int n;
    long[] dp = new long[101];

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (dp[num] == 0) {
                for (int j = 6; j <= num; j++) {
                    if (dp[j] == 0) dp[j] = dp[j - 1] + dp[j - 5];
                }
            }
            sb.append(dp[num]).append("\n");
        }
        System.out.print(sb);
    }
}
