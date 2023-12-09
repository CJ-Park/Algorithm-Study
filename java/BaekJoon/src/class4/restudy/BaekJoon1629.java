package class4.restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 곱셈 - 모듈러 법칙 재귀 + Integer / Long 범위
public class BaekJoon1629 {
    long a, b, c, result;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());

        result = getResult(b);
        System.out.println(result);
    }

    // 모듈러 합동 공식 : (a * b) % c = ((a % c) * (b % c)) % c
    public long getResult(long b) {
        if (b == 1) return a % c;
        long half = getResult(b / 2);
        if (b % 2 == 1) {
            long reHalf = (half * half) % c;
            long reA = a % c;
            return (reHalf * reA) % c;
        }
        return half * half % c;
    }
}
