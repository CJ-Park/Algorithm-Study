package Graph.level3;

// 플로이드-워셜 알고리즘
// 중간인덱스 값 집중
public class 순위 {
    static boolean[][] win;

    public int solution(int n, int[][] results) {
        int res = 0;
        win = new boolean[n + 1][n + 1];

        for (int[] result : results) {
            win[result[0]][result[1]] = true;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (win[i][k] && win[k][j]) {
                        win[i][j] = true;
                    }
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            int game = 0;
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    continue;
                }

                if (win[i][j] || win[j][i]) {
                    game++;
                }
            }
            if (game == n - 1) {
                res++;
            }
        }

        return res;
    }
}
