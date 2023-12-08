package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 정수 삼각형 - dp 문제
// dp 메모이제이션을 이용해 삼각형의 제일 아래부터 탐색하는 것도 가능 (탑다운)
// 여기서는 Math.max 로 삼각형의 제일 위부터 비교하며 풀었음 (바텀업)
public class BaekJoon1932 {
    int[][] graph;
    int n, result;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];

        // 정삼각형 그래프 완성
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            getMaxResult(i);
        }

        // 그래프 순회하면서 최대값 확인
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                result = Math.max(result, graph[i][j]);
            }
        }

        System.out.println(result);
    }

    // 0,0 / 1,0 / 1,1 / 2,0 / 2,1 / 2,2
    public void getMaxResult(int x) {
        if (x == 0) { // 0 층이면 리턴
            return;
        }
        for (int i = 0; i <= x; i++) { // 해당 계층 순회
            if (i == 0) { // 양 끝인 경우 (0,0 / 1,0 / 1,1 / 2,0 / 2,2 / 3,0 / 3,3 ....)
                graph[x][i] += graph[x - 1][i];
            } else if (i == x) {
                graph[x][i] += graph[x - 1][i - 1];
            } else { // 양 끝이 아니라 겹치는 경우
                graph[x][i] += Math.max(graph[x - 1][i - 1], graph[x - 1][i]);
            }
        }
    }
}
