package 이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 떡만들기 {
    int n, m, res; // n <= 10^6 / m <= 2 * 10^9
    int[] rice;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        rice = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            rice[i] = Integer.parseInt(st.nextToken());
        }

        // 시작인덱스 0 / 마지막인덱스 rice 의 요소 중 최대값
        System.out.println(solve());
    }

    public int solve() {
        int start = 0;
        int end = Arrays.stream(rice).max().getAsInt();
        while (start < end) {
            int sum = 0;
            int mid = (start + end) / 2;

            for (int i : rice) {
                if (i > mid) {
                    sum += (i - mid);
                }
            }

            if (sum >= m) {
                res = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return res;
    }
}
