package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 동전 0 - 그리디 알고리즘
public class BaekJoon11047 {
    int n, k;
    int[] coinValue;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        k = Integer.parseInt(s[1]);

        coinValue = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            coinValue[i] = Integer.parseInt(br.readLine());
        }

        // coinValue 를 순회하면서 k 를 나눴을 때 나머지가 k 일 경우 이전 인덱스부터 시작
        int mod = 0;
        int idx = 0;
        while (mod != k) {
            idx++;
            if (idx > n) break; // idx 초과한 경우 반복문 중지
            mod = k % coinValue[idx];

        }

        // 해당 인덱스부터 k 를 나눠가며 동전개수 카운트
        int count = 0;
        while (k != 0) {
            idx--;
            count += k / coinValue[idx];
            k = k % coinValue[idx];
        }

        System.out.println(count);

    }
}
