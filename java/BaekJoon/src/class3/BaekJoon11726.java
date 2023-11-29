package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2xn 타일링 - dp 문제
public class BaekJoon11726 {
    int MOD = 10007;
    int n;
    int[] dp;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 2];
        // 2*2 -> 2가지 방법 / 2*1 -> 1가지 방법
        // 2와 1로 몇개로 나눠지는지 조합
        // n = 1 -> 2*1 1개 => 1개 (1)
        // n = 2 -> 2*1 2개 / 2*2 1개 => 2개 (1, 1 / 2)
        // n = 3 -> 2*1 3개 / 2*1 1개 + 2*2 1개 (자리바꾸기 허용) => 3개 (1, 1, 1 / 2, 1/ 1, 2)
        // n = 4 -> 2*1 4개 / 1 2개 + 2 1개 / 2 2개 => 5개 (1, 1, 1, 1 / 2, 1, 1 / 1, 2, 1 / 1, 1, 2 / 2, 2)
        // n = 5 -> 2*1 5개 / 1 1개 + 2 2개 / 1 3개 + 2 1개 => 8개 (1, 1, 1, 1, 1 / 2, 1, 1, 1 / 1, 2, 1, 1 /
        // 1, 1, 2, 1 / 1, 1, 1, 2 / 2, 2, 1 / 2, 1, 2 / 1, 2, 2)
        // n = 6 ->
        // ...
        // 피보나치 수열과 같음
        dp[1] = 1;
        dp[2] = 2;
        int res = recur(n);
        System.out.println(res);
    }

    public int recur(int num) {
        if (dp[num] != 0) {
            return dp[num];
        }
        dp[num] = (recur(num - 1) + recur(num - 2)) % MOD;
        return dp[num];
    }
}
