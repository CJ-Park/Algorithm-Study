package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
종이의 개수 - 실버2
재귀 사용
*/
public class BaekJoon1780 {

    int[][] map; // 종이 정보
    int[] result = new int[3];

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        checkPaper(0, 0, n);
        System.out.println(result[0] + "\n" + result[1] + "\n" + result[2]);
    }

    private void checkPaper(int x, int y, int size) {
        if (x < 0 || x >= map.length || y < 0 || y >= map.length) { // 범위 초과
            return;
        }

        int value = map[x][y];
        boolean divide = false;

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (value != map[i][j]) { // 값이 다름 => 다시 분할
                    divide = true;
                    break;
                }
            }

            if (divide) {
                break;
            }
        }

        if (divide) { // 분할해서 다시 종이 체크
            int n = size / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    checkPaper(x + n * i, y + n * j, n);
                }
            }
        } else { // 분할 필요 없으면 종이 결과 추가
            result[value + 1]++;
        }
    }
}
