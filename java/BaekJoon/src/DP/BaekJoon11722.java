package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 가장 긴 감소하는 부분수열 - dp
public class BaekJoon11722 {
    int n;
    int[] arr, dp;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i] = 1;
            } else {
                int res = 0;

                for (int j = i; j >= 0; j--) { // 이전 모든 인덱스들과 비교하며 dp 최대값으로 갱신
                    res = Math.max(res, compareDp(i, j));
                }

                dp[i] = res;
            }
        }

        Arrays.sort(dp);
        System.out.print(dp[n - 1]);
    }

    // 이전의 특정 인덱스와 현재 인덱스의 크기 비교 후 dp 값 반환
    public int compareDp(int nowIdx, int beforeIdx) {
        if (arr[nowIdx] < arr[beforeIdx]) {
            return dp[beforeIdx] + 1;
        }
        return 1;
    }
}
