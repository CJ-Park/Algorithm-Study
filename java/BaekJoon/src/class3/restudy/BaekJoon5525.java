package class3.restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

// IOIOI - 문자열 조작 문제 (시간초과로 인한 50점)
// 이후 dp 사용으로 100점 달성
public class BaekJoon5525 {
    int n, m, count;
    String[] s;
    int[] dp;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine()); // 반복 탐색 횟수
        dp = new int[m];

        s = br.readLine().split("");

        // O O I O I O I I I I O I
        // 0 0 1 0 2 0 3 0 0 0 0 1
        for (int i = 1; i < m - 1; i++) {
            if (Objects.equals(s[i], "O") && Objects.equals(s[i + 1], "I")) { // OI 가 등장한 경우
                dp[i + 1] = dp[i - 1] + 1;

                if (dp[i + 1] >= n && Objects.equals(s[i - 2 * n + 1], "I")) { // dp 값과 n 값 만큼 뒤로 가서 인덱스 확인
                    count++;
                }
            }
        }

        // 시간 초과로 인한 50점
//        StringBuilder sb = new StringBuilder();
//        for (String str : arr) {
//            sb.append(str);
//        }
//        String myWord = sb.toString(); // 이걸로 탐색
//
//        for (int i = 0; i <= s.length() - arr.length; i++) {
//            if (s.charAt(i) == 'O') continue;
//            String sub = s.substring(i, i + arr.length);
//            if (Objects.equals(sub, myWord)) {
//                count++;
//                i++;
//            }
//        }

        System.out.println(count);
    }
}
