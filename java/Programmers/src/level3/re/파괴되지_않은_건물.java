package level3.re;

/*
2차원 누적합
단순 구현 시 최악의 시간복잡도 O(N * M * K)
전체 board 크기 N * M = 10^6
주어지는 skill 의 수 K = 250000
=> 시간복잡도를 줄이기 위해 누적합 사용 => O((N * M) + K)
 */
public class 파괴되지_않은_건물 {
    int[][] skillBoard;
    public int solution(int[][] board, int[][] skill) {
        int n = board.length;
        int m = board[0].length;
        skillBoard = new int[n + 1][m + 1];

        for (int i = 0; i < skill.length; i++) {
            int x1 = skill[i][1];
            int y1 = skill[i][2];
            int x2 = skill[i][3];
            int y2 = skill[i][4];
            int degree = skill[i][5];
            if (skill[i][0] == 1) { // 공격
                degree *= -1;
            }

            getSkillBoard(x1, y1, x2, y2, degree);
        }

        // skillBoard 가로 누적합
        for (int i = 0; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                skillBoard[i][j] += skillBoard[i][j - 1];
            }
        }

        // skillBoard 세로 누적합
        for (int i = 0; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                skillBoard[j][i] += skillBoard[j - 1][i];
            }
        }

        int safe = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] + skillBoard[i][j] > 0) {
                    safe++;
                }
            }
        }

        return safe;
    }

    /*
    누적합을 위한 skillBoard 구하는 메서드
    2  2  0        2  0 -2
    2  2  0   =>   0  0  0
    0  0  0       -2  0  2
    누적합 이전의 값 도출 후 skillBoard 에 넣어주기
     */
    private void getSkillBoard(int x1, int y1, int x2, int y2, int degree) {
        skillBoard[x1][y1] += degree;
        skillBoard[x2 + 1][y1] += degree * (-1);
        skillBoard[x1][y2 + 1] += degree * (-1);
        skillBoard[x2 + 1][y2 + 1] += degree;
    }
}
