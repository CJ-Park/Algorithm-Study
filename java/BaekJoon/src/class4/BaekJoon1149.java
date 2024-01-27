package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// RGB 거리 - dp 문제
// 복습 완료
public class BaekJoon1149 {
    int n, minCost;
    int[][] arr;
    int[][] dp;

    public void restudy() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        minCost = Integer.MAX_VALUE;

        arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[n][3];
        dp[0] = arr[0].clone();

        for (int i = 1; i < n; i++) {
            dp[i][0] = arr[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = arr[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = arr[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        for (int i = 0; i < 3; i++) {
            minCost = Math.min(minCost, dp[n - 1][i]);
        }

        System.out.print(minCost);
    }

//    int n;
//    int[][] dp;
//    int[][] colorList;
//
//    public void solution() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        n = Integer.parseInt(br.readLine());
//        colorList = new int[n][3];
//        dp = new int[n + 1][3];
//
//        for (int i = 0; i < n; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < 3; j++) {
//                colorList[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        // 모든 경우 다해봐야 됨
//        // dp[n][0] = Math.min(dp[n - 1][1], dp[n - 1][2]) + colorList[n][0]
//        // dp[n][1] = Math.min(dp[n - 1][0], dp[n - 1][2]) + colorList[n][1]
//        // dp[n][2] = Math.min(dp[n - 1][0], dp[n - 1][1]) + colorList[n][2]
//        dp[1][0] = colorList[0][0];
//        dp[1][1] = colorList[0][1];
//        dp[1][2] = colorList[0][2];
//        for (int i = 2; i <= n; i++) {
//            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + colorList[i - 1][0];
//            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + colorList[i - 1][1];
//            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + colorList[i - 1][2];
//        }
//
//        int result = Integer.MAX_VALUE;
//        for (int i = 0; i < 3; i++) {
//            result = Math.min(result, dp[n][i]);
//        }
//        System.out.println(result);
//    }
}
