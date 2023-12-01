package class4.restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 가장 긴 증가하는 부분수열 - dp
// dp 배열 도출하는 방식 생각해보기
public class BaekJoon11053 {
    int n;
    int[] arr, dp;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n]; // 해당 인덱스까지의 부분수열 최대 길이

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // dp 를 구해놓고 max 값을 구하면 됨
        for (int i = 0; i < n; i++) {
            recur(i);
        }

        int max = dp[0];
        for (int i = 0; i < n; i++) {
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }

    // 10 20 10 30 20 50
    // 1  2  1  3  2  4
    public int recur(int idx) { // idx 까지의 dp 값 계산
        if (dp[idx] == 0) { // 해당 인덱스 탐색한적 없음
            dp[idx] = 1; // 스스로 1개의 부분수열 무조건 가짐

            // 이전 노드들 탐색
            for (int i = idx - 1; i >= 0; i--) {
                if (arr[i] < arr[idx]) {
                    dp[idx] = Math.max(recur(i) + 1, dp[idx]);
                }
            }
        }

        return dp[idx];
    }
}
