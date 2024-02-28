package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 피보나치 2 - dp
public class BaekJoon2748 {
    int n;
    long[] fibo;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        fibo = new long[n + 1];
        fibo[0] = 0;
        fibo[1] = 1;

        // 바텀업 방식
//        for (int i = 2; i <= n; i++) {
//            fibo[i] = fibo[i - 1] + fibo[i - 2];
//        }
//        long res = fibo[n];

        // 탑다운 방식
        long res = getFibo(n);

        System.out.print(res);
    }

    public long getFibo(int idx) {
        if (idx == 0) {
            return 0;
        }

        if (fibo[idx] != 0) {
            return fibo[idx];
        }

        fibo[idx] = getFibo(idx - 1) + getFibo(idx - 2);
        return fibo[idx];
    }
}
