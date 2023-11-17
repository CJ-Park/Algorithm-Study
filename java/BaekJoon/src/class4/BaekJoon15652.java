package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N 과 M - 4
public class BaekJoon15652 {
    int n, m;
    int[] result;
    StringBuilder sb = new StringBuilder();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        result = new int[m];

        dfs(1, 0); // 결과값 1 1 / 1 2 / 1 3 / 1 4 / 2 2 / 2 3 / 2 4
        System.out.print(sb);
    }

    public void dfs(int start, int idx) {
        if (idx == m) {
            for (int res : result) {
                sb.append(res).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = start; i <= n; i++) {
                if (idx > 0 && result[idx - 1] > i) {
                    continue;
                }
                result[idx] = i;
                dfs(start, idx + 1);
            }
        }
    }
}
