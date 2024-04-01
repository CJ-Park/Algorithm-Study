package DP.level3;

public class 정수삼각형 {
    public int solution(int[][] triangle) {
        // dp[0][0] = 7
        // dp[1][0] = 10
        // dp[1][1] = 15
        // dp[2][0] = 18
        // dp[2][1] = Math.max(dp[1][0], dp[1][1]) + 1 = 16
        // dp[2][2] = 15
        // dp[3][0] = 20
        // dp[3][1] = Math.max(dp[2][0], dp[2][1]) + 7 = 25
        // dp[3][2] = Math.max(dp[2][1], dp[2][2]) + 4 = 20
        // dp[3][3] = 19
        // ... dp[4][0] ~ dp[4][4] 까지

        // 7
        // 3 8
        // 8 1 0
        // 2 7 4 4
        // 4 5 2 6 5
        int height = triangle.length;
        int[][] dp = new int[height][height];
        int result = 0;

        dp[0][0] = triangle[0][0];

        for (int i = 1; i < height; i++) {

            for (int j = 0; j <= i; j++) {

                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                }

            }

        }

        for (int i = 0; i < height; i++) {
            result = Math.max(result, dp[height - 1][i]);
        }

        return result;
    }
}
