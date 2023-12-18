package class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 가장 가까운 세 사람의 심리적 거리 - 브루트포스 & 시간초과 고민
public class BaekJoon20529 {
    int T, n;
    String[] person;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            // 전체탐색은 필수인데 n 은 100000 이하이므로 줄이지 않으면 시간초과 발생
            if (n > 32) { // 사람이 32명 이상이면 적어도 3명은 mbti 겹침 => 최소값 0 가짐
                sb.append(0).append("\n");
                continue;
            }

            // person 배열 초기화 및 데이터 저장
            person = new String[n];

            for (int j = 0; j < n; j++) {
                person[j] = st.nextToken();
            }

            // 세 명 골라서 확인 => n 명중에 3명 고르면서 전체탐색
            int res = searchThreePeople();
            sb.append(res).append("\n");
        }

        System.out.print(sb);
    }

    // person 배열에서 3명 골라서 최소값 가지는 경우 반환
    public int searchThreePeople() {
        int min = Integer.MAX_VALUE;

        // 전체탐색 해야됨 => 0 ~ n - 1
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int count = 0;
                    for (int l = 0; l < 4; l++) {
                        if (person[i].charAt(l) != person[j].charAt(l)) count++;
                        if (person[j].charAt(l) != person[k].charAt(l)) count++;
                        if (person[i].charAt(l) != person[k].charAt(l)) count++;
                    }
                    min = Math.min(min, count);
                }
            }
        }

        return min;
    }
}
