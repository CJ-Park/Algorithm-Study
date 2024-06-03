package DP.level3;

public class 등교길 {
    public int solution(int m, int n, int[][] puddles) {
        int MOD = 1000000007;
        int[][] dp = new int[m + 1][n + 1];
        dp[1][1] = 1;

        for (int[] puddle : puddles) {
            dp[puddle[0]][puddle[1]] = -1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (dp[i][j] == -1) { // 웅덩이일 경우
                    dp[i][j] = 0;
                    continue;
                }

                if (dp[i][j] != 1) { // 탐색 아직 안했을 경우
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }

                dp[i][j] %= MOD;
            }
        }

        return dp[m][n];
    }
}
