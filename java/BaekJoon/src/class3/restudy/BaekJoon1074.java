package class3.restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Z - 재귀 문제
public class BaekJoon1074 {
    int n, r, c, count;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int num = 1;
        for (int i = 0; i < n; i++) {
            num *= 2;
        }

        recur(num, c, r);

        System.out.println(count);
    }

    // 좌표 1사분면 => count 그대로 두고 재귀
    // 2사분면 => count += (size * size) / 4 * 1
    // 3사분면 => count += (size * size) / 4 * 2
    // 4사분면 => count += (size * size) / 4 * 3
    public void recur(int size, int a, int b) {
        if (size == 1) return;
        if (a < size / 2 && b >= size / 2) { // 3사분면
            count += (size * size) / 4 * 2;
            b = b - size / 2;
        }
        if (a >= size / 2 && b < size / 2) { // 2사분면
            count += (size * size) / 4;
            a = a - size / 2;
        }
        if (a >= size / 2 && b >= size / 2) { // 4사분면
            count += (size * size) / 4 * 3;
            a = a - size / 2;
            b = b - size / 2;
        }

        recur(size / 2, a, b);
    }
}
