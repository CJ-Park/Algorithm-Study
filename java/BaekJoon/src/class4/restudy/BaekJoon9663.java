package class4.restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// N-Queen - 브루트포스, 백트래킹
public class BaekJoon9663 {
    int n, count;
    int[][] map;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            getResult(0, i);
        }

        System.out.println(count);
    }

    // 0 1 0 0
    // 0 0 0 1
    // 1 0 0 0
    // 0 0 1 0
    public void getResult(int i, int j) {
        if (i == n - 1){ // 마지막 행 성공적으로 도달 시 count 증가 후 리턴
            count += 1;
            return;
        }

        // 세로 채우기
        for (int k = i; k < n; k++) {
            map[k][j] += 1;
        }

        // 대각선 채우기
        addCross_1(i + 1, j + 1);
        addCross_2(i + 1, j - 1);

        for (int k = 0; k < n; k++) {
            if (map[i + 1][k] == 0)
                getResult(i + 1, k);
        }

        // 대각선 비우기
        removeCross_1(i + 1, j + 1);
        removeCross_2(i + 1, j - 1);

        // 세로 비우기
        for (int k = i; k < n; k++) {
            map[k][j] -= 1;
        }
    }

    public void addCross_1(int i, int j) { // \ 방향 대각선 채우기
        if (i >= n || j >= n)
            return;

        map[i][j] += 1;
        addCross_1(i + 1, j + 1);
    }

    public void addCross_2(int i, int j) { // / 방향 대각선 채우기
        if (i >= n || j < 0)
            return;

        map[i][j] += 1;
        addCross_2(i + 1, j - 1);
    }

    public void removeCross_1(int i, int j) { // \ 방향 대각선 지우기
        if (i >= n || j >= n)
            return;

        map[i][j] -= 1;
        removeCross_1(i + 1, j + 1);
    }

    public void removeCross_2(int i, int j) { // / 방향 대각선 지우기
        if (i >= n || j < 0)
            return;

        map[i][j] -= 1;
        removeCross_2(i + 1, j - 1);
    }
}
