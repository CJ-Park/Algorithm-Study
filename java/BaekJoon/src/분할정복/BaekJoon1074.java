package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
- 0 2 - 4 - - - 6 - - - - - - -
1 - - - - - - - - - - - - - - -
3 - - - - - - - - - - - - - - -
- - - - - - - - - - - - - - - -
5 - - - - - - - - - - - - - - -
- - - - - - - - - - - - - - - -
- - - - - - - - - - - - - - - -
- - - - - - - - - - - - - - - -
7 - - - - - - - - - - - - - - -

0,1 => 0승
1,1 => 1승
2,0 => 2승
0,2 => 3승
4,0 => 4승
0,4 => 5승
8,0 => 6승
0,8 => 7승

n = 1 => 2^1 => 0 / 1 = 2^0 / 2 = 2^1 / 3
n = 2 => 2^2 => 0 / 4 = 2^2 / 8 = 2^3 / 12
n = 3 => 2^3 => 0 / 16 = 2^4 / 32 = 2^5 / 48
n = 4 => 2^4 => 0 / 64 = 2^6 / 128 = 2^7 / 64*3
n = 5 => 2^5 => 0 / 256 = 2^8 / 256*2 = 2^9 / 256*3
*/
public class BaekJoon1074 {
    int result = 0;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        recur(N, r, c);
        System.out.println(result);
    }

    // 4분면 구분하면서 재귀 진행
    private void recur(int n, int r, int c) {
        if (n == 0) { // 재귀 종료 => 결과 찾음
            if (r == 1 && c == 1) {
                result += 3;
            }

            if (r == 0 && c == 1) {
                result += 1;
            }

            if (r == 1 && c == 0) {
                result += 2;
            }

            return;
        }

        int mid = (int) Math.pow(2, n) / 2; // 4

        double add = Math.pow(2, 2 * (n - 1));

        if (r < mid && c < mid) { // 1사분면
            recur(n - 1, r, c);
        }

        if (r < mid && c >= mid) { // 2사분면
            result += (int) add;
            recur(n - 1, r, c - mid);
        }

        if (r >= mid && c < mid) { // 3사분면
            result += (int) add * 2;
            recur(n - 1, r - mid, c);
        }

        if (r >= mid && c >= mid) { // 4사분면
            result += (int) add * 3;
            recur(n - 1, r - mid, c - mid);
        }
    }
}
