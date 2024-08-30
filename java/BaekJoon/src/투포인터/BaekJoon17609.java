package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
회문 - 골드5

1. 문자열 팰린드롬 확인
2. 좌측끝과 우측끝부터 조사
3. 틀릴경우 left + 1 == rigth || left == rigth - 1 확인
4. 확인해서 true 이면 유사 회문 가능 false 이면 회문 아님
 */
public class BaekJoon17609 {
    StringBuilder result = new StringBuilder();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int checkCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < checkCount; i++) {
            String s = br.readLine();
            getResult(s, 0, s.length() - 1);
            result.append("\n");
        }

        System.out.println(result);
    }

    private void getResult(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) { // 유사회문 판별
                if (isSimilar(s, start + 1, end) || isSimilar(s, start, end - 1)) { // 유사회문이면
                    result.append(1);
                } else { // 회문 아니면
                    result.append(2);
                }
                return;
            }

            start++;
            end--;
        }

        result.append(0); // 회문
    }

    private boolean isSimilar(String s, int start, int end) { // 해당 인덱스 기준 펠린드롬 확인
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
