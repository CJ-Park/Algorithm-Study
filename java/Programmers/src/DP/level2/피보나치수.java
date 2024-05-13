package DP.level2;

// 반복문 + 메모이제이션
public class 피보나치수 {
    static int[] fibo = new int[100001];
    static int NUM = 1234567;

    public int solution(int n) {
        fibo[0] = 0;
        fibo[1] = 1;

        for (int i = 2; i <= n; i++) {
            int val = fibo[i - 1] + fibo[i - 2];
            val %= NUM;
            fibo[i] = val;
        }

        return fibo[n];
    }
}
