package class3.restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 카잉 달력 - 브루트포스, 정수론
// 최소공배수 활용하여 해결했음 -> 조건 나눌 때 순서 확인
public class BaekJoon6064 {
    int T, m, n, x, y, lastYear, result;
    StringBuilder sb = new StringBuilder();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            result = -1;
            lastYear = 0;
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            getLastYear();
            getResult();
            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }

    // 10 12
    // 13 11
    // m n 의 최소공배수 구하기 = lastYear
    public void getLastYear() {
        int target = m;
        while (target % n != 0) {
            target += m;
        }
        lastYear = target;
    }

    // 1 - 1 1 / 2 - 2 2 ... 11 - 1(11 % 10) 11 / 12 - 2 12 / 13 - 3 1 (13 % 12)
    // 즉 target 을 m 과 n 으로 나눴을 때의 나머지가 x y 가 되는 경우의 target 구해야됨
    // 10 12 2 12 =>
    // 2 12 22 32 ..
    // 12 24 36 ..

    // 3 13 23 33 43 53 ... => m * i + x
    // 9 21 33 45 ... => n * j + y

    // 시간초과 + 메모리초과 둘 다 발생 => 조건문 집어넣고 x 만족하는 수만 골라서 시작하는거로 해결
    public void getResult() {
        // target 을 m 으로 나눌 때 나머지가 x 임을 만족하는 수 골라서 시작
        int i = 0;
        int res = 0;

        // 1. x == m 인 경우
        if (x == m) {
            while (x * (i + 1) % n != y) {
                if (x * (i + 1) > lastYear) {
                    res = -1;
                    break;
                }
                i++;
            }
            if (res != -1) res = x * (i + 1);
        }

        // 2. y == n 인 경우
        if (y == n) {
            while ((m * i + x) % n != 0) {
                if (m * i + x > lastYear) {
                    res = -1;
                    break;
                }
                i++;
            }
            if (res != -1) res = m * i + x;
        }

        // 3. x == m && y == n 인 경우
        if (x == m && y == n) res = lastYear;

        // 4. x, y 모두 m, n 이 아닌 경우
        if (x != m && y != n) {
            while ((m * i + x) % n != y) {
                if (m * i + x > lastYear) {
                    res = -1;
                    break;
                }
                i++;
            }
            if (res != -1) res = m * i + x;
        }

        result = res;
    }
}
