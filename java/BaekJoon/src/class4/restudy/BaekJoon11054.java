package class4.restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 가장 긴 바이토닉 부분 수열 - dp 문제
// 증가하다 감소하는 부분을 어떻게 풀어낼지 고민
// 아이디어 떠올리지 못해서 검색 참조함 => 0번부터 증가하는 부분수열과 n - 1 부터 증가하는 부분수열 dp 2개 생성
public class BaekJoon11054 {
    int n, maxLen;
    int[] arr, dp, reverseDp;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n]; // idx 0 부터 증가하는 부분수열을 위한 dp
        reverseDp = new int[n]; // 반대로 증가하는 부분수열을 위한 dp

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            arr[i] = value;
        }

        // arr 1 5 2 1 4 3 4 5 2 1
        // dp  1 2 2 1 3 3 4 5 2 1 => 정방향 증가 부분수열 계산

        // arr     1 5 2 1 4 3 4 5 2 1
        // reverse 1 5 2 1 4 3 3 3 2 1 => 역방향 증가 부분수열 계산

        makeDp(0);
        makeReverseDp(n - 1);

        for (int i = 0; i < n; i++) {
            int sum = dp[i] + reverseDp[i] - 1; // 두 dp 의 합 - 1 = 해당 arr[i]를 최대값으로 갖는 바이토닉 수열 dp
            maxLen = Math.max(maxLen, sum);
        }

        System.out.print(maxLen);
    }

    public void makeDp(int idx) {
        if (idx >= n)
            return;

        if (idx == 0)
            dp[idx] = 1;
        else {
            int res = 0;

            for (int i = idx; i >= 0; i--) {
                res = Math.max(res, searchDp(idx, i));
            }
            dp[idx] = res;
        }

        makeDp(idx + 1);
    }

    public int searchDp(int idx, int compareIdx) {
        if (arr[idx] > arr[compareIdx])
            return dp[compareIdx] + 1;
        return 1;
    }

    // 거꾸로 확인
    public void makeReverseDp(int idx) {
        if (idx < 0)
            return;

        if (idx == n - 1)
            reverseDp[idx] = 1;
        else {
            int res = 0;

            for (int i = idx; i < n; i++) {
                res = Math.max(res, searchReverse(idx, i));
            }
            reverseDp[idx] = res;
        }

        makeReverseDp(idx - 1);
    }

    public int searchReverse(int idx, int compareIdx) {
        if (arr[idx] > arr[compareIdx])
            return reverseDp[compareIdx] + 1;
        return 1;
    }
}
