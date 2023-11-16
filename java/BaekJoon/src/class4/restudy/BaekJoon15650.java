package class4.restudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N 과 M - 2
// 백트래킹 문제
// 재귀함수 부분 이해가 잘 안됨 -> 다시 공부
public class BaekJoon15650 {
    int n, m;
    int[] arr; // 탐색해서 데이터 넣을 수열
    boolean[] visited; // 해당 데이터 방문 여부
    StringBuilder sb;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        visited = new boolean[n + 1];

        // 탐색이 가능하면 계속 탐색 / 불가능하면 되돌아가서 다른 자식노드 탐색
        dfs(1, 0);
        System.out.println(sb);
    }

    // 길이가 m인 수열이 완성되면 출력
    // 수열 완성 전까지 탐색하면서 수열에 추가
    public void dfs(int start, int resultSize) {
        if (resultSize == m) { // 길이가 m 인 수열 완성!
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = start; i <= n; i++) { // 반복문 돌면서 재귀함수 작동
                if (!visited[i]) {
                    visited[i] = true;
                    arr[resultSize] = i;
                    dfs(i, resultSize + 1);
                    visited[i] = false;
                }
            }
        }
    }
}
