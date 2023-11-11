package class2.restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 마인크래프트
// 브루트포스 알고리즘
public class BaekJoon18111 {
    int n, m, b, height;
    int time = Integer.MAX_VALUE; // 최대값을 줘놓고 줄여야됨
    int[][] home;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        home = new int[n][m];
        int max = 0; // 배열에서의 최대 높이
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                home[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, home[i][j]);
            }
        }
        getAnswer(max);
        sb.append(time).append(" ").append(height);
        System.out.print(sb);
    }

    // home 전체 탐색하면서 0 부터 max 까지 확인
    public void getAnswer(int m) {
        for (int i = 0; i <= m; i++) {
            searchHome(i);
        }
    }

    // height 와 home 비교하면서 카운트
    public void searchHome(int h) {
        int b1 = b;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (h == home[i][j]) {
                    continue;
                }

                if (h > home[i][j]) {
                    count += h - home[i][j];
                    b1 -= h - home[i][j];
                } else {
                    count += 2 * (home[i][j] - h);
                    b1 += home[i][j] - h;
                }
            }
        }

        if (b1 < 0) return; // b1 < 0 이면 해당 작업 취소

        if (time > count) {
            time = count;
            height = h;
        } else if (time == count && height < h) {
            height = h;
        }
    }
}
