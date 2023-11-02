package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//
public class 바이러스 {
    int MOD = 1000000007;
    int k, p, n;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long result;
        k = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        // k * (p**n) -> 최종 바이러스 개수
        result = k * solve(p, n) % MOD;
        System.out.println(result);
    }


    public long solve(int p, int n) {
        if(n == 1) {
            return p;
        }
        long res = solve(p, n/2);
        if(n % 2 == 0) {
            res *= res;
            res %= MOD;
            return res;
        } else {
            res *= res;
            res %= MOD;
            res *= p; // res * p 가 int 범위 초과 가능하므로 solve 의 반환 타입 long 타입으로 변경
            res %= MOD;
            return res;
        }
    }
}
