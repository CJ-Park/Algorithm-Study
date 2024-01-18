package class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// N 과 M (8) - 백트래킹 문제
// 정렬과 재귀로 해결
public class BaekJoon15657 {
    int n, m;
    int[] arr;
    StringBuilder sb = new StringBuilder();

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // arr 정렬
        Arrays.sort(arr);

        // 1 2 3 4 / 3
        // 1 1 1 / 1 1 2 / 1 1 3 / 1 1 4
        // 1 2 2 / 1 2 3 / 1 2 4
        // 1 3 3 / 1 3 4
        // 1 4 4
        for (int i = 0; i < n; i++) {
            String s = arr[i] + " ";
            getList(s, i, 1);
        }

        System.out.println(sb);
    }
    public void getList(String s, int idx, int cnt) {
        if (cnt == m) {
            sb.append(s).append("\n");
            return;
        }

        for (int i = idx; i < n; i++) {
            String s1 = s + arr[i] + " ";
            getList(s1, i, cnt + 1);
        }
    }
}
