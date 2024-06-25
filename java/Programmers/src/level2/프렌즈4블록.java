package level2;

import java.util.ArrayDeque;
import java.util.Queue;

// 2018 카카오 블라인드
public class 프렌즈4블록 {
    private class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public Queue<Point> startPoint = new ArrayDeque<>();
    public char[][] myBoard;
    public int result = 0;

    public int solution(int m, int n, String[] board) {
        myBoard = new char[m][n];

        // 2차원배열로 초기화
        // 좌측하단이 0,0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                myBoard[i][j] = board[m - 1 - i].charAt(j);
            }
        }

        // myBoard 갱신 후 다시 확인하므로 반복
        while (true) {
            // 사라지는 블록좌표 저장
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char c = myBoard[i][j];

                    if (check(i, j, c)) {
                        startPoint.add(new Point(i, j));
                    }
                }
            }

            // 저장된 블록 좌표가 없다면 반복문 탈출
            if (startPoint.isEmpty()) {
                break;
            }

            // 저장한 블록 좌표 비울때까지 카운팅
            while (!startPoint.isEmpty()) {
                Point p = startPoint.poll();

                getCount(p.x, p.y);
                getCount(p.x + 1, p.y);
                getCount(p.x + 1, p.y + 1);
                getCount(p.x, p.y + 1);
            }

            // myBoard 최신화
            for (int i = 0; i < n; i++) {
                int count = 0;
                for (int j = 0; j < m; j++) {
                    if (myBoard[j][i] == ' ') {
                        count++;
                    } else if (count > 0 && myBoard[j][i] != ' ') {
                        myBoard[j - count][i] = myBoard[j][i];
                        myBoard[j][i] = ' ';
                    }
                }
            }
        }

        return result;
    }

    private void getCount(int x, int y) {
        if (myBoard[x][y] != ' ') {
            myBoard[x][y] = ' ';
            result++;
        }
    }

    private boolean check(int x, int y, char target) {
        if (target == ' ') {
            return false;
        }

        return myBoard[x + 1][y] == target &&
                myBoard[x + 1][y + 1] == target &&
                myBoard[x][y + 1] == target;
    }
}
