package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 내려가기 - dp
public class BaekJoon2096 {
    static int n, res1, res2;
    static int[][] map;
    static int[] dpMax;
    static int[] dpMin;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][3];
        dpMax = new int[3];
        dpMin = new int[3];
        res2 = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 3; i++) {
            dpMax[i] = dpMin[i] = map[0][i];
        }

        for (int i = 1; i < n; i++) {
            getMaxDp(i);
            getMinDp(i);
        }

        for (int i = 0; i < 3; i++) {
            res1 = Math.max(res1, dpMax[i]);
            res2 = Math.min(res2, dpMin[i]);
        }

        sb.append(res1).append(" ").append(res2);
        System.out.print(sb);
    }

    // 각 계층간 dp는 한번에 바뀌어야 됨 -> 값을 구해놓고 일괄 변경
    public void getMaxDp(int level) {
        int dp1 = 0, dp2 = 0, dp3 = 0;
        for (int idx = 0; idx < 3; idx++) {
            if (idx == 0) {
                dp1 = Math.max(dpMax[idx], dpMax[idx + 1]) + map[level][idx];
            }
            if (idx == 1) {
                int max = Math.max(dpMax[idx - 1], dpMax[idx]);
                max = Math.max(max, dpMax[idx + 1]);
                dp2 = map[level][idx] + max;
            }
            if (idx == 2) {
                dp3 = Math.max(dpMax[idx - 1], dpMax[idx]) + map[level][idx];
            }
        }
        dpMax[0] = dp1;
        dpMax[1] = dp2;
        dpMax[2] = dp3;
    }

    public void getMinDp(int level) {
        int dp1 = 0, dp2 = 0, dp3 = 0;
        for (int idx = 0; idx < 3; idx++) {
            if (idx == 0) {
                dp1 = Math.min(dpMin[idx], dpMin[idx + 1]) + map[level][idx];
            }
            if (idx == 1) {
                int min = Math.min(dpMin[idx - 1], dpMin[idx]);
                min = Math.min(min, dpMin[idx + 1]);
                dp2 = map[level][idx] + min;
            }
            if (idx == 2) {
                dp3 = Math.min(dpMin[idx - 1], dpMin[idx]) + map[level][idx];
            }
        }
        dpMin[0] = dp1;
        dpMin[1] = dp2;
        dpMin[2] = dp3;
    }
}
