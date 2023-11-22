package class3.restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 색종이 만들기 - 재귀함수
public class BaekJoon2630 {
    int n;
    int[][] paper;
    int[] result = new int[2];

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        paper = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 재귀를 통해 구현해야됨
        // 제일 큰 정사각형부터 조사 => 모든 숫자 같지 않다면 재귀 진행
        recur(n, n, n);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    // 모든 숫자가 같으면 result 에 추가
    // 아니면 정사각형 확인
    public void recur(int x, int y, int length) {
        if (checkPaper(x, y, length)) {
            result[paper[x - length][y - length]]++;
        } else { // 체크해서 실패한다면? => 해당 정사각형을 나눠서 나오는 4가지 실행
            length /= 2;

            recur(x - length, y - length, length); // 1 사분면
            recur(x -length, y, length); // 2 사분면
            recur(x, y - length, length); // 3 사분면
            recur(x, y, length); // 4 사분면
        }
    }


    // 정사각형 확인 메서드
    public boolean checkPaper(int x, int y, int length) {
        int res = paper[x - length][y - length];
        for (int i = x - length; i < x; i++) {
            for (int j = y - length; j < y; j++) {
                if (res != paper[i][j]) return false;
            }
        }
        return true;
    }
}
