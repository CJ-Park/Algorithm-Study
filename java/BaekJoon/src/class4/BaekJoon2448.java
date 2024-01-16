package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 별 찍기 - 11
// 재귀 문제
public class BaekJoon2448 {
    int n;
    boolean[][] stars;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        stars = new boolean[n][2 * n - 1];

        // n 은 무조건 2의 제곱수 * 3 임
        // 최대 2의 10제곱까지임
        // 즉 n 은 3, 6, 12, 24, 48, 96, ..., 3072

        // n = 3
        //   *
        //  * *
        // *****
        // 0 1 2 3 4
        // 2, 13, 01234

        // n = 6
        //      *
        //     * *
        //    *****
        //   *     *
        //  * *   * *
        // ***** *****

        // 별 그리기
        drawStar(0, n - 1, n);

        for (boolean[] b : stars) {
            for (boolean star : b) {
                if (star)
                    sb.append("*");
                else
                    sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public void drawStar(int x, int y, int n) {
        if (n == 3) { // n == 3 일 때 x, y 기준 좌표로 제일 작은 삼각형 만듦
            stars[x][y] = true;
            stars[x + 1][y - 1] = stars[x + 1][y + 1] = true;
            stars[x + 2][y - 2] = stars[x + 2][y - 1] =
                    stars[x + 2][y] = stars[x + 2][y + 1] =
                            stars[x + 2][y + 2] = true;
            return;
        }

        drawStar(x, y, n / 2); // 반토막해서 위쪽 삼각형
        drawStar(x + n / 2, y - n / 2, n / 2); // 반토막 아래쪽의 좌측 삼각형
        drawStar(x + n / 2, y + n / 2, n / 2); // 반토막 아래쪽의 우측 삼각형
    }
}
