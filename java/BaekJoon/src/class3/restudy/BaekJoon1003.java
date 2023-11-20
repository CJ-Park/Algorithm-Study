package class3.restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 피보나치 함수 - DP 문제 (시간초과 생각)
public class BaekJoon1003 {
    int T;
    int[][] result;
    StringBuilder sb = new StringBuilder();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        result = new int[2][41];
        result[0][0] = 1;
        result[0][1] = 0;
        result[1][0] = 0;
        result[1][1] = 1;

        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            for (int j = 2; j <= num; j++) {
                result[0][j] = result[0][j - 1] + result[0][j - 2];
                result[1][j] = result[1][j - 1] + result[1][j - 2];
            }
            sb.append(result[0][num]).append(" ").append(result[1][num]).append("\n");
        }
        System.out.print(sb);
    }

    // 시간초과 문제 발생
//    public void getResult(int n) {
//        if (n == 0) {
//            result[0] += 1;
//        } else if (n == 1) {
//            result[1] += 1;
//        } else {
//            getResult(n - 1);
//            getResult(n - 2);
//        }
//
//    }
}
